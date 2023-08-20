package dev.boxadactle.boxlib.util;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.locale.Language;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.HoverEvent;

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

    public static Component ON;
    public static Component OFF;
    public static Component DONE;
    public static Component CANCEL;
    public static Component YES;
    public static Component NO;
    public static Component OK;
    public static Component ALL;
    public static Component BACK;
    public static Component SAVE;
    public static Component LOAD;
    public static Component REFRESH;
    public static Component ACCEPT;
    public static Component REJECT;
    public static Component ERROR_OCCURED;

    public static Component TRUE;
    public static Component FALSE;

    public static void init() {
        ON = Component.translatable("options.on");
        OFF = Component.translatable("options.off");
        DONE = Component.translatable("gui.done");
        CANCEL = Component.translatable("gui.cancel");
        YES = Component.translatable("gui.yes");
        NO = Component.translatable("gui.no");
        OK = Component.translatable("mco.gui.ok");
        ALL = Component.translatable("gui.all");
        BACK = Component.translatable("gui.back");
        SAVE = Component.translatable("structure_block.mode.save");
        LOAD = Component.translatable("structure_block.mode.load");
        REFRESH = Component.translatable("selectServer.refresh");
        ACCEPT = Component.translatable("mco.invites.button.accept");
        REJECT = Component.translatable("mco.invites.button.reject");
        ERROR_OCCURED = Component.translatable("selectWorld.futureworld.error.title");

        TRUE = colorize(YES, GREEN);
        FALSE = colorize(NO, RED);
    }

    public static String getTranslatable(String key) {
        return Language.getInstance().getOrDefault(key);
    }

    public static Component colorize(Component text, int color) {
        return text.copy().withStyle(style -> style.withColor(color));
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
            }
        }
        return decimal;
    }

    public static int getLongestLength(Component ...text) {
        int largest = 0;
        Font textRenderer = GuiUtils.getTextRenderer();
        for (Component value : text) {
            int t = textRenderer.width(value);
            if (t > largest) largest = t;
        }
        return largest;
    }

    public static int getShortestLength(Component ...text) {
        int shortest = 0;
        Font textRenderer = GuiUtils.getTextRenderer();
        shortest = textRenderer.width(text[0]);
        for (Component value : text) {
            int t = textRenderer.width(value);
            if (t < shortest) shortest = t;
        }
        return shortest;
    }

    public static int getLongestWidget(AbstractWidget...widgets) {
        int longest = 0;
        for (AbstractWidget widget : widgets) {
            int t = widget.getWidth();
            if (t > longest) longest = t;
        }

        return longest;
    }

    public static Component createHyperLink(Component text, String link) {
        return text.copy().withStyle(ChatFormatting.UNDERLINE, ChatFormatting.BLUE).withStyle(a1 -> a1
                .withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, link))
                .withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Component.translatable("chat.link.open")))
        );
    }

    public static int getTallestWidget(AbstractWidget ...widgets) {
        int tallest = 0;
        for (AbstractWidget widget : widgets) {
            int t = widget.getHeight();
            if (t > tallest) tallest = t;
        }

        return tallest;
    }

    public static int nonZeroGuiScale() {
        int scale = ClientUtils.getOptions().guiScale().get();
        Minecraft client = ClientUtils.getClient();
        if (scale == 0) {
            return (int) Math.max(1, Math.min(Math.floor(client.getWindow().getGuiScaledWidth() / 320), Math.floor(client.getWindow().getGuiScaledHeight() / 240)));
        } else {
            return scale;
        }
    }

    public static Component surround(String str1, String str2, Component input) {
        return Component.literal(str1).append(input).append(Component.literal(str2));
    }

    public static Component parentheses(Component input) {
        return surround("(", ")", input);
    }

    public static Component brackets(Component input) {
        return surround("[", "]", input);
    }

    public static Component quotes(Component input) {
        return surround("\"", "\"", input);
    }

    public static Font getTextRenderer() {
        return ClientUtils.getClient().font;
    }
}
