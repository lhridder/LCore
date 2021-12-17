package nl.lucasridder.lcore;

import com.onarandombox.MultiverseCore.MultiverseCore;
import com.onarandombox.MultiverseCore.api.MVWorldManager;
import com.onarandombox.MultiverseCore.utils.WorldManager;
import nl.lucasridder.lcore.Commands.JoinCommand;
import nl.lucasridder.lcore.Commands.MapCommand;
import nl.lucasridder.lcore.Commands.PlaytimeCommand;
import nl.lucasridder.lcore.Commands.StatsCommand;
import nl.lucasridder.lcore.Listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public class LCore extends JavaPlugin {

    public static LCore plugin;
    public LCore() {
        plugin = this;
    }
    public static MVWorldManager wm;

    @Override
    public void onEnable() {
        //config
        if (!getDataFolder().exists()) {
            //create config folder
            try {
                getDataFolder().createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            plugin.getConfig().options().copyDefaults(true);
        }

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
        getServer().getPluginManager().registerEvents(new InteractEvent(), this);
        getServer().getPluginManager().registerEvents(new MoveEvent(), this);

        //register commands
        this.getCommand("join").setExecutor(new JoinCommand());
        this.getCommand("map").setExecutor(new MapCommand());
        this.getCommand("stats").setExecutor(new StatsCommand());
        this.getCommand("playtime").setExecutor(new PlaytimeCommand());

        MultiverseCore core = (MultiverseCore) Bukkit.getServer().getPluginManager().getPlugin("Multiverse-Core");
        wm = core.getMVWorldManager();
    }

    @Override
    public void onDisable() {

    }

}
