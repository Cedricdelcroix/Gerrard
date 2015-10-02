package com.company;

import java.util.ArrayList;

/**
 * Created by cedric on 02/10/15.
 */
public class Application {
    private ArrayList<Player> playersToBuy;
    private ArrayList<Player> playersSell;
    private ArrayList<Player> playersToBuyRead;
    private ArrayList<Player> playersSellRead;
    private int money;
    private DataFrame dataFrame;
    public void init(){
        dataFrame = new DataFrame();
        money=10000;
        playersToBuy=new ArrayList<Player>();
        playersSell=new ArrayList<Player>();
        playersToBuyRead=new ArrayList<Player>();
        playersSellRead=new ArrayList<Player>();

        playersToBuy.add(new Player("Messi",1030,1050,1500));
        playersToBuy.add(new Player("Ronaldo",1031,1051,1501));
        playersToBuy.add(new Player("Gourcuff",1032,1052,1502));
        playersToBuy.add(new Player("Grenier",1033,1053,1503));

        playersSell.add(new Player("Gerard",2000,2001,2002));
        playersSell.add(new Player("Ozil",2010,2020,2030));
        playersSell.add(new Player("Lampard",2100,2200,2300));
        dataFrame.writeFile(money,playersToBuy,playersSell);
        dataFrame.readFile();

        playersToBuyRead.addAll(dataFrame.getPlayersToBuy());
        playersSellRead.addAll(dataFrame.getPlayerSell());
        String j = "";
    }

}
