# Teste Técnico - Iniflex

## Requisitos

### Classes
- **Pessoa:** nome (String), dataNascimento (LocalDate)
- **Funcionario:** estende Pessoa + salario (BigDecimal), funcao (String)

### Funcionalidades
1. Inserir todos os funcionários da tabela (mesma ordem e informações)
2. Remover o funcionário "João" da lista
3. Imprimir todos os funcionários com todas suas informações:
   - Data: formato dd/mm/aaaa
   - Valores numéricos: separador de milhar como ponto, decimal como vírgula
4. Aplicar 10% de aumento de salário a todos os funcionários
5. Agrupar funcionários por função em um MAP (chave: função, valor: lista de funcionários)
6. Imprimir funcionários agrupados por função
7. Imprimir funcionários que fazem aniversário nos meses 10 e 12
8. Imprimir funcionário com a maior idade (nome e idade)
9. Imprimir lista de funcionários por ordem alfabética
10. Imprimir total dos salários dos funcionários
11. Imprimir quantos salários mínimos ganha cada funcionário (salário mínimo: R$ 1.212,00)

## Dados dos Funcionários

| Nome | Data Nascimento | Salário | Função |
|------|----------------|---------|---------|
| Maria | 18/10/2000 | R$ 2.009,44 | Operador |
| João | 12/05/1990 | R$ 2.284,38 | Operador |
| Caio | 02/05/1961 | R$ 9.836,14 | Coordenador |
| Miguel | 14/10/1988 | R$ 19.119,88 | Diretor |
| Alice | 05/01/1995 | R$ 2.234,68 | Recepcionista |
| Heitor | 19/11/1999 | R$ 1.582,72 | Operador |
| Arthur | 31/03/1993 | R$ 4.071,84 | Contador |
| Laura | 08/07/1994 | R$ 3.017,45 | Gerente |
| Heloísa | 24/05/2003 | R$ 1.606,85 | Eletricista |
| Helena | 02/09/1996 | R$ 2.799,93 | Gerente |