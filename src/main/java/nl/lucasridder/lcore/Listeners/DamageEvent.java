package nl.lucasridder.lcore.Listeners;

import nl.lucasridder.lcore.Managers.Teams;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageEvent implements Listener {

    @EventHandler
    public void onEntityDamageEvent(EntityDamageEvent e) {
        if(e.getCause().equals(EntityDamageEvent.DamageCause.FALL) && Teams.spec.contains((Player) e.getEntity())) {
            e.setCancelled(true);
        }
    }

}
