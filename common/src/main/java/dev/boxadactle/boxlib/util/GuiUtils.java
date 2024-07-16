package dev.boxadactle.boxlib.util;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.*;

/**
 * The `GuiUtils` class provides utility methods and constants for GUI-related operations.
 * It includes methods for colorizing text, getting text size and height, creating hyperlinks,
 * and calculating the longest and shortest lengths of text and widgets.
 * It also provides constants for various colors and common components used in GUIs.
 */
@SuppressWarnings("unused")
public class GuiUtils {

    /**
     * Represents the color black.
     */
    public static final int BLACK = 0;

    /**
     * Represents the color dark blue.
     */
    public static final int DARK_BLUE = 170;

    /**
     * Represents the color dark green.
     */
    public static final int DARK_GREEN = 43520;

    /**
     * Represents the color dark aqua.
     */
    public static final int DARK_AQUA = 43690;

    /**
     * Represents the color dark red.
     */
    public static final int DARK_RED = 11141120;

    /**
     * Represents the color dark purple.
     */
    public static final int DARK_PURPLE = 11141290;

    /**
     * Represents the color gold.
     */
    public static final int GOLD = 16755200;

    /**
     * Represents the color gray.
     */
    public static final int GRAY = 11184810;

    /**
     * Represents the color dark gray.
     */
    public static final int DARK_GRAY = 5592405;

    /**
     * Represents the color blue.
     */
    public static final int BLUE = 5592575;

    /**
     * Represents the color green.
     */
    public static final int GREEN = 5635925;

    /**
     * Represents the color aqua.
     */
    public static final int AQUA = 5636095;

    /**
     * Represents the color red.
     */
    public static final int RED = 16733525;

    /**
     * Represents the color light purple.
     */
    public static final int LIGHT_PURPLE = 16733695;

    /**
     * Represents the color yellow.
     */
    public static final int YELLOW = 16777045;

    /**
     * Represents the color white.
     */
    public static final int WHITE = 16777215;

    /**
     * Represents the "ON" component.
     */
    public static Component ON;

    /**
     * Represents the "OFF" component.
     */
    public static Component OFF;

    /**
     * Represents the "DONE" component.
     */
    public static Component DONE;

    /**
     * Represents the "CANCEL" component.
     */
    public static Component CANCEL;

    /**
     * Represents the "YES" component.
     */
    public static Component YES;

    /**
     * Represents the "NO" component.
     */
    public static Component NO;

    /**
     * Represents the "OK" component.
     */
    public static Component OK;

    /**
     * Represents the "ALL" component.
     */
    public static Component ALL;

    /**
     * Represents the "BACK" component.
     */
    public static Component BACK;

    /**
     * Represents the "SAVE" component.
     */
    public static Component SAVE;

    /**
     * Represents the "LOAD" component.
     */
    public static Component LOAD;

    /**
     * Represents the "REFRESH" component.
     */
    public static Component REFRESH;

    /**
     * Represents the "ACCEPT" component.
     */
    public static Component ACCEPT;

    /**
     * Represents the "REJECT" component.
     */
    public static Component REJECT;

    /**
     * Represents the "ERROR OCCURRED" component.
     */
    public static Component ERROR_OCCURED;

    /**
     * Represents the "TRUE" component.
     */
    public static Component TRUE;

    /**
     * Represents the "FALSE" component.
     */
    public static Component FALSE;

    /**
     * Initializes the static components used in the GUI.
     */
    public static void init() {
        ON = new TranslatableComponent("options.on");
        OFF = new TranslatableComponent("options.off");
        DONE = new TranslatableComponent("gui.done");
        CANCEL = new TranslatableComponent("gui.cancel");
        YES = new TranslatableComponent("gui.yes");
        NO = new TranslatableComponent("gui.no");
        OK = new TranslatableComponent("mco.gui.ok");
        ALL = new TranslatableComponent("gui.all");
        BACK = new TranslatableComponent("gui.back");
        SAVE = new TranslatableComponent("structure_block.mode.save");
        LOAD = new TranslatableComponent("structure_block.mode.load");
        REFRESH = new TranslatableComponent("selectServer.refresh");
        ACCEPT = new TranslatableComponent("mco.invites.button.accept");
        REJECT = new TranslatableComponent("mco.invites.button.reject");
        ERROR_OCCURED = new TranslatableComponent("selectWorld.futureworld.error.title");

        TRUE = colorize(YES, ChatFormatting.GREEN);
        FALSE = colorize(NO, ChatFormatting.RED);
    }

