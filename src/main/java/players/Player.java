package players;

import gui_fields.GUI_Player;
import gui_main.GUI;
import mainGame.Setup;

/**
 *
 *
 *
 */

public class Player {

    // Var for position of player on the field, checking if player is still in the match
    private int fieldPosition;
    private boolean isPlayerAlive = true;

    // Creating instance of GUI
    private GUI gui;

    // Creating object of type GUIPlayer
    private GUI_Player GUIPlayer;


    // Constructor for Player
    protected Player(int startField, GUI_Player GUIPlayer, boolean isPlayerAlive) {
        this.fieldPosition = startField;
        this.GUIPlayer = GUIPlayer;
        this.isPlayerAlive = isPlayerAlive;
    }

    // Method to change and add to the player's current position.
    // Used when rolling the dice and certain chance cards that only moves a player a few squares
    public void addToFieldPosition(int addToFieldposition) {
        if (addToFieldposition < 0) {
            return;
        }
        if (addToFieldposition > Setup.MAX_FIELDS) {
            this.fieldPosition = fieldPosition - Setup.MAX_FIELDS;

        }
        if (addToFieldposition + fieldPosition >= Setup.MAX_FIELDS) {
            this.fieldPosition = fieldPosition - Setup.MAX_FIELDS + addToFieldposition;
        } else {
            this.fieldPosition = addToFieldposition + fieldPosition;
        }
    }

    // Sets the player's position to a certain field. Utilized by many chance cards
    public void setFieldPosition(int fieldPosition) {
        this.fieldPosition = fieldPosition;
    }

    public boolean isPlayerAlive() {
        return isPlayerAlive;
    }

    public void setPlayerAlive(boolean playerAlive) {
        isPlayerAlive = playerAlive;
    }

    public int getFieldPosition() {
        return fieldPosition;
    }

    public GUI_Player getGUIPlayer() {
        return GUIPlayer;
    }

    public void setGUIPlayer(GUI_Player GUIPlayer) {
        this.GUIPlayer = GUIPlayer;
    }

}
