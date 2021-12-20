package nl.lucasridder.lcore.Listeners;

import nl.lucasridder.lcore.Managers.Teams;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.projectiles.ProjectileSource;

public class DamageByEntityEvent implements Listener {

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && (e.getDamager() instanceof Player || e.getDamager() instanceof Projectile)) {
            Player player = (Player) e.getEntity();
            Player Damager = (Player) e.getDamager();
            // Check if damager was a projectile
            if (e.getDamager() instanceof Projectile) {
                ProjectileSource shooter = ((Projectile) e.getDamager()).getShooter();
                if (!(shooter instanceof Player)) {
                    return;
                } else {
                    Damager = (Player) shooter;
                }
            }
            // Check if player is spectator
            if(Teams.spec.contains(Damager)) {
                e.setCancelled(true);
            }
            // Friendly fire
            if((Teams.red.contains(player) && Teams.red.contains(Damager)) || (Teams.blue.contains(player) && Teams.blue.contains(Damager))) {
                e.setCancelled(true);
            }
        }
    }

}
