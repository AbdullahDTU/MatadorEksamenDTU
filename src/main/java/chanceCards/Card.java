package chanceCards;

import players.Bank;
import players.Player;
import players.PlayerManager;

abstract class Card {
    protected String cardName;
    protected String cardDescription;
    protected Bank bank;
    protected PlayerManager playerManager;

    public Card(Bank bank, String cardName, String cardDescription, PlayerManager playerManager) {
        this.bank = bank;
        this.cardName = cardName;
        this.cardDescription = cardDescription;
        this.playerManager = playerManager;
    }

    abstract void drawCard(Player player);
}

