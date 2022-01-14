package chanceCards;

import gui_main.GUI;
import players.Bank;
import players.Player;
import players.PlayerManager;

abstract class Card {
    protected String cardName;
    protected String cardDescription;
    protected GUI gui;
    protected Bank bank;
    protected Player player;
    protected PlayerManager playerManager;

    public Card(GUI gui, Bank bank, Player player, PlayerManager playerManager, String cardName, String cardDescription) {
        this.gui = gui;
        this.bank = bank;
        this.player = player;
        this.playerManager = playerManager;
        this.cardName = cardName;
        this.cardDescription = cardDescription;
    }
    
    abstract void drawCard(Player player, GUI gui);
}

