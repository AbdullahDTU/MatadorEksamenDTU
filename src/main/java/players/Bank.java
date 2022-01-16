package players;

import gui_fields.GUI_Field;
import gui_fields.GUI_Ownable;
import gui_fields.GUI_Street;
import gui_main.GUI;

import java.awt.*;

/**
 * The bank class controls all transactions done in the game
 */

public class Bank {
    String[] ownedFields = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
    private int[] fieldPrice = {0, 1200, 0, 1200, 0, 2000, 2000, 0, 2000, 2400, 0, 2800, 3000, 2800, 3200, 4000, 3600, 0, 3600, 4000, 0, 4400, 0, 4400, 4800, 4000, 5200, 5200, 3000, 5600, 0, 6000, 6000, 0, 6400, 4000, 0, 7000, 0, 8000};
    private int[] fieldRent = {0, 50, 0, 50, 0, 0, 100, 0, 100, 150, 0, 200, 0, 200, 250, 500, 300, 0, 300, 350, 0, 350, 0, 350, 400, 0, 450, 450, 0, 500, 0, 550, 550, 0, 600, 500, 0, 700, 0, 1000};
    private static final int[] FIELD_PRICE = {0, 1200, 0, 1200, 0, 2000, 2000, 0, 2000, 2400, 0, 2800, 3000, 2800, 3200, 4000, 3600, 0, 3600, 4000, 0, 4400, 0, 4400, 4800, 4000, 5200, 5200, 3000, 5600, 0, 6000, 6000, 0, 6400, 4000, 0, 7000, 0, 8000};
    private static final int[] FIELD_RENT = {0, 50, 0, 50, 0, 0, 100, 0, 100, 150, 0, 200, 0, 200, 250, 500, 300, 0, 300, 350, 0, 350, 0, 350, 400, 0, 450, 450, 0, 500, 0, 550, 550, 0, 600, 500, 0, 700, 0, 1000};
    private int[] housesCount = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    PlayerManager playerManager;
    GUI gui;

    public Bank(GUI gui, PlayerManager playerManager) {
        this.gui = gui;
        this.playerManager = playerManager;
    }

    public int getFieldRentConstant(int index) {
        return FIELD_RENT[index];
    }

    public int getFieldRent(int index) {
        return fieldRent[index];
    }

    public void setFieldRent(int fieldRent, int index) {
        this.fieldRent[index] = fieldRent;
    }

    public void addToFieldRent(int addFieldRent, int index) {
        this.fieldRent[index] = getFieldRentConstant(index) + addFieldRent;
    }

    public int getFieldPrice(int index) {
        return fieldPrice[index];
    }

    public void setFieldPrice(int fieldPrice, int index) {
        this.fieldPrice[index] = fieldPrice;
    }

    // Methods that changes the player balance
    public void changePlayerBalance(int index, int price) {
        int newBalance = playerManager.getPlayerBalance(index) + price;

        // If statement to make sure balance does not reach negative numbers
        if (newBalance <= 0) {
            playerManager.setPlayerBalance(index, 0);
        } else {
            playerManager.setPlayerBalance(index, newBalance);
        }

    }

    // Method to make transactions between players, used to pay rent from a player to the owner of field
    public void makeTransaction(int custumorIndex, int money, int recipientIndex) {
        changePlayerBalance(custumorIndex, -money);
        changePlayerBalance(recipientIndex, money);
    }

    // Checks if a field is owned and returns true or false
    public boolean isFieldOwnable(int playerIndex) {
        int placement = playerManager.getPlayer(playerIndex).getFieldPosition();
        int price = fieldPrice[placement];
        return ownedFields[placement].isEmpty() && fieldPrice[placement] != 0;
    }

