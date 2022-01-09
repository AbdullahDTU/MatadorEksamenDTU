package mainGame;

import gui_main.GUI;
import players.PlayerManager;

public class Setup {
    //Constants for creating players
    public static final int MAX_FIELDS = 40; //TODO Unused can be removed?
    public static final int START_FIELD = 0;
    public static final int START_MONEY = 30000;
    public static final int MIN_PLAYER = 2;
    public static final int MAX_PLAYER = 4;

    //Creating an instance of GUI
    private GUI gui;

    //Creating instance of PlayerManager
    PlayerManager pM;

    public PlayerManager getpM() {
        return pM;
    }

    public void setpM(PlayerManager pM) {
        this.pM = pM;
    }

    public Setup(GUI gui) {
        this.gui = gui;
        pM = new PlayerManager(gui, getsPlayerAmount());
    }

    //Method which asks the player for amount of players from 2-4 and returns the value to be used for adding players
    private int getsPlayerAmount() {
        int playerAmount = gui.getUserInteger("Select amount of players. Between 2-4 Players: ", MIN_PLAYER, MAX_PLAYER);
        System.out.println("Amount of players: " + playerAmount);
        return playerAmount;
    }

    //Runs the methods which setsup the game
    public void startSetupMethods() {
        pM.getPlayerNames();
        pM.makePlayer();
    }

}
