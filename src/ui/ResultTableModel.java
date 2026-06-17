package ui;

import javax.swing.table.AbstractTableModel;
import lexer.Token;
import java.util.ArrayList;
import java.util.List;

/**
 * Modelo customizado para a JTable que exibe os tokens.
 * 
 * @author Miguel
 * @version 1.0
 */
public class ResultTableModel extends AbstractTableModel {
    private static final String[] COLUMN_NAMES = {"Lexema", "Tipo", "Linha", "Coluna"};
    private List<Token> tokens;

    /**
     * Construtor do modelo da tabela.
     */
    public ResultTableModel() {
        this.tokens = new ArrayList<>();
    }

    /**
     * Define a lista de tokens a ser exibida na tabela.
     * 
     * @param tokens Lista de tokens
     */
    public void setTokens(List<Token> tokens) {
        this.tokens = new ArrayList<>(tokens);
        fireTableDataChanged();
    }

    /**
     * Limpa todos os tokens da tabela.
     */
    public void clearTokens() {
        this.tokens.clear();
        fireTableDataChanged();
    }

    /**
     * Obtém o número de linhas (tokens).
     * 
     * @return Número de linhas
     */
    @Override
    public int getRowCount() {
        return tokens.size();
    }

    /**
     * Obtém o número de colunas.
     * 
     * @return Número de colunas
     */
    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    /**
     * Obtém o nome de uma coluna.
     * 
     * @param column Índice da coluna
     * @return Nome da coluna
     */
    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    /**
     * Obtém o valor de uma célula.
     * 
     * @param row Índice da linha
     * @param column Índice da coluna
     * @return Valor da célula
     */
    @Override
    public Object getValueAt(int row, int column) {
        if (row < 0 || row >= tokens.size()) {
            return null;
        }

        Token token = tokens.get(row);

        switch (column) {
            case 0: // Lexema
                return token.getLexeme();
            case 1: // Tipo
                return token.getType().getDescription();
            case 2: // Linha
                return token.getLine();
            case 3: // Coluna
                return token.getColumn();
            default:
                return null;
        }
    }

    /**
     * Indica se uma célula é editável (não é).
     * 
     * @param row Índice da linha
     * @param column Índice da coluna
     * @return false (não editável)
     */
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
