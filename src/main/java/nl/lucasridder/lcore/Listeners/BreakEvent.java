package nl.lucasridder.lcore.Listeners;

import nl.lucasridder.lcore.Managers.Teams;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakEvent implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        if(!Teams.blue.contains(player) || !Teams.red.contains(player) && !player.isOp()) {
            e.setCancelled(true);
            player.sendMessage(ChatColor.RED + "No permission to break this block");
        } else {
            //nexus
            if(e.getBlock().getType().equals(Material.OBSIDIAN)) {
                //dont drop
                e.getBlock().getDrops().clear();
                //TODO check if own nexus
            }
            //TODO check arena bounds
        }
    }

}
