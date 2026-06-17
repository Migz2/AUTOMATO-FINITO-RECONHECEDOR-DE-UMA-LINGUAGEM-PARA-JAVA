package lexer;

/**
 * Classe que representa um Token reconhecido pelo analisador léxico.
 * 
 * @author Miguel
 * @version 1.0
 */
public class Token {
    private String lexeme;
    private TokenType type;
    private int line;
    private int column;

    /**
     * Construtor da classe Token.
     * 
     * @param lexeme O lexema (string) do token
     * @param type O tipo do token
     * @param line O número da linha onde o token foi encontrado
     * @param column A coluna onde o token foi encontrado
     */
    public Token(String lexeme, TokenType type, int line, int column) {
        this.lexeme = lexeme;
        this.type = type;
        this.line = line;
        this.column = column;
    }

    /**
     * Obtém o lexema do token.
     * 
     * @return O lexema
     */
    public String getLexeme() {
        return lexeme;
    }

    /**
     * Obtém o tipo do token.
     * 
     * @return O tipo do token
     */
    public TokenType getType() {
        return type;
    }

    /**
     * Obtém a linha do token.
     * 
     * @return O número da linha
     */
    public int getLine() {
        return line;
    }

    /**
     * Obtém a coluna do token.
     * 
     * @return O número da coluna
     */
    public int getColumn() {
        return column;
    }

    /**
     * Representação em string do token.
     * 
     * @return String contendo informações do token
     */
    @Override
    public String toString() {
        return String.format("Token{lexeme='%s', type=%s, line=%d, column=%d}",
                lexeme, type.getDescription(), line, column);
    }
}
