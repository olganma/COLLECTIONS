import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game = new Game();
    Player player1 = new Player(123, "olga82", 2);
    Player player2 = new Player(126, "juli", 9);
    Player player3 = new Player(129, "kolya", 7);
    Player player4 = new Player(34, "fedor", 7);

    @Test
    public void ShouldPlayIfBothRegisteredAnd2More() {
        game.isRegistered(player1);
        game.isRegistered(player2);
        int expected = 2;
        int actual = game.round("olga82", "juli");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldPlayIfBothRegisteredAnd2Less() {
        game.isRegistered(player2);
        game.isRegistered(player3);
        int expected = 1;
        int actual = game.round("juli", "kolya");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldPlayIfBothRegisteredEqual() {
        game.isRegistered(player3);
        game.isRegistered(player4);
        int expected = 0;
        int actual = game.round("kolya", "fedor");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldErrorIfBothNameNotRegistered() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("viktoria", "mark");
        });
    }

    @Test
    public void ShouldErrorIfFirstNameNotRegistered() {
        game.isRegistered(player1);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("viktoria", "olga82");
        });
    }

    @Test
    public void ShouldErrorIfSecondNameNotRegistered() {
        game.isRegistered(player1);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("olga82", "kolya");
        });
    }

}
