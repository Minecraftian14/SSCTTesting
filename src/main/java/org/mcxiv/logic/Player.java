package org.mcxiv.logic;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends JLabel {

    Coordinates position;
    private static ImageIcon icon = null;
    int cooldown = 0;

    static {
        int w = 100, h = 100, p = 10, d = 30;
        BufferedImage im = new BufferedImage(w, h, 2);
        for (int i = 0; i < im.getWidth(); i++) for (int j = 0; j < im.getHeight(); j++) im.setRGB(i, j, 0);

        Graphics2D gg = im.createGraphics();

        gg.setColor(Color.RED);
        gg.fillOval(d, d, w - 2 * d, h - d);
        gg.setColor(Color.BLUE);
        gg.fillOval(d + p, d + p, w - 2 * (d + p), h - 2 * d);
        gg.setColor(Color.WHITE);
        gg.fillRect((w - p / 2) / 2, 0, p / 2, h);
        gg.fillPolygon(new int[]{0, w / 2, w}, new int[]{h, 3 * h / 4, h}, 3);
        gg.setColor(Color.YELLOW);
        gg.fillPolygon(new int[]{w / 3, w / 2, 2 * w / 3}, new int[]{h, h / 2, h}, 3);
        icon = new ImageIcon(im);
    }

    public Player(JPanel content) {
        super(icon);
        position = new Coordinates();
        setSpace(content);
    }

    public void Update() {
        matchBounds();
        if (cooldown > 0) cooldown--;
    }

    public void setSpace(JPanel content) {
        Rectangle r = content.getBounds();
        position.set(M.avg(r.x, r.width) - 50, r.height - 120, r.x + 20, r.y + 20, r.width - 120, r.height - 20);
        matchBounds();
    }

    private void matchBounds() {
        setBounds(position.getX(), position.getY(), 100, 100);
    }

    public Coordinates getCoordinates() {
        return position;
    }

    public void tryToShoot() throws Bullet.BulletPackage {
        if (cooldown == 0) {
            cooldown = 50;
            throw new Bullet.BulletPackage(new Bullet(getX() + 25, getY()));
        }
    }

    public void moveRight() {
        getCoordinates().add((int) (0.005 * position.getWidth()), 0);
    }

    public void moveLeft() {
        getCoordinates().add((int) (-0.005 * position.getWidth()), 0);
    }
}
