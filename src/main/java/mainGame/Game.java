package mainGame;

import players.PlayerManager;

public class Game {

        public void initializeGame () {
            Setup setup = new Setup();
            setup.setupPlayers();
            PlayerManager playerManager = new PlayerManager();
            System.out.println(playerManager.getPlayerName(2));
            System.out.println(playerManager.getPlayerBalance(2));
        }
    }
