package sk.stuba.fei.uim.oop.board;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel {
    private ArrayList<Shape> shapes;
    private ArrayList<Line> lines;
    private Point point;
    private Line line;
    @Setter
    private int shapeId;
    private int counter;
    @Getter
    @Setter
    private int length;
    @Getter
    @Setter
    private int radius;
    @Getter
    @Setter
    private int spacing;

    public Board(){
        this.shapes = new ArrayList<>();
        this.lines = new ArrayList<>();
        this.line = new Line(0,0,0,0);
        this.counter = 0;
        this.point = new Point();
    }

    public void addPoint(Point point) {
        if(this.counter == 0){
            this.point = point;
            this.counter++;
            return;
        }
        this.line = new Line(this.point.x, this.point.y, point.x, point.y);
        this.lines.add(line);
        this.add(line);
        this.shapes.add(this.addShape(this.point.x, this.point.y));

        this.counter = 0;
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(Line l : this.lines){
            l.paintComponent(g);
        }
        this.fixLength(this.length);
        this.drawShapes(g);
    }

    private Shape addShape(int x, int y) {
        switch (this.shapeId){
            case 1:
                return new Circle(x, y, this.radius);
            case 2:
                return new Square(x, y, this.radius);
            case 3:
                //return new Hourglass());
        }
        return null;
    }

    private void drawShapes(Graphics g) {
        if(this.shapes.isEmpty()) return;
        int counter = 0;
        for(Shape s : this.shapes){
            if(counter % this.spacing == 0){
                s.setRadius(this.radius);
                s.paintComponent(g);
            }
            counter++;
        }
        this.shapes.get(this.shapes.size()-1).setRadius(this.radius);
        this.shapes.get(this.shapes.size()-1).paintComponent(g);
    }

    public void changeShapeId() {
        if(this.shapes.isEmpty()) return;
        ArrayList<Shape> newShapes = new ArrayList<>();

        for(Shape s : this.shapes){
            newShapes.add(this.addShape(s.x, s.y));
        }
        this.shapes.clear();
        this.shapes.addAll(newShapes);
        repaint();
    }

    public void fixLength(int length) {
        this.length = length;
        while(this.lines.size() > length){
            this.lines.remove(0);
            this.shapes.remove(0);
        }
        repaint();
    }


}
