package players;

import gui_fields.GUI_Player;
import mainGame.Setup;
import java.util.logging.Level;

public class Player {

    //Player name, ID, Balance
    private int fieldPosition;
    private GUI_Player GUIPlayer;

    protected Player(int startField, GUI_Player GUIPlayer) {
        this.fieldPosition = startField;
        this.GUIPlayer = GUIPlayer;
    }

    public void setFieldPosition(int addToFieldposition) {
        if(addToFieldposition < 0) {
            return;
        }
        if(addToFieldposition > Setup.MAX_FIELDS) {
            this.fieldPosition = fieldPosition - Setup.MAX_FIELDS;
        }
        this.fieldPosition = addToFieldposition + fieldPosition;
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
