package lexer;

/**
 * Enum que representa os estados possíveis do Autômato Finito Determinístico.
 * 
 * @author Miguel
 * @version 1.0
 */
public enum State {
    START("Inicial"),
    LETTER("Letra"),
    NUMBER("Número"),
    REAL("Real"),
    STRING("String"),
    CHAR("Caractere"),
    OPERATOR("Operador"),
    DELIMITER("Delimitador"),
    END("Fim"),
    ERROR("Erro");

    private final String description;

    State(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
