import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game = new Game();
    Player player1 = new Player(123, "Оля", 2);
    Player player2 = new Player(126, "Юля", 9);
    Player player3 = new Player(129, "Коля", 7);
    Player player4 = new Player(34, "Федя", 7);

    @Test
    public void ShouldPlayIfBothRegisteredAnd2More() {
        game.isRegistered(player1);
        game.isRegistered(player2);
        int expected = 2;
        int actual = game.round("Оля", "Юля");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldPlayIfBothRegisteredAnd2Less() {
        game.isRegistered(player2);
        game.isRegistered(player3);
        int expected = 1;
        int actual = game.round("Юля", "Коля");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldPlayIfBothRegisteredEqual() {
        game.isRegistered(player3);
        game.isRegistered(player4);
        int expected = 0;
        int actual = game.round("Коля", "Федя");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldErrorIfBothNameNotRegistered() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Зоя", "Витя");
        });
    }

    @Test
    public void ShouldErrorIfFirstNameNotRegistered() {
        game.isRegistered(player1);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Зоя", "Оля");
        });
    }

    @Test
    public void ShouldErrorIfSecondNameNotRegistered() {
        game.isRegistered(player1);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Оля", "Коля");
        });
    }

}
