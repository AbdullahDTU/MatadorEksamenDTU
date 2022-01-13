package chanceCards;

import players.Bank;
import players.Player;
import players.PlayerManager;

public class ChangePlayerBalanceCard extends Card {
    private int price;

    // Super constructor to accept attributes from Bank and Card
    public ChangePlayerBalanceCard(Bank bank, Player player, PlayerManager playerManager, String cardName, String cardDescription, int price) {
        super(bank, player, playerManager, cardName, cardDescription);
        this.price = price;
    }

    // Changes player's balance according to the chance card drawn
    @Override
    void drawCard(Player player) {
        String name = player.getGUIPlayer().getName();
        bank.changePlayerBalance(playerManager.getPlayerIndex(name), price);
    }
}
