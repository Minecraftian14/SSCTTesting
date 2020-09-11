package gui;

import logic.Bullet;
import logic.Holder;
import main.annotatedLogger.LOG;
import main.generalLogger.LOGGER;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Controller extends KeyAdapter {

    private Body body;

    private boolean isRKeyDown = false;
    private boolean isLKeyDown = false;
    private boolean isSpaceDown = false;

    private Holder holder = null;

    public Controller() {
        body = new Body();
        body.content.addKeyListener(this);
        body.frame.addKeyListener(this);
//        body.frame.requestFocus();
        body.content.grabFocus();
        add(new Bullet(100, 100));
    }

    int cycle = 0;
    ArrayList<Bullet> list = new ArrayList<>();

    public void Update() {
        if (isRKeyDown) body.player.getCoordinates().add(2, 0);
        if (isLKeyDown) body.player.getCoordinates().add(-2, 0);

        if (isSpaceDown && cycle == 0) {
            Bullet bb = new Bullet(body.player.getX() + 50, body.player.getY());
            body.content.add(bb);
            list.add(bb);
            cycle = 50;
        }

        for (int i = 0; i < list.size(); i++) {
            list.get(i).Update();

            if (list.get(i).getY() < 0) {
                body.content.remove(list.get(i));
                Bullet bb = list.remove(i);
                if (holder != null) {
                    holder.send(bb);
                }
            } else if (list.get(i).getY() > body.frame.getHeight()) {
                body.content.remove(list.get(i));
                list.remove(i);
            }

        }

        if (cycle > 0) cycle--;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                isRKeyDown = true;
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                isLKeyDown = true;
                break;
            case KeyEvent.VK_SPACE:
                isSpaceDown = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                isRKeyDown = false;
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                isLKeyDown = false;
                break;
            case KeyEvent.VK_SPACE:
                isSpaceDown = false;
        }
    }

    public void add(Bullet o) {
        list.add(o);
        body.content.add(o);
    }

    public void setSender(Holder h) {
        holder = h;
    }
}