    // Can buy field player is standing on if the field has a price and the field is not already owned
    public void buyField(int playerIndex, GUI gui) {
        int placement = playerManager.getPlayer(playerIndex).getFieldPosition();
        int price = fieldPrice[placement];
        if (playerManager.getPlayerBalance(playerIndex) > price) {
            ownedFields[placement] = playerManager.getPlayerName(playerIndex);
            changePlayerBalance(playerIndex, -price);
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

    // When a player first buys a field or lands on a field they own, they get asked whether they would like to buy some houses and hotels to that field
    public void buyHouses(int playerIndex, GUI gui) {
        int placement = playerManager.getPlayer(playerIndex).getFieldPosition();
        int price = FIELD_PRICE[placement] / 4;
        int fieldRentConstant = getFieldRentConstant(placement);
        int balance = playerManager.getPlayerBalance(playerIndex);
        String name = playerManager.getPlayerName(playerIndex);
        GUI_Field field = gui.getFields()[placement];
        if (field instanceof GUI_Street) {
            GUI_Street street = (GUI_Street) field;
            if (ownedFields[placement].equals(name) && housesCount[placement] != 3) {
                String chosenHouseCount = gui.getUserSelection(
                        "Choose the number of houses you want to buy you can have a maximum of 3 and you have: " + housesCount[placement] + " .It will cost: " + price,
                        "0", "1", "2", "3");
                switch (Integer.parseInt(chosenHouseCount)) {
                    case 0:
                        break;
                    case 1:
                        if (housesCount[placement] == 0 || housesCount[placement] == 1 || housesCount[placement] == 2 && price <= balance) {
                            street.setHouses(1 + housesCount[placement]);
                            housesCount[placement] = housesCount[placement] + 1;
                            setFieldRent(fieldRentConstant * (housesCount[placement] + 1), placement);
                            setFieldPrice(price + getFieldPrice(placement), placement);
                            changePlayerBalance(playerIndex, -price);
                            gui.showMessage(name + ", has bought a house for: " + price + " kr.");
                            break;
                        } else {
                            gui.showMessage(name + ", you either have 3 houses already or don´t have the funds to buy a house");
                        }
                    case 2:
                        if (housesCount[placement] == 0 || housesCount[placement] == 1 && (price * 2) <= balance) {
                            street.setHouses(2 + housesCount[placement]);
                            housesCount[placement] = housesCount[placement] + 2;
                            setFieldRent(fieldRentConstant * ((housesCount[placement] + 1) * 4), placement);
                            setFieldPrice(price * 2 + getFieldPrice(placement), placement);
                            changePlayerBalance(playerIndex, -price * 2);
                            gui.showMessage(name + ", has bought 2 houses for: "  + (price * 2) + " kr.");
                            break;
                        } else {
                            gui.showMessage(name + ", you either have at least 2 houses already or don´t have the funds to buy 2 houses ");
                        }
                    case 3:
                        if (housesCount[placement] == 0 && (price * 3) <= balance) {
                            street.setHouses(3);
                            housesCount[placement] = housesCount[placement] + 3;
                            setFieldRent(fieldRentConstant * 8, placement);
                            setFieldPrice(price * 3 + getFieldPrice(placement), placement);
                            changePlayerBalance(playerIndex, -price * 3);
                            gui.showMessage(name + ", has bought 3 houses for: " + (price * 3) + " kr.");
                            break;
                        } else {
                            gui.showMessage(name + ", you either have at least 1 house already or don´t have the funds to buy 3 houses");
                        }
                }
            }
        }
    }

    // To prevent a player from going bankrupt while they still own fields, their fields are automatically sold to ensure the player's balance doesn't go below 0
    public void auctionField(int playerIndex, GUI gui) {
        String name = playerManager.getPlayerName(playerIndex);
        for (int i = 0; i < ownedFields.length && playerManager.getPlayerBalance(playerIndex) == 0; i++) {
            if(ownedFields[i].equals(name)) {
                ownedFields[i] = "";
                int price = fieldPrice[i];
                changePlayerBalance(playerIndex, price/2);
                GUI_Field field = gui.getFields()[i];
                GUI_Ownable ownable = (GUI_Ownable) field;
                GUI_Street street = (GUI_Street) field;
                ownable.setOwnerName(null);
                gui.showMessage(playerManager.getPlayerName(playerIndex) + " had their field force-auctioned to avoid bankruptcy and recieved: " + price/2 + " Kr" + " for the field");
                ownable.setBorder(null, null);
                fieldPrice[i] = FIELD_PRICE[i];
                fieldRent[i] = FIELD_RENT[i];
                street.setHouses(0);
            }
        }
    }

    // Method for player to pay rent for his owned fields
    public void payRent(PlayerManager playerManager, Player player, GUI gui, int sum) {
        int rent = fieldRent[player.getFieldPosition()];
        int custumorIndex = playerManager.getPlayerIndex(player.getGUIPlayer().getName());
        String recipientName = ownedFields[player.getFieldPosition()];
        int recipientIndex = playerManager.getPlayerIndex(recipientName);

        if (player.getFieldPosition() == 4) {
            changePlayerBalance(custumorIndex, -player.getGUIPlayer().getBalance() / 10);
            gui.showMessage(playerManager.getPlayerName(custumorIndex) + " paid 10% of your money in tax");
        } else if (!ownedFields[player.getFieldPosition()].isEmpty() && !ownedFields[player.getFieldPosition()].equals(player.getGUIPlayer().getName()) && (player.getFieldPosition() == 12 || player.getFieldPosition() == 28)) {
            int rentSpecial = sum * 100;
            makeTransaction(custumorIndex, rentSpecial, recipientIndex);
            gui.showMessage(playerManager.getPlayerName(custumorIndex) + " paid a rent of: " + rentSpecial + " kr." + " To player: " + recipientName);
        } else if (player.getFieldPosition() == 38) {
            changePlayerBalance(custumorIndex, -2000);
            gui.showMessage(playerManager.getPlayerName(custumorIndex) + " paid 2000 kr in tax");
        } else if (!ownedFields[player.getFieldPosition()].isEmpty() && !ownedFields[player.getFieldPosition()].equals(player.getGUIPlayer().getName())) {
            makeTransaction(custumorIndex, rent, recipientIndex);
            gui.showMessage(playerManager.getPlayerName(custumorIndex) + " paid a rent of: " + rent + " kr." + " To player: " + recipientName);
        }
    }

    // Amount of money a player recieves when passing start
    public void passStartHandout(int index) {
        changePlayerBalance(index, 3000);
    }
}
