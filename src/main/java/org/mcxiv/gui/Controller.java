package org.mcxiv.gui;

import org.mcxiv.logic.Bullet;
import org.mcxiv.logic.Holder;
import org.mcxiv.logic.tokens.BulletCoords;

import java.awt.event.*;
import java.util.ArrayList;

public class Controller extends KeyAdapter {

    private Body body;
    private Holder holder = null;

    private boolean isRKeyDown = false;
    private boolean isLKeyDown = false;
    private boolean isSpaceDown = false;

    public Controller() {
        body = new Body();
        body.content.addKeyListener(this);
        body.frame.addKeyListener(this);
        body.content.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                body.player.setSpace(body.content);
            }
        });
        body.content.grabFocus();
        add(new Bullet(100, 100));
    }

    ArrayList<Bullet> list = new ArrayList<>();

    public void Update() {
        if (isRKeyDown) body.player.moveRight();
        if (isLKeyDown) body.player.moveLeft();
        body.player.Update();

        if (isSpaceDown) {
            try {
                body.player.tryToShoot();
            } catch (Bullet.BulletPackage bb) {
                body.content.add(bb.get());
                list.add(bb.get());
            }
        }

        for (int i = 0; i < list.size(); i++) {
            list.get(i).Update();

            if (list.get(i).getY() < 0) {
                body.content.remove(list.get(i));
                Bullet bb = list.remove(i);
                if (holder != null) holder.send(new BulletCoords(bb, body.content));
            } else if (list.get(i).getY() > body.frame.getHeight()) {
                body.content.remove(list.get(i));
                list.remove(i);
            }
        }

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

    public Body getBody() {
        return body;
    }
}
