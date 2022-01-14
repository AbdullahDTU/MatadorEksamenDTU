package dice;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DieTest {
    @Test
    public void testDieMax_FaceValue(){
        int Correct_Max_FaceValue = 6;

        //Unit test: See if Correct_Max_FaceValue = Max face value
        assertEquals(Correct_Max_FaceValue,Die.DIE_MAX_FACEVALUE);
    }

    @Test
    public void testDieMin_FaceValue(){
        int Correct_Min_FaceValue = 1;

        //Unit test: See if Correct_Min_FaceValue = Face value
        assertEquals(Correct_Min_FaceValue, Die.FACE_VALUE);

    }

    }
