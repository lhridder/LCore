package nl.lucasridder.lcore.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlaytimeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (args.length == 0) {
            calculateUptime(player, player);
        } else {
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                sender.sendMessage(ChatColor.RED + "Doel is niet online");
                return true;
            } else {
                calculateUptime(player, target);
            }
        }
        return true;
    }

    void calculateUptime(Player player, Player target) {
        if (target == null) {
            player.sendMessage(ChatColor.RED + "Doel is niet online");
        }
        //get source
        int ptt = target.getStatistic(Statistic.PLAY_ONE_TICK);
        String name = target.getName();
        //calculate
        int pts = ptt / 20; //seconds
        int ptm = pts / 60; //minutes
        int pth = ptm / 60; //hours
        int rm = ptm - (pth * 60); //res minutes
        int rs = pts - (ptm * 60); //res seconds
        // Send response back
        target.sendMessage(ChatColor.GREEN + "Playtime: "
                + ChatColor.GOLD + name + ChatColor.GREEN + ": "
                + ChatColor.GOLD + pth + ChatColor.GREEN + " hours, "
                + ChatColor.GOLD + rm + ChatColor.GREEN + " minutes and "
                + ChatColor.GOLD + rs + ChatColor.GREEN + " seconds");
    }
}
