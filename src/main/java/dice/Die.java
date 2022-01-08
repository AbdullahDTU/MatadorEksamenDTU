package dice;

public class Die  {
    private int faceValue;

    public static final int DIE_MAX_FACEVALUE = 6; // Maximum face value
    public static final int FACE_VALUE = 1; //Dice Face Value

    public Die(int faceValue){this.faceValue = faceValue;}
    public Die() {
        this.faceValue = FACE_VALUE;
    }

    public void roll() // returns result (math.random method)
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
