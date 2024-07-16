package dev.boxadactle.boxlib.forge.mixin;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import dev.boxadactle.boxlib.command.BCommandSourceStack;
import dev.boxadactle.boxlib.util.WorldUtils;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(CommandSourceStack.class)
public abstract class CommandSourceStackMixin implements BCommandSourceStack {

    @Override
    public void boxlib$sendFeedback(Component message, boolean broadcastToOps) {
        ((CommandSourceStack) (Object) this).sendSuccess(message, broadcastToOps);
    }

    @Override
    public void boxlib$sendError(Component message) {
        ((CommandSourceStack) (Object) this).sendFailure(message);
    }

    @Override
    public LocalPlayer boxlib$getPlayer() {
        try {
            return (LocalPlayer) ((CommandSourceStack) (Object) this).getEntityOrException();
        } catch (CommandSyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Vec3 boxlib$getPosition() {
        return ((CommandSourceStack) (Object) this).getPosition();
    }

    @Override
    public Vec2 boxlib$getRot() {
        return ((CommandSourceStack) (Object) this).getRotation();
    }

    @Override
    public ClientLevel boxlib$getWorld() {
        return (ClientLevel) WorldUtils.getWorld();
    }

}
