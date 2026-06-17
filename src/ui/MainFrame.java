package ui;

import lexer.Lexer;
import lexer.Token;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Classe que implementa a interface grafica do analisador lexico.
 * 
 * Utiliza Java Swing para criar uma janela interativa onde o usuario
 * pode digitar codigo e analisar os tokens gerados.
 * 
 * @author Miguel
 * @version 1.0
 */
public class MainFrame extends JFrame {
    private JTextArea textAreaInput;
    private JButton buttonAnalyze;
    private JButton buttonClear;
    private JTable tableResults;
    private ResultTableModel tableModel;
    private JLabel labelTokenCount;
    private JLabel labelErrorCount;
    private JLabel labelStatus;

    /**
     * Construtor da janela principal.
     * Inicializa todos os componentes da interface.
     */
    public MainFrame() {
        setTitle("Reconhecedor Lexico para Java");
        setSize(900, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        initializeComponents();
        setupLayout();
        setupListeners();

        setVisible(true);
    }

    /**
     * Inicializa os componentes da interface.
     */
    private void initializeComponents() {
        textAreaInput = new JTextArea();
        textAreaInput.setFont(new Font("Courier New", Font.PLAIN, 12));
        textAreaInput.setLineWrap(true);
        textAreaInput.setWrapStyleWord(true);

        buttonAnalyze = new JButton("Analisar");
        buttonAnalyze.setFont(new Font("Arial", Font.PLAIN, 12));

        buttonClear = new JButton("Limpar");
        buttonClear.setFont(new Font("Arial", Font.PLAIN, 12));

        tableModel = new ResultTableModel();
        tableResults = new JTable(tableModel);
        tableResults.setFont(new Font("Arial", Font.PLAIN, 11));
        tableResults.getTableHeader().setFont(new Font("Arial", Font.BOLD, 11));
        tableResults.setRowHeight(25);

        labelTokenCount = new JLabel("Quantidade de tokens: 0");
        labelTokenCount.setFont(new Font("Arial", Font.PLAIN, 11));

        labelErrorCount = new JLabel("Quantidade de erros: 0");
        labelErrorCount.setFont(new Font("Arial", Font.PLAIN, 11));

        labelStatus = new JLabel("Pronto para analise");
        labelStatus.setFont(new Font("Arial", Font.PLAIN, 11));
        labelStatus.setForeground(Color.BLUE);
    }

    /**
     * Configura o layout dos componentes.
     */
    private void setupLayout() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBorder(BorderFactory.createTitledBorder("Codigo Fonte"));

        JScrollPane scrollInput = new JScrollPane(textAreaInput);
        scrollInput.setPreferredSize(new Dimension(0, 200));
        topPanel.add(scrollInput, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        buttonPanel.add(buttonAnalyze);
        buttonPanel.add(buttonClear);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createTitledBorder("Tokens Reconhecidos"));

        JScrollPane scrollTable = new JScrollPane(tableResults);
        scrollTable.setPreferredSize(new Dimension(0, 250));
        centerPanel.add(scrollTable, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        bottomPanel.setBorder(BorderFactory.createTitledBorder("Resultado da Analise"));
        bottomPanel.add(labelTokenCount);
        bottomPanel.add(labelErrorCount);
        bottomPanel.add(labelStatus);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        setContentPane(mainPanel);
    }

    /**
     * Configura os listeners dos botoes.
     */
    private void setupListeners() {
        buttonAnalyze.addActionListener(e -> analyzeCode());
        buttonClear.addActionListener(e -> clearAll());
    }

    /**
     * Realiza a analise lexica do codigo.
     */
    private void analyzeCode() {
        String code = textAreaInput.getText();

        if (code.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Por favor, digite o codigo a ser analisado.",
                    "Aviso",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        Lexer lexer = new Lexer(code);
        List<Token> tokens = lexer.analyze();

        tableModel.setTokens(tokens);

        int tokenCount = tokens.size();
        int errorCount = lexer.getErrorCount();

        labelTokenCount.setText("Quantidade de tokens: " + tokenCount);
        labelErrorCount.setText("Quantidade de erros: " + errorCount);

        if (errorCount == 0) {
            labelStatus.setText("[OK] Analise concluida com sucesso!");
            labelStatus.setForeground(new Color(0, 128, 0));
        } else {
            labelStatus.setText("[ERRO] Analise com " + errorCount + " erro(s)");
            labelStatus.setForeground(new Color(255, 140, 0));
        }
    }

    /**
     * Limpa todos os dados da interface.
     */
    private void clearAll() {
        textAreaInput.setText("");
        tableModel.clearTokens();
        labelTokenCount.setText("Quantidade de tokens: 0");
        labelErrorCount.setText("Quantidade de erros: 0");
        labelStatus.setText("Pronto para analise");
        labelStatus.setForeground(Color.BLUE);
    }

    /**
     * Ponto de entrada da aplicacao.
     * 
     * @param args Argumentos da linha de comando (nao utilizados)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame());
    }
}
