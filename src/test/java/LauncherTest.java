import gui.Controller;
import logic.Bullet;
import logic.StrPack;
import main.generalLogger.LOGGER;
import org.ConnectionHandle;
import org.HostManager;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class LauncherTest {

    HostManager manager = null;

    ConnectionHandle connection;
    Controller gameController = null;

    public LauncherTest(boolean host) throws IOException, InterruptedException {

        if (host) {
            manager = new HostManager(1234567890, 2);
            manager.addClientJoinListener(this::clientJoined);
            manager.addObjectReceivedListener(this::serverReceived);
            manager.addOnInitializationListeners(this::serverInitialized);
            manager.start();
        }

        connection = new ConnectionHandle(1234567890);
        connection.addObjectReceivedListener(this::clientReceived);

    }

    private void clientReceived(Object object) {
        LOGGER.general("Client Received", object);

        if (object instanceof StrPack) {
            StrPack pack = (StrPack) object;

            if (pack.getMsg().equals("Hello")) {

                gameController = new Controller();
                gameController.setSender(connection::send);

                new Timer().scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        gameController.Update();
                    }
                }, 1000, 10);
                LOGGER.general("Client Side started");
            }

        } else if (gameController != null && object instanceof Bullet) {
            Bullet bb = (Bullet) object;
            bb.setY(1);
            bb.setF(6);
            gameController.add(bb);
        }
    }

    private void clientJoined(ConnectionHandle handle) {
        LOGGER.general("Client Joined", handle);
    }

    private void serverReceived(Object object, ConnectionHandle sender) {
        LOGGER.info("server received: ", object);

        if (object instanceof Bullet) manager.send(object, handle -> !handle.equals(sender));
    }

    private void serverInitialized() {
        manager.send(new StrPack("Hello"));
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        new LauncherTest(true);
        new LauncherTest(false);
    }

}