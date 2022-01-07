package players;

import gui_fields.GUI_Car;
import gui_fields.GUI_Player;
import gui_main.GUI;
import mainGame.Setup;

import static mainGame.Setup.START_MONEY;

public class PlayerManager {
    //Playercount and Players list

    private GUI gui;

    Player[] players;

    public PlayerManager(GUI gui, int playerAmount) {
        this.gui = gui;
        this.players = new Player[playerAmount];
    }

    public void makePlayer() {
        for (int i = 0; i <= players.length - 1; i++) {
            String playerName = "player" + i;
            System.out.println("Player Name: " + playerName);
            GUI_Player GUIPlayer = new GUI_Player(playerName, START_MONEY, Cars.getCars()[i]);
            this.players[i] = new Player(Setup.START_FIELD, GUIPlayer);
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

