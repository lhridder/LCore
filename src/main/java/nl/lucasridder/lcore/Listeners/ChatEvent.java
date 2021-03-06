package nl.lucasridder.lcore.Listeners;

import nl.lucasridder.lcore.Managers.Teams;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        String name = player.getName();
        ChatColor prefix = Teams.prefix(player);
        e.setFormat(prefix + name + ChatColor.DARK_GRAY + " » " + ChatColor.RESET +  e.getMessage());
    }

}
