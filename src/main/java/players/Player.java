package players;

import gui_fields.GUI_Player;

import java.util.ArrayList;

public class Player extends PlayerManager {

    //Player name, ID, Balance
    private int fieldPosition;
    private final GUI_Player GUIPlayer;

    protected Player(int startField, GUI_Player GUIPlayer) {
        this.fieldPosition = startField;
        this.GUIPlayer = GUIPlayer;
    }


    public int getFieldPosition() {
        return fieldPosition;
    }
    public GUI_Player getGUIPlayer() {
        return GUIPlayer;
    }

    //Car array with the different cars and colors

}
