package utils;

/**
 * Classe responsável pela validação de strings e caracteres literais.
 * 
 * @author Miguel
 * @version 1.0
 */
public class StringValidator {

    /**
     * Verifica se uma string é um literal string válido.
     * Deve estar entre aspas duplas.
     * 
     * @param str A string a ser verificada
     * @return true se é um string literal válido, false caso contrário
     */
    public static boolean isString(String str) {
        if (str == null || str.length() < 2) {
            return false;
        }

        return str.startsWith("\"") && str.endsWith("\"");
    }

    /**
     * Verifica se uma string é um literal caractere válido.
     * Deve estar entre aspas simples.
     * 
     * @param str A string a ser verificada
     * @return true se é um caractere literal válido, false caso contrário
     */
    public static boolean isChar(String str) {
        if (str == null || str.length() < 3) {
            return false;
        }

        return str.startsWith("'") && str.endsWith("'");
    }
}
