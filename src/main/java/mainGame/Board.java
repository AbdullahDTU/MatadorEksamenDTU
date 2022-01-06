package mainGame;


import gui_fields.GUI_Field;

public class Board {
    //Constructing fields of type Street, Chance, Jail and Parking
    // Field Name, Field Subtext, Field Description, Rent.
    private static final GUI_Field field1 = new GUI_Start("START", "Collect kr. 4000", "Collect kr. 4000", new Color(255, 0, 0), Color.WHITE);
    private static final GUI_Field field2 = new GUI_Street("RØDOVREVEJ", "kr. 8.000", "Buy this field kr. 8.000", "Rent kr.50", new Color(140, 43, 5), Color.WHITE);
    private static final GUI_Field field3 = new GUI_Chance("CHANCE", "CHANCE_SUBTEXT ?", "CHANCE_DESCRIPTION", new Color(140, 43, 5), Color.WHITE);
    private static final GUI_Field field4 = new GUI_Street("HVIDOVREVEJ", "kr. 1.200", "Buy this field kr. 1.200" , new Color(255, 220, 38), Color.WHITE);
    private static final GUI_Field field5 = new GUI_Tax("TAX", "LUXURY TAX", "Pay 10% of your Income or pay kr.4000", new Color(0, 197, 255), Color.WHITE);
    private static final GUI_Field field6 = new GUI_Street("SCANDLINES", "kr. 4000" , "Buy this field kr. 2000", "Rent kr.500", new Color(0, 197, 255), Color.WHITE);
    private static final GUI_Field field7 = new GUI_Street("ROSKILDEVEJ", "kr.2000", "Buy this field kr. 2000", "Rent kr. 100", new Color(151, 24, 255), Color.WHITE);
    private static final GUI_Field field8 = new GUI_Chance("CHANCE", "CHANCE_SUBTEXT ?", "CHANCE_DESCRIPTION", new Color(151, 24, 255), Color.WHITE);
    private static final GUI_Field field9 = new GUI_Street("VAlBY LANGGADE", "kr.2000", "Buy this field kr. 2000", "Rent kr. 100", new Color(255, 220, 38), Color.WHITE);
    private static final GUI_Field field10 = new GUI_Street("ALLE GADE", "kr. 2400", "Buy this field kr. 2400", "Rent kr. 150", new Color(255, 184, 0), Color.WHITE);
    private static final GUI_Field field11 = new GUI_Jail("JAIL", "Just Visiting", "JAIL_DESCRIPTION", new Color(125, 125, 125), Color.WHITE)
    private static final GUI_Field field12 = new GUI_Street("FREDERIKSBERG ALLE", "kr. 2.800", "Buy this field kr. 2.800", Rent kr. 200, new Color(255, 184, 0), Color.WHITE);
    private static final GUI_Field field13 = new GUI_Street("SQUASH, kr.3000", "Buy this field kr.3000", "Rent = Die Value", new Color(255, 255, 255), Color.BLACK);
    private static final GUI_Field field14 = new GUI_Street("BÜLOWSVEJ", "kr. 2.800", "Buy this field kr. 2.800", "Rent kr. 200", new Color(255, 0, 47), Color.WHITE);
    private static final GUI_Field field15 = new GUI_Street("GL. KONGEVEJ", "kr. 3.200", "Buy this field kr. 3.200", "Rent kr. 250", new Color(255, 0, 47), Color.WHITE);
    private static final GUI_Field field16 = new GUI_Street("MOLS-LINJEN", "kr 4.000", "Buy this field kr. 4.000", "Rent kr. 500", new Color(255, 220, 38), Color.WHITE);
    private static final GUI_Field field17 = new GUI_Street("BERNSTORFFSVEJ", "kr. 3.600", "Buy this field kr. 3.600", "Rent kr. 300", new Color(234, 234, 2), Color.WHITE);
    private static final GUI_Field field18 = new GUI_Chance("CHANCE, CHANCE_SUBTEXT ?", "CHANCE_DESCRIPTION", new Color(140, 43, 5), Color.WHITE);
    private static final GUI_Field field19 = new GUI_Street("HELLERUPVEJ", "Kr. 3.600", "Buy this field kr. 3.600", "Rent kr. 300", new Color(234, 234, 2), Color.WHITE);
    private static final GUI_Field field20 = new GUI_Street("STRANDVEJEN", "kr 4.000, Buy this field kr. 4.000", "Rent kr. 350", new Color(125, 125, 125), Color.WHITE);
    private static final GUI_Field field21 = new GUI_Street("PARKING", "Free Parking", "Parking_DESCRIPTION", new Color(8, 75, 8), Color.WHITE);
    private static final GUI_Field field22 = new GUI_Street("TRIANGLEN", "Kr. 4.400", "Buy this field kr. 4.400", "Rent kr. 350", new Color(6, 68, 6), Color.WHITE);
    private static final GUI_Field field23 = new GUI_Chance("CHANCE", "CHANCE_SUBTEXT ?", "CHANCE_DESCRIPTION", new Color(140, 43, 5), Color.WHITE);
    private static final GUI_Field field24 = new GUI_Street("ØSTERBROGADE", "Kr. 4.400", "Buy this field kr. 4.400", "Rent kr. 350", new Color(6, 24, 68), Color.WHITE);
    private static final GUI_Field field25 = new GUI_Street("GRØNNINGEN", "Kr. 4.800", "Buy this field kr 4.800", "Rent kr 400.", new Color(6, 18, 68), Color.WHITE);
    private static final GUI_Field field26 = new GUI_Street("SCANDLINES", "Kr. 4.000, Buy this field kr 4.000", "Rent kr 500." , new Color(6, 18, 68), Color.WHITE);
    private static final GUI_Field field27 = new GUI_Street("BREDGADE", "Kr. 5.200, Buy this field kr 5.200", "Rent kr 450". , new Color(6, 18, 68), Color.WHITE);
    private static final GUI_Field field28 = new GUI_Street("KGS. NYTORV", "Kr. 5.200, Buy this field kr 5.200", "Rent kr 450". , new Color(6, 18, 68), Color.WHITE);
    private static final GUI_Field field29 = new GUI_Street("COCACOLA", "Kr. 3.000", "Buy this field kr 3.000", "Rent = DICE VALUE". , new Color(6, 18, 68), Color.WHITE);
    private static final GUI_Field field30 = new GUI_Street("ØSTERGADE", "Kr. 5.600", "Buy this field kr 5.600", "Rent kr 500." , new Color(6, 18, 68), Color.WHITE);
    private static final GUI_Field field31 = new GUI_Jail("JAIL, GO TO JAIL!", "JAIL_DESCRIPTION", new Color(125, 125, 125), Color.WHITE)
    private static final GUI_Field field32 = new GUI_Street("AMAGERTORV", "Kr. 6.000", "Buy this field kr 6.000", "Rent kr 550". , new Color(6, 18, 68), Color.WHITE);
    private static final GUI_Field field33 = new GUI_Street("VIMMELSKAFFET", "Kr. 6.000", "Buy this field kr 6.000", "Rent kr 550". , new Color(6, 18, 68), Color.WHITE);
    private static final GUI_Field field34 = new GUI_Chance("CHANCE", "CHANCE_SUBTEXT ?", "CHANCE_DESCRIPTION", new Color(140, 43, 5), Color.WHITE);
    private static final GUI_Field field35 = new GUI_Street("NYGADE", "Kr. 6.400", "Buy this field kr 6.400", "Rent kr 600". , new Color(6, 18, 68), Color.WHITE);
    private static final GUI_Field field36 = new GUI_Street("SCANDLINES", "Kr. 4.000", "Buy this field kr 4.000", "Rent kr 500." , new Color(6, 18, 68), Color.WHITE);
    private static final GUI_Field field37 = new GUI_Chance("CHANCE", "CHANCE_SUBTEXT ?", "CHANCE_DESCRIPTION", new Color(140, 43, 5), Color.WHITE);
    private static final GUI_Field field38 = new GUI_Street("FREDERIKSBERG GADE", "Kr. 7.000", "Buy this field kr 7.000", "Rent kr 700." , new Color(6, 18, 68), Color.WHITE);
    private static final GUI_Field field39 = new GUI_Tax("TAX", "EXTRA ORDINARY TAX", "Pay Goverment Tax kr.2000" , new Color(0, 197, 255), Color.WHITE);
    private static final GUI_Field field40 = new GUI_Street("RÅDHUSPLADESEN", "Kr. 8.000", "Buy this field kr 8.000", "Rent kr 1000." , new Color(6, 18, 68), Color.WHITE);


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


}
