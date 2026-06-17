# 📑 ÍNDICE DO PROJETO - ANALISADOR LÉXICO JAVA

## 🎯 Comece Aqui

**Novo no projeto?** Leia nesta ordem:

1. **[PROJETO_COMPLETO.md](PROJETO_COMPLETO.md)** - Visão geral completa (5 min)
2. **[README.md](README.md)** - Manual de uso (10 min)
3. **[EXEMPLOS_TESTE.md](EXEMPLOS_TESTE.md)** - Teste com exemplos (5 min)

---

## 📂 Estrutura de Arquivos

### 📝 Código-Fonte (13 arquivos Java)

#### Core - Análise Léxica
| Arquivo | Linhas | Descrição |
|---------|--------|-----------|
| [src/lexer/TokenType.java](src/lexer/TokenType.java) | 20 | Enum com tipos de tokens |
| [src/lexer/State.java](src/lexer/State.java) | 19 | Estados do AFD |
| [src/lexer/Token.java](src/lexer/Token.java) | 67 | Classe Token |
| [src/lexer/Automaton.java](src/lexer/Automaton.java) | 88 | Autômato Finito Determinístico |
| [src/lexer/Lexer.java](src/lexer/Lexer.java) | 287 | Analisador Léxico |

#### Utilitários - Validadores
| Arquivo | Linhas | Descrição |
|---------|--------|-----------|
| [src/utils/ReservedWords.java](src/utils/ReservedWords.java) | 60 | Gerenciador de palavras-chave |
| [src/utils/IdentifierValidator.java](src/utils/IdentifierValidator.java) | 38 | Validador de identificadores |
| [src/utils/NumberValidator.java](src/utils/NumberValidator.java) | 54 | Validador de números |
| [src/utils/StringValidator.java](src/utils/StringValidator.java) | 37 | Validador de strings/chars |
| [src/utils/OperatorValidator.java](src/utils/OperatorValidator.java) | 60 | Validador de operadores |

#### Interface - Gráfica
| Arquivo | Linhas | Descrição |
|---------|--------|-----------|
| [src/ui/MainFrame.java](src/ui/MainFrame.java) | 193 | Janela principal em Swing |
| [src/ui/ResultTableModel.java](src/ui/ResultTableModel.java) | 92 | Modelo da tabela de resultados |

#### Entry Point
| Arquivo | Linhas | Descrição |
|---------|--------|-----------|
| [src/main/Main.java](src/main/Main.java) | 37 | Ponto de entrada da aplicação |

### 📚 Documentação (6 arquivos)

| Arquivo | Descrição |
|---------|-----------|
| **[PROJETO_COMPLETO.md](PROJETO_COMPLETO.md)** | 🎯 **COMECE AQUI** - Visão geral completa |
| **[README.md](README.md)** | Manual de usuário e instruções |
| **[ARTIGO.md](ARTIGO.md)** | Artigo científico (fundamentação teórica) |
| **[EXEMPLOS_TESTE.md](EXEMPLOS_TESTE.md)** | 10 exemplos prontos para testar |
| **[REFERENCIA.md](REFERENCIA.md)** | Guia técnico de referência |
| **[ENTREGA.md](ENTREGA.md)** | Resumo da entrega e status |

### 🔧 Scripts (2 arquivos)

| Arquivo | Descrição |
|---------|-----------|
| **[build.sh](build.sh)** | Compila todos os arquivos Java |
| **[run.sh](run.sh)** | Executa a aplicação |

---

## 📊 Conteúdo de Cada Arquivo

### 🎯 PROJETO_COMPLETO.md (LEIA PRIMEIRO!)
- Estatísticas do projeto
- Estrutura completa
- Funcionalidades implementadas
- Como usar em 3 passos
- Exemplo de teste rápido
- Checklist de entrega

### 📖 README.md
- Objetivo
- Como compilar e executar
- Estrutura de pastas
- Funcionamento da análise
- Tipos de tokens
- Operadores suportados
- Exemplo completo
- Recursos principais

