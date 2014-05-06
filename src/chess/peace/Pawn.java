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
public class Pawn extends Peace {

    public Pawn(int peaceColor, int initXpos, int initYpos) {
        super(PAWN, peaceColor, initXpos, initYpos);
    }
    
    @Override
    protected boolean isValidMove(BoardPosition newPosition) {
        if (!simpleValidMove(newPosition))
        	return false;
        int x = peacePosition.getXpos();
        int y = peacePosition.getYpos();
        int newX = newPosition.getXpos();
        int newY = newPosition.getYpos();
        if (peaceColor == Peace.WHITE) {
            if ((x == newX && (y+1) == newY) ||
            		(x==newX && y==1 && (y+2) == newY))
            	return true;
        } else {
            if ((x == newX && (y-1) == newY) ||
            		(x==newX && y==6 && (y-2) == newY))
            	return true;
        }
        return false;
    }
    
}
