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
public class Queen extends Peace {

    public Queen(int peaceColor, int xPos, int yPos) {
        super(QUEEN, peaceColor, xPos, yPos);
    }
    
    @Override
    protected boolean isValidMove(BoardPosition newPosition) {
        if (!simpleValidMove(newPosition))
        	return false;
        int x = peacePosition.getXpos();
        int y = peacePosition.getYpos();
        int newX = newPosition.getXpos();
        int newY = newPosition.getYpos();
        if (isOnDiagonal(x, y, newX, newY))
        	return true;
        if (x==newX || y==newY)
            return true;
        return false;
    }
    
}
