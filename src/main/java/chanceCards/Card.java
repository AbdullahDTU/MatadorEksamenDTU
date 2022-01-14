package chanceCards;

import players.Bank;
import players.Player;
import players.PlayerManager;

abstract class Card {
    protected String cardName;
    protected String cardDescription;
    protected Bank bank;
    protected Player player;
    protected PlayerManager playerManager;

    public Card(Bank bank, Player player, PlayerManager playerManager, String cardName, String cardDescription) {
        this.bank = bank;
        this.player = player;
        this.playerManager = playerManager;
        this.cardName = cardName;
        this.cardDescription = cardDescription;
    }

    abstract void drawCard(Player player);
}

