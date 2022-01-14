package mainGame;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class BoardTest {
    @Test
    public void testNumberOfFields(){
        int correctFields = 40;

        //Unit test: Test the correct number of fields
        assertEquals(correctFields,Board.getFields().length);
    }

}