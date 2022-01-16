package chanceCards;

import gui_main.GUI;
import players.Bank;
import players.Player;
import players.PlayerManager;

/**
 * Abstract class that serves to create different types of card method actions
 */

abstract class Card {
    protected String cardName;
    protected String cardDescription;
    protected GUI gui;
    protected Bank bank;
    protected Player player;
    protected PlayerManager playerManager;

    // Constuctor to create cards that
    public Card(GUI gui, Bank bank, Player player, PlayerManager playerManager, String cardName, String cardDescription) {
        this.gui = gui;
        this.bank = bank;
        this.player = player;
        this.playerManager = playerManager;
        this.cardName = cardName;
        this.cardDescription = cardDescription;
    }

    // Abstract method that is used to perform the chosen card's action
    abstract void drawCard(Player player, GUI gui);
}

