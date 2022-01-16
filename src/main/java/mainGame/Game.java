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
 */

public class Game {

    // Instances of GUI, pM, Deck and Hand
    private GUI gui;
    PlayerManager pM;
    Deck deck;
    Hand hand = new Hand();
    Bank bank;

    // Array for amount of rounds a player has been in jail
    int[] roundsInJailTally = {0,0,0,0};

    // If game is finished, this is set to true and stops the playRound method from running
    private boolean gameHasFinished = false;
    // Counts the amount of rounds that has passed
    private int roundsTally = 0;

    // Constructor of type Game that takes input from GUI, PlayerManger and Deck
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

    // Checks if player has landed on Jail
    private boolean playerLandedOnJail(Player player) {
        if (player.getFieldPosition() == 30) {
            String name = player.getGUIPlayer().getName();
            int playerIndex = pM.getPlayerIndex(name);
            return true;
        } else {
            return false;
        }
    }

    // Checks if player has landed on a chance field, draws a chance card and then runs the action of that card
    public void checkForChanceField(GUI gui, Player player, PlayerManager playerManager) {
        if (player.getFieldPosition() == 2 || player.getFieldPosition() == 7 || player.getFieldPosition() == 17 || player.getFieldPosition() == 22 || player.getFieldPosition() == 33 || player.getFieldPosition() == 36) {

            deck.createCard(gui, bank, player, playerManager);

            deck.drawCard(player, gui);
        }
    }

    // Adds a clickable button which rolls the dice
    private boolean playerWishesToRollDice(Player player) {
        //Makes a pressable button called "Roll the dice"
        String choice = gui.getUserButtonPressed(player.getGUIPlayer().getName() + " roll the dice:", "Roll");
        return choice.equals("Roll");
    }

    // When a player lands on a field which is not owned, the player is given an option to buy the field or skip it
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

    // When game is finished, this method compares the balance of each player and decides the winner
    private Player compareBalances() {
        Player richestPlayer = this.pM.players[0];
        for (Player player : this.pM.players)
            if (player.getGUIPlayer().getBalance() > richestPlayer.getGUIPlayer().getBalance()) {
                richestPlayer = player;
            }
        return richestPlayer;
    }

    // Checks if player has served their jail sentence and puts them back to the start field
    private void getOutOfJail(Player player) {
        player.setFieldPosition(0);
        String name = player.getGUIPlayer().getName();
        GUI_Field field = gui.getFields()[player.getFieldPosition()];
        player.getGUIPlayer().getCar().setPosition(field);
        int playerIndex = pM.getPlayerIndex(name);
        roundsInJailTally[playerIndex] = 0;
        gui.showMessage("The player " + name + ", served his sentence and can begin moving again from Start.");
    }

    // Method which runs the playable part of the game
    public void playRound() {
        // A for each loop which runs the playRound method using the attributes of each player
        for (Player player : this.pM.players) {
            System.out.println("Rounds nr " + roundsTally);
            String name = player.getGUIPlayer().getName();
            int playerIndex = pM.getPlayerIndex(name);

            // Checks if player has served his jail sentence and breaks him out of jail if conditions are met
            if (roundsInJailTally[playerIndex] == Setup.STUCK_IN_JAIL_ROUNDS_MAX) {
                getOutOfJail(player);
            }

            // If the player's balance is 0, run the auctionField method to sell some of the player's fields to prevent the player from going bankrupt
            if (player.getGUIPlayer().getBalance() == 0) {
                bank.auctionField(pM.getPlayerIndex(name), gui);
            }

            // If player is in Jail, increment the rounds he has been in jail
            withExceptionsRunBoardActions(player);
            if (playerLandedOnJail(player)) {
                roundsInJailTally[playerIndex] = roundsInJailTally[playerIndex] + 1;
            }

            // Checks if player has landed on a Chance Field
            checkForChanceField(gui, player, pM);

            // If amount of Rounds has reached the max amount of turns, declare a winner and end the game
            if (roundsTally == Setup.NUMBER_OF_TURNS) {
                Player winningPlayer = compareBalances();
                String nameWinner = winningPlayer.getGUIPlayer().getName();
                int balance = winningPlayer.getGUIPlayer().getBalance();
                gui.showMessage(nameWinner + " has won the game by being the richest player at the end of the game with a balance of " + balance + " kr!");
                gameHasFinished = true;
                break;
            }
        }
    }

    // Checks and returns which of the players have gone bankrupt
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

    // Method which controls the actions done by the board, such as rolling the dice, moving a player, asking them whether to buy the field, paying rent + and buying houses
    public void boardActions(Player player, String name) {
        int index = pM.getPlayerIndex(name);
        int roll = hand.rollDice(gui);
        // Rolls the dice and checks if player has passed the start position and awards them the Passing Start money
        if (roll + player.getFieldPosition() >= Setup.MAX_FIELDS) {
            bank.passStartHandout(index);
        }

        // Adds the sum of a roll to the player's position and displays the car at the new position
        player.addToFieldPosition(roll);
        GUI_Field field = gui.getFields()[player.getFieldPosition()];
        player.getGUIPlayer().getCar().setPosition(field);

        // Asks the player if they want to buy the non-owned field they have landed on
        if (bank.isFieldOwnable(index)) {
            askWetherToBuyField(player, gui);
        }
        bank.buyHouses(index, gui);
        bank.payRent(pM, player, gui, roll);
    }

    // If a player has gone bankrupt they are removed from the game
    public void playerIsBankruptActions(Player player) {
        // Shows a message of which player has gone bankrup
        gui.showMessage(player.getGUIPlayer().getName() + " is out of the game");
        {
            // If all except one player is remaining, declare that remaining player the winner
            Player lastSurvivingPlayer = determineLastSurvivingPlayer();
            if (lastSurvivingPlayer != null) {
                String nameLastPlayer = lastSurvivingPlayer.getGUIPlayer().getName();
                gui.showMessage(nameLastPlayer + "has won the game by being the last surviving player");
            }
        }
    }

    // Checks if player is still alive and out of jail before running the different board actions
    public void withExceptionsRunBoardActions(Player player) {
        String name = player.getGUIPlayer().getName();
        int playerIndex = pM.getPlayerIndex(name);
        if (player.getGUIPlayer().getBalance() == 0) {
            player.setPlayerAlive(false); }
        if (player.isPlayerAlive()) {
            if (!playerLandedOnJail(player)) {
                if (playerWishesToRollDice(player)) {
                    boardActions(player, name);
                    if(playerLandedOnJail(player)) {
                        gui.showMessage(name + " has landed on jail you will now be stuck here for: " + Setup.STUCK_IN_JAIL_ROUNDS_MAX + " rounds.");
                    }
                }
            }
            else {
                gui.showMessage(name + " Is in jail for: " + (Setup.STUCK_IN_JAIL_ROUNDS_MAX - roundsInJailTally[playerIndex]) + " turns.");
            }
        } else {
            playerIsBankruptActions(player);
        }
    }
}

