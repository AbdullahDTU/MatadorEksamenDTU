package chanceCards;

import players.Bank;

public class CardTemplate {

    private String chanceName;
    private String chanceDescription;
    private int cardIndex;

    private Bank bank;

    //Constructor for Chance Cards
    public CardTemplate(String chanceName, String chanceDescription, int cardIndex) {
        this.chanceName = chanceName;
        this.chanceDescription = chanceDescription;
        this.cardIndex = cardIndex;
    }

    public void performCardAction() {
        switch (cardIndex) {
            case 1:
                fullStopAction();
                break;
            case 2:
                break;
            default:
        }
    }

    //Constructing Chance cards
    CardTemplate fullStop = new CardTemplate(
            "Full Stop",
            "You have driven over a Full Stop, pay 1000 DKK",
            1);
    CardTemplate oilPrices = new CardTemplate(
            "Oil Prices",
            "Oil prices have risen, and you must pay kr. 500 per house and kr 2.000 per hotel.",
            2);
    CardTemplate propertyTaxes = new CardTemplate(
            "Property Taxes",
            "Property taxes have risen. The extra costs are kr. 800 per house, kr. 2.300 per hotel",
            2);
    CardTemplate carWash = new CardTemplate(
            "Car Wash",
            "Pay for car wash and lubrication kr. 300",
            2);

    //Methods to call the action of the chance cards
    public void fullStopAction() {
        bank.changePlayerBalance(bank.playerManager, index, -1000);
    }


}
