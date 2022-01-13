package chanceCards;

import players.Bank;
import players.Player;
import players.PlayerManager;

public class Deck {
    private Bank bank;
    private PlayerManager playerManager;
    private Player player;

    private int index = 0;

    private int amountOfCards;
    public Card deck[];

    public void createCard(Bank bank, Player player, PlayerManager playerManager) {
        CardTemplate template = new CardTemplate(bank, player, playerManager);
        deck = template.getCardList();
    }

    // Chance field calls this method to draw cards
    public void drawCard(Player player) {
        Card currentCard = deck[index];
        currentCard.drawCard(player);
        index++;
    }

}
