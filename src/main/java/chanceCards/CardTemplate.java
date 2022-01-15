package chanceCards;

import gui_main.GUI;
import players.Bank;
import players.Player;
import players.PlayerManager;

/**
 *
 *
 *
 */

public class CardTemplate {
    private GUI gui;
    private Bank bank;
    private PlayerManager playerManager;
    private Player player;
    private Card[] cards = new Card[28];

    //Constructor for Chance Cards
    public CardTemplate(GUI gui, Bank bank, Player player, PlayerManager playerManager) {
        this.gui = gui;
        this.bank = bank;
        this.player = player;
        this.playerManager = playerManager;
        // Card that changes player balance
        cards[0] = new ChangePlayerBalanceCard(gui, bank, player, playerManager, "Full Stop", "You have driven over a full stop, pay kr. 1000", -1000);
        cards[1] = new ChangePlayerBalanceCard(gui, bank, player, playerManager, "Garden", "The value of own breeding from the utility garden is now kr. 200 which you receive from the bank", 200);
        cards[2] = new ChangePlayerBalanceCard(gui, bank, player, playerManager, "Car Wash", "Pay for car wash and lubrication kr. 300", -300);
        cards[3] = new ChangePlayerBalanceCard(gui, bank, player, playerManager, "Delivery Box", "Pay kr. 200 for delivery of 2 boxes of beer", -200);
        cards[4] = new ChangePlayerBalanceCard(gui, bank, player, playerManager, "Car Repair", "Pay kr. 3.000 for repairing the car", -3000);
        cards[5] = new ChangePlayerBalanceCard(gui, bank, player, playerManager, "Car Repair", "Pay kr. 3.000 for repairing the car", -3000);
        cards[6] = new ChangePlayerBalanceCard(gui, bank, player, playerManager, "New Tires", "You have bought 4 new tires for your car, pay kr. 1.000", -1000);
        cards[7] = new ChangePlayerBalanceCard(gui, bank, player, playerManager, "Parking Fine", "You have received a parking fine, pay kr. 200 in fines", -200);
        cards[8] = new ChangePlayerBalanceCard(gui, bank, player, playerManager, "Car Insurance", "Pay the car insurance, kr. 1.000", -1000);
        cards[9] = new ChangePlayerBalanceCard(gui, bank, player, playerManager, "Cigarette Tax", "You have been abroad and bought too many cigarettes, pay kr. 200 in tax", -200);
        cards[10] = new ChangePlayerBalanceCard(gui, bank, player, playerManager, "Dental Bill", "Dental bill, pay kr. 2,000", -2000);
        cards[11] = new ChangePlayerBalanceCard(gui, bank, player, playerManager, "Lottery", "You have won the class lottery. Receive Kr. 500", 500);
        cards[12] = new ChangePlayerBalanceCard(gui, bank, player, playerManager, "Lottery", "You have won the class lottery. Receive Kr. 500", 500);
        cards[13] = new ChangePlayerBalanceCard(gui, bank, player, playerManager, "Dividend", "You will receive your share dividend. Receive kr. 1.000 from the bank", 1000);
        cards[14] = new ChangePlayerBalanceCard(gui, bank, player, playerManager, "Dividend", "You will receive your share dividend. Receive kr. 1.000 from the bank", 1000);
        cards[15] = new ChangePlayerBalanceCard(gui, bank, player, playerManager, "Dividend", "You will receive your share dividend. Receive kr. 1.000 from the bank", 1000);
        cards[16] = new ChangePlayerBalanceCard(gui, bank, player, playerManager, "Government Tax", "The government has remitted a quarterly tax. Withdraw kr. 3.000 from the bank", 3000);
        cards[17] = new ChangePlayerBalanceCard(gui, bank, player, playerManager, "Jackpot", "You have a row of eleven jackpot in tipping, receive kr. 1000", 1000);
        cards[18] = new ChangePlayerBalanceCard(gui, bank, player, playerManager, "Salary", "Due to the expensive time, you have received a salary increase, receive kr. 1.000.", 1000);
        cards[19] = new ChangePlayerBalanceCard(gui, bank, player, playerManager, "Growing Bond", "Your premium bond is growing. Receive 1000 kr. from the Bank", 1000);
        cards[20] = new ChangePlayerBalanceCard(gui, bank, player, playerManager, "Auction", "They have sold some old furniture at auction. Receive kr. 1.000 from the bank", 1000);

        // Card that moves player to a specific position
        cards[21] = new PlayerMoveCard(gui, bank, player, playerManager, "Go back", "Move to start", 0);
        cards[22] = new PlayerMoveCard(gui, bank, player, playerManager, "Go back", "Move to start", 0);
        int playerPosition = player.getFieldPosition();
        cards[23] = new PlayerMoveCard(gui, bank, player, playerManager, "Move forward", "Move three squares forward", playerPosition + 3);
        cards[24] = new PlayerMoveCard(gui, bank, player, playerManager, "Move back", "Move three squares back", playerPosition - 3);
        cards[25] = new PlayerMoveCard(gui, bank, player, playerManager, "Move back", "Move three squares back", playerPosition - 3);

        // Card that puts player into jail
        cards[26] = new JailCard(gui, bank, player, playerManager, "Go to Jail", "Go to jail, you do not collect kr .4.000 to pass the start");
        cards[27] = new JailCard(gui, bank, player, playerManager, "Go to Jail", "Go to jail, you do not collect kr .4.000 to pass the start");

    }

    public Card[] getCardList() {

        return cards;
    }

}










