package dev.boxadactle.boxlib.util;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ModLogger {

    private final Logger logger;

    private final String prefix;

    private final Component chatPrefix;

    private final Minecraft client;

    public PlayerLogging player;

    public ModLogger(String modName) {
        logger = LogManager.getFormatterLogger(modName);

        client = ClientUtils.getClient();

        prefix = "[" + modName + "]: ";
        chatPrefix = GuiUtils.colorize(
                GuiUtils.brackets(GuiUtils.colorize(Component.literal(modName), GuiUtils.AQUA)),
                GuiUtils.BLUE
        );

        player = new PlayerLogging(client);
    }

    public void error(Object msg, Object... data) {
        logger.log(Level.ERROR, prefix + msg, data);
    }

    public void warn(Object msg, Object... data) {
        logger.log(Level.WARN, prefix + msg, data);
    }

    public void info(Object msg, Object... data) {
        logger.log(Level.INFO, prefix + msg, data);
    }

    public void printStackTrace(Exception e) {
        StackTraceElement[] stacktrace = e.getStackTrace();
        logger.error(prefix + e.getMessage());
        for (StackTraceElement stackTraceElement : stacktrace) {
            logger.error(prefix + "\t" + stackTraceElement.toString());
        }
    }

    public void chatError(String msg, Object... data) {
        if (this.client.player != null) {
            this.client.player.sendSystemMessage(Component.literal(chatPrefix + "§4" + String.format(msg, data)));
        }
    }

    public void chatWarn(String msg, Object... data) {
        if (this.client.player != null) {
            this.client.player.sendSystemMessage(Component.literal(chatPrefix + "§3" + String.format(msg, data)));
        }
    }

    public Component getChatPrefix() {
        return chatPrefix;
    }

    public String getPrefix() {
        return prefix;
    }

    public static class PlayerLogging {

        private final Component prefix = GuiUtils.colorize(GuiUtils.brackets(
                GuiUtils.colorize(Component.literal("Coordinates Display"), 5636095)
        ), 43690).copy().append(" ");

        private final Minecraft client;

        public PlayerLogging(Minecraft client) {
            this.client = client;
        }

        public void error(String msg, Object... data) {
            if (this.client.player != null) {
                this.client.player.sendSystemMessage(
                        prefix.copy().append(GuiUtils.colorize(Component.literal(String.format(msg, data)), 0x2f2d2d))
                );
            }
        }

        public void warn(String msg, Object... data) {
            if (this.client.player != null) {
                this.client.player.sendSystemMessage(
                        prefix.copy().append(GuiUtils.colorize(Component.literal(String.format(msg, data)), 0xff9966))
                );
            }
        }

        public void info(String msg, Object... data) {
            if (this.client.player != null) {
                this.client.player.sendSystemMessage(
                        prefix.copy().append(GuiUtils.colorize(Component.literal(String.format(msg, data)), 5635925))
                );
            }
        }

        public void chat(Component msg) {
            if (this.client.player != null) {
                this.client.player.sendSystemMessage(msg);
            }
        }

        public void publicChat(String msg) {
            if (this.client.player != null) {
                this.client.player.connection.sendChat(msg);
            }
        }
    }
}