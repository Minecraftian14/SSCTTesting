package gui;

import logic.Player;

import javax.swing.*;
import java.awt.*;

public class Body {

    JFrame frame;
    JPanel content;

    Player player;

    public Body() {
        init();

        player = new Player(content);
        content.add(player);
        content.repaint();
    }

    private void init() {
        GridBagLayout lay = new GridBagLayout();
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(lay = new GridBagLayout());

        content = new JPanel(null);
        content.setBackground(Color.BLACK);

        lay.setConstraints(content, new GridBagConstraints(0, 0, 1, 1, 1, 1, 10, 0, new Insets(0, 0, 0, 0), 300, 500));
        frame.add(content);

        frame.pack();
        frame.setVisible(true);
    }
}
