package nl.lucasridder.lcore.Listeners;

import nl.lucasridder.lcore.Managers.Prefixes;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        String name = player.getName();
        e.setJoinMessage(ChatColor.GRAY + name + " joined.");

        //TODO cool stuff
    }

}
