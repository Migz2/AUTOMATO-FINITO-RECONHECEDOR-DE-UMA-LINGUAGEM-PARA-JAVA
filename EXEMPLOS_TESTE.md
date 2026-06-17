# Exemplos de Teste - Analisador Léxico

Este arquivo contém exemplos de código para testar o analisador léxico.

## Exemplo 1: Código Simples (Recomendado para começar)

```java
int x = 10;
double y = 3.14;
String nome = "Teste";
```

**Resultado esperado:** 15 tokens, 0 erros

---

## Exemplo 2: Palavras-Chave e Identificadores

```java
public class Pessoa {
    private int idade;
    public String nome;
}
```

**Resultado esperado:** 10 tokens, 0 erros

---

## Exemplo 3: Operadores

```java
int a = 5;
int b = 10;
int soma = a + b;
int resultado = a * b - soma / 2;
```

**Resultado esperado:** 28 tokens, 0 erros

---

## Exemplo 4: Literals e Strings

```java
String msg = "Ola Mundo";
char letra = 'A';
int num1 = 42;
double num2 = 3.14159;
boolean verdadeiro = true;
String vazio = "";
```

**Resultado esperado:** 30 tokens, 0 erros

---

## Exemplo 5: Estruturas de Controle

```java
if (x > 10) {
    y = x + 5;
} else {
    y = x - 5;
}

for (int i = 0; i < 10; i++) {
    System.out.println(i);
}

while (condicao) {
    executarAlgo();
}
```

**Resultado esperado:** 58 tokens, 0 erros

---

## Exemplo 6: Métodos e Classes

```java
public static void main(String[] args) {
    int resultado = calcular(5, 10);
    System.out.println(resultado);
}

private static int calcular(int a, int b) {
    return a + b;
}
```

**Resultado esperado:** 49 tokens, 0 erros

---

## Exemplo 7: Arrays e Collections

```java
int[] numeros = {1, 2, 3, 4, 5};
String[] nomes = {"Ana", "Bruno", "Carlos"};
ArrayList lista = new ArrayList();
HashMap mapa = new HashMap();
```

**Resultado esperado:** 46 tokens, 0 erros

*Nota: ArrayList e HashMap são identificadores válidos (começam com letra) e não geram erros léxicos*

---

## Exemplo 8: Código Completo (Recomendado para teste completo)

```java
public class Teste {
    public static void main(String[] args) {
        int idade = 20;
        double altura = 1.75;
        String nome = "Miguel";
        char sexo = 'M';
        
        if (idade > 18 && altura >= 1.70) {
            System.out.println(nome);
        }
    }
}
```

**Resultado esperado:** 58 tokens, 0 erros

---

## Exemplo 9: Operador Personalizado

```java
int a = 10;
int b = 20;

if (a <> b) {
    System.out.println("Diferentes");
}
```

**Resultado esperado:** 27 tokens (incluindo o operador <>), 0 erros

---

## Exemplo 10: Teste com Erros

```java
_invalido123 = 10;
123abc = 20;
@variavel = 30;
String incompleta = "nao fecha;
int x = 10 # comentario;
```

**Resultado esperado:** 
- Número significativo de erros
- Tokens desconhecidos identificados
- (@, #, etc.)

---

## Teste Manual Passo a Passo

1. **Abra a aplicação:**
   ```bash
   ./run.sh
   ```

2. **Cole um dos exemplos acima na área de texto**

3. **Clique em "Analisar"**

4. **Verifique:**
   - A quantidade de tokens encontrados
   - A quantidade de erros
   - A classificação de cada token na tabela
   - O status da análise

5. **Use "Limpar" para resetar e testar outro código**

---

## Verificação de Tipos de Tokens

### Palavras Reservadas (esperadas)
- public, private, protected, static
- class, interface, extends, implements
- int, double, float, long, String
- if, else, for, while, switch, case
- return, new, this, super, try, catch

### Identificadores (válidos)
- idade, nome, contador
- _private, _var
- Classe, Pessoa, MeuTest

### Identificadores (inválidos - devem gerar erros)
- 1teste, 2var
- @username, #hashtag
- teste-variavel

### Números
- Inteiros: 0, 1, 10, 999, 123456
- Reais: 1.5, 3.14, 0.001, 10.0

### Operadores
- Aritméticos: +, -, *, /, %
- Lógicos: &&, ||, !
- Relacionais: ==, !=, >, <, >=, <=
- Atribuição: =, +=, -=, *=, /=
- Incremento: ++, --
- Personalizado: <>

### Delimitadores
- Parênteses: (, )
- Chaves: {, }
- Colchetes: [, ]
- Ponto e vírgula: ;
- Vírgula: ,
- Ponto: .

---

## Interpretação dos Resultados

**Status Verde (OK):**
- Significa que a análise foi concluída sem erros
- Todos os tokens foram reconhecidos corretamente

**Status Laranja (AVISO):**
- Indica que houve tokens desconhecidos
- A análise foi concluída, mas com algumas anomalias

---

## Dicas Importantes

1. **Espaços em branco:** São ignorados pelo analisador (esperado)
2. **Quebras de linha:** São registradas para controle de linha
3. **Strings não fechadas:** Serão marcadas como erro
4. **Números com múltiplos pontos:** Apenas o primeiro ponto é reconhecido
5. **Caso sensível:** TESTE, teste, Teste são identificadores diferentes

---

**Bom teste! Qualquer dúvida, consulte o README.md ou ARTIGO.md**
