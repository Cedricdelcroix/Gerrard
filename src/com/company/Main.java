package com.company;
import org.sikuli.basics.FileManager;
import org.sikuli.basics.Settings;
import org.sikuli.basics.proxies.Vision;
import org.sikuli.script.*;
import org.sikuli.script.Screen;

import java.io.File;

public class Main {

    public static void main(String[] args) {
	// write your code here
        FileManager.loadLibrary("VisionProxy");
        Vision.setParameter("MinTargetSize",12);
        App.focus("chrome");
        Settings.MoveMouseDelay=0;
        Application application = new Application();
        application.test();

    }

}
