package org.animey.skins;

import java.net.MalformedURLException;
import java.net.URL;

public class Capes {
    public static final String VANILLA = "";
    public static final String MIGRATOR = "";
    public static final String TURTLE = "";
    public static final String MAP_MAKER = "";
    public static final String JIRA_MOD = "";
    public static final String COBALT = "";
    public static final String SCROLLS = "";
    public static final String TRANSLATOR_CH = "";
    public static final String TRANSLATOR = "";
    public static final String VALENTINE = "";
    public static final String BIRTHDAY = "";
    public static final String PRISMARINE = "";
    public static final String MESSIAH = "";
    public static final String CHEAPSHOT = "";
    public static final URL JULIAN_CLARK;

    static {
        try {
            JULIAN_CLARK = new URL("https://textures.minecraft.net/texture/23ec737f18bfe4b547c95935fc297dd767bb84ee55bfd855144d279ac9bfd9fe");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static final String DANNY_BSTYLE = "";
    public static final String MILLIONTH = "";
    public static final String MINECON_16 = "";
    public static final String MINECON_15 = "";
    public static final String MINECON_13 = "";
    public static final String MINECON_12 = "";
    public static final String MINECON_11 = "";
    public static final String MOJANG_21 = "";
    public static final String MOJANG_10 = "";
    public static final String MOJANG_15 = "";
}
