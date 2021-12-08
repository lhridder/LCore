package nl.lucasridder.lcore.Managers;

import org.bukkit.entity.Player;
import java.util.ArrayList;

public class Teams {
    public static ArrayList<Player> red = new ArrayList<>();
    public static ArrayList<Player> blue = new ArrayList<>();

    public static void joinTeam(Player player, Team team) {

    }

    public enum Team {
        RED, BLUE
    }
}
