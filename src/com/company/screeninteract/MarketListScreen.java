package com.company.screeninteract;

import com.company.Application;
import com.company.Player;
import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

/**
 * Created by cedric on 02/10/15.
 */
public class MarketListScreen {

    public void goToMarketList() throws FindFailed {
        App.focus("chrome");
        Application application = new Application();
        application.init();
        Screen s = new Screen();
        Pattern p = new Pattern("src/images/transfert.png");
        s.click(p);
        Pattern d = new Pattern("src/images/listeTransfert.png");
        s.click(d);
    }

}
