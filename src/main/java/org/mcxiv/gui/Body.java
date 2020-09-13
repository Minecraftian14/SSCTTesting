package org.mcxiv.gui;

import org.mcxiv.logic.Player;

import javax.swing.*;
import java.awt.*;

public class Body {

    JFrame frame;
    GridBagLayout lay;

    JPanel content;

    Player player;

    public Body() {
        init();

        player = new Player(content);
        content.add(player);
        content.repaint();
    }

    private void init() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(lay = new GridBagLayout());

        content = new JPanel(null);
        content.setBackground(Color.BLACK);

//        lay.setConstraints(content, new GridBagConstraints(0, 0, 1, 1, 1, 1, 10, 0, new Insets(0, 0, 0, 0), 1000, 500));
        lay.setConstraints(content, new GridBagConstraints(0, 0, 1, 1, 1, 1, 10, 1, new Insets(0, 0, 0, 0), 1000, 500));

        frame.add(content);

        frame.pack();
        frame.setVisible(true);
    }

    public Component getContent() {
        return content;
    }
}
