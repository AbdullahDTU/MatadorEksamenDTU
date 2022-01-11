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
            "You have driven over a Full Stop, pay kr 1.000",
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
    CardTemplate deliveryBox = new CardTemplate(
            "Delivery Box",
            "Pay kr. 200 for delivery of 2 boxes of beer",
            2);
    CardTemplate carRepair = new CardTemplate(
            "Car Repair",
            "Pay kr. 3.000 for repairing the car",
            2);
    CardTemplate newTires = new CardTemplate(
            "New Tires",
            "You have bought 4 new tires for your car, pay kr. 1.000",
            2);
    CardTemplate parkingFine = new CardTemplate(
            "Parking Fine",
            "You have received a parking fine, pay kr. 200 in fines",
            2);
    CardTemplate carInsurance = new CardTemplate(
            "Car Insurance",
            "Pay the car insurance, kr. 1.000",
            2);
    CardTemplate cigaretteTax = new CardTemplate(
            "Cigarette Tax",
            "You have been abroad and bought too many cigarettes, pay kr. 200 in tax",
            2);
    CardTemplate dentalBill = new CardTemplate(
            "Dental Bill",
            "Dental bill, pay kr. 2,000",
            2);
    CardTemplate lottery = new CardTemplate(
            "Lottery",
            "You have won the class lottery. Receive Kr. 500 ",
            2);
    CardTemplate dividend = new CardTemplate(
            "Dividend",
            "You will receive your share dividend. Receive kr. 1.000 from the bank",
            2);
    CardTemplate governmentTax = new CardTemplate(
            "Government Tax",
            "The government has remitted a quarterly tax. Withdraw kr. 3.000 from the bank",
            2);
    CardTemplate jackPot = new CardTemplate(
            "Jackpot",
            "You have a row of eleven jackpot in tipping, receive kr.1000",
            2);
    CardTemplate salary = new CardTemplate(
            "Salary",
            "Due to the expensive time, you have received a salary increase, receive kr. 1.000.",
            2);



    //Methods to call the action of the chance cards
    public void fullStopAction() {
        bank.changePlayerBalance(bank.playerManager, index, -1000);
    }


}
