# Guia Rápido de Referência - Analisador Léxico

## Estrutura de Classes

### Pacote: lexer (Núcleo da Análise)

#### TokenType.java
- **Enum** com os tipos de tokens possíveis
- Valores: KEYWORD, IDENTIFIER, INTEGER, REAL, STRING, CHAR, OPERATOR, DELIMITER, UNKNOWN
- Cada tipo possui uma descrição em português

#### Token.java
- **Classe** que representa um token individual
- Atributos: lexeme (String), type (TokenType), line (int), column (int)
- Construtor e getters
- Método toString() para exibição

#### State.java
- **Enum** dos estados do Autômato Finito Determinístico
- Estados: START, LETTER, NUMBER, REAL, STRING, CHAR, OPERATOR, DELIMITER, END, ERROR
- Cada estado possui uma descrição

#### Automaton.java
- **Classe** que implementa o AFD
- Método principal: `recognize(String lexeme)` - classifica um lexema
- Métodos auxiliares para verificar delimitadores
- Retorna o TokenType apropriado

#### Lexer.java
- **Classe** principal do analisador léxico
- Construtor: `Lexer(String input)`
- Método público: `analyze()` - retorna List<Token>
- Métodos privados para processar diferentes tipos de tokens
- Rastreia posição, linha, coluna e erros

### Pacote: utils (Validadores)

#### ReservedWords.java
- Gerencia o conjunto de 50 palavras reservadas Java
- Método: `isReserved(String word)` - boolean

#### IdentifierValidator.java
- Valida identificadores conforme regras Java
- Método: `isValidIdentifier(String identifier)` - boolean
- Regra: começa com letra ou _, contém letras/dígitos/_

#### NumberValidator.java
- Valida números inteiros e reais
- Métodos:
  - `isInteger(String number)` - boolean
  - `isReal(String number)` - boolean
  - `isNumber(String number)` - boolean

#### StringValidator.java
- Valida strings e caracteres literais
- Métodos:
  - `isString(String str)` - boolean (entre aspas duplas)
  - `isChar(String str)` - boolean (entre aspas simples)

#### OperatorValidator.java
- Gerencia operadores reconhecidos
- Método: `isOperator(String operator)` - boolean
- Método: `isOperatorChar(char ch)` - boolean

### Pacote: ui (Interface Gráfica)

#### MainFrame.java
- **Classe principal da interface**
- Herda de JFrame
- Componentes:
  - JTextArea: entrada de código
  - JButton: "Analisar" e "Limpar"
  - JTable: exibição de tokens
  - JLabel: informações (contadores e status)
- Métodos principais:
  - `analyzeCode()` - executa análise
  - `clearAll()` - limpa dados

#### ResultTableModel.java
- **Classe customizada de AbstractTableModel**
- Exibe tokens em formato tabular
- Colunas: Lexema, Tipo, Linha, Coluna
- Métodos:
  - `setTokens(List<Token>)` - atualiza dados
  - `clearTokens()` - limpa tabela

### Pacote: main

#### Main.java
- Ponto de entrada da aplicação
- Chama `MainFrame.main(args)`

---

## Fluxo de Execução

```
1. Main.main()
   ↓
2. MainFrame construtor
   ↓
3. initializeComponents()
   ↓
4. setupLayout()
   ↓
5. setupListeners()
   ↓
6. Interface visível aguardando entrada
   ↓
7. Usuário clica "Analisar"
   ↓
8. analyzeCode()
   ↓
9. Lexer.analyze()
   ↓
10. Para cada caractere:
    - Determina o tipo
    - Cria Token
    - Adiciona à lista
   ↓
11. Tokens retornam para MainFrame
   ↓
12. tableModel.setTokens()
   ↓
13. Labels atualizados
   ↓
14. Interface atualizada
```

---

## Algoritmo Principal do Lexer

```java
while (position < input.length()) {
    char c = input[position];
    
    if (isWhitespace(c)) {
        skipWhitespace();
    } else if (isLetter(c) || c == '_') {
        scanIdentifierOrKeyword();
    } else if (isDigit(c)) {
        scanNumber();
    } else if (isOperatorChar(c)) {
        scanOperator();
    } else if (isDelimiterChar(c)) {
        addDelimiter();
    } else {
        addUnknownToken();
    }
}
```

