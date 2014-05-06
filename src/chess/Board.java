/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import chess.peace.Bishop;
import chess.peace.King;
import chess.peace.Knight;
import chess.peace.Pawn;
import chess.peace.Peace;
import chess.peace.Queen;
import chess.peace.Rook;

/**
 *
 * @author hani
 */
public class Board {
    
    private Peace[][] board;
    
    public Board() {
    	board = new Peace[8][8];
    	initBoard();
    }
    
    private void initBoard() {
    	initWhitePeaces();
    	initBlackPeaces();
    }
    
    private void initWhitePeaces() {
    	// Pawns
    	for (int x=0; x<8; x++) {
    		int y = 1;
    		board[x][y] = new Pawn(Peace.WHITE, x, y);
    	}
    	// Rooks
    	board[0][0] = new Rook(Peace.WHITE, 0, 0);
    	board[7][0] = new Rook(Peace.WHITE, 7, 0);
    	
    	//Knights
    	board[1][0] = new Knight(Peace.WHITE, 1, 0);
    	board[6][0] = new Knight(Peace.WHITE, 6, 0);
    	
    	// Bishops
    	board[2][0] = new Bishop(Peace.WHITE, 2, 0);
    	board[5][0] = new Bishop(Peace.WHITE, 5, 0);
    	
    	// The queen
    	board[3][0] = new Queen(Peace.WHITE, 3, 0);
    	
    	// The king
    	board[4][0] = new King(Peace.WHITE, 4, 0);
    	
    }
    
    private void initBlackPeaces() {
    	for (int x=0; x<8; x++) {
    		int y = 6;
    		board[x][y] = new Pawn(Peace.BLACK, x, y);
    	}
    	// Rooks
    	board[0][7] = new Rook(Peace.BLACK, 0, 7);
    	board[7][7] = new Rook(Peace.BLACK, 7, 7);
    	
    	//Knights
    	board[1][7] = new Knight(Peace.BLACK, 1, 7);
    	board[6][7] = new Knight(Peace.BLACK, 6, 7);
    	
    	// Bishops
    	board[2][7] = new Bishop(Peace.BLACK, 2, 7);
    	board[5][7] = new Bishop(Peace.BLACK, 5, 7);
    	
    	// The queen
    	board[3][7] = new Queen(Peace.BLACK, 3, 7);
    	
    	// The king
    	board[4][7] = new King(Peace.BLACK, 4, 7);
    }
    
    public void printBoard() {
    	for (int y=7; y>=0; y--) {
    		for (int x=0; x<8; x++) {
    			Peace p = board[x][y];
    			if (p == null) {
    				System.out.print(" x ");
    			} else {
    				System.out.print(" " + p.getShortPeaceName() + " ");
    			}
    		}
    		System.out.println();
    	}
    }
    
    public void moveAsBlack(int x1, int y1, int x2, int y2) {
    	move(x1, 7-y1, x2, 7-y2);
    }
    
    public void move(int x1, int y1, int x2, int y2) {
    	Peace p1 = board[x1][y1];
    	Peace p2 = board[x2][y2];
    	
    	if (p1==null) {
    		System.out.println("No peace at (" + x1 + "," + y1 + ")");
    		return;
    	}
    	
    	if (p2 != null) {
    		if (p1.isWhitePeace() && p2.isWhitePeace() ||
    				p1.isBlackPeace() && p2.isBlackPeace()) {
    			System.out.println("Cannot kill same color");
    			return;
    		}
    	}
    	
    	// This covers the case when a pawn wants to move diagonally
    	if (p1 instanceof Pawn) {
    		System.out.println("Instance of pawn");
    		if (p2 != null) {
    			if (p1.isWhitePeace() && p2.isBlackPeace()) {
    				if (x1+1==x2 && y1+1==y2)
    					p1 = new Pawn(Peace.WHITE, x1+1, y1);
    				else if (x1-1==x2 && y1+1==y2)
    					p1 = new Pawn(Peace.WHITE, x1-1, y1);
    			} else if(p1.isBlackPeace() && p2.isWhitePeace()) {
    				if (x1+1==x2 && y1-1==y2)
    					p1 = new Pawn(Peace.BLACK, x1+1, y1);
    				else if (x1-1==x2 && y1-1==y2)
    					p1 = new Pawn(Peace.BLACK, x1-1, y1);
    			}
    		}
    	}
    	
    	if (p1 instanceof Bishop || p1 instanceof Queen) {
    		if (!isDiagonalEmpty(x1, y1, x2, y2)) {
    			System.out.println("The " + p1.getPeaceName() + " peace is blocked");
    			return;
    		}
    	}
    	
    	p1.move(new BoardPosition(x2, y2));
    	board[x1][y1] = null;
    	board[p1.getPosition().getXpos()][p1.getPosition().getYpos()] = p1;
    	
    	printBoard();
    }
    
    public boolean isOnDiagonal(int x1, int y1, int x2, int y2) {
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
    
    private boolean isDiagonalEmpty(int x1, int y1, int x2, int y2) {
    	if (x2 > x1) { // right side
    		if (y2 > y1) { // right upper diagonal
    			for (int x=x1+1; x<x2; x++) {
    				y1 += 1;
    				if (board[x][y1] != null)
    					return false;
    			}
    		} else { //right lower diagonal
    			for (int x=x1+1; x<x2; x++) {
    				y1 -= 1;
    				if (board[x][y1] != null)
    					return false;
    			}
    		}
    	} else { // left side
    		if (y2 > y1) { // left upper diagonal
    			for (int x=x1-1; x>x2; x--) {
    				y1 += 1;
    				if (board[x][y1] != null)
    					return false;
    			}
    		} else { //left lower diagonal
    			for (int x=x1-1; x>x2; x--) {
    				y1 -= 1;
    				if (board[x][y1] != null)
    					return false;
    			}
    		}
    	}
    	return true;
    }
    
}
