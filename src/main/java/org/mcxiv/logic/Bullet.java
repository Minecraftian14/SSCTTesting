package org.mcxiv.logic;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Bullet extends JLabel {

    int x;
    int y;

    int w;
    int h;
    int f = -6;

    public static ImageIcon icon;

    static {
        BufferedImage im = new BufferedImage(25, 50, 2);
        for (int i = 0; i < im.getWidth(); i++) for (int j = 0; j < im.getHeight(); j++) im.setRGB(i, j, 0);

        Graphics2D gg = im.createGraphics();

        gg.setColor(Color.YELLOW);
        gg.fillOval(0, 5, 25, 40);
        gg.setColor(Color.WHITE);
        gg.fillRect(5, 10, 15, 30);
        gg.setColor(Color.RED);
        gg.fillPolygon(new int[]{12, 5, 12, 20}, new int[]{15, 25, 35, 25}, 4);

        icon = new ImageIcon(im);
    }

    public Bullet() {
        super(icon);
    }

    public Bullet(int x, int y) {
        super(icon);
        setBounds(this.x = x, this.y = y, w = 25, h = 50);
    }

    public void Update() {
        setBounds(x, y = (y + f), w, h);
    }

    public boolean isARetard(int m) {
        return y < 0 || y > m;
    }

    public void setY(int i) {
        y = i;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setF(int i) {
        f = 6;
    }

    @Override
    public String toString() {
        return "Bullet{" +
                "x=" + x +
                ", y=" + y +
                ", w=" + w +
                ", h=" + h +
                ", f=" + f +
                '}';
    }

    public int getF() {
        return f;
    }

    public static class BulletPackage extends Throwable {
        private final Bullet object;

        public BulletPackage(Bullet o) {
            this.object = o;
        }

        public Bullet get() {
            return object;
        }
    }

}
