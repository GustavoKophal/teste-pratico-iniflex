import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;
    
    public Funcionario() {
        super();
    }
    
    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }
    
    public BigDecimal getSalario() {
        return salario;
    }
    
    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
    
    public String getFuncao() {
        return funcao;
    }
    
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
    
    public void aplicarAumento(double percentual) {
        if (salario != null && percentual > 0) {
            BigDecimal multiplicador = BigDecimal.valueOf(1 + (percentual / 100));
            this.salario = salario.multiply(multiplicador).setScale(2, RoundingMode.HALF_UP);
        }
    }
    
    public double calcularSalariosMinimos(BigDecimal salarioMinimo) {
        if (salario != null && salarioMinimo != null && salarioMinimo.compareTo(BigDecimal.ZERO) > 0) {
            return salario.divide(salarioMinimo, 2, RoundingMode.HALF_UP).doubleValue();
        }
        return 0.0;
    }

    @Override
    public String toString() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));
        formatter.setMaximumFractionDigits(2);
        formatter.setMinimumFractionDigits(2);
        
        String salarioFormatado = salario != null ? formatter.format(salario) : "N/A";
        
        return super.toString() + 
               ", Salário: " + salarioFormatado + 
               ", Função: " + funcao;
    }
}
