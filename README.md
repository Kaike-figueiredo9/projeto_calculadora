# projeto_calculadora

## Descrição do projeto

Módulo de cálculos matemáticos básicos em Java para o aplicativo fictício **FinançApp** (controle de finanças pessoais). A classe `Calculadora` realiza soma, subtração, multiplicação e divisão por meio do método `calc(int a, int b, String op)`, sem nunca interromper a execução do programa em caso de erro.

## Objetivo da atividade

Praticar qualidade de software na prática: testes unitários, tratamento de erros, refatoração, documentação técnica (JavaDoc) e versionamento com Git/GitHub.

## Tecnologias utilizadas

- Java 21 (JDK)
- JavaDoc (geração da documentação HTML)
- Git e GitHub

## Estrutura do projeto

```
projeto_calculadora/
├── src/calculadora/
│   ├── Calculadora.java
│   └── TesteCalculadora.java
├── docs/                 # JavaDoc gerado (abrir docs/index.html)
├── saida_testes.txt      # saída real da execução dos testes
└── README.md
```

## Explicação das operações

`calc(int a, int b, String op)` devolve o resultado como `String`.

| Operador | Operação | Exemplo | Retorno |
|----------|----------|---------|---------|
| `+` | Soma | `calc(10, 5, "+")` | `15` |
| `-` | Subtração | `calc(10, 5, "-")` | `5` |
| `*` | Multiplicação | `calc(10, 5, "*")` | `50` |
| `/` | Divisão | `calc(7, 2, "/")` | `3.5` (inteiro quando exata: `10/5` → `2`) |
| `/` com `b = 0` | Divisão por zero | `calc(10, 0, "/")` | `Erro: divisao por zero` |
| outro / `null` | Operação inválida | `calc(10, 5, "%")` | `Operacao invalida` |

Tratamento de erros: o método não lança exceções; erros são devolvidos como mensagem, então o programa nunca é interrompido.

## Como compilar e executar

```bash
mkdir out
javac -d out src/calculadora/*.java
java -cp out calculadora.TesteCalculadora
```

Gerar o JavaDoc:

```bash
javadoc -encoding UTF-8 -private -author -version -d docs -sourcepath src calculadora
```

## Branches

- `main`: versão final.
- `Refatoracao`: refatoração e documentação JavaDoc.

## Prints da execução dos testes

Resultado obtido (8/8 testes passaram; saída completa em `saida_testes.txt`):

> <img width="1512" height="927" alt="image" src="https://github.com/user-attachments/assets/d73c3079-ba33-46f8-ae65-48187d1bc83a" />


## Prints da documentação JavaDoc

> <img width="1917" height="912" alt="image" src="https://github.com/user-attachments/assets/15fed49b-943f-43b7-839e-8a223230258a" />
> <img width="1822" height="747" alt="image" src="https://github.com/user-attachments/assets/b25ddae5-7677-4d68-8942-261687efecc9" />


## Link do repositório

> https://github.com/Kaike-figueiredo9/projeto_calculadora

## Autor

Kaike Figueiredo
