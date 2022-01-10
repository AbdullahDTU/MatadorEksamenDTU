package mainGame;


import gui_fields.*;
import gui_resources.Attrs;

import java.awt.*;

public class Board {
    //Constructing fields of type Street, Chance, Jail and Parking
    // Field Name, Field Subtext, Field Description, Rent.
    private static final GUI_Field field1 = new GUI_Start("START", "Collect kr. 4.000", "Collect kr. 4000 everytime you pass START", new Color(255, 0, 0), Color.BLACK);
    private static final GUI_Field field2 = new GUI_Street("Rødovrevej", "kr. 1.200", "Buy this field", "Rent kr.50", new Color(11, 47, 140), Color.BLACK);
    private static final GUI_Field field3 = new GUI_Chance("?", "CHANCE", "CHANCE_DESCRIPTION", new Color(0, 0, 0), Color.GREEN);
    private static final GUI_Field field4 = new GUI_Street("Hvidovrevej", "kr. 1.200", "Buy this field", "Rent kr. 50", new Color(11, 47, 140), Color.BLACK);
    private static final GUI_Field field5 = new GUI_Tax("Tax", "Luxury Tax", "Pay 10% of your Income or pay kr.4000", new Color(0, 197, 255), Color.BLACK);
    private static final GUI_Field field6 = new GUI_Shipping("default","Scandlines", "kr. 4.000", "Buy this field", "Rent kr.500", new Color(11, 47, 140), Color.BLACK);
    private static final GUI_Field field7 = new GUI_Street("Roskildevej", "kr.2.000", "Buy this field", "Rent kr. 100", new Color(255, 68, 0), Color.BLACK);
    private static final GUI_Field field8 = new GUI_Chance("?", "CHANCE", "CHANCE_DESCRIPTION", new Color(0, 0, 0), Color.GREEN);
    private static final GUI_Field field9 = new GUI_Street("Valby Langgade", "kr.2.000", "Buy this field", "Rent kr. 100", new Color(255, 68, 0), Color.BLACK);
    private static final GUI_Field field10 = new GUI_Street("Alle Gade", "kr. 2.400", "Buy this field", "Rent kr. 150", new Color(255, 68, 0), Color.BLACK);
    private static final GUI_Field field11 = new GUI_Jail("default", "Jail", "Just Visiting", "JAIL_DESCRIPTION", new Color(0, 0, 0), Color.WHITE);
    private static final GUI_Field field12 = new GUI_Street("Frederiksberg Alle", "kr. 2.800", "Buy this field", "Rent kr. 200", new Color(255, 184, 0), Color.BLACK);
    private static final GUI_Field field13 = new GUI_Brewery("default","Tuborg", "kr.3.000", "Buy this field", "(Rent == Die Value)", new Color(255, 0, 0), Color.BLACK);
    private static final GUI_Field field14 = new GUI_Street("Bülowsvej", "kr. 2.800", "Buy this field", "Rent kr. 200", new Color(255, 184, 0), Color.BLACK);
    private static final GUI_Field field15 = new GUI_Street("Gl. kongevej", "kr. 3.200", "Buy this field", "Rent kr. 250", new Color(255, 184, 0), Color.BLACK);
    private static final GUI_Field field16 = new GUI_Shipping("default","Mols-linjen", "kr 4.000", "Buy this field", "Rent kr. 500", new Color(255, 0, 0), Color.BLUE);
    private static final GUI_Field field17 = new GUI_Street("Bernstotffsvej", "kr. 3.600", "Buy this field", "Rent kr. 300", new Color(164, 158, 158), Color.BLACK);
    private static final GUI_Field field18 = new GUI_Chance("?", "CHANCE", "CHANCE_DESCRIPTION", new Color(0, 0, 0), Color.GREEN);
    private static final GUI_Field field19 = new GUI_Street("Hellerupvej", "Kr. 3.600", "Buy this field", "Rent kr. 300", new Color(164, 158, 158), Color.BLACK);
    private static final GUI_Field field20 = new GUI_Street("Strandvejen", "kr 4.000", "Buy this field", "Rent kr. 350", new Color(164, 158, 158), Color.BLACK);
    private static final GUI_Field field21 = new GUI_Refuge("default","Parking", "Free Parking", "Parking_DESCRIPTION", new Color(0, 197, 255), Color.BLACK);
    private static final GUI_Field field22 = new GUI_Street("Trianglen", "Kr. 4.400", "Buy this field", "Rent kr. 350", new Color(255, 0, 0), Color.BLACK);
    private static final GUI_Field field23 = new GUI_Chance("?", "CHANCE", "CHANCE_DESCRIPTION", new Color(0, 0, 0), Color.GREEN);
    private static final GUI_Field field24 = new GUI_Street("Østerbrogade", "Kr. 4.400", "Buy this field", "Rent kr. 350", new Color(255, 0, 0), Color.BLACK);
    private static final GUI_Field field25 = new GUI_Street("Grønningen", "Kr. 4.800", "Buy this field", "Rent kr 400.", new Color(255, 0, 0), Color.BLACK);
    private static final GUI_Field field26 = new GUI_Shipping("default","Scandlines", "Kr. 4.000", "Buy this field", "Rent kr 500.", new Color(11, 47, 140), Color.BLACK);
    private static final GUI_Field field27 = new GUI_Street("Bredgade", "Kr. 5.200", "Buy this field", "Rent kr 450", new Color(255, 255, 255), Color.BLACK);
    private static final GUI_Field field28 = new GUI_Street("Kgs. Nytorv", "Kr. 5.200", "Buy this field", "Rent kr 450", new Color(255, 255, 255), Color.BLACK);
    private static final GUI_Field field29 = new GUI_Brewery("default","Carlsberg", "Kr. 3.000", "Buy this field", "Rent = DICE VALUE", new Color(255, 0, 0), Color.BLACK);
    private static final GUI_Field field30 = new GUI_Street("Østergade", "Kr. 5.600", "Buy this field", "Rent kr 500.", new Color(255, 255, 255), Color.BLACK);
    private static final GUI_Field field31 = new GUI_Jail("default", "Jail", "Go to Jail!", "JAIL_DESCRIPTION", new Color(0, 0, 0), Color.WHITE);
    private static final GUI_Field field32 = new GUI_Street("Amagertorv", "Kr. 6.000", "Buy this field", "Rent kr 550", new Color(255, 184, 0), Color.BLACK);
    private static final GUI_Field field33 = new GUI_Street("Vimmelskaffet", "Kr. 6.000", "Buy this field", "Rent kr 550", new Color(255, 184, 0), Color.BLACK);
    private static final GUI_Field field34 = new GUI_Chance("?", "CHANCE", "CHANCE_DESCRIPTION", new Color(0, 0, 0), Color.GREEN);
    private static final GUI_Field field35 = new GUI_Street("Nygade", "Kr. 6.400", "Buy this field", "Rent kr 600", new Color(255, 184, 0), Color.BLACK);
    private static final GUI_Field field36 = new GUI_Shipping("default","Scandlines", "Kr. 4.000", "Buy this field", "Rent kr 500.", new Color(11, 47, 140), Color.BLACK);
    private static final GUI_Field field37 = new GUI_Chance("?", "CHANCE", "CHANCE_DESCRIPTION", new Color(0, 0, 0), Color.GREEN);
    private static final GUI_Field field38 = new GUI_Street("Frederiksberggade", "Kr. 7.000", "Buy this field", "Rent kr 700.", new Color(61, 29, 77), Color.BLACK);
    private static final GUI_Field field39 = new GUI_Tax("Tax", "Extra ordinary tax", "Pay Goverment Tax kr.2000", new Color(0, 197, 255), Color.BLACK);
    private static final GUI_Field field40 = new GUI_Street("Rådhuspladsen", "Kr. 8.000", "Buy this field", "Rent kr 1000.", new Color(61, 29, 77), Color.BLACK);


    //GUI Field Array. The fields are shown in the order they are added in
    private static GUI_Field[] fields = new GUI_Field[]{
            field1,
            field2,
            field3,
            field4,
            field5,
            field6,
            field7,
            field8,
            field9,
            field10,
            field11,
            field12,
            field13,
            field14,
            field15,
            field16,
            field17,
            field18,
            field19,
            field20,
            field21,
            field22,
            field23,
            field24,
            field25,
            field26,
            field27,
            field28,
            field29,
            field30,
            field31,
            field32,
            field33,
            field34,
            field35,
            field36,
            field37,
            field38,
            field39,
            field40,

    };

    public static GUI_Field[] getFields() {
        return fields;
    }
}
