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
public abstract class Peace {
    
    public static final int PAWN = 0;
    public static final int KNIGHT = 1;
    public static final int BISHOP = 2;
    public static final int ROOK = 3;
    public static final int QUEEN = 4;
    public static final int KING = 5;
    
    public static final int WHITE = 10;
    public static final int BLACK = 20;
    
    private int peaceType;
    protected int peaceColor;
    protected BoardPosition peacePosition;
    
    public Peace(int peaceType, int peaceColor, int xPos, int yPos) {
        this.peaceType = peaceType;
        this.peaceColor = peaceColor;
        peacePosition = new BoardPosition(xPos, yPos);
    }
    
    public BoardPosition getPosition() {
        return peacePosition;
    }
    
    public int getPeaceType() {
        return peaceType;
    }
    
    public int getPeaceColor() {
        return peaceColor;
    }
    
    public boolean isWhitePeace() {
    	return peaceColor==WHITE;
    }
    
    public boolean isBlackPeace() {
    	return !isWhitePeace();
    }
    
    public void move(BoardPosition newPosition) {
        if (isValidMove(newPosition)) {
            this.peacePosition = new BoardPosition(newPosition.getXpos(), newPosition.getYpos());
            System.out.println(getPeaceName() + ": move OK");
        } else {
            System.out.println(getPeaceName() + ": Invalid move from " + 
                    "(" + peacePosition.getXpos()+","+peacePosition.getYpos()+") to " +
                    "(" + newPosition.getXpos()+","+newPosition.getYpos()+")");
        }
    }
    
    protected boolean simpleValidMove(BoardPosition newPosition) {
        if (this.peacePosition.equals(newPosition))
        	return false;
        int x = peacePosition.getXpos();
        int y = peacePosition.getYpos();
        int newX = newPosition.getXpos();
        int newY = newPosition.getYpos();
        if (x>7 || x<0 || y>7 || y<0)
            return false;
        if (newX>7 || newX<0 || newY>7 || newY<0)
            return false;
        return true;
    }
    
    public String getPeaceName() {
        switch(peaceType) {
            case PAWN:
                return "PAWN";
            case KNIGHT:
                return "KNIGHT";
            case BISHOP:
                return "BISHOP";
            case ROOK:
                return "ROOK";
            case QUEEN:
                return "QUEEN";
            case KING:
                return "KING";
        }
        return "UNKNOWN PEACE";
    }
    
    public String getShortPeaceName() {
        switch(peaceType) {
            case PAWN:
                return "P";
            case KNIGHT:
                return "N";
            case BISHOP:
                return "B";
            case ROOK:
                return "R";
            case QUEEN:
                return "Q";
            case KING:
                return "K";
        }
        return "UNKNOWN PEACE";
    }
    
    protected boolean isOnDiagonal(int x1, int y1, int x2, int y2) {
        for (int i=0; i<8; i++) {
            if (x1==x2+i && y1==y2+i)
                return true;
        }
        for (int i=0; i<8; i++) {
            if (x1==x2-i && y1==y2-i)
                return true;
        }
        for (int i=0; i<8; i++) {
            if (x1==x2+i && y1==y2-i)
                return true;
        }
        for (int i=0; i<8; i++) {
            if (x1==x2-i && y1==y2+i)
                return true;
        }
        return false;
    }
    
    protected abstract boolean isValidMove(BoardPosition newPosition);
    
}
