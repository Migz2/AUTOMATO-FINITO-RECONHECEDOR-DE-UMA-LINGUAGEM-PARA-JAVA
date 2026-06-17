package lexer;

import utils.OperatorValidator;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que implementa o analisador léxico.
 * 
 * Responsável por percorrer o código e reconhecer os tokens
 * utilizando um Autômato Finito Determinístico.
 * 
 * @author Miguel
 * @version 1.0
 */
public class Lexer {
    private String input;
    private int position;
    private int line;
    private int column;
    private List<Token> tokens;
    private int errorCount;

    /**
     * Construtor do analisador léxico.
     * 
     * @param input O código a ser analisado
     */
    public Lexer(String input) {
        this.input = input;
        this.position = 0;
        this.line = 1;
        this.column = 1;
        this.tokens = new ArrayList<>();
        this.errorCount = 0;
    }

    /**
     * Realiza a análise léxica do código.
     * 
     * @return Lista de tokens reconhecidos
     */
    public List<Token> analyze() {
        while (position < input.length()) {
            char currentChar = input.charAt(position);

            // Ignora espaços
            if (currentChar == ' ' || currentChar == '\t') {
                position++;
                column++;
                continue;
            }

            // Trata quebras de linha
            if (currentChar == '\n') {
                line++;
                column = 1;
                position++;
                continue;
            }

            // Trata retorno de carro
            if (currentChar == '\r') {
                position++;
                if (position < input.length() && input.charAt(position) == '\n') {
                    position++;
                }
                line++;
                column = 1;
                continue;
            }

            // Trata strings entre aspas duplas
            if (currentChar == '"') {
                scanString('"');
                continue;
            }

            // Trata caracteres entre aspas simples
            if (currentChar == '\'') {
                scanString('\'');
                continue;
            }

            // Trata números e identificadores
            if (Character.isLetter(currentChar) || currentChar == '_') {
                scanIdentifierOrKeyword();
                continue;
            }

            // Trata números
            if (Character.isDigit(currentChar)) {
                scanNumber();
                continue;
            }

            // Trata operadores
            if (OperatorValidator.isOperatorChar(currentChar)) {
                scanOperator();
                continue;
            }

            // Trata delimitadores
            if (Automaton.isDelimiterChar(currentChar)) {
                int startColumn = column;
                String lexeme = String.valueOf(currentChar);
                tokens.add(new Token(lexeme, TokenType.DELIMITER, line, startColumn));
                position++;
                column++;
                continue;
            }

            // Caractere desconhecido
            int startColumn = column;
            String lexeme = String.valueOf(currentChar);
            tokens.add(new Token(lexeme, TokenType.UNKNOWN, line, startColumn));
            errorCount++;
            position++;
            column++;
        }

        return tokens;
    }

    /**
     * Realiza a leitura de uma string ou caractere.
     * 
     * @param delimiter O caractere delimitador (aspas duplas ou simples)
     */
    private void scanString(char delimiter) {
        int startColumn = column;
        int startPos = position;
        position++; // Pula a aspra inicial
        column++;

        while (position < input.length()) {
            char currentChar = input.charAt(position);

            if (currentChar == delimiter) {
                position++; // Pula a aspra final
                column++;
                String lexeme = input.substring(startPos, position);

                TokenType type = (delimiter == '"') ? TokenType.STRING : TokenType.CHAR;
                tokens.add(new Token(lexeme, type, line, startColumn));
                return;
            }

            if (currentChar == '\n') {
                line++;
                column = 1;
            } else {
                column++;
            }

            position++;
        }

        // String não fechada - token inválido
        String lexeme = input.substring(startPos);
        tokens.add(new Token(lexeme, TokenType.UNKNOWN, line, startColumn));
        errorCount++;
    }

    /**
     * Realiza a leitura de um identificador ou palavra reservada.
     */
    private void scanIdentifierOrKeyword() {
        int startColumn = column;
        int startPos = position;

        while (position < input.length()) {
            char currentChar = input.charAt(position);

            if (!Character.isLetterOrDigit(currentChar) && currentChar != '_') {
                break;
            }

            position++;
            column++;
        }

        String lexeme = input.substring(startPos, position);
        TokenType type = Automaton.recognize(lexeme);
        tokens.add(new Token(lexeme, type, line, startColumn));
    }

    /**
     * Realiza a leitura de um número (inteiro ou real).
     */
    private void scanNumber() {
        int startColumn = column;
        int startPos = position;
        boolean hasDecimalPoint = false;

        while (position < input.length()) {
            char currentChar = input.charAt(position);

            if (currentChar == '.') {
                if (hasDecimalPoint) {
                    break; // Segundo ponto, para a leitura
                }
                hasDecimalPoint = true;
                position++;
                column++;
                continue;
            }

            if (!Character.isDigit(currentChar)) {
                break;
            }

            position++;
            column++;
        }

        String lexeme = input.substring(startPos, position);
        TokenType type = Automaton.recognize(lexeme);
        tokens.add(new Token(lexeme, type, line, startColumn));
    }

    /**
     * Realiza a leitura de um operador.
     */
    private void scanOperator() {
        int startColumn = column;
        int startPos = position;
        position++;
        column++;

        // Verifica operadores de dois caracteres
        if (position < input.length()) {
            String twoCharOp = input.substring(startPos, position + 1);
            if (OperatorValidator.isOperator(twoCharOp)) {
                position++;
                column++;
                String lexeme = input.substring(startPos, position);
                tokens.add(new Token(lexeme, TokenType.OPERATOR, line, startColumn));
                return;
            }
        }

        // Operador de um caractere
        String lexeme = input.substring(startPos, position);
        if (OperatorValidator.isOperator(lexeme)) {
            tokens.add(new Token(lexeme, TokenType.OPERATOR, line, startColumn));
        } else {
            tokens.add(new Token(lexeme, TokenType.UNKNOWN, line, startColumn));
            errorCount++;
        }
    }

    /**
     * Obtém a lista de tokens reconhecidos.
     * 
     * @return Lista de tokens
     */
    public List<Token> getTokens() {
        return tokens;
    }

    /**
     * Obtém a contagem de erros encontrados.
     * 
     * @return Número de erros
     */
    public int getErrorCount() {
        return errorCount;
    }
}
