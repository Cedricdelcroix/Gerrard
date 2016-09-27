package com.company.screeninteract;

import com.company.Application;
import com.company.Player;
import org.sikuli.basics.Settings;
import org.sikuli.script.*;
import org.sikuli.script.Screen;

import java.util.concurrent.TimeUnit;


/**
 * Created by cedric on 02/10/15.
 */
public class MarketScreen {
    public void goToHome(Screen s) throws FindFailed {
       s.click(new Region(509,312,55,15));
    }

    public void goToMarket(Screen s) throws FindFailed {
        s.click(new Region(920,315,72,11));
        s.click(new Region(789,342,72,7));
    }

    public void FillPlayer(Screen s, Player player){
        Pattern p = new Pattern("src/images/saisirnom.png");
        try {
            s.type(p,player.getName());
            TimeUnit.MILLISECONDS.sleep(1000);
            s.click(new Region(562,483,79,21));
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void RemovePlayer(Screen s) {
        Pattern p = new Pattern("src/images/delete.png");
        try {
            if(s.exists(p)!=null) {
                s.click(p);
            }
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }
    }
    public void FillPrice(Screen s, Player player){
        try {
            Region reg = new Region(710,694,60,17);
            s.doubleClick(reg);
            s.click(reg);
            s.paste(String.valueOf(player.getBuyPrice()));
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }
    }
    public void searchPlayer(Screen s, Player player){
        FillPlayer(s, player);
        FillPrice(s, player);
        search(s);
    }
    public void search(Screen s){
        Region region = new Region(687,763,82,14);
        try {
            s.click(region);
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }
    }
    public int nbOfCard(){
        return 5;
    }
    public boolean IsBuyable(){
        return false;
    }
    public boolean isFind() throws FindFailed {
        Screen s = new Screen();
        Region r = s.setRect(735,372,436,248);
        Pattern p = new Pattern("src/images/noresult.png");
        if (r.exists(p)!=null){
            return true;
        }else {
            return false;
        }
    }
    public boolean isBuy(){
        Screen  s = new Screen();
        Pattern p = new Pattern("src/images/listerapide.png");
        if(s.exists(p) != null){
            return true;
        }else {
            return false;
        }
    }
    public boolean isExpire(){
        Screen  s = new Screen();
        Pattern p = new Pattern("src/images/expire.png");
        Pattern p2 = new Pattern("src/images/notaccepted.png");
        if(s.exists(p) != null || s.exists(p2) != null){
            if (s.exists(p2) !=null){
                try {
                    s.click(new Pattern("src/images/oknotfind.png"));
                } catch (FindFailed findFailed) {
                    findFailed.printStackTrace();
                }
            }
            return true;
        }else {
            return false;
        }
    }
    public void clickSearch(){
        Screen s = new Screen();
        Settings.MoveMouseDelay=0;
        Region region = new Region(687,763,82,14);
        try {
            s.click(region);
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }
    }
    public void clickOk(){
        Screen s = new Screen();
        Settings.MoveMouseDelay=0;
        Pattern p = new Pattern("src/images/oknotfind.png");
        try {
            s.click(p);
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }
    }
    public void playerDetail(Screen s){
        Settings.MoveMouseDelay=0;
        Region region = new Region(495,618,40,240);
        try {
            Settings.MoveMouseDelay=0;
            s.click(region);
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }

    }
    public void buyPlayer(Screen s){
        Pattern p = new Pattern("src/images/acheter.png");
        Pattern confirm = new Pattern("src/images/oknotfind.png");
        try {
            Settings.MoveMouseDelay=0;
            s.click(p);
//            Settings.MoveMouseDelay=0;
//            s.click(confirm);
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }
    }
    public void putOnMarcketList(Player player){
        Settings.MoveMouseDelay=0;
        Screen s = new Screen();
        Pattern p = new Pattern("src/images/listerapide.png");
        try {
            s.click(p);
            setStartPrice(player);
            setbuyNow(player);
            setDuration();
            validate();
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }
    }

    public void setStartPrice(Player player) throws FindFailed {
        Screen s = new Screen();
        s.doubleClick(new Region(859, 313, 6, 7));
        s.click(new Region(859, 313, 6, 7));
        s.paste(String.valueOf(player.getSellprice()));
    }
    public void setbuyNow(Player player) throws FindFailed {
        Screen s = new Screen();
        s.doubleClick(new Region(861, 362, 11, 7));
        s.click(new Region(861, 362, 11, 7));
        s.paste(String.valueOf(player.getSellprice()));
    }
    public void setDuration() throws FindFailed {
        Screen s = new Screen();
        s.click(new Region(815, 409, 10, 12));
        s.click(new Region(807, 432, 18, 7));
    }
    public void validate(){
        Screen s = new Screen();
        Pattern p = new Pattern("src/images/okmarket.png");
        try {
            s.click(p);
        }catch (FindFailed findFailed){
            findFailed.printStackTrace();
        }
        }
}
