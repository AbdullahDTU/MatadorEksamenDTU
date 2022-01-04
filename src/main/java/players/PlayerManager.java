package players;

import gui_fields.GUI_Car;
import gui_fields.GUI_Player;
import mainGame.Setup;

public class PlayerManager {
    //Playercount and Players list

    int i = 1;
    public void playersArrayList(Player player) {
        i++;
        switch (i) {
            case 1:
                Player player1 = player;
                break;
            case 2:
                Player player2 = player;
                break;
            case 3:
                Player player3 = player;
                break;
            case 4:
                Player player4 = player;
                break;
            default:
                System.out.println("More players than 4 or less players than 1 registered, invalid input");
        }
    }

    public void createPlayer(String name, int balance, GUI_Car car) {
        GUI_Player GUIPlayer = new GUI_Player(name, balance,car);
        Player player = new Player(Setup.START_FIELD,GUIPlayer);
        playersArrayList(player);
    }
}
