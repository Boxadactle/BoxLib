package dev.boxadactle.boxlib.util;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.scores.Team;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Comparator;
import java.util.List;

public class WorldUtils {

    public static Entity getCamera() {
        return ClientUtils.getClient().getCameraEntity();
    }

    public static Player getPlayer() {
        return ClientUtils.getClient().player;
    }

    public static Level getWorld() {
        return ClientUtils.getClient().level;
    }

    public static String getCurrentDimension() {
        ResourceKey<Level> registry = getPlayer().level().dimension();

        return registry.location().toString();
    }

    public static List<PlayerInfo> getTabListUnordered() {
        ClientPacketListener clientPlayNetworkHandler = ClientUtils.getClient().getConnection();
        return clientPlayNetworkHandler.getOnlinePlayers().stream().toList();
    }

    public static List<PlayerInfo> getTabList() {
        return Ordering.from(new EntryOrderComparator()).sortedCopy(getTabListUnordered());
    }

    @OnlyIn(Dist.CLIENT)
    static class EntryOrderComparator implements Comparator<PlayerInfo> {
        EntryOrderComparator() {
        }

        public int compare(PlayerInfo playerListEntry, PlayerInfo playerListEntry2) {
            Team team = playerListEntry.getTeam();
            Team team2 = playerListEntry2.getTeam();
            return ComparisonChain.start().compareTrueFirst(playerListEntry.getGameMode() != GameType.SPECTATOR, playerListEntry2.getGameMode() != GameType.SPECTATOR).compare(team != null ? team.getName() : "", team2 != null ? team2.getName() : "").compare(playerListEntry.getProfile().getName(), playerListEntry2.getProfile().getName(), String::compareToIgnoreCase).result();
        }
    }

}
