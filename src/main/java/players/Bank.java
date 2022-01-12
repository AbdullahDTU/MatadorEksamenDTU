package players;

import gui_fields.GUI_Field;
import gui_fields.GUI_Ownable;
import gui_main.GUI;
import players.PlayerManager;

import java.awt.*;
import java.util.Arrays;

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

    // Methods that changes the player balance
    public void changePlayerBalance(PlayerManager playerManager, int index, int price) {
        int newBalance = playerManager.getPlayerBalance(index) + price;

        // If statement to make sure balance does not reach negative numbers
        if (newBalance <= 0) {
            playerManager.setPlayerBalance(index, 0);
        } else {
            playerManager.setPlayerBalance(index, newBalance);
        }

    }

    // Method to make transactions between players, used to pay rent from a player to the owner of field
    public void makeTransaction(PlayerManager playerManager, int custumorIndex, int money, int recipientIndex) {
        changePlayerBalance(playerManager, custumorIndex, -money);
        changePlayerBalance(playerManager, recipientIndex, money);
    }

    // Checks if a field is owned and returns true or false
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
        if (playerManager.getPlayerBalance(playerIndex) > price) {
            ownedFields[placement] = playerManager.getPlayerName(playerIndex);
            changePlayerBalance(playerManager, playerIndex, -price);
            gui.showMessage(playerManager.getPlayerName(playerIndex) + " bought the field for: " + price + " Kr!");
            GUI_Field field = gui.getFields()[placement];
            GUI_Ownable ownable = (GUI_Ownable) field;
            ownable.setOwnerName(playerManager.getPlayerName(playerIndex));
            ownable.setBorder(playerManager.getGuiCar(playerIndex).getPrimaryColor(), Color.BLACK);
        }
        else {
            gui.showMessage(playerManager.getPlayerName(playerIndex) + " unfortunately lack the funds to buy this field. Therefore the field was not bought.");
        }
    }

    public void auctionField(PlayerManager playerManager, int playerIndex, GUI gui) {
        String name = playerManager.getPlayerName(playerIndex);
        for (int i = 0; i < ownedFields.length && playerManager.getPlayerBalance(playerIndex) == 0; i++) {
            if(ownedFields[i].equals(name)) {
                ownedFields[i] = "";
                int price = fieldPrice[i];
                changePlayerBalance(playerManager, playerIndex, price/2);
                GUI_Field field = gui.getFields()[i];
                GUI_Ownable ownable = (GUI_Ownable) field;
                ownable.setOwnerName(null);
                gui.showMessage(playerManager.getPlayerName(playerIndex) + " had their field force-auctioned to avoid bankruptcy and recieved: " + price/2 + " Kr" + " for the field");
                ownable.setBorder(null, null);
            }
        }
    }

    // Method for player to pay rent for his owned fields
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

    // Amount of money a player recieves when passing start
    public void passStartHandout(PlayerManager playerManager, int index) {
        changePlayerBalance(playerManager, index, 4000);
    }
}
