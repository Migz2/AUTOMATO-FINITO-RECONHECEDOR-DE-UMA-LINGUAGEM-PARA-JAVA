# Reconhecedor Léxico para Java

## Objetivo

Este projeto implementa um analisador léxico (lexer) baseado em um Autômato Finito Determinístico (AFD) que reconhece uma linguagem inspirada em Java. O objetivo é ler código digitado pelo usuário e separar os tokens encontrados, classificando-os conforme seu tipo.

## Como Executar

### Pré-requisitos

- Java JDK 11 ou superior instalado
- IDE (VSCode, IntelliJ IDEA) ou compilador Java (javac)

### Compilação e Execução

#### Opção 1: Usando a linha de comando

```bash
# Navegue até a raiz do projeto
cd /caminho/para/LFA

# Compile todos os arquivos
javac -d bin src/lexer/*.java src/utils/*.java src/ui/*.java src/main/*.java

# Execute a aplicação
java -cp bin Main
```

#### Opção 2: Usando VSCode

1. Abra a pasta do projeto no VSCode
2. Instale a extensão "Extension Pack for Java" (Microsoft)
3. Clique em "Run" sobre a classe Main ou pressione F5

#### Opção 3: Usando IntelliJ IDEA

1. Abra a pasta do projeto como novo projeto
2. Clique em "Run" > "Run 'Main'" ou pressione Shift+F10

## Estrutura do Projeto

```
LFA/
├── src/
│   ├── main/
│   │   └── Main.java                 # Ponto de entrada da aplicação
│   ├── lexer/
│   │   ├── Lexer.java               # Analisador léxico principal
│   │   ├── Token.java               # Classe que representa um token
│   │   ├── TokenType.java           # Enum dos tipos de tokens
│   │   ├── State.java               # Enum dos estados do AFD
│   │   └── Automaton.java           # Implementação do AFD
│   ├── ui/
│   │   ├── MainFrame.java           # Interface gráfica principal
│   │   └── ResultTableModel.java    # Modelo customizado da JTable
│   └── utils/
│       ├── ReservedWords.java       # Gerenciador de palavras reservadas
│       ├── IdentifierValidator.java # Validador de identificadores
│       ├── NumberValidator.java     # Validador de números
│       ├── StringValidator.java     # Validador de strings/chars
│       └── OperatorValidator.java   # Validador de operadores
├── README.md                         # Este arquivo
└── ARTIGO.md                         # Artigo científico
```

## Funcionamento

### Interface Gráfica

A aplicação oferece uma interface intuitiva com os seguintes componentes:

- **Área de Entrada**: Campo de texto onde o usuário digita o código a ser analisado
- **Botão Analisar**: Inicia a análise léxica do código
- **Botão Limpar**: Limpa todos os dados da interface
- **Tabela de Resultados**: Exibe os tokens encontrados com as colunas:
  - Lexema (o texto do token)
  - Tipo (classificação do token)
  - Linha (número da linha onde foi encontrado)
  - Coluna (posição na linha)
- **Painel de Informações**: Mostra:
  - Quantidade de tokens reconhecidos
  - Quantidade de erros encontrados
  - Status da análise

### Processo de Análise Léxica

1. O código é passado para a classe `Lexer`
2. O Lexer percorre o código caractere por caractere
3. Para cada caractere, o autômato determina o tipo de token
4. Os tokens são armazenados em uma lista
5. A lista é exibida na tabela da interface

### Tipos de Tokens Reconhecidos

- **Palavras Reservadas**: abstract, boolean, break, byte, class, for, if, etc.
- **Identificadores**: variáveis e nomes de classes (deve começar com letra ou _ )
- **Inteiros**: números sem ponto decimal (0, 1, 123, etc.)
- **Reais**: números com ponto decimal (3.14, 10.5, etc.)
- **Strings**: texto entre aspas duplas ("Hello", "Teste")
- **Caracteres**: um caractere entre aspas simples ('a', 'x')
- **Operadores**: +, -, *, /, ++, --, +=, ==, !=, &&, ||, <>, etc.
- **Delimitadores**: (, ), {, }, [, ], ;, ,, .
- **Desconhecidos**: caracteres não classificáveis

## Exemplo de Uso

Copie e cole o seguinte código na área de entrada:

```java
public class Teste {
    public static void main(String[] args) {
        int idade = 20;
        double altura = 1.75;
        String nome = "Miguel";
        char sexo = 'M';
        
        if (idade > 18 && altura >= 1.70) {
            System.out.println(nome);
        }
    }
}
```

Após clicar em "Analisar", você verá uma tabela contendo todos os tokens reconhecidos com suas respectivas informações (lexema, tipo, linha e coluna).

## Recursos Principais

✅ Análise léxica baseada em Autômato Finito Determinístico
✅ Suporte a múltiplos tipos de tokens
✅ Reconhecimento de números inteiros e reais
✅ Suporte a strings e caracteres literais
✅ Rastreamento de linhas e colunas
✅ Interface gráfica amigável com Java Swing
✅ Contagem de erros e tokens
✅ Design orientado a objetos

## Palavras Reservadas Reconhecidas

abstract, boolean, break, byte, case, catch, char, class, continue, default, do, double, else, extends, false, final, finally, float, for, if, implements, import, int, interface, long, new, null, package, private, protected, public, return, short, static, super, switch, this, throw, throws, true, try, void, while, String

## Operadores Suportados

### Matemáticos
`+` `-` `*` `/` `%` `^`

### Atribuição
`=` `+=` `-=` `*=` `/=`

### Incremento/Decremento
`++` `--`

### Relacionais
`>` `<` `>=` `<=` `==` `!=`

### Lógicos
`&&` `||` `!`

### Personalizado (acadêmico)
`<>`

## Arquitetura e Design

### Princípios Aplicados

- **Separação de Responsabilidades**: Cada classe tem uma responsabilidade clara
- **Encapsulamento**: Uso de modificadores de acesso apropriados
- **Reutilização de Código**: Métodos utilitários centralizados
- **Padrão MVC**: Separação entre lógica (Lexer) e apresentação (UI)

### Classes Principais

- **Lexer**: Implementa o analisador léxico
- **Token**: Representa um token individual
- **Automaton**: Implementa o AFD para reconhecimento de tokens
- **MainFrame**: Interface gráfica do usuário
- Classes Utilitárias: Validadores específicos para cada tipo de token

## Requisitos Técnicos

- Java 11+
- Biblioteca Swing (incluída no JDK)

## Autor

Miguel - Engenheiro de Software

## Licença

Projeto acadêmico - Uso livre para fins educacionais

## Observações

Este projeto foi desenvolvido como um exercício acadêmico em Linguagens Formais e Compiladores, demonstrando os conceitos práticos de:

- Autômatos Finitos Determinísticos
- Análise Léxica
- Programação Orientada a Objetos
- Interface Gráfica em Java

Para mais detalhes técnicos, consulte o arquivo `ARTIGO.md`.
# UTOMATO-FINITO-RECONHECEDOR-DE-UMA-LINGUAGEM-PARA-JAVA
