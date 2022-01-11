package mainGame;

import dice.Hand;
import gui_fields.GUI_Field;
import gui_main.GUI;
import players.Bank;
import players.Player;
import players.PlayerManager;

import java.util.Arrays;

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

    Bank bank = new Bank(gui, pM);

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

    private void askWetherToBuyField(Player player, GUI gui) {
        //Makes 2 pressable buttons called "Buy" and "Don´t buy"
        String name = player.getGUIPlayer().getName();
        int index = pM.getPlayerIndex(name);
        String choice = gui.getUserButtonPressed("Buy the field?", "Buy", "Don´t buy");
        if (choice.equals("Buy")) {
            bank.buyField(pM, index, gui);
        }
        else if (choice.equals("Don´t buy")) {
            return;
        }
    }


    public void playRound() {
        for (Player player : this.pM.players) {
            goToNewPosition(player);
        }
    }

    public void goToNewPosition(Player player) {
        if (playerWishesToRollDice()) {
            String name = player.getGUIPlayer().getName();
            int index = pM.getPlayerIndex(name);
            int roll = hand.rollDice(gui);
            if (roll + player.getFieldPosition() >= Setup.MAX_FIELDS) {
                bank.passStartHandout(pM, index);
            }
            player.setFieldPosition(roll);
            GUI_Field field = gui.getFields()[player.getFieldPosition()];
            player.getGUIPlayer().getCar().setPosition(field);
            if(bank.isFieldOwnable(pM,index)) {
                askWetherToBuyField(player, gui);
            }
            bank.payRent(pM, player, gui);
        }
    }
}
