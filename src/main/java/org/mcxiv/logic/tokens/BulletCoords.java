package org.mcxiv.logic.tokens;

import org.mcxiv.logic.Bullet;
import org.util.annotations.SendEveryField;

import java.awt.*;

@SendEveryField
public class BulletCoords {
    double factor_x;
    double factor_y;
    double factor_speed;

    public BulletCoords(double factor_x, double factor_y, double factor_speed) {
        this.factor_x = factor_x;
        this.factor_y = factor_y;
        this.factor_speed = factor_speed;
    }

    public BulletCoords(Bullet bullet, Component space) {
        this(bullet.getX() / (double) space.getWidth(), bullet.getY() / (double) space.getHeight(), bullet.getF() / (double) space.getHeight());
    }

    public BulletCoords() {
    }

    public double getFactor_x() {
        return factor_x;
    }

    public double getFactor_y() {
        return factor_y;
    }

    @Override
    public String toString() {
        return "BulletCoords{" +
                "factor_x=" + factor_x +
                ", factor_y=" + factor_y +
                '}';
    }

    public Bullet getBullet(Component content) {
        Bullet bb = new Bullet((int) (factor_x * content.getWidth()), (int) (factor_y * content.getHeight()));
        bb.setF((int) (factor_speed * content.getHeight()));
        return bb;
    }
}
