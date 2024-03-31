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

/**
 * The ClientUtils class provides utility methods for interacting with the Minecraft client.
 * It includes methods for accessing client instances, obtaining game options, parsing identifiers,
 * retrieving the game window, getting the game version, handling keyboard input, managing screens,
 * opening URLs, and accessing the configuration folder.
 */
public class ClientUtils {

    /**
     * Returns the client instance of Minecraft.
     *
     * @return the client instance of Minecraft
     */
    public static Minecraft getClient() {
        return Minecraft.getInstance();
    }

    /**
     * Returns the options for the client.
     *
     * @return the options for the client
     */
    public static Options getOptions() {
        return getClient().options;
    }

    /**
     * Parses the identifier and returns the formatted name.
     *
     * @param id the identifier to parse
     * @return the formatted name
     */
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

    /**
     * Returns the window ID of the client.
     *
     * @return the window ID of the client
     */
    public static long getWindow() {
        return getClient().getWindow().getWindow();
    }

    /**
     * Returns the current game version as a string.
     *
     * @return the current game version
     */
    public static String getGameVersion() {
        return SharedConstants.getCurrentVersion().getName();
    }

    /**
     * Returns the keyboard handler instance.
     *
     * @return the keyboard handler instance
     */
    public static KeyboardHandler getKeyboard() {
        return getClient().keyboardHandler;
    }

    /**
     * Retrieves the current screen being displayed on the client.
     *
     * @return the current screen being displayed
     */
    public static Screen getCurrentScreen() {
        return getClient().screen;
    }

    /**
     * Represents a screen in the game.
     */
    public static Screen setScreen(Screen newScreen) {
        getClient().setScreen(newScreen);

        return newScreen;
    }

    @Deprecated
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

    /**
     * Opens the specified URL in the default web browser.
     *
     * @param url the URL to be opened
     * @throws RuntimeException if the URL is malformed
     */
    public static void openUrl(String url) {
        try {
            Util.getPlatform().openUrl(new URL(url));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Opens a link confirmation screen.
     *
     * @param link   The link to be opened.
     * @param parent The parent screen to return to after confirming the link.
     */
    public static void openLinkConfirmScreen(String link, Screen parent) {
        getClient().setScreen(new ConfirmLinkScreen(open -> {
            if (open) openUrl(link);
            setScreen(parent);
        }, link, true));
    }

    /**
     * Returns the path to the config folder.
     *
     * @return the path to the config folder
     */
    public static Path getConfigFolder() {
        return Path.of(getClient().gameDirectory.getAbsolutePath() + "/config");
    }

}
