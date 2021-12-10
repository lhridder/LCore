package nl.lucasridder.lcore.Listeners;

import nl.lucasridder.lcore.Managers.Teams;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveEvent implements Listener {

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        // gather info
        Player player = e.getPlayer();
        // remove player from team
        Teams.blue.remove(player);
        Teams.red.remove(player);
        // finish event with msg
        e.setQuitMessage(Teams.prefix(player) + player.getName() +  " has left.");
    }

}
