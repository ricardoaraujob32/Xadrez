/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author ricardobalduino
 */
public class CoordenadaTeste {

    /**
     *
     */
    private int x;

    /**
     *
     */
    private int y;

    /**
     *
     * @param x
     */
    public void setX(int x){
        this.x = x;
    }
    
    /**
     *
     * @param y
     */
    public void setY(int y){
        this.y = y;
    }
    
    /**
     *
     * @return
     */
    public int getX(){
        return x;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        String s = "";
        
        switch(y){
            case 1: s = "A"; break;
            case 2: s = "B"; break;
            case 3: s = "C"; break;
            case 4: s = "D"; break;
            case 5: s = "E"; break;
            case 6: s = "F"; break;
            case 7: s = "G"; break;
            case 8: s = "H"; break;
        }
        
        return s + x;
    }
    
    
    
}
