package nl.lucasridder.lcore.Listeners;

import nl.lucasridder.lcore.Managers.Statistics;
import nl.lucasridder.lcore.Managers.Teams;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.projectiles.ProjectileSource;

public class DeathEvent implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player player = e.getEntity().getPlayer();
        String name = player.getName();
        ChatColor prefix = Teams.prefix(player);
        EntityDamageEvent cause = e.getEntity().getLastDamageCause();
        //player kill
        if (cause.getEntity() instanceof Player || cause instanceof Projectile) {
            // Assume killer is player
            Entity killer = cause.getEntity();
            // Check if damage was from a projectile
            if (cause.getEntity() instanceof Projectile) {
                ProjectileSource shooter = ((Projectile) cause.getEntity()).getShooter();
                if (shooter instanceof Player) {
                    killer = (Entity) shooter;
                }
                e.setDeathMessage(prefix + name + " was shot by " + Teams.prefix((Player) killer) + killer.getName());
            } else {
                e.setDeathMessage(prefix + name + " was killed by " + Teams.prefix((Player) killer) + killer.getName());
            }
            Statistics.registerKill((Player) killer);
        } else {
            switch (cause.getCause()) {
                case VOID:
                    e.setDeathMessage(prefix + name + " fell from the world.");
                    break;
                case DROWNING:
                    e.setDeathMessage(prefix + name + " drowned.");
                    break;
                case FALL:
                    e.setDeathMessage(prefix + name + " fell till death.");
                    break;
                case FIRE:
                case FIRE_TICK:
                case LAVA:
                    e.setDeathMessage(prefix + name + " went up in flames.");
                    break;
                case LIGHTNING:
                    e.setDeathMessage(prefix + name + " was truck by Zeus.");
                    break;
                default:
                    e.setDeathMessage(prefix + name + " died.");
            }
        }
        Statistics.registerDeath(player);
    }

}
