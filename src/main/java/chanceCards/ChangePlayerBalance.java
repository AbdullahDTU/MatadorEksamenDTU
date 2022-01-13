package chanceCards;

import players.Bank;
import players.Player;
import players.PlayerManager;

public class ChangePlayerBalance extends Card {
    private int price;

    // Super constructor to accept attributes from Bank and Card
    public ChangePlayerBalance(Bank bank, String cardName, String cardDescription, PlayerManager playerManager, int price) {
        super(bank, cardName, cardDescription, playerManager);
        this.price = price;
    }

    // Changes player's balance according to the chance card drawn
    @Override
    void drawCard(Player player) {
        String name = player.getGUIPlayer().getName();
        bank.changePlayerBalance(playerManager.getPlayerIndex(name), price);
    }
}
