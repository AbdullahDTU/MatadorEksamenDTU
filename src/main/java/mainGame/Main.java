package mainGame;

import gui_main.GUI;

public class Main {


    public static void main(String[] args) {
        //Initializes GUI with the fields from Board as input. And then a color for the background
        GUI gui = new GUI();
        //GameController gameController = new GameController(gui);
        Setup setup = new Setup();
        Game game = new Game();

        //Initializes and runs Board + game
        setup.startSetupMethods();
        game.initializeGame();
    }
}
