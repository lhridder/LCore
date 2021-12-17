package nl.lucasridder.lcore.Managers;

import nl.lucasridder.lcore.LCore;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arenas {
    static String currentMap = "";
    static String currentWorld = "";
    Location lobby = null;
    static ArrayList<String> maps = new ArrayList<>();
    public static FileConfiguration config = LCore.plugin.getConfig();

    public void getArenas() {
        // fetch lobby coords
        lobby.setX(config.getDouble("lobby.x"));
        lobby.setY(config.getDouble("lobby.y"));
        lobby.setZ(config.getDouble("lobby.z"));
        lobby.setWorld(Bukkit.getWorld(config.getString("lobby.world")));
        // fetch maps
        List<String> maps = config.getStringList("maplist");
        for (String map : maps) {
            config.get("maps." + map);
        }
    }

    public void newArena() {
        // Choose new map
        Random rand = new Random();
        ArrayList<String> newmaps = maps;
        newmaps.remove(currentMap);
        int map = rand.nextInt(newmaps.size());
        String newmap = newmaps.get(map);
        // Load map
        LCore.wm.cloneWorld(newmap, newmap + "_active");
        Location newmapspawn = null;
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.teleport(newmapspawn);
        }
        currentMap = newmap;
        // Delete old map
        LCore.wm.deleteWorld(currentWorld);
        currentMap = newmap;
        currentWorld = newmap + "_active";
    }

    public void closeArenas() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.teleport(lobby);
        }
        LCore.wm.deleteWorld(currentWorld);
    }

}
