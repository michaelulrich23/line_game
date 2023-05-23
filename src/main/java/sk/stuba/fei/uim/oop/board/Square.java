package sk.stuba.fei.uim.oop.board;

import java.awt.*;

public class Square extends Shape{

    public Square(int x, int y, int radius) {
        super(x, y, radius);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(this.x, this.y, this.radius*2, this.radius*2);
    }
}
