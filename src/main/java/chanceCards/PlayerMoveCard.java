package chanceCards;

import players.Bank;
import players.Player;
import players.PlayerManager;

public class PlayerMoveCard extends Card {
    private int newPlayerPosition;

    public PlayerMoveCard(Bank bank, Player player, PlayerManager playerManager, String cardName, String cardDescription, int newPlayerPosition) {
        super(bank, player, playerManager, cardName, cardDescription);
        this.newPlayerPosition = newPlayerPosition;
    }

    @Override
    void drawCard(Player player) {
        player.setFieldPosition(newPlayerPosition);
    }
}
