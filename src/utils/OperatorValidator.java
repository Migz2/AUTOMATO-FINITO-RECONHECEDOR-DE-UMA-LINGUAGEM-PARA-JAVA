package utils;

import java.util.HashSet;
import java.util.Set;

/**
 * Classe responsável pela validação de operadores.
 * 
 * @author Miguel
 * @version 1.0
 */
public class OperatorValidator {
    private static final Set<String> OPERATORS = new HashSet<>();
    private static final Set<Character> OPERATOR_CHARS = new HashSet<>();

    static {
        // Operadores matemáticos
        OPERATORS.add("+");
        OPERATORS.add("-");
        OPERATORS.add("*");
        OPERATORS.add("/");
        OPERATORS.add("%");
        OPERATORS.add("^");

        // Operadores de atribuição
        OPERATORS.add("=");
        OPERATORS.add("+=");
        OPERATORS.add("-=");
        OPERATORS.add("*=");
        OPERATORS.add("/=");

        // Operadores incremento/decremento
        OPERATORS.add("++");
        OPERATORS.add("--");

        // Operadores relacionais
        OPERATORS.add(">");
        OPERATORS.add("<");
        OPERATORS.add(">=");
        OPERATORS.add("<=");
        OPERATORS.add("==");
        OPERATORS.add("!=");

        // Operadores lógicos
        OPERATORS.add("&&");
        OPERATORS.add("||");
        OPERATORS.add("!");

        // Operador personalizado
        OPERATORS.add("<>");

        // Caracteres que podem iniciar operadores
        OPERATOR_CHARS.add('+');
        OPERATOR_CHARS.add('-');
        OPERATOR_CHARS.add('*');
        OPERATOR_CHARS.add('/');
        OPERATOR_CHARS.add('%');
        OPERATOR_CHARS.add('^');
        OPERATOR_CHARS.add('=');
        OPERATOR_CHARS.add('!');
        OPERATOR_CHARS.add('>');
        OPERATOR_CHARS.add('<');
        OPERATOR_CHARS.add('&');
        OPERATOR_CHARS.add('|');
    }

    /**
     * Verifica se uma string é um operador válido.
     * 
     * @param operator A string a ser verificada
     * @return true se é um operador válido, false caso contrário
     */
    public static boolean isOperator(String operator) {
        return OPERATORS.contains(operator);
    }

    /**
     * Verifica se um caractere pode iniciar um operador.
     * 
     * @param ch O caractere a ser verificado
     * @return true se o caractere pode iniciar um operador, false caso contrário
     */
    public static boolean isOperatorChar(char ch) {
        return OPERATOR_CHARS.contains(ch);
    }
}
