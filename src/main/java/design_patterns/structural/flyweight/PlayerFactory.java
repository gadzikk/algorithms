package design_patterns.structural.flyweight;

import java.util.HashMap;

/**
 * Created by gadzik on 30.07.20.
 */
public class PlayerFactory {
    private static HashMap<String, Player> hm = new HashMap<>();

    public static Player getPlayer(String type) {
        Player player = null;

        if (hm.containsKey(type)) {
            player = hm.get(type);
        } else {
            switch (type) {
                case "Terrorist":
                    System.out.println("Terrorist Created");
                    player = new Terrorist();
                    break;
                case "CounterTerrorist":
                    System.out.println("Counter Terrorist Created");
                    player = new CounterTerrorist();
                    break;
                default:
                    System.out.println("Unreachable code!");
            }
            hm.put(type, player);
        }
        return player;
    }
}
