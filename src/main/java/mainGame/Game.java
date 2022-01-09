package mainGame;

import dice.Hand;
import gui_main.GUI;
import players.Player;
import players.PlayerManager;

public class Game {

    private GUI gui;

    //Creating instance of PlayerManager
    PlayerManager pM;

    private boolean gameHasFinished = false;

    public Game(GUI gui) {
        this.gui = gui;
    }

    protected void startGame() {
        //Do loop to constantly run the game while gameHasFinished is false
        do {
            this.playRound();
        } while (!gameHasFinished);
    }

    private boolean playerWishesToRollDice() {
        //Makes a pressable button called "Roll the dice"
        String choice = gui.getUserButtonPressed("Roll the dice:", "Roll");
        return choice.equals("Roll");
    }


    public void playRound() {
        for (Player player : this.pM.players) {

            if (playerWishesToRollDice()) {
                //Roll the Dice
                //Hand.rollDice();
            }


        }

    }

}
