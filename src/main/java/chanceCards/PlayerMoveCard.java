package chanceCards;

import gui_fields.GUI_Field;
import gui_main.GUI;
import players.Bank;
import players.Player;
import players.PlayerManager;

/**
 *
 *
 *
 */

public class PlayerMoveCard extends Card {
    private int newPlayerPosition;

    public PlayerMoveCard(GUI gui, Bank bank, Player player, PlayerManager playerManager, String cardName, String cardDescription, int newPlayerPosition) {
        super(gui, bank, player, playerManager, cardName, cardDescription);
        this.newPlayerPosition = newPlayerPosition;
    }

    // Moves amount of squares or to a specific position that is decided by the drawn chance card
    @Override
    void drawCard(Player player, GUI gui) {
        player.setFieldPosition(newPlayerPosition);
        String name = player.getGUIPlayer().getName();
        GUI_Field field = gui.getFields()[player.getFieldPosition()];
        player.getGUIPlayer().getCar().setPosition(field);
        System.out.println("Position moved to: " + newPlayerPosition);
    }
}
