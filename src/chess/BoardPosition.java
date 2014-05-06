/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

/**
 *
 * @author hani
 */
public class BoardPosition {
    
    private int x, y;
    
    public BoardPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getXpos() {
        return x;
    }
    
    public int getYpos() {
        return y;
    }
    
    public void moveTo(int newX, int newY) {
        x = newX;
        y = newY;
    }
    
    public void moveXpos(int newX) {
        x = newX;
    }
    
    public void moveYpos(int newY) {
        y = newY;
    }
    
    public BoardPosition getPosition() {
        return this;
    }
    
    @Override
    public boolean equals(Object o) {
        BoardPosition p = (BoardPosition)o;
        return (p.getXpos()== this.getXpos() 
                && p.getYpos() == this.getYpos());
    }
    
}
