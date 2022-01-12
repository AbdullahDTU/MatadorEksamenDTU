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
                //fullStopAction();
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
            3);

    CardTemplate carWash = new CardTemplate(
            "Car Wash",
            "Pay for car wash and lubrication kr. 300",
            4);

    CardTemplate deliveryBox = new CardTemplate(
            "Delivery Box",
            "Pay kr. 200 for delivery of 2 boxes of beer",
            5);

    CardTemplate carRepair = new CardTemplate(
            "Car Repair",
            "Pay kr. 3.000 for repairing the car", // 2 cards
            6);

    CardTemplate newTires = new CardTemplate(
            "New Tires",
            "You have bought 4 new tires for your car, pay kr. 1.000",
            7);

    CardTemplate parkingFine = new CardTemplate(
            "Parking Fine",
            "You have received a parking fine, pay kr. 200 in fines",
            8);

    CardTemplate carInsurance = new CardTemplate(
            "Car Insurance",
            "Pay the car insurance, kr. 1.000",
            9);

    CardTemplate cigaretteTax = new CardTemplate(
            "Cigarette Tax",
            "You have been abroad and bought too many cigarettes, pay kr. 200 in tax",
            10);

    CardTemplate dentalBill = new CardTemplate(
            "Dental Bill",
            "Dental bill, pay kr. 2,000",
            11);

    CardTemplate lottery = new CardTemplate(
            "Lottery",
            "You have won the class lottery. Receive Kr. 500 ", // 2 cards
            12);

    CardTemplate dividend = new CardTemplate(
            "Dividend",
            "You will receive your share dividend. Receive kr. 1.000 from the bank", // 3 cards
            13);

    CardTemplate governmentTax = new CardTemplate(
            "Government Tax",
            "The government has remitted a quarterly tax. Withdraw kr. 3.000 from the bank",
            14);

    CardTemplate jackPot = new CardTemplate(
            "Jackpot",
            "You have a row of eleven jackpot in tipping, receive kr.1000",
            15);

    CardTemplate salary = new CardTemplate(
            "Salary",
            "Due to the expensive time, you have received a salary increase, receive kr. 1.000.",
            16);

    CardTemplate growingBond = new CardTemplate(
            "GrowingBond",
            "Your premium bond is growing. Receive 1000 kr. from the Bank", // 2 cards
            17);

    CardTemplate auction = new CardTemplate(
            "Auction",
            "They have sold some old furniture at auction. Receive kr. 1.000 from the bank",
            18);

    CardTemplate garden = new CardTemplate(
            "Garden",
            "The value of own breeding from the utility garden" +
                    " is now kr. 200 which you receive from the bank",
            19);

    CardTemplate scholarship = new CardTemplate(
            "Scholarship",
            "You receive the Matador scholarship of" +
                    " kr. 40.000, but only if the values do not exceed Kr.15.000",
            20);

    CardTemplate birthday = new CardTemplate(
            "Birthday",
            "Its your Birthday. Receipt of each teammate kr. 200",
            21);

    CardTemplate fellowship = new CardTemplate(
            "Fellowship",
            "You have put money out for a fellowship feast." +
                    "Oddly enough, everyone pays immediately. Receive kr. 500 from each teammate",
            22);

    CardTemplate family_party = new CardTemplate(
            "Family Party",
            "You hold a family party and receive a subsidy from each partner of kr. 500",
            23);

    CardTemplate go_back = new CardTemplate(
            "Go Back",
            "Move to START", // 2 cards
            24);

    CardTemplate move_forward = new CardTemplate(
            "Move Forward",
            "Move three squares forward",
            25);

    CardTemplate move_back = new CardTemplate(
            "Move Back",
            "Move three squares back", // 2 cards
            26);

    CardTemplate frederiksberg_alle = new CardTemplate(
            "Frederiksberg Alle",
            "Move forward to Frederiksberg Alle. If you pas START, you will collect kr. 4000",
            27);

    CardTemplate twice_rent = new CardTemplate(
            "Twice Rent",
            "Move to the nearest shipping company and pay the owner" +
                    " twice the rent he is otherwise entitled to",
            28);

    CardTemplate buy_company = new CardTemplate(
            "Buy Company",
            "If the company is not owned by anyone, you can buy it from the bank", // 2 cards
            29);

    CardTemplate mols_line = new CardTemplate(
            "Mols Line",
            "Take the Mols Line, move the piece forward and if you pass START, collect kr. 4000.",
            30);

    CardTemplate grønningen = new CardTemplate(
            "Grønningen",
            "Move to Grønningen, if you pass the START, collect kr. 4000",
            31);

    CardTemplate vimmelskaftet = new CardTemplate(
            "Vimmelskaftet",
            "Move to Vimmelskaftet, if they pass START, collect kr. 4000",
            32);

    CardTemplate ferry = new CardTemplate(
            "Ferry",
            "Take the nearest ferry, if they pass the start collection then kr. 4.000",
            33);

    CardTemplate strandvejen = new CardTemplate(
            "Strandvejen",
            "Move forward to Strandvejen. If you pass START, you will collect kr 4.000.",
            34);

    CardTemplate town_hall_square = new CardTemplate(
            "Town Hall Square",
            "Go to the Town Hall Square",
            35);

    CardTemplate king_birthday = new CardTemplate(
            "King Birthday",
            "On the occasion of the King's birthday, you are hereby pardoned for imprisonment." +
                    " This card can keep until you need it or you can sell it", // 2 cards
            36);

    CardTemplate jail = new CardTemplate(
            "Jail",
            "Go to jail, you do not collect kr .4.000 to pass the start", // 2 cards
            37);




/*
    //Methods to call the action of the chance cards
    //public void fullStopAction() {
      //  bank.changePlayerBalance(bank.playerManager, index, -1000);
     //}

 */


}
