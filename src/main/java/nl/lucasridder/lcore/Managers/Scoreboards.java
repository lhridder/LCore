package nl.lucasridder.lcore.Managers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class Scoreboards {

    private Scoreboard generateScoreboard(Player player) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard b = manager.getNewScoreboard();

        Objective o = b.registerNewObjective("dummy", "");
        o.setDisplayName(ChatColor.GOLD + "FeroxMC");
        o.setDisplaySlot(DisplaySlot.SIDEBAR);

        if (Games.ingame) {
            // timer 8
            //TODO insert parsed gametime
            o.getScore(ChatColor.AQUA + "Gametime elapsed: ").setScore(8);
            // spacer 7
            o.getScore(ChatColor.DARK_AQUA + "").setScore(7);
            // red left 6
            String redleft = Games.redleft ? ChatColor.GREEN + "✔" : ChatColor.RED + "✘";
            o.getScore(ChatColor.RED + "Red left nexus: " + redleft).setScore(6);
            // red right 5
            String redright = Games.redright ? ChatColor.GREEN + "✔" : ChatColor.RED + "✘";
            o.getScore(ChatColor.RED + "Red right nexus: " + redright).setScore(5);
            // spacer 4
            o.getScore(ChatColor.GOLD + "").setScore(4);
            // blue left 3
            String blueleft = Games.blueleft ? ChatColor.GREEN + "✔" : ChatColor.RED + "✘";
            o.getScore(ChatColor.BLUE + "Blue left nexus: " + blueleft).setScore(3);
            // blue right 2
            String blueright = Games.blueright ? ChatColor.GREEN + "✔" : ChatColor.RED + "✘";
            o.getScore(ChatColor.BLUE + "Blue right nexus: " + blueright).setScore(3);
        } else {
            // text 2
            o.getScore(ChatColor.AQUA + "Start a game by joining!").setScore(2);
        }
        //spacer 1
        o.getScore("").setScore(1);
        //server footer 0
        o.getScore(ChatColor.GREEN + "play.ferox.host").setScore(0);

        return b;
    }

}
