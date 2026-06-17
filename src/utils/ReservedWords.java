package utils;

import java.util.HashSet;
import java.util.Set;

/**
 * Classe que gerencia as palavras reservadas da linguagem Java.
 * 
 * @author Miguel
 * @version 1.0
 */
public class ReservedWords {
    private static final Set<String> RESERVED_WORDS = new HashSet<>();

    static {
        // Inicializa o conjunto de palavras reservadas
        RESERVED_WORDS.add("abstract");
        RESERVED_WORDS.add("boolean");
        RESERVED_WORDS.add("break");
        RESERVED_WORDS.add("byte");
        RESERVED_WORDS.add("case");
        RESERVED_WORDS.add("catch");
        RESERVED_WORDS.add("char");
        RESERVED_WORDS.add("class");
        RESERVED_WORDS.add("continue");
        RESERVED_WORDS.add("default");
        RESERVED_WORDS.add("do");
        RESERVED_WORDS.add("double");
        RESERVED_WORDS.add("else");
        RESERVED_WORDS.add("extends");
        RESERVED_WORDS.add("false");
        RESERVED_WORDS.add("final");
        RESERVED_WORDS.add("finally");
        RESERVED_WORDS.add("float");
        RESERVED_WORDS.add("for");
        RESERVED_WORDS.add("if");
        RESERVED_WORDS.add("implements");
        RESERVED_WORDS.add("import");
        RESERVED_WORDS.add("int");
        RESERVED_WORDS.add("interface");
        RESERVED_WORDS.add("long");
        RESERVED_WORDS.add("new");
        RESERVED_WORDS.add("null");
        RESERVED_WORDS.add("package");
        RESERVED_WORDS.add("private");
        RESERVED_WORDS.add("protected");
        RESERVED_WORDS.add("public");
        RESERVED_WORDS.add("return");
        RESERVED_WORDS.add("short");
        RESERVED_WORDS.add("static");
        RESERVED_WORDS.add("super");
        RESERVED_WORDS.add("switch");
        RESERVED_WORDS.add("this");
        RESERVED_WORDS.add("throw");
        RESERVED_WORDS.add("throws");
        RESERVED_WORDS.add("true");
        RESERVED_WORDS.add("try");
        RESERVED_WORDS.add("void");
        RESERVED_WORDS.add("while");
        RESERVED_WORDS.add("String");
    }

    /**
     * Verifica se uma palavra é reservada.
     * 
     * @param word A palavra a ser verificada
     * @return true se é uma palavra reservada, false caso contrário
     */
    public static boolean isReserved(String word) {
        return RESERVED_WORDS.contains(word);
    }
}
