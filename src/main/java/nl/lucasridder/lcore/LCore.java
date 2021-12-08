package nl.lucasridder.lcore;

import nl.lucasridder.lcore.Commands.JoinCommand;
import nl.lucasridder.lcore.Commands.MapCommand;
import nl.lucasridder.lcore.Commands.StatsCommand;
import nl.lucasridder.lcore.Listeners.*;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class LCore extends JavaPlugin {

    public static LCore plugin;
    public LCore() {
        plugin = this;
    }

    @Override
    public void onEnable() {
        //config

        //register listeners
        getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        getServer().getPluginManager().registerEvents(new BreakEvent(), this);
        getServer().getPluginManager().registerEvents(new PlaceEvent(), this);
        getServer().getPluginManager().registerEvents(new RespawnEvent(), this);
        getServer().getPluginManager().registerEvents(new DamageEvent(), this);
        getServer().getPluginManager().registerEvents(new ChatEvent(), this);
        getServer().getPluginManager().registerEvents(new DeathEvent(), this);
        getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        getServer().getPluginManager().registerEvents(new WeatherListener(), this);
        getServer().getPluginManager().registerEvents(new FoodListener(), this);

        //register commands
        this.getCommand("join").setExecutor(new JoinCommand());
        this.getCommand("map").setExecutor(new MapCommand());
        this.getCommand("stats").setExecutor(new StatsCommand());

        //TODO tablist
    }

}
