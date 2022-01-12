package players;

import gui_main.GUI;
import players.PlayerManager;

public class Bank {

    String[] ownedFields = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
    private int[] fieldPrice = {0, 1200, 0, 1200, 0, 2000, 2000, 0, 2000, 2400, 0, 2800, 3000, 2800, 3200, 4000, 3600, 0, 3600, 4000, 0, 4400, 0, 4400, 4800, 4000, 5200, 5200, 3000, 5600, 0, 6000, 6000, 0, 6400, 4000, 0, 7000, 0, 8000};
    private int[] fieldRent = {0, 50, 0, 50, 0, 0, 100, 0, 100, 150, 0, 200, 0, 200, 250, 500, 300, 0, 300, 350, 0, 350, 0, 350, 400, 0, 450, 450, 0, 500, 0, 550, 550, 0, 600, 500, 0, 700, 0, 1000};
    private GUI gui;
    PlayerManager playerManager;

    public Bank(GUI gui, PlayerManager playerManager) {
        this.gui = gui;
        this.playerManager = playerManager;
    }

    public void changePlayerBalance(PlayerManager playerManager, int index, int price) {
        int newBalance = playerManager.getPlayerBalance(index) + price;
        playerManager.setPlayerBalance(index, newBalance);
    }

    public void makeTransaction(PlayerManager playerManager, int custumorIndex, int money, int recipientIndex) {
        changePlayerBalance(playerManager, custumorIndex, -money);
        changePlayerBalance(playerManager, recipientIndex, money);
    }

    public boolean isFieldOwnable(PlayerManager playerManager, int playerIndex) {
        int placement = playerManager.getPlayer(playerIndex).getFieldPosition();
        int price = fieldPrice[placement];
        if (ownedFields[placement].isEmpty() && fieldPrice[placement] != 0) {
            return true;
        } else {
            return false;
        }
    }

    // Can buy field player is standing on if the field has a price and the field is not already owned
    public void buyField(PlayerManager playerManager, int playerIndex, GUI gui) {
        int placement = playerManager.getPlayer(playerIndex).getFieldPosition();
        int price = fieldPrice[placement];
        ownedFields[placement] = playerManager.getPlayerName(playerIndex);
        changePlayerBalance(playerManager, playerIndex, -price);
        gui.showMessage(playerManager.getPlayerName(playerIndex) + " bought the field for: " + price + " Kr!");
    }


    public void payRent(PlayerManager playerManager, Player player, GUI gui) {
        int rent = fieldRent[player.getFieldPosition()];
        int custumorIndex = playerManager.getPlayerIndex(player.getGUIPlayer().getName());
        String recipientName = ownedFields[player.getFieldPosition()];
        int recipientIndex = playerManager.getPlayerIndex(recipientName);

        if (player.getFieldPosition() == 4) {
            changePlayerBalance(playerManager, custumorIndex, -player.getGUIPlayer().getBalance() / 10);
            gui.showMessage(playerManager.getPlayerName(custumorIndex) + " paid 10% of your money in tax");
        } else if (player.getFieldPosition() == 38) {
            changePlayerBalance(playerManager, custumorIndex, -2000);
            gui.showMessage(playerManager.getPlayerName(custumorIndex) + " paid 2000 kr in tax");
        } else if (!ownedFields[player.getFieldPosition()].isEmpty() && !ownedFields[player.getFieldPosition()].equals(player.getGUIPlayer().getName())) {
            makeTransaction(playerManager, custumorIndex, rent, recipientIndex);
            gui.showMessage(playerManager.getPlayerName(custumorIndex) + " paid a rent of:" + rent + " kr." + " To player: " + recipientName);
        }
    }

    public void passStartHandout(PlayerManager playerManager, int index) {
        changePlayerBalance(playerManager, index, 4000);
    }

    public void sellField(int index) {
        int selectedField;
    }
}
