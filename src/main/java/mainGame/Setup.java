package mainGame;

import gui_main.GUI;
import players.Player;
import players.PlayerManager;
import players.Cars;

import java.util.Scanner;

public class Setup {
    public static final int MAX_FIELDS = 40;
    public static final int START_FIELD = 0;
    public static final int START_MONEY = 30000;

    public static final int MIN_PLAYER = 2;
    public static final int MAX_PLAYER = 4;

    private int playerAmount;

    private GUI gui;

    public Setup(GUI gui) {
        this.gui = gui;
    }


    /*
    Player player1 = new Player();
    Player player2 = new Player();
    Player player3 = new Player();
    Player player4 = new Player();

    Player[] players = new {};

     */


    public void startSetupMethods(){
        welcomeMessage();
        getPlayerAmount();
    }

    public void welcomeMessage() {
        //Welcome message
        gui.showMessage("Welcome to Monopoly Juniour");
    }

    public void getPlayerAmount() {
        //Player inserts amount of players in the game between 2 and 4
        playerAmount = gui.getUserInteger("Select amount of players. Between 2-4 Players: ", 2, 4);

    }

    public void setupPlayers() {
        PlayerManager pM = new PlayerManager();
        pM.createPlayer("player1",START_MONEY,Cars.getCars()[0]);
        pM.createPlayer("player2",START_MONEY,Cars.getCars()[1]);
        pM.createPlayer("player3",START_MONEY,Cars.getCars()[2]);
        pM.createPlayer("player4",START_MONEY,Cars.getCars()[3]);
    }

    /*

    public arrayOfPlayers (int playerAmount) {
        switch (playerAmount) {
            case 1:
                Player[] players1 = {player1};
                break;
            case 2:
                Player[] players2 = {player1, player2};
                break;
            case 3:
                Player[] players3 = {player1, player2, player3};
                break;
            case 4:
                Player[] players4 = {player1, player2, player3, player4};
                break;
            default:
                System.out.println("More players than 4 or less players than 1 registered, invalid input");
                return;
        }
    }



    public void getPlayerNames() {
        //For loop to add each player inserted name into the game
        for (int currentPlayer = 0; currentPlayer < playerAmount; currentPlayer++) {
            while (true) {
                String playerName = gui.getUserString("Enter the " + playerOrderText[currentPlayer]);
                playerNames.add(playerName);

                break;
            }
        }
    }
    
     */






}
