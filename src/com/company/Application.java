package com.company;

import com.company.screeninteract.MarketScreen;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by cedric on 02/10/15.
 */
public class Application {
    private ArrayList<Player> playersToBuy;
    private ArrayList<Player> playersSell;
    private ArrayList<Player> playersToBuyRead;
    private ArrayList<Player> playersSellRead;
    private int money;
    int count =0;

//    public void test(){
//        Player player = new Player("Blind",3000,2700,1600);
//        MarketScreen marketListScreen = new MarketScreen();
//        try {
//            marketListScreen.goToHome();
//            marketListScreen.goToMarket();
//            //marketListScreen.RemovePlayer();
//            marketListScreen.searchPlayer(player);
//            //if (!marketListScreen.isFind()) {
//            marketListScreen.playerDetail(player);
//            marketListScreen.buyPlayer();
//
//        }catch (FindFailed findFailed) {
//            findFailed.printStackTrace();
//        }
//        /*catch (InterruptedException e) {
//            e.printStackTrace();
//        }*/
//    }
    public void init(){
        try {
            playersToBuy = new ArrayList<Player>();
//            playersToBuy.add(new Player("Verratti",2000,19000,23000));
//            playersToBuy.add(new Player("Jantschke",1500,1600,2700));
//            playersToBuy.add(new Player("arteta",1500,1000,1400));
//            playersToBuy.add(new Player("EL Kaddouri",600,600,1100));
            //playersToBuy.add(new Player("Verratti",18500,17000,20000));
//            playersToBuy.add(new Player("Debuchy",2500,2500,3100));
//            playersToBuy.add(new Player("Sagna",1600,1600,2500));
           // playersToBuy.add(new Player("Sagna",1600,1600,2500));
           //   playersToBuy.add(new Player("Perin",1100,1300,1600));
          //  playersToBuy.add(new Player("Quaresma",2000,3600,4500));
              playersToBuy.add(new Player("Blind",1400,1400,1400));
//            playersToBuy.add(new Player("Debuchy",2000,2700,4000));

            for(Player player : playersToBuy) {
               buyProcess(player);
            }
        } catch (NullPointerException nullpointer) {
            nullpointer.printStackTrace();
        }
    }
    public void buyRequest(){
        MarketScreen marketListScreen = new MarketScreen();
        try {
            Screen s = new Screen();
            marketListScreen.clickSearch();
            int count =0;
            while (marketListScreen.isFind()) {
                if(count == 22){
                    count = 0;
                    TimeUnit.MINUTES.sleep(1);
                }
                marketListScreen.clickOk();
                TimeUnit.MILLISECONDS.sleep(400);
                marketListScreen.clickSearch();
                TimeUnit.MILLISECONDS.sleep(1000);
                s.click(new Region(497,733,27,15));
                TimeUnit.MILLISECONDS.sleep(400);
                s.click(new Region(1225,490,85,13));
                TimeUnit.MILLISECONDS.sleep(400);
                s.click(new Region(883,589,49,18));
                count++;
            }
            marketListScreen.playerDetail(s);
            //
            //marketListScreen.buyPlayer(s);
            } catch (FindFailed findFailed) {
                findFailed.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    public void buyProcess(Player player){
        MarketScreen marketListScreen = new MarketScreen();
        try {
            Screen s = new Screen();
            marketListScreen.goToHome(s);
            marketListScreen.goToMarket(s);
            marketListScreen.RemovePlayer(s);
            marketListScreen.searchPlayer(s,player);
            int count =0;
            while (marketListScreen.isFind()) {
               if(count == 22){
                   count = 0;
                   TimeUnit.MINUTES.sleep(1);
                }
                marketListScreen.clickOk();
                TimeUnit.MILLISECONDS.sleep(500);
                marketListScreen.clickSearch();
                count++;
            }
            marketListScreen.playerDetail(s);
            //
            marketListScreen.buyPlayer(s);
            //marketListScreen.putOnMarcketList(player);
            //}else {
              //  buyProcess(player);
            //}
        } catch (FindFailed findFailed) {
        findFailed.printStackTrace();
    } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
