package dev.boxadactle.boxlib.util;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.Dimension;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.scores.Team;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility class for interacting with the game world.
 */
public class WorldUtils {

    /**
     * Retrieves the camera entity.
     *
     * @return The camera entity.
     */
    public static Entity getCamera() {
        return ClientUtils.getClient().getCameraEntity();
    }

    /**
     * Retrieves the player entity.
     *
     * @return The player entity.
     */
    public static Player getPlayer() {
        return ClientUtils.getClient().player;
    }

    /**
     * Retrieves the current game world.
     *
     * @return The game world.
     */
    public static Level getWorld() {
        return ClientUtils.getClient().level;
    }

    /**
     * Retrieves the current dimension of the player.
     *
     * @return The dimension as a string.
     */
    public static String getCurrentDimension() {
        Dimension dimension = getPlayer().level.dimension;

        return DimensionType.getName(dimension.getType()).toString();
    }

    /**
     * Retrieves the list of players in the tab list in no particular order.
     *
     * @return The unordered list of players.
     */
    public static List<PlayerInfo> getTabListUnordered() {
        ClientPacketListener clientPlayNetworkHandler = ClientUtils.getClient().getConnection();
        return clientPlayNetworkHandler.getOnlinePlayers().stream().collect(Collectors.toList());
    }

    /**
     * Retrieves the list of players in the tab list sorted by a specific order.
     *
     * @return The sorted list of players.
     */
    public static List<PlayerInfo> getTabList() {
        return Ordering.from(new EntryOrderComparator()).sortedCopy(getTabListUnordered());
    }

    /**
     * Comparator used for sorting player entries in the tab list.
     */
    static class EntryOrderComparator implements Comparator<PlayerInfo> {
        EntryOrderComparator() {
        }

        public int compare(PlayerInfo playerListEntry, PlayerInfo playerListEntry2) {
            Team team = playerListEntry.getTeam();
            Team team2 = playerListEntry2.getTeam();
            return ComparisonChain.start()
                    .compareTrueFirst(playerListEntry.getGameMode() != GameType.SPECTATOR, playerListEntry2.getGameMode() != GameType.SPECTATOR)
                    .compare(team != null ? team.getName() : "", team2 != null ? team2.getName() : "")
                    .compare(playerListEntry.getProfile().getName(), playerListEntry2.getProfile().getName(), String::compareToIgnoreCase)
                    .result();
        }
    }

}
