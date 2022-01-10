package dice;
import gui_main.GUI;


public class Hand {
        private Die die1;
        private Die die2;
        private int sum;
        private GUI gui;

        public Hand(){
                die1 = new Die();
                die2 = new Die();
                sum = 0;
        }

        public int rollDice(GUI gui){
                die1.roll();
                die2.roll();
                sum = die1.getFaceValue() + die2.getFaceValue();
                gui.setDice(die1.getFaceValue(),die2.getFaceValue());
                System.out.println("Die sum:" + sum);
                return sum;
        }
}

