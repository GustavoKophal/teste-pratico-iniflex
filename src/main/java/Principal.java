import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private static final BigDecimal SALARIO_MINIMO = new BigDecimal("1212.00");
    private static List<Funcionario> funcionarios = new ArrayList<>();
    
    public static void main(String[] args) {
        System.out.println("=== TESTE TÉCNICO INIFLEX ===\n");
        
        // 3.1 - Inserir todos os funcionários
        inserirFuncionarios();
        
        // 3.2 - Remover o funcionário "João"
        removerJoao();
        
        // 3.3 - Imprimir todos os funcionários
        imprimirFuncionarios();
        
        // 3.4 - Aplicar 10% de aumento salarial
        aplicarAumentoSalarial();
        
        // 3.5 e 3.6 - Agrupar e imprimir por função
        agruparEImprimirPorFuncao();
        
        // 3.8 - Imprimir aniversariantes dos meses 10 e 12
        imprimirAniversariantesMeses10e12();
        
        // 3.9 - Imprimir funcionário mais velho
        imprimirFuncionarioMaisVelho();
        
        // 3.10 - Imprimir em ordem alfabética
        imprimirEmOrdemAlfabetica();
        
        // 3.11 - Imprimir total dos salários
        imprimirTotalSalarios();
        
        // 3.12 - Imprimir salários em salários mínimos
        imprimirSalariosEmSalariosMinimos();
    }
    
    // 3.1 - Inserir todos os funcionários da tabela
    private static void inserirFuncionarios() {
        System.out.println("3.1 - INSERINDO FUNCIONÁRIOS:");
        
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));
        
        System.out.println("OK - " + funcionarios.size() + " funcionarios inseridos com sucesso!\n");
    }
    
    // 3.2 - Remover o funcionário "João"
    private static void removerJoao() {
        System.out.println("3.2 - REMOVENDO FUNCIONÁRIO 'JOÃO':");
        
        boolean removido = funcionarios.removeIf(f -> "João".equals(f.getNome()));
        
        if (removido) {
            System.out.println("OK - Funcionario 'Joao' removido com sucesso!");
            System.out.println("OK - Total de funcionarios: " + funcionarios.size() + "\n");
        } else {
            System.out.println("ERRO - Funcionario 'Joao' nao encontrado!\n");
        }
    }
    
    // 3.3 - Imprimir todos os funcionários
    private static void imprimirFuncionarios() {
        System.out.println("3.3 - LISTA DE FUNCIONÁRIOS:");
        System.out.println("(Formatação: data dd/mm/aaaa, números com ponto para milhar e vírgula para decimal)");
        System.out.println("-".repeat(80));
        
        for (Funcionario f : funcionarios) {
            System.out.println(f);
        }
        System.out.println();
    }
    
    // 3.4 - Aplicar 10% de aumento salarial
    private static void aplicarAumentoSalarial() {
        System.out.println("3.4 - APLICANDO 10% DE AUMENTO SALARIAL:");
        
        for (Funcionario f : funcionarios) {
            f.aplicarAumento(10.0);
        }
        
        System.out.println("OK - Aumento de 10% aplicado a todos os funcionarios!\n");
    }
    
    // 3.5 e 3.6 - Agrupar e imprimir por função
    private static void agruparEImprimirPorFuncao() {
        System.out.println("3.5 e 3.6 - FUNCIONÁRIOS AGRUPADOS POR FUNÇÃO:");
        
        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));
        
        for (Map.Entry<String, List<Funcionario>> entry : funcionariosPorFuncao.entrySet()) {
            System.out.println("\n" + entry.getKey().toUpperCase() + " (" + entry.getValue().size() + " funcionario(s)):");
            System.out.println("-".repeat(50));
            
            for (Funcionario f : entry.getValue()) {
                System.out.println("  - " + f.getNome() + " - " + f.getSalario());
            }
        }
        System.out.println();
    }
    
    // 3.8 - Imprimir aniversariantes dos meses 10 e 12
    private static void imprimirAniversariantesMeses10e12() {
        System.out.println("3.8 - ANIVERSARIANTES DOS MESES 10 E 12:");
        
        List<Funcionario> aniversariantes = funcionarios.stream()
                .filter(f -> {
                    int mes = f.getDataNascimento().getMonthValue(); 
                    return mes == 10 || mes == 12;
                })
                .collect(Collectors.toList());
        
        if (aniversariantes.isEmpty()) {
            System.out.println("ERRO - Nenhum funcionario faz aniversario nos meses 10 e 12.");
        } else {
            for (Funcionario f : aniversariantes) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM");
                String dataFormatada = f.getDataNascimento().format(formatter);
                System.out.println("  - " + f.getNome() + " - " + dataFormatada);
            }
        }
        System.out.println();
    }
    
    // 3.9 - Imprimir funcionário mais velho
    private static void imprimirFuncionarioMaisVelho() {
        System.out.println("3.9 - FUNCIONÁRIO MAIS VELHO:");
        
        Funcionario maisVelho = funcionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .orElse(null);
        
        if (maisVelho != null) {
            int idade = maisVelho.calcularIdade();
            System.out.println("  - Nome: " + maisVelho.getNome());
            System.out.println("  - Idade: " + idade + " anos");
        }
        System.out.println();
    }
    
    // 3.10 - Imprimir em ordem alfabética
    private static void imprimirEmOrdemAlfabetica() {
        System.out.println("3.10 - FUNCIONÁRIOS EM ORDEM ALFABÉTICA:");
        
        List<Funcionario> ordenados = funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .collect(Collectors.toList());
        
        for (Funcionario f : ordenados) {
            System.out.println("  - " + f.getNome());
        }
        System.out.println();
    }
    
    // 3.11 - Imprimir total dos salários
    private static void imprimirTotalSalarios() {
        System.out.println("3.11 - TOTAL DOS SALÁRIOS:");
        
        BigDecimal total = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        
        System.out.println("  - Total: " + total);
        System.out.println();
    }
    
    // 3.12 - Imprimir salários em salários mínimos
    private static void imprimirSalariosEmSalariosMinimos() {
        System.out.println("3.12 - SALÁRIOS EM SALÁRIOS MÍNIMOS (R$ " + SALARIO_MINIMO + "):");
        
        for (Funcionario f : funcionarios) {
            double salariosMinimos = f.calcularSalariosMinimos(SALARIO_MINIMO);
            System.out.println("  - " + f.getNome() + ": " + String.format("%.2f", salariosMinimos) + " salarios minimos");
        }
        System.out.println();
    }
}
