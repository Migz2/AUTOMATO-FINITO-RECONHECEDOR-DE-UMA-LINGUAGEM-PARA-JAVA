#!/bin/bash

# Script para compilar e executar o Analisador Léxico

echo "====================================="
echo "Compilador Léxico - Script de Build"
echo "====================================="
echo ""

# Cria diretório de saída
echo "[1/3] Criando diretório de compilação..."
mkdir -p bin

# Compila todos os arquivos Java
echo "[2/3] Compilando arquivos Java..."
javac -d bin \
    src/lexer/TokenType.java \
    src/lexer/State.java \
    src/lexer/Token.java \
    src/utils/ReservedWords.java \
    src/utils/IdentifierValidator.java \
    src/utils/NumberValidator.java \
    src/utils/StringValidator.java \
    src/utils/OperatorValidator.java \
    src/lexer/Automaton.java \
    src/lexer/Lexer.java \
    src/ui/ResultTableModel.java \
    src/ui/MainFrame.java \
    src/main/Main.java

if [ $? -eq 0 ]; then
    echo "[3/3] Compilação concluída com sucesso!"
    echo ""
    echo "Para executar a aplicação, use o comando:"
    echo "  java -cp bin Main"
    echo ""
    echo "Ou use o script de execução:"
    echo "  ./run.sh"
else
    echo "Erro durante a compilação!"
    exit 1
fi
