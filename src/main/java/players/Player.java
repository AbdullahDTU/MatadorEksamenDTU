package players;

import gui_fields.GUI_Player;
import gui_main.GUI;

import java.util.ArrayList;

public class Player {

    //Player name, ID, Balance
    private int fieldPosition;
    private GUI_Player GUIPlayer;

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

    public void setGUIPlayer(GUI_Player GUIPlayer) {
        this.GUIPlayer = GUIPlayer;
    }

    //Car array with the different cars and colors

}
