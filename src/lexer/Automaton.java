package lexer;

import utils.*;

/**
 * Classe que implementa o Autômato Finito Determinístico (AFD)
 * para reconhecimento de tokens.
 * 
 * @author Miguel
 * @version 1.0
 */
public class Automaton {

    /**
     * Reconhece o tipo de token baseado em seu lexema.
     * 
     * @param lexeme O lexema a ser reconhecido
     * @return O tipo de token reconhecido
     */
    public static TokenType recognize(String lexeme) {
        if (lexeme == null || lexeme.isEmpty()) {
            return TokenType.UNKNOWN;
        }

        // Verifica se é uma palavra reservada
        if (ReservedWords.isReserved(lexeme)) {
            return TokenType.KEYWORD;
        }

        // Verifica se é uma string
        if (StringValidator.isString(lexeme)) {
            return TokenType.STRING;
        }

        // Verifica se é um caractere
        if (StringValidator.isChar(lexeme)) {
            return TokenType.CHAR;
        }

        // Verifica se é um número real
        if (NumberValidator.isReal(lexeme)) {
            return TokenType.REAL;
        }

        // Verifica se é um número inteiro
        if (NumberValidator.isInteger(lexeme)) {
            return TokenType.INTEGER;
        }

        // Verifica se é um operador
        if (OperatorValidator.isOperator(lexeme)) {
            return TokenType.OPERATOR;
        }

        // Verifica se é um delimitador
        if (isDelimiter(lexeme)) {
            return TokenType.DELIMITER;
        }

        // Verifica se é um identificador válido
        if (IdentifierValidator.isValidIdentifier(lexeme)) {
            return TokenType.IDENTIFIER;
        }

        // Caso nenhuma regra seja atendida
        return TokenType.UNKNOWN;
    }

    /**
     * Verifica se um caractere é um delimitador.
     * 
     * @param ch O caractere a ser verificado
     * @return true se é um delimitador, false caso contrário
     */
    public static boolean isDelimiterChar(char ch) {
        switch (ch) {
            case '(':
            case ')':
            case '{':
            case '}':
            case '[':
            case ']':
            case ';':
            case ',':
            case '.':
                return true;
            default:
                return false;
        }
    }

    /**
     * Verifica se uma string é um delimitador.
     * 
     * @param lexeme O lexema a ser verificado
     * @return true se é um delimitador, false caso contrário
     */
    public static boolean isDelimiter(String lexeme) {
        if (lexeme == null || lexeme.length() != 1) {
            return false;
        }

        return isDelimiterChar(lexeme.charAt(0));
    }

    /**
     * Obtém o estado inicial do autômato.
     * 
     * @return O estado inicial
     */
    public static State getInitialState() {
        return State.START;
    }

    /**
     * Obtém o estado final do autômato.
     * 
     * @return O estado final
     */
    public static State getFinalState() {
        return State.END;
    }
}
