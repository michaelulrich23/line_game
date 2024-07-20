package sk.stuba.fei.uim.oop.controls;

import lombok.Getter;
import sk.stuba.fei.uim.oop.board.Board;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class GameLogic extends UniversalAdapter {
    private JFrame mainGame;
    private Board currentBoard;
    @Getter
    private JSlider lengthSlider;
    @Getter
    private JSlider radiusSlider;
    @Getter
    private JSlider spacingSlider;
    @Getter
    private JComboBox shapesCombo;

    public GameLogic(JFrame mainGame) {
        this.lengthSlider = new JSlider(JSlider.VERTICAL, 20, 200, 50);
        this.lengthSlider.setMinorTickSpacing(10);
        this.lengthSlider.setMajorTickSpacing(10);
        this.lengthSlider.setSnapToTicks(true);
        this.lengthSlider.setPaintTicks(true);
        this.lengthSlider.setPaintLabels(true);
        this.lengthSlider.addChangeListener(this);

        this.radiusSlider = new JSlider(JSlider.VERTICAL, 1, 20, 5);
        this.radiusSlider.setMinorTickSpacing(1);
        this.radiusSlider.setMajorTickSpacing(1);
        this.radiusSlider.setSnapToTicks(true);
        this.radiusSlider.setPaintTicks(true);
        this.radiusSlider.setPaintLabels(true);
        this.radiusSlider.addChangeListener(this);

        this.spacingSlider = new JSlider(JSlider.VERTICAL, 1, 20, 5);
        this.spacingSlider.setMinorTickSpacing(1);
        this.spacingSlider.setMajorTickSpacing(1);
        this.spacingSlider.setSnapToTicks(true);
        this.spacingSlider.setPaintTicks(true);
        this.spacingSlider.setPaintLabels(true);
        this.spacingSlider.addChangeListener(this);

        String[] shapes ={"Circle","Square"}; //,"Hourglass"};
        this.shapesCombo = new JComboBox(shapes);
        this.shapesCombo.addItemListener(this);

        this.mainGame = mainGame;
        this.initializeBoard();
        this.mainGame.add(this.currentBoard);

        this.currentBoard.setLength(this.lengthSlider.getValue());
        this.currentBoard.setRadius(this.radiusSlider.getValue());
        this.currentBoard.setSpacing(this.spacingSlider.getValue());
        this.changeShapeId(this.shapesCombo.getSelectedItem().toString());
    }

    private void initializeBoard() {
        this.currentBoard = new Board();
        this.currentBoard.addMouseMotionListener(this);
    }

    private void changeShapeId(String name){
        if(Objects.equals(name, "Circle")){
            this.currentBoard.setShapeId(1);
        }
        if(Objects.equals(name, "Square")){
            this.currentBoard.setShapeId(2);
        }
        /*if(Objects.equals(name, "Hourglass")){
            this.currentBoard.setShapeId(3);
        }*/
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (e == null) return;
        Component current = this.currentBoard.getComponentAt(e.getX(), e.getY());
        if (!(current instanceof Board)) {
            return;
        }
        ((Board) current).addPoint(e.getPoint());
        this.currentBoard.repaint();
    }

    @Override
    public void stateChanged(ChangeEvent e){
        if (e == null) return;

        if(e.getSource() == this.lengthSlider){
            if (this.currentBoard.getLength() == ((JSlider) e.getSource()).getValue()) return;
            this.currentBoard.fixLength(((JSlider) e.getSource()).getValue());
        }

        if(e.getSource() == this.radiusSlider){
            if (this.currentBoard.getRadius() == ((JSlider) e.getSource()).getValue()) return;
            this.currentBoard.setRadius(((JSlider) e.getSource()).getValue());
        }

        if(e.getSource() == this.spacingSlider){
            if (this.currentBoard.getSpacing() == ((JSlider) e.getSource()).getValue()) return;
            this.currentBoard.setSpacing(((JSlider) e.getSource()).getValue());
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e == null) return;
        if(e.getSource() == this.shapesCombo){
            this.changeShapeId(e.getItem().toString());
            this.currentBoard.changeShapeId();
        }
    }
}
