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

        JSlider lengthSlider = new JSlider(JSlider.VERTICAL, 20, 200, 50);
        lengthSlider.setMinorTickSpacing(10);
        lengthSlider.setMajorTickSpacing(10);
        lengthSlider.setSnapToTicks(true);
        lengthSlider.setPaintTicks(true);
        lengthSlider.setPaintLabels(true);
        lengthSlider.addChangeListener(logic);

        JSlider radiusSlider = new JSlider(JSlider.VERTICAL, 1, 20, 5);
        radiusSlider.setMinorTickSpacing(1);
        radiusSlider.setMajorTickSpacing(1);
        radiusSlider.setSnapToTicks(true);
        radiusSlider.setPaintTicks(true);
        radiusSlider.setPaintLabels(true);
        radiusSlider.addChangeListener(logic);

        JSlider spacingSlider = new JSlider(JSlider.VERTICAL, 1, 20, 5);
        spacingSlider.setMinorTickSpacing(1);
        spacingSlider.setMajorTickSpacing(1);
        spacingSlider.setSnapToTicks(true);
        spacingSlider.setPaintTicks(true);
        spacingSlider.setPaintLabels(true);
        spacingSlider.addChangeListener(logic);

        String shapes[]={"Kruh","Štvorec","Presypacie hodiny"};
        JComboBox shapesCombo = new JComboBox(shapes);

        sideMenu.setLayout(new GridLayout(3, 1));
        labelMenu.setLayout(new GridLayout(1, 3));
        sliderMenu.setLayout(new GridLayout(1, 3));
        labelMenu.add(length);
        labelMenu.add(radius);
        labelMenu.add(spacing);
        sideMenu.add(labelMenu);
        sliderMenu.add(lengthSlider);
        sliderMenu.add(radiusSlider);
        sliderMenu.add(spacingSlider);
        sideMenu.add(sliderMenu);
        sideMenu.add(shapesCombo);
        frame.add(sideMenu, BorderLayout.EAST);

        frame.setVisible(true);
    }
}
