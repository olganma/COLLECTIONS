import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    public void ShouldSetId() {
        Player player1 = new Player(123, "Olga82", 2);
        player1.setId(124);
        Assertions.assertEquals(124, player1.getId());
    }

    @Test
    public void ShouldSetName() {
        Player player1 = new Player(123, "olga82", 2);
        player1.setName("olga1982");
        Assertions.assertEquals("olga1982", player1.getName());
    }

    @Test
    public void ShouldSetStrength() {
        Player player1 = new Player(123, "olga82", 2);
        player1.setStrength(3);
        Assertions.assertEquals(3, player1.getStrength());
    }
}