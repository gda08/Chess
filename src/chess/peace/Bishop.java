/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.peace;

import chess.BoardPosition;

/**
 *
 * @author hani
 */
public class Bishop extends Peace {

    public Bishop(int peaceColor, int xPos, int yPos) {
        super(BISHOP, peaceColor, xPos, yPos);
    }
    
    @Override
    protected boolean isValidMove(BoardPosition newPosition) {
        if (!simpleValidMove(newPosition))
            return false;
        int x = peacePosition.getXpos();
        int y = peacePosition.getYpos();
        int newX = newPosition.getXpos();
        int newY = newPosition.getYpos();
        return isOnDiagonal(x, y, newX, newY);
    }
    
}
