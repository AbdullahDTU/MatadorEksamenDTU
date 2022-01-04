package players;

import gui_fields.GUI_Car;
import gui_fields.GUI_Player;
import mainGame.Setup;

public class PlayerManager {
    //Playercount and Players list

    private int i = 1;
    Player player1;
    Player player2;
    Player player3;
    Player player4;

    public void playersListAdd(Player player) {
        i++;
        switch (i) {
            case 1:
                player1 = player;
                break;
            case 2:
                player2 = player;
                break;
            case 3:
                player3 = player;
                break;
            case 4:
                player4 = player;
                break;
            default:
                System.out.println("More players than 4 or less players than 1 registered, invalid input");
        }
    }

    public Player getPlayer(int index) {
        switch (index) {
            case 1:
                return player1;
            case 2:
                return player2;
            case 3:
                return player3;
            case 4:
                return player4;
            default:
                System.out.println("More players than 4 or less players than 1 registered, invalid input");
                return null;
        }
    }

    public void createPlayer(String name, int balance, GUI_Car car) {
        GUI_Player GUIPlayer = new GUI_Player(name, balance,car);
        Player player = new Player(Setup.START_FIELD,GUIPlayer);
        playersListAdd(player);
    }
}
