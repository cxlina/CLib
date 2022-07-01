package de.celinadev.clib;

import net.md_5.bungee.api.ChatColor;
import org.apache.commons.lang3.ArrayUtils;

import java.util.regex.Pattern;

public class ValidationUtil {

    /**
     * Validates if the passed Code is either a Legacy, Hex, or RGB-colorcode
     * NOTE: FOR Rgb you have to pass it in like "rgb(255,255,255)", else it won't detect it.
     *
     * @param code the colorcode to validate
     * @return A ChatColor parsed from the Code, or null if invalid.
     */
    public static ChatColor validateColor(String s) {
        //LEGACY codes ( §b )
        if (s.length() == 1 && ChatColor.getByChar(s.charAt(0)) != null) {
            return ChatColor.getByChar(s.charAt(0));
        }
        //Hex-Codes ( 00FF00 )
        if (s.length() == 6 && Pattern.matches("[0-9A-Fa-f]{6}", s)) {
            return ChatColor.of("#" + s);
        }
        // rgb ( rgb(255,255,0) )
        if (s.startsWith("rgb(") && s.endsWith(")")) {
            String[] s1 = s.substring(4, s.length() - 1).split(",");
            if (s1.length == 3) {
                int[] values = new int[]{};
                for (String s2 : s1) {
                    try {
                        if (Integer.parseInt(s2) < 0 || Integer.parseInt(s2) > 255)
                            return null;
                        values = ArrayUtils.add(values, Integer.parseInt(s2));
                    } catch (NumberFormatException e) {
                        System.out.println(s2);
                        return null;
                    }
                }
                return ChatColor.of("#" + String.format("%02X", values[0]) + String.format("%02X", values[1]) + String.format("%02X", values[2]));
            }
        }
        return null;
    }
}
