# Reconhecedor Léxico para Linguagem Java Baseado em Autômato Finito Determinístico

## Resumo

Este artigo apresenta o desenvolvimento de um analisador léxico (lexer) baseado em Autômato Finito Determinístico (AFD) para reconhecer tokens de uma linguagem inspirada em Java. O projeto implementa a primeira etapa fundamental de um compilador: a análise léxica. A ferramenta oferece uma interface gráfica em Java Swing que permite aos usuários digitar código e visualizar os tokens reconhecidos, classificados de acordo com seu tipo. O sistema é capaz de reconhecer palavras-chave, identificadores, literais numéricas, strings, operadores e delimitadores, fornecendo informações sobre linha e coluna de cada token identificado.

**Palavras-chave**: Autômatos Finitos, Análise Léxica, Compiladores, Tokens, Java, Swing, Programação Orientada a Objetos.

---

## 1. Introdução

A análise léxica é a primeira fase do processo de compilação de uma linguagem de programação. Seu objetivo é transformar uma sequência de caracteres (código-fonte) em uma sequência de tokens (símbolos significativos) que serão posteriormente processados pelas fases seguintes do compilador: análise sintática e análise semântica.

Segundo Aho et al. (2006), a análise léxica pode ser implementada através de autômatos finitos, sejam determinísticos (AFD) ou não-determinísticos (AFN). Os autômatos finitos oferecem uma abordagem formal e robusta para o reconhecimento de padrões em linguagens regulares.

Este projeto apresenta a implementação prática de um analisador léxico para uma linguagem inspirada em Java, utilizando um Autômato Finito Determinístico. A implementação é feita em Java com interface gráfica, permitindo visualização interativa dos tokens reconhecidos.

### 1.1 Objetivo Geral

Desenvolver um analisador léxico funcional que reconheça e classifique tokens de uma linguagem Java-like, implementando um AFD explícito e oferecendo uma interface amigável para testes.

### 1.2 Objetivos Específicos

- Implementar as estruturas de dados necessárias para representar tokens (classe Token e enum TokenType)
- Criar um Autômato Finito Determinístico para reconhecimento de padrões
- Desenvolver validadores específicos para cada tipo de token
- Implementar a classe Lexer para percorrer e analisar o código-fonte
- Criar uma interface gráfica em Java Swing para visualizar os resultados
- Demonstrar o funcionamento prático do conceito de análise léxica

---

## 2. Fundamentação Teórica

### 2.1 Autômatos Finitos

Um Autômato Finito é uma máquina abstrata que aceita ou rejeita cadeias de símbolos de um alfabeto finito. Formalmente, um Autômato Finito Determinístico (AFD) é uma tupla:

**AFD = (Q, Σ, δ, q₀, F)**

Onde:
- **Q**: Conjunto finito de estados
- **Σ**: Alfabeto (conjunto de símbolos de entrada)
- **δ**: Função de transição δ: Q × Σ → Q
- **q₀**: Estado inicial
- **F**: Conjunto de estados finais (aceitadores)

#### 2.1.1 Características dos AFDs

Os Autômatos Finitos Determinísticos possuem as seguintes características:

1. **Determinismo**: Para cada estado e símbolo de entrada, existe exatamente uma transição
2. **Memória Limitada**: Armazena apenas o estado atual
3. **Finitude**: Possui um número finito de estados
4. **Completude**: Pode haver transições definidas para todos os pares (estado, símbolo)

#### 2.1.2 Aplicações

Os AFDs são amplamente utilizados em:
- Análise léxica de compiladores
- Reconhecimento de padrões em expressões regulares
- Validação de formatos (emails, telefones, etc.)
- Processamento de linguagens naturais

### 2.2 Análise Léxica

A análise léxica, também conhecida como varredura (scanning), é responsável por:

1. **Leitura do código-fonte** caractere por caractere
2. **Agrupamento de caracteres** em tokens significativos
3. **Classificação dos tokens** conforme seu tipo
4. **Eliminação de espaços em branco** e comentários (quando aplicável)
5. **Detecção de erros** léxicos simples

#### 2.2.1 Definição de Token

