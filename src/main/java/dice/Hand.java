package dice;

public class Hand {
        private Die die1;
        private Die die2;
        private int sum;

        public Hand(){
                die1 = new Die();
                die2 = new Die();
                sum = 0;
        }

        public int rollDice(){
                die1.roll();
                die2.roll();
                sum = die1.getFaceValue() + die2.getFaceValue();
                System.out.println("Die sum:" + sum);
                return sum;
        }
}

