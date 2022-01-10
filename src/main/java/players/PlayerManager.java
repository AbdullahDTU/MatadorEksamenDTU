package players;

import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;
import mainGame.Setup;

import static mainGame.Setup.START_FIELD;
import static mainGame.Setup.START_MONEY;

public class PlayerManager {
    private GUI gui;

    //Arrays for player objects and player names
    public Player[] players;
    String[] playerNames;
    private String[] playerOrderText = {"first player's name", "second player's name", "third player's name", "fourth player's name"};

    public PlayerManager(GUI gui, int playerAmount) {
        this.gui = gui;
        this.players = new Player[playerAmount];
        this.playerNames = new String[playerAmount];
    }

    public void getPlayerNames() {
        //For loop to add each inserted player name into the game
        for (int currentPlayer = 0; currentPlayer < players.length; currentPlayer++) {
            while (true) {
                String playerName = gui.getUserString("Enter the " + playerOrderText[currentPlayer]);
                this.playerNames[currentPlayer] = new String(playerName);

                break;
            }
        }
    }

    //Creates the players from the given player amount and names
    public void makePlayer() {
        for (int i = 0; i <= players.length - 1; i++) {
            String playerName = playerNames[i];
            System.out.println("Player Name: " + playerName);
            GUI_Player GUIPlayer = new GUI_Player(playerName, START_MONEY, Cars.getCars()[i]);
            this.players[i] = new Player(Setup.START_FIELD, GUIPlayer);
            GUI_Field field = gui.getFields()[getPlayer(i).getFieldPosition()];
            getPlayer(i).getGUIPlayer().getCar().setPosition(field);
            gui.addPlayer(getPlayer(i).getGUIPlayer());
        }
    }

    public int getPlayerBalance(int index) {
        return players[index].getGUIPlayer().getBalance();
    }

    public String getPlayerName(int index) {
        return players[index].getGUIPlayer().getName();
    }

    public void setPlayerName(int index, String name) {
        players[index].getGUIPlayer().setName(name);
    }

    public Player getPlayer(int index) {
        return players[index];
    }

    public GUI_Car getGuiCar(int index) {
        return players[index].getGUIPlayer().getCar();
    }

    public void setPlayerBalance(int index, int balance) {
        players[index].getGUIPlayer().setBalance(balance);
    }
}

