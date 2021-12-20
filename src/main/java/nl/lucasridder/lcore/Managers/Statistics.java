package nl.lucasridder.lcore.Managers;

import org.bukkit.entity.Player;

import java.util.UUID;

public class Statistics {

    // Log kill
    public static void registerKill(Player killer) {
        UUID uuid = killer.getUniqueId();
        //TODO yeet into db
    }

    // Log death
    public static void registerDeath(Player victim) {
        UUID uuid = victim.getUniqueId();
        //TODO yeet into db
    }

    // Log nexus destroy
    public static void registerNexusBreak(Player player) {
        UUID uuid = player.getUniqueId();
        //TODO yeet into db
    }

    // Log win
    public static void registerWin(Player player) {
        UUID uuid = player.getUniqueId();
        //TODO yeet into db
    }

    // Log block broken
    public static void registerBlockBreak(Player player) {
        UUID uuid = player.getUniqueId();
        //TODO yeet into db
    }

    // Log block placed
    public static void registerBlockPlace(Player player) {
        UUID uuid = player.getUniqueId();
        //TODO yeet into db
    }

}
