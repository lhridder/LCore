package nl.lucasridder.lcore;

import com.onarandombox.MultiverseCore.MultiverseCore;
import com.onarandombox.MultiverseCore.api.MVWorldManager;
import nl.lucasridder.lcore.Commands.JoinCommand;
import nl.lucasridder.lcore.Commands.MapCommand;
import nl.lucasridder.lcore.Commands.PlaytimeCommand;
import nl.lucasridder.lcore.Commands.StatsCommand;
import nl.lucasridder.lcore.Listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class LCore extends JavaPlugin {

    public static LCore plugin;
    public LCore() {
        plugin = this;
    }
    public static MVWorldManager wm;

    @Override
    public void onEnable() {
        //config
        plugin.getConfig().options().copyDefaults(true);

        try {
            //register listeners
            getServer().getPluginManager().registerEvents(new JoinEvent(), this);
            getServer().getPluginManager().registerEvents(new BreakEvent(), this);
            getServer().getPluginManager().registerEvents(new PlaceEvent(), this);
            getServer().getPluginManager().registerEvents(new RespawnEvent(), this);
            getServer().getPluginManager().registerEvents(new DamageByEntityEvent(), this);
            getServer().getPluginManager().registerEvents(new ChatEvent(), this);
            getServer().getPluginManager().registerEvents(new DeathEvent(), this);
            getServer().getPluginManager().registerEvents(new JoinEvent(), this);
            getServer().getPluginManager().registerEvents(new WeatherListener(), this);
            getServer().getPluginManager().registerEvents(new FoodListener(), this);
            getServer().getPluginManager().registerEvents(new InteractEvent(), this);
            getServer().getPluginManager().registerEvents(new MoveEvent(), this);
            getServer().getPluginManager().registerEvents(new PreCommandEvent(), this);
        } catch(Exception e) {
            e.printStackTrace();
        }

        try {
            //register commands
            plugin.getCommand("join").setExecutor(new JoinCommand());
            plugin.getCommand("map").setExecutor(new MapCommand());
            plugin.getCommand("stats").setExecutor(new StatsCommand());
            plugin.getCommand("playtime").setExecutor(new PlaytimeCommand());
        } catch(Exception e) {
            e.printStackTrace();
        }

        try {
            MultiverseCore core = (MultiverseCore) Bukkit.getServer().getPluginManager().getPlugin("Multiverse-Core");
            wm = core.getMVWorldManager();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        //TODO unload
    }

}
