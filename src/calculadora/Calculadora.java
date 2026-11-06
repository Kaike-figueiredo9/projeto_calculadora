package calculadora;

/**
 * Modulo de calculos basicos do aplicativo FinancApp.
 * <p>
 * Oferece as quatro operacoes aritmeticas (soma, subtracao, multiplicacao e
 * divisao) e nunca lanca excecao para entradas invalidas: em vez disso,
 * devolve uma mensagem de erro em texto.
 * </p>
 *
 * @author Klau
 * @version 1.1
 */
public class Calculadora {

    /** Mensagem devolvida quando o operador informado nao e suportado. */
    private static final String MSG_OPERACAO_INVALIDA = "Operacao invalida";

    /** Mensagem devolvida quando o divisor e zero. */
    private static final String MSG_DIVISAO_POR_ZERO = "Erro: divisao por zero";

    /**
     * Executa uma operacao matematica entre dois numeros inteiros.
     * <p>
     * Operadores aceitos: {@code +}, {@code -}, {@code *} e {@code /}.
     * Este metodo nao lanca excecoes; erros sao reportados na String retornada.
     * </p>
     *
     * @param a  primeiro operando
     * @param b  segundo operando
     * @param op operador da operacao ("+", "-", "*" ou "/"); pode ser nulo
     * @return o resultado da operacao como texto (inteiro quando exato, decimal
     *         na divisao nao exata), {@code "Erro: divisao por zero"} se
     *         {@code op} for "/" e {@code b} for 0, ou
     *         {@code "Operacao invalida"} se o operador for nulo ou desconhecido
     */
    public static String calc(int a, int b, String op) {
        // Operador nulo seria causa de NullPointerException no switch
        if (op == null) {
            return MSG_OPERACAO_INVALIDA;
        }

        switch (op) {
            case "+":
                return formatar(somar(a, b));
            case "-":
                return formatar(subtrair(a, b));
            case "*":
                return formatar(multiplicar(a, b));
            case "/":
                return dividir(a, b);
            default:
                return MSG_OPERACAO_INVALIDA;
        }
    }

    /**
     * Soma dois inteiros.
     *
     * @param a primeira parcela
     * @param b segunda parcela
     * @return a soma, em {@code long} para evitar estouro de {@code int}
     */
    private static long somar(int a, int b) {
        return (long) a + b;
    }

    /**
     * Subtrai dois inteiros.
     *
     * @param a minuendo
     * @param b subtraendo
     * @return a diferenca, em {@code long} para evitar estouro de {@code int}
     */
    private static long subtrair(int a, int b) {
        return (long) a - b;
    }

    /**
     * Multiplica dois inteiros.
     *
     * @param a primeiro fator
     * @param b segundo fator
     * @return o produto, em {@code long} para evitar estouro de {@code int}
     */
    private static long multiplicar(int a, int b) {
        return (long) a * b;
    }

    /**
     * Divide dois inteiros, tratando divisao por zero.
     *
     * @param dividendo numero a ser dividido
     * @param divisor   numero pelo qual se divide
     * @return o quociente formatado, ou a mensagem de divisao por zero
     */
    private static String dividir(int dividendo, int divisor) {
        // Checagem antecipada evita Infinity/NaN e protege a execucao
        if (divisor == 0) {
            return MSG_DIVISAO_POR_ZERO;
        }
        return formatar((double) dividendo / divisor);
    }

    /**
     * Converte um resultado inteiro para texto.
     *
     * @param valor valor a converter
     * @return o valor como texto
     */
    private static String formatar(long valor) {
        return String.valueOf(valor);
    }

    /**
     * Converte um resultado decimal para texto, omitindo a parte fracionaria
     * quando o valor e inteiro (ex.: 2.0 vira "2").
     *
     * @param valor valor a converter
     * @return o valor como texto
     */
    private static String formatar(double valor) {
        if (valor == Math.floor(valor)) {
            return String.valueOf((long) valor);
        }
        return String.valueOf(valor);
    }

    /**
     * Ponto de entrada com uma demonstracao rapida da calculadora.
     *
     * @param args argumentos de linha de comando (nao utilizados)
     */
    public static void main(String[] args) {
        System.out.println("10 + 5 = " + calc(10, 5, "+"));
        System.out.println("10 / 0 = " + calc(10, 0, "/"));
    }
}
