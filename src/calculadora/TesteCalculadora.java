package calculadora;

/**
 * Testes unitarios da classe {@link Calculadora}.
 * <p>
 * Cada teste exibe as entradas, o resultado esperado e o resultado obtido.
 * Se algum teste falhar, o programa termina com codigo de saida 1.
 * </p>
 *
 * @author Kaike Figueiredo
 * @version 1.1
 */
public class TesteCalculadora {

    /** Quantidade total de testes executados. */
    static int total = 0;

    /** Quantidade de testes que passaram. */
    static int aprovados = 0;

    /**
     * Executa um caso de teste e imprime entradas, esperado e obtido.
     *
     * @param nome     descricao do teste
     * @param a        primeiro operando
     * @param b        segundo operando
     * @param op       operador a testar (pode ser nulo)
     * @param esperado resultado que {@link Calculadora#calc(int, int, String)}
     *                 deve devolver
     */
    static void testar(String nome, int a, int b, String op, String esperado) {
        String obtido = Calculadora.calc(a, b, op);
        boolean ok = esperado.equals(obtido);
        total++;
        if (ok) {
            aprovados++;
        }
        System.out.println("Teste: " + nome);
        System.out.println("  Entradas : a=" + a + ", b=" + b + ", op=\"" + op + "\"");
        System.out.println("  Esperado : " + esperado);
        System.out.println("  Obtido   : " + obtido);
        System.out.println("  Resultado: " + (ok ? "PASSOU" : "FALHOU"));
        System.out.println();
    }

    /**
     * Executa todos os testes e imprime o resumo.
     *
     * @param args argumentos de linha de comando (nao utilizados)
     */
    public static void main(String[] args) {
        testar("Soma", 10, 5, "+", "15");
        testar("Subtracao", 10, 5, "-", "5");
        testar("Multiplicacao", 10, 5, "*", "50");
        testar("Divisao exata", 10, 5, "/", "2");
        testar("Divisao com decimal", 7, 2, "/", "3.5");
        testar("Divisao por zero", 10, 0, "/", "Erro: divisao por zero");
        testar("Operacao invalida", 10, 5, "%", "Operacao invalida");
        testar("Operacao nula", 10, 5, null, "Operacao invalida");

        System.out.println("Resumo: " + aprovados + "/" + total + " testes passaram.");
        if (aprovados != total) {
            System.exit(1);
        }
    }
}
