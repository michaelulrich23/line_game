package sk.stuba.fei.uim.oop.board;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel {
    private ArrayList<Shape> shapes;
    private ArrayList<Line> lines;
    private Point point;
    private int counter;

    public Board(){
        this.shapes = new ArrayList<>();
        this.lines = new ArrayList<>();
        this.counter = 0;
        this.point = new Point();
    }

    public void addPoint(Point point) {
        if(this.counter == 0){
            this.point = point;
            this.counter++;
            return;
        }
        Line line = new Line(this.point.x, this.point.y, point.x, point.y);
        this.lines.add(line);
        this.add(line);

        this.counter = 0;
        this.repaint();
    }
}
