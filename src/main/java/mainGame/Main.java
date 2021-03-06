package mainGame;

import gui_main.GUI;

import java.awt.*;

/**
 * The Main class initializes the game by creating the GUI, running the Setup and Game
 */

public class Main {

    public static void main(String[] args) {
        //Initializes the GUI with the fields from Board as input. And then a color for the background
        GUI gui = new GUI(Board.getFields(), new Color(252, 229, 229));

        //Shows a welcome message at the start of the game
        gui.showMessage("Welcome to Matador");

        //Initializing instance of Setup and Game with access to GUI
        Setup setup = new Setup(gui);
        Game game = new Game(gui, setup.getpM(), setup.getdK());

        //Initializes and runs Setup + Game
        setup.startSetupMethods();
        game.startGame();
    }

}
