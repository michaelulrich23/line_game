package sk.stuba.fei.uim.oop.controls;

import lombok.Getter;
import sk.stuba.fei.uim.oop.board.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class GameLogic extends UniversalAdapter {
    private JFrame mainGame;
    private Board currentBoard;

    public GameLogic(JFrame mainGame) {
        this.mainGame = mainGame;
        this.initializeBoard();
        this.mainGame.add(this.currentBoard);
    }

    private void initializeBoard() {
        this.currentBoard = new Board();
        this.currentBoard.addMouseMotionListener(this);
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
}
