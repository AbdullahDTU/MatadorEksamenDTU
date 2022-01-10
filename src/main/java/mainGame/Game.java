package mainGame;

import dice.Hand;
import gui_fields.GUI_Field;
import gui_main.GUI;
import players.Bank;
import players.Player;
import players.PlayerManager;

public class Game {

    private GUI gui;

    //Creating instance of PlayerManager
    PlayerManager pM;
    Hand hand = new Hand();

    private boolean gameHasFinished = false;

    public Game(GUI gui, PlayerManager pM) {
        this.gui = gui;
        this.pM = pM;
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
            goToNewPosition(player);
        }
    }

    public void goToNewPosition(Player player) {
        if (playerWishesToRollDice()) {
            int roll = hand.rollDice();
            player.setFieldPosition(roll);
            GUI_Field field = gui.getFields()[player.getFieldPosition()];
            player.getGUIPlayer().getCar().setPosition(field);
        }
    }
}
