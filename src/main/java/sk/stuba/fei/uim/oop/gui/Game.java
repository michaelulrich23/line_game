package sk.stuba.fei.uim.oop.gui;

import sk.stuba.fei.uim.oop.controls.GameLogic;

import javax.swing.*;
import java.awt.*;

public class Game {
    public Game() {
        JFrame frame = new JFrame("Skuska RT");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);
        frame.getContentPane().setBackground(Color.GRAY);
        frame.setResizable(false);
        frame.setFocusable(true);
        frame.requestFocusInWindow();

        GameLogic logic = new GameLogic(frame);
        frame.addKeyListener(logic);

        JPanel sideMenu = new JPanel();
        JPanel labelMenu = new JPanel();
        JPanel sliderMenu = new JPanel();
        sideMenu.setBackground(Color.LIGHT_GRAY);
        labelMenu.setBackground(Color.LIGHT_GRAY);
        sliderMenu.setBackground(Color.LIGHT_GRAY);
        JLabel length = new JLabel("Length");
        JLabel radius = new JLabel("Radius");
        JLabel spacing = new JLabel("Spacing");

        sideMenu.setLayout(new BorderLayout());
        labelMenu.setLayout(new GridLayout(1, 3));
        sliderMenu.setLayout(new GridLayout(1, 3));

        labelMenu.add(length);
        labelMenu.add(radius);
        labelMenu.add(spacing);
        sideMenu.add(labelMenu, BorderLayout.PAGE_START);

        sliderMenu.add(logic.getLengthSlider());
        sliderMenu.add(logic.getRadiusSlider());
        sliderMenu.add(logic.getSpacingSlider());
        sideMenu.add(sliderMenu, BorderLayout.CENTER);

        sideMenu.add(logic.getShapesCombo(), BorderLayout.PAGE_END);

        frame.add(sideMenu, BorderLayout.EAST);

        frame.setVisible(true);
    }
}
