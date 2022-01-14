package chanceCards;

import gui_main.GUI;
import players.Bank;
import players.Player;
import players.PlayerManager;

public class Deck {
    private GUI gui;
    private Bank bank;
    private PlayerManager playerManager;
    private Player player;

    public int index = 0;

    private int amountOfCards;
    public Card deck[];

    public Deck(GUI gui, Bank bank, PlayerManager playerManager, Player player) {
        this.gui = gui;
        this.bank = bank;
        this.playerManager = playerManager;
        this.player = player;
    }

    public void createCard(GUI gui, Bank bank, Player player, PlayerManager playerManager) {
        CardTemplate template = new CardTemplate(gui, bank, player, playerManager);
        deck = template.getCardList();
    }

    // Chance field calls this method to draw cards
    public void drawCard(Player player, GUI gui) {
        Card currentCard = deck[index];
        currentCard.drawCard(player, gui);
        System.out.println("Current Card Description: " + currentCard.cardDescription);
        gui.showMessage(currentCard.cardDescription);
        if (index == deck.length) {
            index = 0;
        } else {
            index++;
        }

    }

}
