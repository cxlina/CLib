package de.celinadev.clib;

public class TranslationUtil {

    /**
     * Gives the translation corresponding to the given text.
     *
     * @param s            Text to translate
     * @param placeholders Placeholders to replace
     * @return the corresponding translation, or the text itself if none found.
     */
    public static String translate(String s, Placeholder... placeholders) {
        String s1 = CLib.getInstance().getPlugin().getConfig().getString("translations." + s);
        if (s1 == null) {
            return s;
        }
        for (Placeholder placeholder : placeholders) {
            s1 = s1.replace(placeholder.getOriginal(), placeholder.getReplacement());
        }
        return s1.replace("&", "§");
    }
}
