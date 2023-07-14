package dev.boxadactle.boxlib.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.locale.Language;
import net.minecraft.network.chat.Component;

public abstract class BClientCommand {

    protected void sendFeedback(Component message) {
        try {
            Minecraft.getInstance().player.sendSystemMessage(message);
        } catch (Exception ignored) {

        }
    }

    protected String translatable(String key) {
        return Language.getInstance().getOrDefault(key);
    }

    public abstract String getName();

    public abstract String getCommandName();

    public abstract void build(LiteralArgumentBuilder<CommandSourceStack> builder);

    public final void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        LiteralArgumentBuilder<CommandSourceStack> builder = Commands.literal(this.getName());
        this.build(builder);

        LiteralArgumentBuilder<CommandSourceStack> root = Commands.literal(this.getCommandName())
                .executes(this::onRootCommand);

        dispatcher.register(root.then(builder));
    }

    protected int onRootCommand(CommandContext<CommandSourceStack> context) {
        return 0;
    }

}
