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

public class ChangePlayerBalanceCard extends Card {
    private int price;

    // Super constructor to accept attributes from Bank and Card
    public ChangePlayerBalanceCard(GUI gui, Bank bank, Player player, PlayerManager playerManager, String cardName, String cardDescription, int price) {
        super(gui, bank, player, playerManager, cardName, cardDescription);
        this.price = price;
    }

    // Changes player's balance according to the chance card drawn
    @Override
    void drawCard(Player player, GUI gui) {
        String name = player.getGUIPlayer().getName();
        bank.changePlayerBalance(playerManager.getPlayerIndex(name), price);
        System.out.println("Price changed with: " + price);
    }
}
