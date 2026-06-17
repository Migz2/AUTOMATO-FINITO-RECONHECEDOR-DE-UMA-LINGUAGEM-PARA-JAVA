package lexer;

/**
 * Enum que define os tipos de tokens reconhecidos pelo analisador léxico.
 * 
 * @author Miguel
 * @version 1.0
 */
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

    TokenType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
