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
public abstract class PecaQuePodeFazerRoque extends PecaComPrimeiroMovimento {    
    
    /**
     * 
     */
    private boolean podeFazerRoque;
    
    /**
     * 
     */
    private boolean fezRoque;

    /**
     * 
     */
    public PecaQuePodeFazerRoque() {
        podeFazerRoque = true;
        fezRoque = false;
    }
    
    /**
     *
     * @return
     */
    protected boolean isPodeFazerRoque(){
        return podeFazerRoque;
    }
    
    /**
     * @param podeFazerRoque the podeFazerRoque to set
     */
    protected void setNaoPodeFazerRoque() {
        podeFazerRoque = false;
    }
    
    /**
     * @return the fezRoque
     */
    protected boolean isFezRoque() {
        return fezRoque;
    }

    /**
     * @param fezRoque the fezRoque to set
     */
    protected void setFezRoque() {
        fezRoque = true;
    }
    
    /**
     *
     */
    public abstract void roque(int x, int y);

    /**
     *
     * @return
     */
    public abstract boolean podeFazerRoque();
}
