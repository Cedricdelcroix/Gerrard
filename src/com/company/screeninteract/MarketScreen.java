package com.company.screeninteract;

import com.company.Application;
import com.company.Player;
import org.sikuli.basics.Settings;
import org.sikuli.script.*;
import org.sikuli.script.Screen;
import sun.awt.X11.*;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

/**
 * Created by cedric on 02/10/15.
 */
public class MarketScreen {
    public void goToHome() throws FindFailed {
        Screen s = new Screen();
       s.click(new Region(232,169,15,6));
    }

    public void goToMarket() throws FindFailed {
        Screen s = new Screen();
        Pattern p = new Pattern("src/images/transfert.png");
        s.click(p);
        Pattern d = new Pattern("src/images/marchetransf.png");
        s.click(d);
    }

    public void FillPlayer(Player player){
        Screen s = new Screen();
        Pattern p = new Pattern("src/images/saisirnom.png");
        try {
            s.type(p,player.getName()+Key.ENTER);
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }
    }

    public void RemovePlayer() {
        Screen s = new Screen();
        Pattern p = new Pattern("src/images/delete.png");
        try {
            if(s.exists(p)!=null) {
                s.click(p);
            }
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }
    }
    public void FillPrice(Player player){
        Screen s = new Screen();
        try {
            Region reg = new Region(432,550,6,8);
            s.doubleClick(reg);
            s.click(reg);
            s.paste(String.valueOf(player.getBuyPrice()));
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }
    }
    public void searchPlayer(Player player){
        FillPlayer(player);
        FillPrice(player);
        search();
    }
    public void search(){
        Screen s = new Screen();
        Region region = new Region(420,620,94,15);
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
    public boolean isFind(){
        Screen  s = new Screen();
        Pattern p = new Pattern("src/images/oknotfind.png");
        if (s.exists(p)!=null){
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
        Settings.MoveMouseDelay=0;
        Screen s = new Screen();
        Pattern p = new Pattern("src/images/recherche.png");
        try {
            s.click(p);
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }
    }
    public void clickOk(){
        Settings.MoveMouseDelay=0;
        Screen s = new Screen();
        Pattern p = new Pattern("src/images/oknotfind.png");
        try {
            s.click(p);
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }
    }
    public void playerDetail(Player player){
        Settings.MoveMouseDelay=0;
        Screen s = new Screen();
        Region region = new Region(218,480,104,150);
        Pattern p = new Pattern("src/images/detail.png");
        try {
            Settings.MoveMouseDelay=0;
            s.click(region);
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }

    }
    public void buyPlayer(){
        Screen s = new Screen();
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
