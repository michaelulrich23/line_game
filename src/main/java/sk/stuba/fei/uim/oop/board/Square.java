package sk.stuba.fei.uim.oop.board;

import java.awt.*;

public class Square extends Shape{

    public Square(int x, int y, int radius) {
        super(x, y, radius);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(this.x-radius/2, this.y-radius/2, this.radius, this.radius);
    }
}
