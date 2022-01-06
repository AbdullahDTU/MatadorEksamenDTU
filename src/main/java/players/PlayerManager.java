package players;

import gui_fields.GUI_Car;
import gui_fields.GUI_Player;
import gui_main.GUI;
import mainGame.Setup;

import static mainGame.Setup.START_MONEY;

public class PlayerManager {
    //Playercount and Players list

    private int i = 0;
    Player player0;
    Player player1;
    Player player2;
    Player player3;
    private GUI gui;

    private int playerAmount;

    public PlayerManager(GUI gui) {
        this.gui = gui;
    }

    public void playersListAdd(Player player) {
        switch (playerAmount) {
            case 1:
                player0 = player;
                Player[] players = {player0};
            case 2:
                player1 = player;
                Player[] players2 = {player0, player1};
            case 3:
                player2 = player;
                Player[] players3 = {player0, player1, player2};
            case 4:
                player3 = player;
                Player[] players4 = {player0, player1, player2, player3};
            default:
                System.out.println("More players than 4 or less players than 1 registered, invalid input");
        }
    }

    public void getsPlayerAmount() {
        //Player inserts amount of players in the game between 2 and 4
        playerAmount = gui.getUserInteger("Select amount of players. Between 2-4 Players: ", 2, 4);
        System.out.println("Amount of players: " + playerAmount);

        //String playerAmountStr = playerAmount.toString();
    }

    public Player getPlayer(int index) {
        switch (index) {
            case 1:
                return player0;
            case 2:
                return player1;
            case 3:
                return player2;
            case 4:
                return player3;
            default:
                System.out.println("More players than 4 or less players than 1 registered, invalid input");
                //return null;
        }
        return null;
    }

    public void createPlayer(String name, int balance, GUI_Car car) {
        GUI_Player GUIPlayer = new GUI_Player(name, balance, car);
        Player player = new Player(Setup.START_FIELD, GUIPlayer);
        playersListAdd(player);
    }

    public void makePlayer() {
        //PlayerManager pM = new PlayerManager();

        for (int i = 0; i <= playerAmount; i++) {
            String playerName = "player" + i;
            System.out.println("Player Name: " + playerName);

            createPlayer(playerName, START_MONEY, Cars.getCars()[i]);

        }

        if (playerAmount == 2) {
            Player[] players2 = {player0, player1};
        } else if (playerAmount == 3) {
            Player[] players2 = {player0, player1, player2};
        } else if (playerAmount == 4) {
            Player[] players2 = {player0, player1, player2, player3};
        }

        //Player[] players4 = {player0, player1, player2, player3};

    }

    public int getPlayerBalance(int index) {
        switch (index) {
            case 1:
                return getPlayer(1).getGUIPlayer().getBalance();
            case 2:
                return getPlayer(2).getGUIPlayer().getBalance();
            case 3:
                return getPlayer(3).getGUIPlayer().getBalance();
            case 4:
                return getPlayer(4).getGUIPlayer().getBalance();
            default:
                System.out.println("More players than 4 or less players than 1 registered, invalid input");
                return 0;
        }
    }

    public String getPlayerName(int index) {
        switch (index) {
            case 1:
                return getPlayer(1).getGUIPlayer().getName();
            case 2:
                return getPlayer(2).getGUIPlayer().getName();
            case 3:
                return getPlayer(3).getGUIPlayer().getName();
            case 4:
                return getPlayer(4).getGUIPlayer().getName();
            default:
                System.out.println("More players than 4 or less players than 1 registered, invalid input");
        }
        return getPlayer(index).getGUIPlayer().getName();
        //return getPlayerName(index);
    }

    public void setPlayerBalance(int index, int balance) {
        switch (index) {
            case 1:
                getPlayer(1).getGUIPlayer().setBalance(balance);
                break;
            case 2:
                getPlayer(2).getGUIPlayer().setBalance(balance);
                break;
            case 3:
                getPlayer(3).getGUIPlayer().setBalance(balance);
                break;
            case 4:
                getPlayer(4).getGUIPlayer().setBalance(balance);
                break;
            default:
                System.out.println("More players than 4 or less players than 1 registered, invalid input");
        }
    }
}

