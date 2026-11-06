package calculadora;

public class Calculadora {

    private static final String MSG_OPERACAO_INVALIDA = "Operacao invalida";
    private static final String MSG_DIVISAO_POR_ZERO = "Erro: divisao por zero";

    public static String calc(int a, int b, String op) {
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

    private static long somar(int a, int b) {
        return (long) a + b;
    }

    private static long subtrair(int a, int b) {
        return (long) a - b;
    }

    private static long multiplicar(int a, int b) {
        return (long) a * b;
    }

    private static String dividir(int dividendo, int divisor) {
        if (divisor == 0) {
            return MSG_DIVISAO_POR_ZERO;
        }
        return formatar((double) dividendo / divisor);
    }

    private static String formatar(long valor) {
        return String.valueOf(valor);
    }

    private static String formatar(double valor) {
        if (valor == Math.floor(valor)) {
            return String.valueOf((long) valor);
        }
        return String.valueOf(valor);
    }

    public static void main(String[] args) {
        System.out.println("10 + 5 = " + calc(10, 5, "+"));
        System.out.println("10 / 0 = " + calc(10, 0, "/"));
    }
}