### 🔬 ARTIGO.md (Científico)
- Resumo executivo
- Introdução
- Fundamentação em Autômatos
- Análise Léxica
- Linguagem Java
- Arquitetura
- Implementação detalhada
- Fluxo de execução
- Resultados esperados
- Conclusão
- Referências

### 🧪 EXEMPLOS_TESTE.md
- 10 exemplos de teste
- Código + resultado esperado
- Teste passo-a-passo
- Verificação de tipos
- Interpretação de resultados
- Dicas importantes

### 📋 REFERENCIA.md
- Estrutura de todas as classes
- Métodos públicos
- Fluxo de execução
- Algoritmo principal
- Configurações
- Extensibilidade
- Testes recomendados

### ✅ ENTREGA.md
- Resumo da entrega
- Arquivos criados
- Recursos implementados
- Verificação de qualidade
- Próximos passos

---

## 🚀 Início Rápido

### 1. Compilar
```bash
cd /home/miguel/Documents/Faculdade/LFA
./build.sh
```

### 2. Executar
```bash
./run.sh
```

### 3. Testar
Cole este código:
```java
int x = 10;
double y = 3.14;
String nome = "Teste";
```

---

## 📊 Estatísticas

- **13** arquivos Java
- **21** arquivos totais
- **1.144** linhas de código
- **50** palavras-chave
- **21** operadores
- **9** delimitadores

---

## 🎓 Conceitos Implementados

### Teóricos
- Autômatos Finitos Determinísticos ✅
- Análise Léxica ✅
- Linguagens Formais ✅
- Máquinas de Estados ✅

### Práticos
- Programação Orientada a Objetos ✅
- Design Patterns (MVC) ✅
- Interface Gráfica (Swing) ✅
- Tratamento de Erros ✅

---

## 🔍 Onde Encontrar...

| Procuro por | Arquivo |
|-------------|---------|
| Como usar? | [README.md](README.md) |
| Exemplo de teste? | [EXEMPLOS_TESTE.md](EXEMPLOS_TESTE.md) |
| Fundamentação teórica? | [ARTIGO.md](ARTIGO.md) |
| Classes e métodos? | [REFERENCIA.md](REFERENCIA.md) |
| Status do projeto? | [ENTREGA.md](ENTREGA.md) |
| Visão geral? | [PROJETO_COMPLETO.md](PROJETO_COMPLETO.md) |

---

## 🏆 Destaques

✅ **Completo** - Nada falta, tudo implementado
✅ **Testado** - Compilação e execução verificadas
✅ **Documentado** - 6 arquivos de documentação
✅ **Profissional** - Código de qualidade acadêmica
✅ **Pronto** - Execute agora mesmo

---

## 📞 Suporte

### Dúvidas sobre...

**Como usar?**
→ Veja [README.md](README.md) seção "Como Executar"

**Exemplos?**
→ Veja [EXEMPLOS_TESTE.md](EXEMPLOS_TESTE.md)

**Teoria?**
→ Veja [ARTIGO.md](ARTIGO.md)

**Classes?**
→ Veja [REFERENCIA.md](REFERENCIA.md)

**Erros na compilação?**
→ Verifique se tem Java 11+ instalado
→ Execute `./build.sh` novamente

---

## 📌 Informações do Projeto

| Item | Valor |
|------|-------|
| Nome | Analisador Léxico para Java |
| Versão | 1.0 |
| Status | ✅ Completo |
| Java | JDK 11+ |
| Dependências | Nenhuma (stdlib) |
| Linhas de Código | 1.144 |
| Arquivos Entregues | 21 |
| Data | Junho 2026 |

---

## 🎯 Próximo Passo

1. **Leia** [PROJETO_COMPLETO.md](PROJETO_COMPLETO.md)
2. **Compile** com `./build.sh`
3. **Execute** com `./run.sh`
4. **Teste** com exemplos do [EXEMPLOS_TESTE.md](EXEMPLOS_TESTE.md)

---

**🚀 Tudo pronto! Comece agora!**

Versão: 1.0 | Status: ✅ Completo | Junho 2026
