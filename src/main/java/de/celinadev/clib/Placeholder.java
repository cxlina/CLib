package de.celinadev.clib;

public class Placeholder {

    String original;
    String replacement;

    public Placeholder(String text, String replacement) {
        this.original = text;
        this.replacement = replacement;
    }

    public String getOriginal() {
        return original;
    }

    public String getReplacement() {
        return replacement;
    }
}
