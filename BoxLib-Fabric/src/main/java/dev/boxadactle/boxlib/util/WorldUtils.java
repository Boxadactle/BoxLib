package dev.boxadactle.boxlib.util;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.entity.Entity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.scoreboard.Team;
import net.minecraft.world.GameMode;
import net.minecraft.world.World;

import java.util.Comparator;
import java.util.List;

public class WorldUtils {

    public static Entity getCamera() {
        return ClientUtils.getClient().getCameraEntity();
    }

    public static ClientPlayerEntity getPlayer() {
        return ClientUtils.getClient().player;
    }

    public static World getWorld() {
        return ClientUtils.getClient().world;
    }

    public static String getCurrentDimension() {
        RegistryKey<World> registry = getPlayer().clientWorld.getRegistryKey();

        return (registry != null ? registry.getValue().toString() : null);
    }

    public static List<PlayerListEntry> getTabListUnordered() {
        ClientPlayNetworkHandler clientPlayNetworkHandler = getPlayer().networkHandler;
        return clientPlayNetworkHandler.getPlayerList().stream().toList();
    }

    public static List<PlayerListEntry> getTabList() {
        return Ordering.from(new EntryOrderComparator()).sortedCopy(getTabListUnordered());
    }

    @Environment(EnvType.CLIENT)
    static class EntryOrderComparator implements Comparator<PlayerListEntry> {
        EntryOrderComparator() {
        }

        public int compare(PlayerListEntry playerListEntry, PlayerListEntry playerListEntry2) {
            Team team = playerListEntry.getScoreboardTeam();
            Team team2 = playerListEntry2.getScoreboardTeam();
            return ComparisonChain.start().compareTrueFirst(playerListEntry.getGameMode() != GameMode.SPECTATOR, playerListEntry2.getGameMode() != GameMode.SPECTATOR).compare(team != null ? team.getName() : "", team2 != null ? team2.getName() : "").compare(playerListEntry.getProfile().getName(), playerListEntry2.getProfile().getName(), String::compareToIgnoreCase).result();
        }
    }

}
