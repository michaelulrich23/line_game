package sk.stuba.fei.uim.oop.board;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class Line extends JPanel {
    private int x;
    private int y;
    private int endX;
    private int endY;

    public Line(int x, int y, int endX, int endY){
        this.x = x;
        this.y = y;
        this.endX = endX;
        this.endY = endY;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ((Graphics2D) g).setStroke(new BasicStroke(5));
        g.setColor(Color.BLUE);
        g.drawLine(this.x, this.y, this.endX, this.endY);
    }
}
