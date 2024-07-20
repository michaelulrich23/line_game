package sk.stuba.fei.uim.oop.board;

import lombok.Setter;

import javax.swing.*;
import java.awt.*;

public class Shape extends JPanel {
    protected int x;
    protected int y;
    @Setter
    protected int radius;

    public Shape(int x, int y, int radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }

}
