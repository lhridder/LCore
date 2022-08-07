package nl.lucasridder.lcore;

import com.onarandombox.MultiverseCore.MultiverseCore;
import com.onarandombox.MultiverseCore.api.MVWorldManager;
import nl.lucasridder.lcore.Commands.JoinCommand;
import nl.lucasridder.lcore.Commands.MapCommand;
import nl.lucasridder.lcore.Commands.PlaytimeCommand;
import nl.lucasridder.lcore.Commands.StatsCommand;
import nl.lucasridder.lcore.Listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
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
            registerEvents();
            //register commands
            registerCommands();
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

    public void registerEvents() {

        PluginManager m = getServer().getPluginManager();

        m.registerEvents(new JoinEvent(), this);
        m.registerEvents(new BreakEvent(), this);
        m.registerEvents(new PlaceEvent(), this);
        m.registerEvents(new RespawnEvent(), this);
        m.registerEvents(new DamageByEntityEvent(), this);
        m.registerEvents(new ChatEvent(), this);
        m.registerEvents(new DeathEvent(), this);
        m.registerEvents(new JoinEvent(), this);
        m.registerEvents(new WeatherListener(), this);
        m.registerEvents(new FoodListener(), this);
        m.registerEvents(new InteractEvent(), this);
        m.registerEvents(new MoveEvent(), this);
        m.registerEvents(new PreCommandEvent(), this);
    }

    public void registerCommands() {
        plugin.getCommand("join").setExecutor(new JoinCommand());
        plugin.getCommand("map").setExecutor(new MapCommand());
        plugin.getCommand("stats").setExecutor(new StatsCommand());
        plugin.getCommand("playtime").setExecutor(new PlaytimeCommand());
    }

}
