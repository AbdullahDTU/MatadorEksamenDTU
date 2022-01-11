package mainGame;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    public void MaxNumberOfPlayers(){
        //Max number of players
        int CorrectMaxPlayer = 4;
        assertEquals(CorrectMaxPlayer,Setup.MAX_PLAYER);
    }

    @Test
    public void MinNumberOfPlayers(){
        //Min number of players
        int CorrectMinPlayer = 2;
        assertEquals(CorrectMinPlayer,Setup.MIN_PLAYER);
    }
}