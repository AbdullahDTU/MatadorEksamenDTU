package dice;

/**
 *
 *
 *
 */

public class Die  {
    // Variables for the Die's face value and max roll
    private int faceValue;
    public static final int DIE_MAX_FACEVALUE = 6; // Maximum face value
    public static final int FACE_VALUE = 1; //Dice Min Face Value

    public Die(int faceValue){this.faceValue = faceValue;}
    public Die() {
        this.faceValue = FACE_VALUE;
    }

    // Sets face value using math.random
    public void roll()
    {
        this.setFaceValue((int)(Math.random()*DIE_MAX_FACEVALUE)+1);
    }


    public int getFaceValue()
    {
        return faceValue;
    }

    public void setFaceValue(int faceValue){this.faceValue=faceValue;}
    public String toString()  // return faceValue in string form
    {
        return Integer.toString(faceValue);
    }


}
