package dev.boxadactle.boxlib.fabric.mixin;

import dev.boxadactle.boxlib.command.BCommandSourceStack;
import net.fabricmc.fabric.api.client.command.v1.FabricClientCommandSource;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;

// sorry
@Mixin(FabricClientCommandSource.class)
public interface FabricClientCommandSourceMixin extends BCommandSourceStack {

    @Override
    default void boxlib$sendFeedback(Component message, boolean broadcastToOps) {
        ((FabricClientCommandSource) this).sendFeedback(message);
    }

    @Override
    default void boxlib$sendError(Component message) {
        ((FabricClientCommandSource) this).sendError(message);
    }

    @Override
    default LocalPlayer boxlib$getPlayer() {
        return ((FabricClientCommandSource) this).getPlayer();
    }

    @Override
    default Vec3 boxlib$getPosition() {
        return ((FabricClientCommandSource) this).getPosition();
    }

    @Override
    default Vec2 boxlib$getRot() {
        return ((FabricClientCommandSource) this).getRotation();
    }

    @Override
    default ClientLevel boxlib$getWorld() {
        return ((FabricClientCommandSource) this).getWorld();
    }

}
