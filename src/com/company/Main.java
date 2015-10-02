package com.company;
import org.sikuli.script.*;
import org.sikuli.script.Screen;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Application application = new Application();
        application.init();
    }

    public static void goToMarket() throws FindFailed {
        Application application = new Application();
        application.init();
      /*  Screen s = new Screen();
        Pattern p = new Pattern("src/images/transfert.png");
        s.click(p);
        Pattern d = new Pattern("src/images/listeTransfert.png");
        s.click(d);
*/
    }
}
