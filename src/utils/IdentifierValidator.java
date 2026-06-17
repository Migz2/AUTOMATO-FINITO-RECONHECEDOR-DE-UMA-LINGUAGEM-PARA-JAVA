package utils;

/**
 * Classe responsável pela validação de identificadores.
 * 
 * Um identificador válido deve:
 * - Começar com letra ou underscore (_)
 * - Conter apenas letras, números e underscores
 * 
 * @author Miguel
 * @version 1.0
 */
public class IdentifierValidator {

    /**
     * Verifica se uma string é um identificador válido.
     * 
     * @param identifier A string a ser verificada
     * @return true se é um identificador válido, false caso contrário
     */
    public static boolean isValidIdentifier(String identifier) {
        if (identifier == null || identifier.isEmpty()) {
            return false;
        }

        // Verifica o primeiro caractere: deve ser letra ou underscore
        char firstChar = identifier.charAt(0);
        if (!Character.isLetter(firstChar) && firstChar != '_') {
            return false;
        }

        // Verifica os demais caracteres: devem ser letras, números ou underscores
        for (int i = 1; i < identifier.length(); i++) {
            char c = identifier.charAt(i);
            if (!Character.isLetterOrDigit(c) && c != '_') {
                return false;
            }
        }

        return true;
    }
}
