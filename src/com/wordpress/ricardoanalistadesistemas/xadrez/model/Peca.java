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
public interface Peca {

    /**
     *
     * @return
     */
    boolean isBranca();

    /**
     *
     * @return
     */
    boolean isPreta();

    /**
     *
     * @param x
     * @param y
     */
    void movimentar(int x, int y);
    
    /**
     * Valida o movimento de uma peça.
     * Deve ser implementado por subclasses para garantir que a movimentação da peça seja adequada
     * 
     * @param x a fileira para a qual se pretende mover a peça
     * @param y a coluna para a qual se pretende mover a peça
     * @return true se o movimento for válido, do contrário false
     */
    boolean validaMovimento(int x, int y);
}
