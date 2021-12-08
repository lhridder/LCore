package nl.lucasridder.lcore.Listeners;

import nl.lucasridder.lcore.Managers.Prefixes;
import nl.lucasridder.lcore.Managers.Teams;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveEvent implements Listener {

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        Teams.blue.remove(player);
        Teams.red.remove(player);
        e.setQuitMessage(Prefixes.team(player) + " has left.");
    }

}
