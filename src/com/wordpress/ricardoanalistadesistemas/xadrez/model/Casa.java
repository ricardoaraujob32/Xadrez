/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.ricardoanalistadesistemas.xadrez.model;

/**
 *
 * @author ricardobalduino
 */
public final class Casa {
    
    /**
     *
     */
    private final Coordenada coord;
    /**
     *
     */
    private final int COR;

    /**
     *
     * @param x
     * @param y
     * @param cor
     */
    public Casa(int x, int y, int cor) {
        coord = new Coordenada();
        
        coord.setX(x);
        coord.setY(y);
        COR = cor;
    }

    /**
     *
     * @return
     */
    public int getX(){
        return coord.getX();
    }
    
    /**
     *
     * @return
     */
    public int getY(){
        return coord.getY();
    }
    
    /**
     *
     * @return
     */
    public Coordenada getCoordenada(){
        return coord;
    }
    
    /**
     *
     * @return
     */
    public int getCor() {
        return COR;
    }    
}
