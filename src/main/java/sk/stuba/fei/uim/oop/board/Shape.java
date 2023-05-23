package sk.stuba.fei.uim.oop.board;

import javax.swing.*;

public class Shape extends JPanel {
    protected int x;
    protected int y;
    protected int radius;


    public Shape(int x, int y, int radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

}
