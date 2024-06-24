package dev.boxadactle.boxlib.command;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.commands.SharedSuggestionProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

/**
 * This interface represents a command source stack for BoxLib commands.
 * It extends the SharedSuggestionProvider interface.
 */
public interface BCommandSourceStack extends SharedSuggestionProvider {

    /**
     * Sends a feedback message to the command source.
     * 
     * @param message The message to send.
     * @param broadcastToOps Whether to broadcast the message to ops.
     */
    void boxlib$sendFeedback(Component message, boolean broadcastToOps);

    /**
     * Sends an error message to the command source.
     * 
     * @param message The error message to send.
     */
    void boxlib$sendError(Component message);

    /**
     * Gets the player associated with the command source.
     * 
     * @return The LocalPlayer object representing the player.
     */
    LocalPlayer boxlib$getPlayer();

    /**
     * Gets the position of the command source.
     * 
     * @return The position as a Vec3 object.
     */
    Vec3 boxlib$getPosition();

    /**
     * Gets the rotation of the command source.
     * 
     * @return The rotation as a Vec2 object.
     */
    Vec2 boxlib$getRot();

    /**
     * Gets the world associated with the command source.
     * 
     * @return The ClientLevel object representing the world.
     */
    ClientLevel boxlib$getWorld();

}
