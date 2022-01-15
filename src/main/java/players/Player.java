package players;

import gui_fields.GUI_Player;
import gui_main.GUI;
import mainGame.Setup;

import java.util.logging.Level;

import players.Bank;

/**
 *
 *
 *
 */

public class Player {

    //Player name, ID, Balance
    private int fieldPosition;
    private GUI_Player GUIPlayer;
    private GUI gui;
    private boolean isPlayerAlive = true;


    protected Player(int startField, GUI_Player GUIPlayer, boolean isPlayerAlive) {
        this.fieldPosition = startField;
        this.GUIPlayer = GUIPlayer;
        this.isPlayerAlive = isPlayerAlive;
    }

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
