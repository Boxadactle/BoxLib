package dev.boxadactle.boxlib.command;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.commands.SharedSuggestionProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public interface BCommandSourceStack extends SharedSuggestionProvider {

    void boxlib$sendFeedback(Component message, boolean broadcastToOps);

    void boxlib$sendError(Component message);

    LocalPlayer boxlib$getPlayer();

    Vec3 boxlib$getPosition();

    Vec2 boxlib$getRot();

    ClientLevel boxlib$getWorld();

}
