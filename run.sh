#!/bin/bash

# Script para executar o Analisador Léxico

if [ ! -d "bin" ]; then
    echo "Diretório 'bin' não encontrado."
    echo "Execute primeiro: ./build.sh"
    exit 1
fi

echo "Iniciando Analisador Léxico..."
echo ""

java -cp bin Main
