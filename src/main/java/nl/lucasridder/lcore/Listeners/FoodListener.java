package nl.lucasridder.lcore.Listeners;

import nl.lucasridder.lcore.Managers.Teams;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodListener implements Listener {

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent e) {
        if(e.getEntity().getType() == EntityType.PLAYER){
            Player player = (Player) e.getEntity();
            // Check if in team
            if (!Teams.red.contains(player) || !Teams.blue.contains(player)) {
                e.setCancelled(true);
            }
        }
    }

}
