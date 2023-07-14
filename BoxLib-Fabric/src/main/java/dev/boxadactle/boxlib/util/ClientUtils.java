package dev.boxadactle.boxlib.util;

import net.minecraft.SharedConstants;
import net.minecraft.client.Keyboard;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ConfirmLinkScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

public class ClientUtils {

    public static MinecraftClient getClient() {
        return MinecraftClient.getInstance();
    }

    public static GameOptions getOptions() {
        return getClient().options;
    }

    public static String parseIdentifier(String id) {
        StringBuilder name = new StringBuilder();

        String withoutNamespace = id.split(":")[1];
        String spaces = withoutNamespace.replaceAll("_", " ");
        for (String word : spaces.split("\\s")) {
            String firstLetter = word.substring(0, 1);
            String theRest = word.substring(1);
            name.append(firstLetter.toUpperCase()).append(theRest).append(" ");
        }

        return name.toString().trim();
    }

    public static long getWindow() {
        return getClient().getWindow().getHandle();
    }

    public static String getGameVersion() {
        return SharedConstants.getGameVersion().getName();
    }

    public static Keyboard getKeyboard() {
        return getClient().keyboard;
    }

    public static Screen getCurrentScreen() {
        return getClient().currentScreen;
    }

    public static Screen setScreen(Screen newScreen) {
        getClient().setScreen(newScreen);

        return newScreen;
    }

    // i honestly cant find a built-in way to do this
    public static char getTypedKey(int keycode, int scancode) {
        InputUtil.Key a = InputUtil.fromKeyCode(keycode, scancode);

        String ab = a.getTranslationKey().substring("key.keyboard.".length());

        if (ab.length() == 1) {
            try {

                int num = Integer.parseInt(ab);

                // if this code is reached, that means that the key typed is a number
                if (!Screen.hasShiftDown()) return ab.charAt(0);

                switch (num) {

                    case 1: return '!';
                    case 2: return '@';
                    case 3: return '#';
                    case 4: return '$';
                    case 5: return '%';
                    case 6: return '^';
                    case 7: return '&';
                    case 8: return '*';
                    case 9: return '(';
                    case 0: return ')';

                }

                return Character.MIN_VALUE;

            } catch (NumberFormatException ignored) {}

            String capitalized = Screen.hasShiftDown() ? ab.toUpperCase(Locale.ROOT) : ab;

            return capitalized.charAt(0);
        } else {
            boolean b = Screen.hasShiftDown();

            switch (a.getCode()) {
                case 45 -> {
                    if (b) return '_';
                    else return '-';
                }
                case 61 -> {
                    if (b) return '+';
                    else return '=';
                }
                case 91 -> {
                    if (b) return '{';
                    else return '[';
                }
                case 93 -> {
                    if (b) return '}';
                    else return ']';
                }
                case 96 -> {
                    if (b) return '~';
                    else return '`';
                }
                case 59 -> {
                    if (b) return ':';
                    else return ';';
                }
                case 39 -> {
                    if (b) return '"';
                    else return '\'';
                }
                case 44 -> {
                    if (b) return '<';
                    else return ',';
                }
                case 46 -> {
                    if (b) return '>';
                    else return '.';
                }
                case 32 -> {
                    return ' ';
                }
            }

            return Character.MIN_VALUE;
        }

    }

    public static void openUrl(String url) {
        try {
            Util.getOperatingSystem().open(new URL(url));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void openLinkConfirmScreen(String link, Screen parent) {
        getClient().setScreen(new ConfirmLinkScreen(open -> {
            if (open) openUrl(link);
            setScreen(parent);
        }, link, true));
    }

}
