package mainGame;

import gui_main.GUI;
import players.Player;
import players.PlayerManager;
import players.Cars;

public class Setup {
    public static final int MAX_FIELDS = 40;
    public static final int START_FIELD = 0;
    public static final int START_MONEY = 30000;

    public static final int MIN_PLAYER = 2;
    public static final int MAX_PLAYER = 4;

    private GUI gui;

    PlayerManager pM;

    public Setup(GUI gui) {
        this.gui = gui;
        pM = new PlayerManager(gui, getsPlayerAmount());
    }

    private int getsPlayerAmount() {
        int playerAmount = gui.getUserInteger("Select amount of players. Between 2-4 Players: ", 2, 4);
        System.out.println("Amount of players: " + playerAmount);
        return playerAmount;

    }

    public void startSetupMethods() {
        welcomeMessage();
        getsPlayerAmount();
        pM.makePlayer();
    }

    public void welcomeMessage() {
        //Welcome message
        gui.showMessage("Welcome to Monopoly Juniour");
    }

    public void settingUpPlayers() {
        //Setup setup = new Setup(gui);
        //setupPlayers();
        //PlayerManager pM = new PlayerManager();
        System.out.println(pM.getPlayerName(2));
        System.out.println(pM.getPlayerBalance(2));
    }
}
