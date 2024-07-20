package sk.stuba.fei.uim.oop.board;

import java.awt.*;

public class Circle extends Shape{

    public Circle(int x, int y, int radius) {
        super(x, y, radius);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(this.x-radius/2, this.y-radius/2, this.radius, this.radius);
    }
}
