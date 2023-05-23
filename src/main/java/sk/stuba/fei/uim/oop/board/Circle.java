package sk.stuba.fei.uim.oop.board;

import java.awt.*;

public class Circle extends Shape{

    public Circle(int x, int y, int radius) {
        super(x, y, radius);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillOval(this.x, this.y, this.radius, this.radius);
    }
}
