package dev.boxadactle.boxlib.command.fabric;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.Minecraft;
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

    public abstract void build(LiteralArgumentBuilder<FabricClientCommandSource> builder);

    public final void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        LiteralArgumentBuilder<FabricClientCommandSource> builder = ClientCommandManager.literal(this.getName());
        this.build(builder);

        LiteralArgumentBuilder<FabricClientCommandSource> root = ClientCommandManager.literal(this.getCommandName())
                .executes(this::onRootCommand);

        dispatcher.register(root.then(builder));
    }

    protected int onRootCommand(CommandContext<FabricClientCommandSource> context) {
        return 0;
    }

}
