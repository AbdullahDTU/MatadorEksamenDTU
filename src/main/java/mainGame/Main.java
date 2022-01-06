package mainGame;

import gui_main.GUI;

import java.awt.*;

public class Main {


    public static void main(String[] args) {
        //Initializes GUI with the fields from Board as input. And then a color for the background
        GUI gui = new GUI(Board.getFields(), new Color(176, 234, 220));
        Setup setup = new Setup(gui);
        Game game = new Game(gui);

        //Initializes and runs Board + game
        setup.startSetupMethods();
        //game.initializeGame();
    }
}
