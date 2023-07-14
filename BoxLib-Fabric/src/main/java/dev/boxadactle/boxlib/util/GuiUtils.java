package dev.boxadactle.boxlib.util;

import dev.boxadactle.boxlib.BoxLib;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.HoverEvent;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Language;

import java.util.Locale;

public class GuiUtils {

    public static final int BLACK = 0;
    public static final int DARK_BLUE = 170;
    public static final int DARK_GREEN = 43520;
    public static final int DARK_AQUA = 43690;
    public static final int DARK_RED = 11141120;
    public static final int DARK_PURPLE = 11141290;
    public static final int GOLD = 16755200;
    public static final int GRAY = 11184810;
    public static final int DARK_GRAY = 5592405;
    public static final int BLUE = 5592575;
    public static final int GREEN = 5635925;
    public static final int AQUA = 5636095;
    public static final int RED = 16733525;
    public static final int LIGHT_PURPLE = 16733695;
    public static final int YELLOW = 16777045;
    public static final int WHITE = 16777215;

    public static Text ON;
    public static Text OFF;
    public static Text DONE;
    public static Text CANCEL;
    public static Text YES;
    public static Text NO;
    public static Text OK;
    public static Text ALL;
    public static Text BACK;
    public static Text SAVE;
    public static Text LOAD;
    public static Text REFRESH;
    public static Text ACCEPT;
    public static Text REJECT;
    public static Text ERROR_OCCURED;

    public static Text TRUE;
    public static Text FALSE;

    public static void init() {
        ON = Text.translatable("options.on");
        OFF = Text.translatable("options.off");
        DONE = Text.translatable("gui.done");
        CANCEL = Text.translatable("gui.cancel");
        YES = Text.translatable("gui.yes");
        NO = Text.translatable("gui.no");
        OK = Text.translatable("mco.gui.ok");
        ALL = Text.translatable("gui.all");
        BACK = Text.translatable("gui.back");
        SAVE = Text.translatable("structure_block.mode.save");
        LOAD = Text.translatable("structure_block.mode.load");
        REFRESH = Text.translatable("selectServer.refresh");
        ACCEPT = Text.translatable("mco.invites.button.accept");
        REJECT = Text.translatable("mco.invites.button.reject");
        ERROR_OCCURED = Text.translatable("selectWorld.futureworld.error.title");

        TRUE = colorize(YES, GREEN);
        FALSE = colorize(NO, RED);
    }

    public static String getTranslatable(String key) {
        return Language.getInstance().get(key);
    }

    public static Text colorize(Text text, int color) {
        return text.copy().styled(style -> style.withColor(color));
    }

    public static int getColorDecimal(String color) {
        int decimal;
        String c = color.toLowerCase(Locale.ROOT);
        switch (c) {
            case "dark_red" -> decimal = DARK_RED;
            case "red" -> decimal = RED;
            case "gold" -> decimal = GOLD;
            case "yellow" -> decimal = YELLOW;
            case "dark_green" -> decimal = DARK_GREEN;
            case "green" -> decimal = GREEN;
            case "aqua" -> decimal = AQUA;
            case "dark_aqua" -> decimal = DARK_AQUA;
            case "dark_blue" -> decimal = DARK_BLUE;
            case "blue" -> decimal = BLUE;
            case "light_purple" -> decimal = LIGHT_PURPLE;
            case "dark_purple" -> decimal = DARK_PURPLE;
            case "white" -> decimal = WHITE;
            case "gray" -> decimal = GRAY;
            case "dark_gray" -> decimal = DARK_GRAY;
            case "black" -> decimal = BLACK;
            default -> {
                decimal = WHITE;
                BoxLib.LOGGER.warn("Could not parse color " + color + " so defaulted to " + decimal);
            }
        }
        return decimal;
    }

    public static int getLongestLength(Text ...text) {
        int largest = 0;
        TextRenderer textRenderer = GuiUtils.getTextRenderer();
        for (Text value : text) {
            int t = textRenderer.getWidth(value);
            if (t > largest) largest = t;
        }
        return largest;
    }

    public static int getShortestLength(Text ...text) {
        int shortest = 0;
        TextRenderer textRenderer = GuiUtils.getTextRenderer();
        shortest = textRenderer.getWidth(text[0]);
        for (Text value : text) {
            int t = textRenderer.getWidth(value);
            if (t < shortest) shortest = t;
        }
        return shortest;
    }

    public static int getLongestWidget(ClickableWidget ...widgets) {
        int longest = 0;
        for (ClickableWidget widget : widgets) {
            int t = widget.getWidth();
            if (t > longest) longest = t;
        }

        return longest;
    }

    public static Text createHyperLink(Text text, String link) {
        return text.copy().formatted(Formatting.UNDERLINE, Formatting.BLUE).styled(a1 -> a1
                .withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, link))
                .withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Text.translatable("chat.link.open")))
        );
    }

    public static int getTallestWidget(ClickableWidget ...widgets) {
        int tallest = 0;
        for (ClickableWidget widget : widgets) {
            int t = widget.getHeight();
            if (t > tallest) tallest = t;
        }

        return tallest;
    }

    public static int nonZeroGuiScale() {
        int scale = ClientUtils.getOptions().getGuiScale().getValue();
        MinecraftClient client = ClientUtils.getClient();
        if (scale == 0) {
            return (int) Math.max(1, Math.min(Math.floor(client.getWindow().getScaledWidth() / 320), Math.floor(client.getWindow().getScaledHeight() / 240)));
        } else {
            return scale;
        }
    }

    public static Text surround(String str1, String str2, Text input) {
        return Text.literal(str1).append(input).append(Text.literal(str2));
    }

    public static Text parentheses(Text input) {
        return surround("(", ")", input);
    }

    public static Text brackets(Text input) {
        return surround("[", "]", input);
    }

    public static Text quotes(Text input) {
        return surround("\"", "\"", input);
    }

    public static TextRenderer getTextRenderer() {
        return ClientUtils.getClient().textRenderer;
    }
}
