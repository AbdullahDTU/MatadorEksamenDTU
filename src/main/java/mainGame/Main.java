package mainGame;

import gui_main.GUI;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        //Initializes GUI with the fields from Board as input. And then a color for the background
        GUI gui = new GUI(Board.getFields() ,new Color(5, 154, 5));

        //Shows a welcome message at the start of the game
<<<<<<< Updated upstream
        gui.showMessage("Welcome to Matador");
=======
        gui.showMessage("Welcome to Monopoly");
>>>>>>> Stashed changes

        //Initializing instance of Setup and Game with access to GUI
        Setup setup = new Setup(gui);
        Game game = new Game(gui, setup.getpM());

        //Initializes and runs Board + game
        setup.startSetupMethods();
        game.startGame();
    }

}
