# Compiladores – Simulador de AFD

Trabalho final da disciplina de **Compiladores**: um simulador de **Autômato Finito Determinístico (AFD)**
em Java. O programa lê a definição do autômato de um arquivo de texto, valida a sintaxe com uma gramática
**ANTLR 4** e depois processa uma palavra de entrada, mostrando estado por estado se ela é aceita ou
rejeitada.

## Como funciona

1. O programa pede o nome do arquivo com a definição do AFD.
2. O conteúdo é analisado pelo lexer/parser gerado a partir de [`GrammarAFD.g4`](src/grammar/GrammarAFD.g4).
3. São criados os estados e as transições. O programa confere se as transições usam só estados declarados
   e símbolos de um caractere.
4. O programa pede a palavra de entrada e verifica se todos os símbolos pertencem ao alfabeto.
5. A simulação começa no estado inicial e imprime, a cada passo, o estado atual e a transição usada.
6. Quando não há mais transição, a palavra é **aceita** se toda a entrada foi consumida e o estado atual é de
   aceitação; caso contrário, é **rejeitada**.

## Formato do arquivo de entrada

```
{{Alfabeto},{Estados},{Transições},EstadoInicial,{EstadosDeAceitação}}
```

- **Alfabeto**: símbolos de um caractere (`a-z`, `A-Z`, `0-9`), separados por vírgula.
- **Estados**: nomes no formato `q0`, `q1`, `q2`...
- **Transições**: `(origem->destino,símbolo)`.

Exemplo ([`1.txt`](1.txt)):

```
{{a,b,c},{q0,q1,q2,q3},{(q0->q1,a),(q1->q2,b),(q2->q3,c)},q0,{q0,q3}}
```

Com esse autômato, a palavra `abc` é aceita e `ab` é rejeitada.

## Estrutura do projeto

| Caminho | Descrição |
|---|---|
| `src/afd/AFD.java` | Ponto de entrada: monta o autômato e executa a simulação |
| `src/afd/Arquivo.java` | Lê o arquivo, valida com o parser ANTLR e separa alfabeto, estados, transições, inicial e finais |
| `src/afd/Estado.java` / `Transicao.java` | Modelo dos estados e das transições |
| `src/grammar/GrammarAFD.g4` | Gramática ANTLR do formato de entrada (lexer e parser gerados na mesma pasta) |
| `antlr-4.7-complete.jar` | Biblioteca do ANTLR 4.7 |
| `1.txt` | Exemplo de definição de AFD |

## Como executar

Projeto do **NetBeans** (Ant, Java 8 ou superior). Abra a pasta no NetBeans e execute, ou compile pela linha de
comando:

```sh
javac -cp antlr-4.7-complete.jar -d build src/afd/*.java src/grammar/*.java
java -cp "build;antlr-4.7-complete.jar" afd.AFD
```

No Linux/macOS, use `:` no lugar de `;` no classpath. Informe `1.txt` como arquivo e depois a palavra a
testar.

## Tecnologias

- Java
- ANTLR 4.7
- NetBeans / Apache Ant
