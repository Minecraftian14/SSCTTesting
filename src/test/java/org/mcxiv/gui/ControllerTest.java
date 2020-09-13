package org.mcxiv.gui;

import java.util.Timer;
import java.util.TimerTask;

public class ControllerTest {

    public static void main(String[] args) {

        Controller cc = new Controller();
//        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(cc::Update, 0, 16, TimeUnit.MILLISECONDS);

//        Timer timer = new Timer(10, actionEvent -> cc.Update());
//        timer.start();

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                cc.Update();
            }
        }, 5000, 10);


    }

}