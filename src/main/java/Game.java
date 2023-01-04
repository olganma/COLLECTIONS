import java.util.ArrayList;

public class Game {

    ArrayList<Player> playerList = new ArrayList<>();


    public void isRegistered(Player player) {
        playerList.add(player);
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
        for (Player player : playerList) {
            if (player.getName() == name) {
                return player;
            }
        }
        return null;
    }

}
