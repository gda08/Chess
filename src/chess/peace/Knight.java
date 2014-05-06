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
public class Knight extends Peace {

    public Knight(int peaceColor, int xPos, int yPos) {
        super(KNIGHT, peaceColor, xPos, yPos);
    }
    
    @Override
    protected boolean isValidMove(BoardPosition newPosition) {
        if (!simpleValidMove(newPosition))
            return false;
        int x = peacePosition.getXpos();
        int y = peacePosition.getYpos();
        int newX = newPosition.getXpos();
        int newY = newPosition.getYpos();
        if (
                ( newX == x+1 && newY == y+2 ) ||
                ( newX == x+2 && newY == y+1 ) ||
                ( newX == x+2 && newY == y-1 ) ||
                ( newX == x+1 && newY == y-2 ) ||
                ( newX == x-1 && newY == y-2 ) ||
                ( newX == x-2 && newY == y-1 ) ||
                ( newX == x-2 && newY == y+1 ) ||
                ( newX == x-1 && newY == y+2 )
                ) {
            return true;
        }
        return false;
    }
    
}
