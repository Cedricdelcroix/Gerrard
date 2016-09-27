package com.company;
import org.sikuli.basics.FileManager;
import org.sikuli.basics.Settings;
import org.sikuli.script.*;
import org.sikuli.script.Screen;
import org.sikuli.script.Region;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main2(String[] args) {

        Screen s =new Screen();
        try {
            s.click(new Region(50,8,8,8));
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }
        Pattern connectBtn = new Pattern("src/images/connect.png");
        Pattern nextButton = new Pattern("src/images/next.png");
        loop(s,connectBtn,nextButton);

    }
    public static void loop(Screen s,Pattern connectBtn, Pattern nextButton){
        try {
                int i =0;
                Iterator<Match> listRegion =  s.findAll(connectBtn);
                for (;listRegion.hasNext();listRegion.next()) {
                    i++;
                    Match m = listRegion.next();
                    s.click(m);
                    TimeUnit.SECONDS.sleep(2);
                    fillMessage();
                    s.click(new Pattern("src/images/previous.png"));
                    TimeUnit.SECONDS.sleep(2);
                }
            if(s.exists(nextButton) != null) {
                s.click(nextButton);
                TimeUnit.SECONDS.sleep(2);
                loop(s,connectBtn,nextButton);
            }
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void fillMessage(){

    }
    public static void main(String[] args) {
        // write your code here
        //FileManager.loadLibrary("VisionProxy");
        //Vision.setParameter("MinTargetSize",12);
        App.focus("chrome");
        Settings.MoveMouseDelay=0;
        Application application = new Application();
        application.buyRequest();
    }

}