Um token é uma unidade sintática significativa em uma linguagem. Cada token possui:
- **Lexema**: A sequência de caracteres que forma o token
- **Tipo**: A classificação do token (palavra-chave, identificador, etc.)
- **Posição**: Linha e coluna onde o token foi encontrado

#### 2.2.2 Exemplos de Tokens em Java

| Lexema | Tipo | Exemplo |
|--------|------|---------|
| class | Palavra Reservada | class Pessoa { } |
| idade | Identificador | int idade = 20; |
| 42 | Inteiro | int x = 42; |
| 3.14 | Real | double pi = 3.14; |
| "Olá" | String | String msg = "Olá"; |
| 'a' | Caractere | char c = 'a'; |
| + | Operador | x = a + b; |
| { | Delimitador | class X { } |

### 2.3 Linguagem Java

Java é uma linguagem de programação orientada a objetos, compilada, com tipagem estática e com suporte a genéricos. Alguns dos elementos léxicos de Java incluem:

#### 2.3.1 Palavras Reservadas

Java possui 50 palavras reservadas (keywords) que não podem ser usadas como identificadores. Exemplos: `public`, `class`, `int`, `if`, `for`, `while`, `return`, etc.

#### 2.3.2 Identificadores

Um identificador em Java:
- Começa com uma letra (a-z, A-Z), underscore (_) ou cifrão ($)
- Contém apenas letras, dígitos, underscores ou cifrões
- É case-sensitive (maiúsculas e minúsculas são diferentes)

Exemplos válidos: `idade`, `_nome`, `contador1`, `Pessoa`
Exemplos inválidos: `1teste`, `@abc`, `#a`, `teste-valor`

#### 2.3.3 Operadores

Java possui diversos operadores:

**Aritméticos**: `+`, `-`, `*`, `/`, `%`
**Relacionais**: `>`, `<`, `>=`, `<=`, `==`, `!=`
**Lógicos**: `&&`, `||`, `!`
**Atribuição**: `=`, `+=`, `-=`, `*=`, `/=`
**Incremento/Decremento**: `++`, `--`

#### 2.3.4 Literais

Literais são valores constantes no código:
- **Inteiros**: 0, 1, 100, 999999
- **Reais**: 3.14, 2.5, 0.001
- **Strings**: "Hello", "Teste", "Olá Mundo"
- **Caracteres**: 'a', 'X', '0'
- **Booleanos**: true, false

---

## 3. Desenvolvimento

### 3.1 Arquitetura do Projeto

O projeto segue a arquitetura de três camadas:

#### 3.1.1 Camada de Lógica (Núcleo)
Responsável pela análise léxica:
- `Lexer.java`: Analisador léxico principal
- `Token.java`: Representação de um token
- `TokenType.java`: Tipos de tokens
- `Automaton.java`: Implementação do AFD
- `State.java`: Estados do autômato

#### 3.1.2 Camada de Validação (Utilitários)
Validadores específicos para cada tipo de token:
- `ReservedWords.java`: Verifica palavras reservadas
- `IdentifierValidator.java`: Valida identificadores
- `NumberValidator.java`: Valida números (inteiros e reais)
- `StringValidator.java`: Valida strings e caracteres
- `OperatorValidator.java`: Valida operadores

#### 3.1.3 Camada de Apresentação (Interface)
Interface gráfica:
- `MainFrame.java`: Janela principal
- `ResultTableModel.java`: Modelo customizado da tabela

### 3.2 Implementação

#### 3.2.1 Estrutura de Dados: Token

```java
public class Token {
    private String lexeme;
    private TokenType type;
    private int line;
    private int column;
    
    public Token(String lexeme, TokenType type, int line, int column) {
        this.lexeme = lexeme;
        this.type = type;
        this.line = line;
        this.column = column;
    }
    
    // Getters...
}
```

A classe Token armazena as informações essenciais de cada símbolo reconhecido.

#### 3.2.2 Tipos de Tokens: TokenType

```java
public enum TokenType {
    KEYWORD("Palavra Reservada"),
    IDENTIFIER("Identificador"),
    INTEGER("Inteiro"),
    REAL("Real"),
    STRING("String"),
    CHAR("Caractere"),
    OPERATOR("Operador"),
    DELIMITER("Delimitador"),
    UNKNOWN("Desconhecido");
    
    private final String description;
    // ...
}
```

O enum TokenType define todas as classificações possíveis de tokens.

#### 3.2.3 Autômato Finito Determinístico

A classe Automaton implementa o reconhecimento de padrões:

```java
public static TokenType recognize(String lexeme) {
    // Verifica palavra reservada
    if (ReservedWords.isReserved(lexeme))
        return TokenType.KEYWORD;
    
    // Verifica string
    if (StringValidator.isString(lexeme))
        return TokenType.STRING;
    
    // Verifica número real
    if (NumberValidator.isReal(lexeme))
        return TokenType.REAL;
    
    // Verifica número inteiro
    if (NumberValidator.isInteger(lexeme))
        return TokenType.INTEGER;
    
    // Verifica operador
    if (OperatorValidator.isOperator(lexeme))
        return TokenType.OPERATOR;
    
    // Verifica delimitador
    if (isDelimiter(lexeme))
        return TokenType.DELIMITER;
    
    // Verifica identificador
    if (IdentifierValidator.isValidIdentifier(lexeme))
        return TokenType.IDENTIFIER;
    
    return TokenType.UNKNOWN;
}
```

O método `recognize()` implementa o núcleo do AFD, percorrendo as transições possíveis até alcançar um estado final.

#### 3.2.4 Analisador Léxico: Lexer

A classe Lexer realiza a varredura do código:

```java
public List<Token> analyze() {
    while (position < input.length()) {
        char currentChar = input.charAt(position);
        
        // Ignora espaços
        if (Character.isWhitespace(currentChar)) {
            skipWhitespace();
            continue;
        }
        
        // Identifica e processa cada tipo de token
        if (Character.isLetter(currentChar) || currentChar == '_') {
            scanIdentifierOrKeyword();
        } else if (Character.isDigit(currentChar)) {
            scanNumber();
        } else if (isOperatorChar(currentChar)) {
            scanOperator();
        } else if (isDelimiterChar(currentChar)) {
            scanDelimiter();
        } else {
            // Token desconhecido
            addUnknownToken();
        }
    }
    
    return tokens;
}
```

O Lexer controla:
- Posição atual (position)
- Linha e coluna para rastreamento
- Lista de tokens encontrados
- Contagem de erros

#### 3.2.5 Validadores Específicos

**IdentifierValidator**:
```java
public static boolean isValidIdentifier(String identifier) {
    // Primeiro caractere: letra ou _
    char firstChar = identifier.charAt(0);
    if (!Character.isLetter(firstChar) && firstChar != '_')
        return false;
    
    // Demais caracteres: letras, dígitos ou _
    for (int i = 1; i < identifier.length(); i++) {
        char c = identifier.charAt(i);
        if (!Character.isLetterOrDigit(c) && c != '_')
            return false;
    }
    
    return true;
}
```

**NumberValidator**:
```java
public static boolean isReal(String number) {
    // Contabiliza ocorrências de '.'
    int dotCount = 0;
    int digitCount = 0;
    
    for (char c : number.toCharArray()) {
        if (c == '.') dotCount++;
        else if (Character.isDigit(c)) digitCount++;
        else return false;
    }
    
    // Exatamente um ponto e dígitos em ambos os lados
    return dotCount == 1 && digitCount >= 2;
}
```

#### 3.2.6 Interface Gráfica: MainFrame

A interface utiliza Java Swing com os seguintes componentes:

- **JTextArea**: Entrada de código
- **JButton**: Botões "Analisar" e "Limpar"
- **JTable**: Exibição dos tokens reconhecidos
- **JLabel**: Informações (contagem de tokens e erros)

### 3.3 Fluxo de Execução

1. **Inicialização**: Usuário abre a aplicação
2. **Entrada**: Digita ou cola código na JTextArea
3. **Análise**: Clica em "Analisar"
4. **Processamento**: 
   - Lexer.analyze() percorre o código
   - Para cada caractere, identifica o tipo de token
   - Tokens são armazenados em uma lista
5. **Visualização**: 
   - Tabela é populada com os tokens
   - Informações são atualizadas
6. **Repetição**: Usuário pode analisar mais código

---

## 4. Resultados Esperados

### 4.1 Funcionalidades Implementadas

✅ Reconhecimento de todas as 50 palavras-chave de Java
✅ Validação de identificadores conforme regras de Java
✅ Reconhecimento de números inteiros e reais
✅ Reconhecimento de strings e caracteres literais
✅ Reconhecimento de operadores (incluindo operador personalizado <>)
✅ Reconhecimento de delimitadores
✅ Rastreamento de linha e coluna
✅ Detecção de tokens desconhecidos
✅ Interface gráfica intuitiva
✅ Contagem de tokens e erros

### 4.2 Exemplo de Saída

Para o código de entrada:

```java
public class Teste{
    public static void main(String[] args){
        int idade=20;
        double altura=1.75;
        String nome="Miguel";
        char sexo='M';
        if(idade>18 && altura>=1.70){
            System.out.println(nome);
        }
    }
}
```

A análise produz a seguinte tabela de tokens:

| Lexema | Tipo | Linha | Coluna |
|--------|------|-------|--------|
| public | Palavra Reservada | 1 | 1 |
| class | Palavra Reservada | 1 | 8 |
| Teste | Identificador | 1 | 14 |
| { | Delimitador | 1 | 19 |
| ... | ... | ... | ... |

### 4.3 Tratamento de Erros

O sistema identifica e conta erros léxicos como:
- Identificadores inválidos (começando com número)
- Strings não fechadas
- Caracteres desconhecidos
- Operadores não reconhecidos

---

## 5. Conclusão

O desenvolvimento deste analisador léxico demonstra a aplicação prática dos conceitos de Autômatos Finitos e Análise Léxica em um contexto real. A implementação em Java com interface gráfica torna o aprendizado destes conceitos mais tangível e interativo.

### 5.1 Contribuições

- Implementação funcional de um AFD para reconhecimento de tokens
- Aplicação de boas práticas de Programação Orientada a Objetos
- Demonstração da separação entre lógica (Lexer) e apresentação (UI)
- Ferramenta educacional para compreender análise léxica

### 5.2 Trabalhos Futuros

Possíveis extensões do projeto:
- Implementação da análise sintática (parser)
- Suporte a comentários (single-line e multi-line)
- Análise semântica básica
- Geração de código intermediário
- Otimizações do analisador léxico
- Suporte a expressões regulares para definição de tokens
- Implementação de AFN com conversão para AFD
- Exportação de resultados (JSON, XML)

### 5.3 Conclusão Final

Este projeto exemplifica como conceitos teóricos de Linguagens Formais podem ser implementados de forma prática e eficiente. O uso de Java e Swing permite criar uma ferramenta educacional profissional que facilita a compreensão dos mecanismos internos de um compilador.

---

## Referências

AHO, A. V.; LAM, M. S.; SETHI, R.; ULLMAN, J. D. **Compilers: Principles, Techniques, and Tools**. 2nd ed. Boston: Addison-Wesley, 2006.

APPEL, A. W. **Modern Compiler Implementation in Java**. 2nd ed. Cambridge: Cambridge University Press, 2002.

AHO, A. V.; ULLMAN, J. D. **The Theory of Parsing, Translation, and Compiling**. Englewood Cliffs: Prentice-Hall, 1972.

HOPCROFT, J. E.; MOTWANI, R.; ULLMAN, J. D. **Introduction to Automata Theory, Languages, and Computation**. 3rd ed. Boston: Addison-Wesley, 2006.

LOUDEN, K. C. **Compiler Construction: Principles and Practice**. Boston: PWS Publishing Company, 1997.

SIPSER, M. **Introduction to the Theory of Computation**. 3rd ed. Boston: Cengage Learning, 2012.

COOPER, K. D.; TORCZON, L. **Engineering a Compiler**. 2nd ed. Boston: Morgan Kaufmann, 2011.

GRUNE, D.; JACOBS, C. J. **Parsing Techniques: A Practical Guide**. 2nd ed. New York: Springer, 2008.

---

**Artigo desenvolvido para fins acadêmicos em Linguagens Formais e Compiladores.**

Data: 2026
Autor: Miguel
Instituição: Universidade [Educação Formal]
