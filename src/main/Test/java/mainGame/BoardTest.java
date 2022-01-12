package mainGame;
import gui_fields.GUI_Field;
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