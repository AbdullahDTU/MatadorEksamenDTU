package chanceCards;

import gui_main.GUI;
import players.Bank;
import players.Player;
import players.PlayerManager;

/**
 * The Deck class creates an array of type Cards, where a card is randomly selected and its action performecd
 * once a player lands on a chance field
 */

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
        // Randomly selects a Chance Cards from the Deck
        index = (int) ((Math.random() * deck.length) + 1);
        Card currentCard = deck[index];

        // Runs the method of the chosen card
        currentCard.drawCard(player, gui);
        gui.showMessage(currentCard.cardDescription);

        // Debugging to see which Card is chosen, Name, Description and index of the card in the cardlist
        System.out.println("Chosen Card: " + currentCard.cardName + " which has index nr: " + index);
        System.out.println("Current Card Description: " + currentCard.cardDescription);
    }

}
