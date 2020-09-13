package org.mcxiv.gui;

import org.mcxiv.logic.Bullet;

public class BodyTest {
    public static void main(String[] args) {
        new Body().content.add(new Bullet(100, 100));
    }
}