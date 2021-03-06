package nl.lucasridder.lcore.Listeners;

import nl.lucasridder.lcore.Managers.Arenas;
import nl.lucasridder.lcore.Managers.Statistics;
import nl.lucasridder.lcore.Managers.Teams;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlaceEvent implements Listener {

    @EventHandler
    public void onPlace(BlockPlaceEvent e){
        Player player = e.getPlayer();
        if(Teams.spec.contains(player)) {
            if(!player.isOp()) {
                e.setCancelled(true);
                player.sendMessage(ChatColor.RED + "No permission to place this block");
            }
        } else {
            if(Arenas.inArena(e.getBlock().getLocation())) {
                Statistics.registerBlockPlace(player);
            }
        }

    }

}
