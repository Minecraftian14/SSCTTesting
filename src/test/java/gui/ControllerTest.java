package gui;

import io.netty.util.HashedWheelTimer;
import junit.framework.TestCase;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ControllerTest extends TestCase {

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
        }, 1000, 10);


    }

}