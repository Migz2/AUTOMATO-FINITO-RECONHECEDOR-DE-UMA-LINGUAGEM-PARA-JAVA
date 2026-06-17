package utils;

/**
 * Classe responsável pela validação de números (inteiros e reais).
 * 
 * @author Miguel
 * @version 1.0
 */
public class NumberValidator {

    /**
     * Verifica se uma string é um número inteiro válido.
     * 
     * @param number A string a ser verificada
     * @return true se é um inteiro válido, false caso contrário
     */
    public static boolean isInteger(String number) {
        if (number == null || number.isEmpty()) {
            return false;
        }

        for (char c : number.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Verifica se uma string é um número real válido.
     * 
     * @param number A string a ser verificada
     * @return true se é um número real válido, false caso contrário
     */
    public static boolean isReal(String number) {
        if (number == null || number.isEmpty()) {
            return false;
        }

        // Deve conter exatamente um ponto
        int dotCount = 0;
        int digitCount = 0;

        for (char c : number.toCharArray()) {
            if (c == '.') {
                dotCount++;
            } else if (Character.isDigit(c)) {
                digitCount++;
            } else {
                return false;
            }
        }

        // Deve ter exatamente um ponto e pelo menos dois dígitos (um antes e outro depois)
        return dotCount == 1 && digitCount >= 2;
    }

    /**
     * Verifica se uma string é um número (inteiro ou real).
     * 
     * @param number A string a ser verificada
     * @return true se é um número válido, false caso contrário
     */
    public static boolean isNumber(String number) {
        return isInteger(number) || isReal(number);
    }
}
