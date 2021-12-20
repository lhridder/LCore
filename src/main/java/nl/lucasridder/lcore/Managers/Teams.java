package nl.lucasridder.lcore.Managers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import java.util.ArrayList;

public class Teams {
    public static ArrayList<Player> red = new ArrayList<>();
    public static ArrayList<Player> blue = new ArrayList<>();
    public static ArrayList<Player> spec = new ArrayList<>();

    // prefix method
    public static ChatColor prefix(Player player) {
        if(red.contains(player)) {
            return ChatColor.RED;
        } else if(blue.contains(player)) {
            return ChatColor.BLUE;
        } else {
            return ChatColor.GRAY;
        }
    }

    // Join team
    public static void joinTeam(Player player, Team team) {
        // turn of spectator mode
        player.setGameMode(GameMode.SURVIVAL);
        spec.remove(player);
        for(Player players : Bukkit.getOnlinePlayers()) {
            players.showPlayer(player);
        }
        // join team
        if(team.equals(Team.RED)) {
            red.add(player);
            //TODO tp red spawn
        }
        if(team.equals(Team.BLUE)) {
            blue.add(player);
            //TODO tp blue spawn
        }
        // set tab name
        player.setDisplayName(prefix(player) + player.getName());
        player.setPlayerListName(prefix(player) + player.getName());
    }

    // Leave team
    public static void leaveTeam(Player player) {
        // spectator mode
        player.setGameMode(GameMode.ADVENTURE);
        for(Player players : Bukkit.getOnlinePlayers()) {
            players.hidePlayer(player);
        }
        player.setFlying(true);
        //TODO tp spawn
    }

    public enum Team {
        RED, BLUE
    }
}
