package calculadora;

public class Calculadora {

    // Versao inicial: funciona, mas com ifs aninhados e pouca organizacao
    public static String calc(int a, int b, String op) {
        String r;
        if (op == null) {
            r = "Operacao invalida";
        } else {
            if (op.equals("+")) {
                r = String.valueOf(a + b);
            } else {
                if (op.equals("-")) {
                    r = String.valueOf(a - b);
                } else {
                    if (op.equals("*")) {
                        r = String.valueOf(a * b);
                    } else {
                        if (op.equals("/")) {
                            if (b == 0) {
                                r = "Erro: divisao por zero";
                            } else {
                                double x = (double) a / b;
                                if (x == Math.floor(x)) {
                                    r = String.valueOf((long) x);
                                } else {
                                    r = String.valueOf(x);
                                }
                            }
                        } else {
                            r = "Operacao invalida";
                        }
                    }
                }
            }
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println("10 + 5 = " + calc(10, 5, "+"));
        System.out.println("10 / 0 = " + calc(10, 0, "/"));
    }
}
