import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {

    private HashMap<String, Player> map = new HashMap<>();


    public void isRegistered(Player player) {
        map.put(player.getName(), player);
    }

    public int round(String playerName1, String playerName2) {
        if (findByName(playerName1) == null || findByName(playerName2) == null) {
            throw new NotRegisteredException("Оба игрока должны быть зарегистрированы");
        }
        if (findByName(playerName1).getStrength() > findByName(playerName2).getStrength()) {
            return 1;
        } else if (findByName(playerName1).getStrength() < findByName(playerName2).getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }

    public Player findByName(String name) {
        return map.get(name);
    }

}
