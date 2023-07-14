package dev.boxadactle.boxlib.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.util.Language;

public abstract class BClientCommand {

    protected void sendFeedback(Text message, boolean overlay) {
        try {
            MinecraftClient.getInstance().player.sendMessage(message, overlay);
        } catch (Exception ignored) {

        }
    }

    protected String translatable(String key) {
        return Language.getInstance().get(key);
    }

    public abstract String getCommandName();

    public abstract String getName();

    public abstract void build(LiteralArgumentBuilder<FabricClientCommandSource> builder);

    public final void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        LiteralArgumentBuilder<FabricClientCommandSource> builder = ClientCommandManager.literal(this.getName());
        this.build(builder);

        LiteralArgumentBuilder<FabricClientCommandSource> root = ClientCommandManager.literal(this.getCommandName())
                .executes(b -> 1);

        dispatcher.register(root.then(builder));
    }
}
