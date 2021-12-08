package nl.lucasridder.lcore.Managers;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Prefixes {

    public static ChatColor team(Player player) {
        if(Teams.red.contains(player)) {
            return ChatColor.RED;
        } else if(Teams.blue.contains(player)) {
            return ChatColor.BLUE;
        } else {
            return ChatColor.GRAY;
        }
    }

}
