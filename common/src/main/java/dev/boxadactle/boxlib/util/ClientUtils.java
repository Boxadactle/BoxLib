package dev.boxadactle.boxlib.util;

import com.mojang.blaze3d.platform.InputConstants;
import dev.boxadactle.boxlib.function.EmptyMethod;
import net.minecraft.SharedConstants;
import net.minecraft.Util;
import net.minecraft.client.KeyboardHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraft.client.gui.components.toasts.SystemToast;
import net.minecraft.client.gui.components.toasts.ToastComponent;
import net.minecraft.client.gui.screens.ConfirmLinkScreen;
import net.minecraft.client.gui.screens.ConfirmScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import java.net.URI;
import java.net.URISyntaxException;
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
        return getClient().window.getWindow();
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

    /**
     * Opens the specified URL in the default web browser.
     *
     * @param url the URL to be opened
     * @throws RuntimeException if the URL is malformed
     */
    public static void openUrl(String url) {
        try {
            URI uri = new URI(url);
            Util.getPlatform().openUri(uri);
        } catch (URISyntaxException e) {
            throw new RuntimeException("Malformed URL: " + url, e);
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
     * Opens a confirmation screen with a message and description.
     *
     * @param message     The message to display.
     * @param description The description to display.
     * @param yes         The method to run if the user confirms.
     * @param no          The method to run if the user denies.
     */
    public static void confirm(Component message, Component description, EmptyMethod yes, EmptyMethod no) {
        getClient().setScreen(new ConfirmScreen((b) -> {
            if (b) yes.accept();
            else no.accept();
        }, message, description));
    }

    /**
     * Displays a toast message with a description.
     *
     * @param message     The message to display.
     * @param description The description to display.
     */
    public static void showToast(Component message, Component description) {
        ToastComponent toastComponent = getClient().getToasts();
        SystemToast.addOrUpdate(
                toastComponent,
                SystemToast.SystemToastIds.NARRATOR_TOGGLE,
                message,
                description
        );
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
