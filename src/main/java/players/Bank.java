package players;
import gui_main.GUI;
import players.PlayerManager;


public class Bank {

    String[] ownedFields = {"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
    private int[] fieldPrice = {0,1200,0,1200,0,2000,2000,0,2000,2400,0,2800,3000,2800,3200,4000,3600,0,3600,4000,0,4400,0,4400,4800,4000,5200,5200,3000,5600,0,6000,6000,0,6400,4000,0,7000,0,8000};
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

    // Can buy field player is standing on if the field has a price and the field is not already owned
    public void buyField(int index) {
        int placement = playerManager.getPlayer(index).getFieldPosition();
        int price = fieldPrice[placement];
        if (ownedFields[placement].isEmpty() && fieldPrice[placement] != 0)
            ownedFields[placement] = playerManager.getPlayerName(index);
            changePlayerBalance(playerManager, index, -price);
    }

    public void passStartHandout(PlayerManager playerManager, int index) {
        changePlayerBalance(playerManager,index, 4000);
    }

    public void  sellField(int index) {
        int selectedField;
    }
}
