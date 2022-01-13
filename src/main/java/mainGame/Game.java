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
    int roundsTally = 0;

    Bank bank;

    public Game(GUI gui, PlayerManager pM) {
        this.gui = gui;
        this.pM = pM;
        this.bank = new Bank(gui, pM);
    }


    protected void startGame() {
        //Do loop to constantly run the game while gameHasFinished is false
        do {
            this.playRound();
            roundsTally++;
        } while (!gameHasFinished);
    }

    private boolean playerWishesToRollDice(Player player) {
        //Makes a pressable button called "Roll the dice"
        String choice = gui.getUserButtonPressed(player.getGUIPlayer().getName() + " roll the dice:", "Roll");
        return choice.equals("Roll");
    }

    private void askWetherToBuyField(Player player, GUI gui) {
        //Makes 2 pressable buttons called "Buy" and "Don´t buy"
        String name = player.getGUIPlayer().getName();
        int index = pM.getPlayerIndex(name);
        String choice = gui.getUserButtonPressed(player.getGUIPlayer().getName() + " buy the field?", "Buy", "Don´t buy");
        if (choice.equals("Buy")) {
            bank.buyField(index, gui);
        } else if (choice.equals("Don´t buy")) {
            return;
        }
    }

    private Player compareBalances() {
        Player richestPlayer = this.pM.players[0];
        for (Player player : this.pM.players)
            if (player.getGUIPlayer().getBalance() > richestPlayer.getGUIPlayer().getBalance()) {
                richestPlayer = player;
            }
        return richestPlayer;
    }


    public void playRound() {
        for (Player player : this.pM.players) {
            System.out.println("Rounds nr " + roundsTally);
            boardActions(player);

            if (player.getGUIPlayer().getBalance() == 0) {
                player.setPlayerAlive(false);
            }
            if(roundsTally == 30) {
                Player winningPlayer = compareBalances();
                String name = winningPlayer.getGUIPlayer().getName();
                int balance = winningPlayer.getGUIPlayer().getBalance();
                gui.showMessage(name + " has won the game by being the richest player at the end of the game with a balance of " + balance + " kr!");
                gameHasFinished = true;
                break;
            }
        }
    }

    private Player determineLastSurvivingPlayer() {
        int i;
        int tallyAlive = 0;
        Player playerAlive = null;
        for (i = 0; i == pM.players.length; i++) {
            if (pM.players[i].isPlayerAlive()) {
                tallyAlive++;
                playerAlive = pM.players[i];
            }
        }
        if (tallyAlive == 1) {
            return playerAlive;
        }
        else {
            return null;
        }
    }

    public void boardActions(Player player) {
        if (player.isPlayerAlive()) {

            if (playerWishesToRollDice(player)) {
                String name = player.getGUIPlayer().getName();
                int index = pM.getPlayerIndex(name);
                int roll = hand.rollDice(gui);
                if (roll + player.getFieldPosition() >= Setup.MAX_FIELDS) {
                    bank.passStartHandout(index);
                }
                player.setFieldPosition(roll);
                GUI_Field field = gui.getFields()[player.getFieldPosition()];
                player.getGUIPlayer().getCar().setPosition(field);
                if (bank.isFieldOwnable(index)) {
                    askWetherToBuyField(player, gui);
                }

                bank.payRent(pM, player, gui, roll);
                if (player.getGUIPlayer().getBalance() <= 0) {
                    bank.auctionField(index, gui);
                }
            } else gui.showMessage(player.getGUIPlayer().getName() + " is out of the game"); {
                Player lastSurvivingPlayer = determineLastSurvivingPlayer();
                if (lastSurvivingPlayer != null) {
                    String name = lastSurvivingPlayer.getGUIPlayer().getName();
                    gui.showMessage(name + "has won the game by being the last surviving player");
                }
                }
            }
        }
    }
