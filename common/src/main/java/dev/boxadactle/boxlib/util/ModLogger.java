package dev.boxadactle.boxlib.util;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The ModLogger class provides logging functionality for a Minecraft mod.
 */
public class ModLogger {

    private final Logger logger;
    private final String prefix;
    private final Component chatPrefix;
    private final Minecraft client;
    public PlayerLogging player;

    /**
     * Constructs a ModLogger object with the specified mod name.
     *
     * @param modName the name of the mod
     */
    public ModLogger(String modName) {
        logger = LogManager.getFormatterLogger(modName);
        client = ClientUtils.getClient();
        prefix = "[" + modName + "]: ";
        chatPrefix = GuiUtils.colorize(
                GuiUtils.brackets(GuiUtils.colorize(Component.literal(modName), GuiUtils.AQUA)),
                GuiUtils.BLUE
        );
        player = new PlayerLogging(client, modName);
    }

    /**
     * Logs an error message.
     *
     * @param msg  the error message
     * @param data additional data to be included in the log message
     */
    public void error(Object msg, Object... data) {
        logger.log(Level.ERROR, prefix + msg, data);
    }

    /**
     * Logs a warning message.
     *
     * @param msg  the warning message
     * @param data additional data to be included in the log message
     */
    public void warn(Object msg, Object... data) {
        logger.log(Level.WARN, prefix + msg, data);
    }

    /**
     * Logs an informational message.
     *
     * @param msg  the informational message
     * @param data additional data to be included in the log message
     */
    public void info(Object msg, Object... data) {
        logger.log(Level.INFO, prefix + msg, data);
    }

    /**
     * Logs a debug message.
     *
     * @param msg  the debug message
     * @param data additional data to be included in the log message
     */
    public void debug(Object msg, Object... data) {
        logger.log(Level.DEBUG, prefix + msg, data);
    }

    /**
     * Prints the stack trace of an exception.
     *
     * @param e the exception
     */
    public void printStackTrace(Exception e) {
        StackTraceElement[] stacktrace = e.getStackTrace();
        logger.error(prefix + e.getMessage());
        for (StackTraceElement stackTraceElement : stacktrace) {
            logger.error(prefix + "\t" + stackTraceElement.toString());
        }
    }

    /**
     * Sends an error message to the chat.
     *
     * @param msg  the error message
     * @param data additional data to be included in the message
     */
    public void chatError(String msg, Object... data) {
        if (this.client.player != null) {
            this.client.player.sendSystemMessage(Component.literal(chatPrefix + "§4" + String.format(msg, data)));
        }
    }

    /**
     * Sends a warning message to the chat.
     *
     * @param msg  the warning message
     * @param data additional data to be included in the message
     */
    public void chatWarn(String msg, Object... data) {
        if (this.client.player != null) {
            this.client.player.sendSystemMessage(Component.literal(chatPrefix + "§3" + String.format(msg, data)));
        }
    }

    /**
     * Returns the chat prefix.
     *
     * @return the chat prefix
     */
    public Component getChatPrefix() {
        return chatPrefix;
    }

    /**
     * Returns the log message prefix.
     *
     * @return the log message prefix
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * The PlayerLogging class provides logging functionality for a player.
     */
    public static class PlayerLogging {

        private final Component prefix;
        private final Minecraft client;

        /**
         * Constructs a PlayerLogging object with the specified Minecraft client.
         *
         * @param client the Minecraft client
         */
        public PlayerLogging(Minecraft client, String prefix) {
            this.client = client;
            this.prefix = GuiUtils.colorize(GuiUtils.brackets(
                    GuiUtils.colorize(Component.literal(prefix), 5636095)
            ), 43690).copy().append(" ");
        }

        /**
         * Logs an error message for the player.
         *
         * @param msg  the error message
         * @param data additional data to be included in the log message
         */
        public void error(String msg, Object... data) {
            if (this.client.player != null) {
                this.client.player.sendSystemMessage(
                        prefix.copy().append(GuiUtils.colorize(Component.literal(String.format(msg, data)), GuiUtils.RED))
                );
            }
        }

        /**
         * Logs a warning message for the player.
         *
         * @param msg  the warning message
         * @param data additional data to be included in the log message
         */
        public void warn(String msg, Object... data) {
            if (this.client.player != null) {
                this.client.player.sendSystemMessage(
                        prefix.copy().append(GuiUtils.colorize(Component.literal(String.format(msg, data)), GuiUtils.YELLOW))
                );
            }
        }

        /**
         * Logs an informational message for the player.
         *
         * @param msg  the informational message
         * @param data additional data to be included in the log message
         */
        public void info(String msg, Object... data) {
            if (this.client.player != null) {
                this.client.player.sendSystemMessage(
                        prefix.copy().append(Component.literal(String.format(msg, data)))
                );
            }
        }

        /**
         * Sends a chat message to the player.
         *
         * @param msg the chat message
         */
        public void chat(Component msg) {
            if (this.client.player != null) {
                this.client.player.sendSystemMessage(prefix.copy().append(msg));
            }
        }

        /**
         * Sends a public chat message.
         *
         * @param msg the public chat message
         */
        public void publicChat(String msg) {
            if (this.client.player != null) {
                this.client.player.connection.sendChat(msg);
            }
        }
    }
}