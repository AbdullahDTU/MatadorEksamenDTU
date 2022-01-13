package chanceCards;

import players.Bank;
import players.Player;
import players.PlayerManager;

public class PlayerMoveCard extends Card {
    private int newPlayerPosition;

    public PlayerMoveCard(Bank bank, String cardName, String cardDescription, PlayerManager playerManager, int newPlayerPosition) {
        super(bank, cardName, cardDescription, playerManager);
        this.newPlayerPosition = newPlayerPosition;
    }

    @Override
    void drawCard(Player player) {
        player.setFieldPosition(newPlayerPosition);
    }
}
