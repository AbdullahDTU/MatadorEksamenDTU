package dice;
import gui_main.GUI;


public class Hand {
        // Create object die1 and die2
        private Die die1;
        private Die die2;
        private int sum;
        private GUI gui;

        // die1 and die2 is given a value
        public Hand(){
                die1 = new Die();
                die2 = new Die();
                sum = 0;
        }

        // Methode for rollDice
        public int rollDice(GUI gui){
                die1.roll();
                die2.roll();
                sum = die1.getFaceValue() + die2.getFaceValue(); //given value for sum (faceValue+faceValue)
                gui.setDice(die1.getFaceValue(),die2.getFaceValue()); //show die1 and die2 on the game board
                System.out.println("Die sum:" + sum);
                return sum;
        }
}

