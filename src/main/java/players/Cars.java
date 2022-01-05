package players;

import gui_fields.GUI_Car;

import java.awt.*;

public class Cars {

    private static GUI_Car[] cars = new GUI_Car[]{
            //Regular car
            new GUI_Car(Color.GREEN,
                    Color.BLACK,
                    GUI_Car.Type.CAR,
                    GUI_Car.Pattern.HORIZONTAL_GRADIANT),

            //Ufo
            new GUI_Car(Color.GREEN,
                    Color.RED,
                    GUI_Car.Type.UFO,
                    GUI_Car.Pattern.DOTTED),

            //Race Car
            new GUI_Car(Color.BLACK,
                    Color.YELLOW,
                    GUI_Car.Type.RACECAR,
                    GUI_Car.Pattern.ZEBRA),

            //Tractor
            new GUI_Car(Color.BLUE,
                    Color.BLACK,
                    GUI_Car.Type.TRACTOR,
                    GUI_Car.Pattern.HORIZONTAL_GRADIANT),

    };

    public static GUI_Car[] getCars() {
        return cars;
    }


}
