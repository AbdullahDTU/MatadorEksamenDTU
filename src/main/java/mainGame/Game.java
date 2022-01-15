package mainGame;

import chanceCards.Deck;
import dice.Hand;
import gui_fields.GUI_Field;
import gui_main.GUI;
import players.Bank;
import players.Player;
import players.PlayerManager;

/**
 *
 *
 *
 */

public class Game {

    private GUI gui;
    int roundsInJailTally = 0;

    //Creating instance of PlayerManager
    PlayerManager pM;
    Deck deck;
    Hand hand = new Hand();


    private boolean gameHasFinished = false;
    int roundsTally = 0;

    Bank bank;

    public Game(GUI gui, PlayerManager pM, Deck deck) {
        this.gui = gui;
        this.pM = pM;
        this.bank = new Bank(gui, pM);
        this.deck = deck;
    }


    protected void startGame() {
        //Do loop to constantly run the game while gameHasFinished is false
        do {
            this.playRound();
            roundsTally++;
        } while (!gameHasFinished);
    }

    private boolean playerLandedOnJail(Player player) {
        if (player.getFieldPosition() == 30) {
            String name = player.getGUIPlayer().getName();
            gui.showMessage(name + " went to jail for " + Setup.STUCK_IN_JAIL_ROUNDS_MAX + " turns.");
            return true;
        } else {
            return false;
        }
    }

    public void checkForChanceField(GUI gui, Player player, PlayerManager playerManager){
        if (player.getFieldPosition() == 2 || player.getFieldPosition() == 7 || player.getFieldPosition() == 17 || player.getFieldPosition() == 22 || player.getFieldPosition() == 33 || player.getFieldPosition() == 36) {
            //2, 7, 17, 22, 33, 36 (Chance fields in array)
            deck.createCard(gui, bank, player, playerManager); //TODO should maybe be in Setup?

            deck.drawCard(player, gui);
        }
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

    private void getOutOfJail(Player player) {
        player.setFieldPosition(0);
        String name = player.getGUIPlayer().getName();
        GUI_Field field = gui.getFields()[player.getFieldPosition()];
        player.getGUIPlayer().getCar().setPosition(field);
        roundsInJailTally = 0;
        gui.showMessage("The player " + name + ", served his sentence and can begin moving again from Start.");
    }


    public void playRound() {
        for (Player player : this.pM.players) {
            System.out.println("Rounds nr " + roundsTally);
            if (roundsInJailTally == Setup.STUCK_IN_JAIL_ROUNDS_MAX && playerLandedOnJail(player)) {
                getOutOfJail(player);
            }
            withExceptionsRunBoardActions(player);
            if (playerLandedOnJail(player)) {
                roundsInJailTally++;
            }
            checkForChanceField(gui, player, pM);
            if (player.getGUIPlayer().getBalance() == 0) {
                player.setPlayerAlive(false);
            }
            if (roundsTally == Setup.NUMBER_OF_TURNS) {
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
        } else {
            return null;
        }
    }

    public void boardActions(Player player, String name) {
        int index = pM.getPlayerIndex(name);
        int roll = hand.rollDice(gui);
        if (roll + player.getFieldPosition() >= Setup.MAX_FIELDS) {
            bank.passStartHandout(index);
        }
        player.addToFieldPosition(roll);
        GUI_Field field = gui.getFields()[player.getFieldPosition()];
        player.getGUIPlayer().getCar().setPosition(field);
        if (bank.isFieldOwnable(index)) {
            askWetherToBuyField(player, gui);
        }
        bank.buyHouses(index, gui);
        bank.payRent(pM, player, gui, roll);
        if (player.getGUIPlayer().getBalance() <= 0) {
            bank.auctionField(index, gui);
        }
    }

    public void playerIsBankruptActions(Player player) {
        gui.showMessage(player.getGUIPlayer().getName() + " is out of the game");
        {
            Player lastSurvivingPlayer = determineLastSurvivingPlayer();
            if (lastSurvivingPlayer != null) {
                String nameLastPlayer = lastSurvivingPlayer.getGUIPlayer().getName();
                gui.showMessage(nameLastPlayer + "has won the game by being the last surviving player");
            }
        }
    }

    public void withExceptionsRunBoardActions(Player player) {
        String name = player.getGUIPlayer().getName();
        if (player.isPlayerAlive()) {
            if (!playerLandedOnJail(player)) {
                if (playerWishesToRollDice(player)) {
                    boardActions(player, name);
                }
            }
            else {
                gui.showMessage(name + " is in jail. Round skipped");
            }
        }
        else {
            playerIsBankruptActions(player);
        }
    }
}