---

## Métodos Públicos Principais

### Lexer
- `List<Token> analyze()`
- `List<Token> getTokens()`
- `int getErrorCount()`

### Automaton
- `static TokenType recognize(String lexeme)`
- `static boolean isDelimiterChar(char ch)`
- `static boolean isDelimiter(String lexeme)`

### Validadores
- `ReservedWords.isReserved(String)`
- `IdentifierValidator.isValidIdentifier(String)`
- `NumberValidator.isInteger(String)`
- `NumberValidator.isReal(String)`
- `StringValidator.isString(String)`
- `StringValidator.isChar(String)`
- `OperatorValidator.isOperator(String)`

### MainFrame
- `static void main(String[] args)`

---

## Configurações Importantes

### Tamanho da Janela
- Largura: 900 pixels
- Altura: 700 pixels
- Localização: Centralizada

### Fontes
- Entrada (TextArea): Courier New, 12pt
- Tabela: Arial, 11pt
- Headers: Arial Bold, 11pt
- Labels: Arial, 11pt

### Alturas de Componentes
- TextArea: 200 pixels
- Tabela: 250 pixels
- Painel inferior: Restante

---

## Constantes e Limites

### Palavras Reservadas
- Total: 50 palavras
- Armazenadas em: HashSet<String>

### Operadores
- Total: 21 operadores
- Inclui operador personalizado: <>

### Delimitadores
- Total: 9 caracteres
- ( ) { } [ ] ; , .

---

## Tratamento de Erros

### Tipos de Erro Detectados
1. Token desconhecido
2. String não fechada
3. Identificador inválido
4. Operador não reconhecido

### Mecanismo
- Cada erro incrementa `errorCount`
- Token inválido recebe tipo UNKNOWN
- Posição é registrada para depuração

---

## Extensibilidade

### Para Adicionar Nova Palavra Reservada
1. Editar `ReservedWords.java`
2. Adicionar ao HashSet no bloco static

### Para Adicionar Novo Operador
1. Editar `OperatorValidator.java`
2. Adicionar ao HashSet OPERATORS

### Para Adicionar Novo Tipo de Token
1. Editar `TokenType.java` - adicionar ao enum
2. Editar `Automaton.recognize()` - adicionar lógica
3. Atualizar MainFrame se necessário

---

## Pontos de Otimização Futuros

1. **Cache de palavras-chave**: Usar array em lugar de HashSet
2. **Processamento em thread**: Para arquivos muito grandes
3. **Compilation ao vivo**: Análise enquanto digita
4. **Histórico**: Manter análises anteriores
5. **Temas**: Modo claro e escuro

---

## Testes Recomendados

### Teste 1: Básico
- Código: `int x = 10;`
- Esperado: 5 tokens, 0 erros

### Teste 2: Palavras Reservadas
- Código: `public class Test { }`
- Esperado: 5 tokens, 0 erros

### Teste 3: Identificador Inválido
- Código: `1teste = 10;`
- Esperado: 3 tokens, 1 erro

### Teste 4: Complexo
- Usar EXEMPLOS_TESTE.md

---

## Arquivos de Configuração Necessários

- **build.sh**: Necessário para compilar
- **run.sh**: Necessário para executar
- Nenhum arquivo XML, INI ou properties necessário

---

## Dependências

- **Internas**: Apenas pacotes java.awt, javax.swing
- **Externas**: Nenhuma
- **JDK Mínimo**: Java 11

---

## Linhas de Código

- Total: ~2000 linhas
- Documentação: ~500 linhas (comentários JavaDoc)
- Código Produtivo: ~1500 linhas

---

## Documentação Disponível

1. **README.md** - Manual do usuário
2. **ARTIGO.md** - Artigo científico
3. **EXEMPLOS_TESTE.md** - Exemplos de teste
4. **ENTREGA.md** - Resumo da entrega
5. **REFERENCIA.md** - Este arquivo

---

**Versão:** 1.0  
**Última Atualização:** Junho de 2026  
**Status:** Completo ✅
