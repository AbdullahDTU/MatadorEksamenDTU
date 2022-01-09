package dice;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DieTest {
    @Test
    public void testDieSide(){
        int Sides = 6;

        //Die object
        Die die = new Die(Sides);

        //Unit test: See if Sides = Face value
        assertEquals(die.getFaceValue(), Sides);
    }

    }