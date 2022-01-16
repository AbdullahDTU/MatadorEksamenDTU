package mainGame;

import chanceCards.Deck;
import gui_main.GUI;
import players.Bank;
import players.Player;
import players.PlayerManager;

/**
 * The Setup class sets up the game with amount of players and creating players
 */

public class Setup {
    //Constants for creating players
    public static final int MAX_FIELDS = 40;
    public static final int START_FIELD = 0;
    public static final int START_MONEY = 20000;
    public static final int MIN_PLAYER = 2;
    public static final int MAX_PLAYER = 4;
    public static final int NUMBER_OF_TURNS = 50;
    public static final int STUCK_IN_JAIL_ROUNDS_MAX = 3;

    //Creating an instance of GUI
    private final GUI gui;

    // Creating Instances of GUI, bank, player and deck
    PlayerManager pM;
    Bank bank;
    Player player;
    Deck dK;

    public PlayerManager getpM() {
        return pM;
    }

    public Deck getdK() {
        return dK;
    }

    // Constructor of type Setup that takes input from GUI
    public Setup(GUI gui) {
        this.gui = gui;
        pM = new PlayerManager(gui, getsPlayerAmount());
        dK = new Deck(gui, bank, pM, player);
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
