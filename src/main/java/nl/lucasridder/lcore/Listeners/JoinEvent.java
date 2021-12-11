package nl.lucasridder.lcore.Listeners;

import nl.lucasridder.lcore.LCore;
import nl.lucasridder.lcore.Managers.Teams;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        //TODO items/compass

        //spec mode
        Teams.spec.add(player);
        for(Player players : Bukkit.getOnlinePlayers()) {
            players.hidePlayer(player);
        }
        player.setFlying(true);

        //TODO tablist

        //TODO scoreboard

        // set join message
        e.setJoinMessage(Teams.prefix(e.getPlayer()) + e.getPlayer().getName() + " joined.");
    }

}
