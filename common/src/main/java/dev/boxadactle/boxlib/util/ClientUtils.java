package dev.boxadactle.boxlib.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.SharedConstants;
import net.minecraft.Util;
import net.minecraft.client.KeyboardHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraft.client.gui.screens.ConfirmLinkScreen;
import net.minecraft.client.gui.screens.Screen;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.util.Locale;

public class ClientUtils {

    public static Minecraft getClient() {
        return Minecraft.getInstance();
    }

    public static Options getOptions() {
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
        return getClient().getWindow().getWindow();
    }

    public static String getGameVersion() {
        return SharedConstants.getCurrentVersion().getName();
    }

    public static KeyboardHandler getKeyboard() {
        return getClient().keyboardHandler;
    }

    public static Screen getCurrentScreen() {
        return getClient().screen;
    }

    public static Screen setScreen(Screen newScreen) {
        getClient().setScreen(newScreen);

        return newScreen;
    }

    // i honestly cant find a built-in way to do this
    public static char getTypedKey(int keycode, int scancode) {
        InputConstants.Key a = InputConstants.getKey(keycode, scancode);

        String ab = a.getName().substring("key.keyboard.".length());

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

            switch (a.getValue()) {
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
            Util.getPlatform().openUrl(new URL(url));
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

    public static Path getConfigFolder() {
        return Path.of(getClient().gameDirectory.getAbsolutePath() + "/config");
    }

}
