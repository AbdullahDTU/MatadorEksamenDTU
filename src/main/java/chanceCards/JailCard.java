package chanceCards;

/**
 *
 *
 *
 */

import gui_fields.GUI_Field;
import gui_main.GUI;
import players.Bank;
import players.Player;
import players.PlayerManager;

public class JailCard extends Card {

    // Super constructor to accept attributes from Bank and Card
    public JailCard(GUI gui, Bank bank, Player player, PlayerManager playerManager, String cardName, String cardDescription) {
        super(gui, bank, player, playerManager, cardName, cardDescription);
    }

    // Sends the player to jail
    @Override
    void drawCard(Player player, GUI gui) {
        player.setFieldPosition(30);
        String name = player.getGUIPlayer().getName();
        GUI_Field field = gui.getFields()[player.getFieldPosition()];
        player.getGUIPlayer().getCar().setPosition(field);
        System.out.println(player.getGUIPlayer().getName() + " went to jail");
    }
}