    /**
     * Retrieves the translated string for the given key.
     *
     * @param key The translation key.
     * @return The translated string.
     */
    public static String getTranslatable(String key, Object ...args) {
        return I18n.get(key, args);
    }

    /**
     * Colorizes the given text with the specified color.
     *
     * @param text  The text to colorize.
     * @param color The color to apply.
     * @return The colorized text.
     */
    public static Component colorize(Component text, ChatFormatting color) {
        return text.copy().withStyle(style -> style.setColor(color));
    }

    /**
     * Retrieves the width of the given text.
     *
     * @param text The text to measure.
     * @return The width of the text.
     */
    public static int getTextSize(Component text) {
        return getTextSize(text.getString());
    }

    /**
     * Retrieves the width of the given text.
     *
     * @param text The text to measure.
     * @return The width of the text.
     */
    public static int getTextSize(String text) {
        return getTextRenderer().width(text);
    }

    /**
     * Retrieves the height of a line of text.
     *
     * @return The height of a line of text.
     */
    public static int getTextHeight() {
        return ClientUtils.getClient().font.lineHeight;
    }

    /**
     * Retrieves the longest length among the given texts.
     *
     * @param text The texts to compare.
     * @return The length of the longest text.
     */
    public static int getLongestLength(Component... text) {
        int largest = 0;
        Font textRenderer = GuiUtils.getTextRenderer();
        for (Component value : text) {
            int t = textRenderer.width(value.getString());
            if (t > largest) largest = t;
        }
        return largest;
    }

    /**
     * Retrieves the shortest length among the given texts.
     *
     * @param text The texts to compare.
     * @return The length of the shortest text.
     */
    public static int getShortestLength(Component... text) {
        int shortest = 0;
        Font textRenderer = GuiUtils.getTextRenderer();
        shortest = textRenderer.width(text[0].getString());
        for (Component value : text) {
            int t = textRenderer.width(value.getString());
            if (t < shortest) shortest = t;
        }
        return shortest;
    }

    /**
     * Retrieves the width of the longest widget among the given widgets.
     *
     * @param widgets The widgets to compare.
     * @return The width of the longest widget.
     */
    public static int getLongestWidget(AbstractWidget... widgets) {
        int longest = 0;
        for (AbstractWidget widget : widgets) {
            int t = widget.getWidth();
            if (t > longest) longest = t;
        }

        return longest;
    }

    /**
     * Creates a hyperlink with the given text and link.
     *
     * @param text The text of the hyperlink.
     * @param link The URL to open when the hyperlink is clicked.
     * @return The created hyperlink component.
     */
    public static Component createHyperLink(Component text, String link) {
        return text.copy().withStyle(ChatFormatting.UNDERLINE, ChatFormatting.BLUE).withStyle(a1 -> a1
                .setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, link))
                .setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslatableComponent("chat.link.open")))
        );
    }

    /**
     * Retrieves the non-zero GUI scale.
     *
     * @return The non-zero GUI scale.
     */
    public static int nonZeroGuiScale() {
        int scale = ClientUtils.getOptions().guiScale;
        Minecraft client = ClientUtils.getClient();
        if (scale == 0) {
            return (int) Math.max(1, Math.min(Math.floor((double) client.window.getGuiScaledWidth() / 320), Math.floor((double) client.window.getGuiScaledHeight() / 240)));
        } else {
            return scale;
        }
    }

    /**
     * Surrounds the given input with the specified strings.
     *
     * @param str1  The first surrounding string.
     * @param str2  The second surrounding string.
     * @param input The input component.
     * @return The surrounded component.
     */
    public static Component surround(String str1, String str2, Component input) {
        return new TextComponent(str1).append(input).append(new TextComponent(str2));
    }

    /**
     * Adds parentheses around the given input.
     *
     * @param input The input component.
     * @return The component with parentheses.
     */
    public static Component parentheses(Component input) {
        return surround("(", ")", input);
    }

    /**
     * Adds brackets around the given input.
     *
     * @param input The input component.
     * @return The component with brackets.
     */
    public static Component brackets(Component input) {
        return surround("[", "]", input);
    }

    /**
     * Adds quotes around the given input.
     *
     * @param input The input component.
     * @return The component with quotes.
     */
    public static Component quotes(Component input) {
        return surround("\"", "\"", input);
    }

    public static Font getTextRenderer() {
        return ClientUtils.getClient().font;
    }
}
