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
public class Peao extends PecaComPrimeiroMovimento {
    
    /**
     * 
     */
    private boolean andouDuasCasas;
    
    private int deslocamento;

    /**
     *
     * @param x
     * @param y
     * @param id_jogador
     */
    public Peao()
    {
        andouDuasCasas = false;
    }

    /**
     *
     */
    public void setAndouDuasCasas(){
        this.andouDuasCasas = true;
    }
    
    /**
     *
     * @return
     */
    public boolean andouDuasCasas(){
        return andouDuasCasas;
    }

    @Override
    public void movimentar(int x, int y) {
        if ( validaMovimento(x, y) ) {
            super.movimentar(x, y);

            if ( isPrimeiroMovimento() ) {
                setNaoEhPrimeiroMovimento();

                if ( deslocamento == 2 || deslocamento == -2) {
                    setAndouDuasCasas();
                }
            }
        }
    }

    public boolean validaCaptura(int destX, int destY) 
    {
       if ( !t.validaLimites(destX, destY) || tentouMovimentarParaTras(destX) ){
           return false;
       }
       
       int deslocX = calculaDeslocamento(destX, "x");
       int deslocY = calculaDeslocamento(destY, "y");
              
       return validaDeslocamento(deslocX) && validaDeslocamento(deslocY);
    }
    
    public void capturar(int x, int y){
        if ( validaCaptura(x, y) ){
            coord.setX(x);
            coord.setY(y);
            
            if ( isPrimeiroMovimento() ){
                setNaoEhPrimeiroMovimento();
            }
        }
    }

    /**
     *
     * @param destX
     * @param destY
     * @return
     */
    @Override
    public boolean validaMovimento(int destX, int destY) {
        int deslocY = calculaDeslocamento(destY, "y");
        boolean mudouDeColuna = deslocY != 0;

        if ( !t.validaLimites(destX, destY) || mudouDeColuna || tentouMovimentarParaTras(destX) ) {
            return false;
        }

        int deslocX = calculaDeslocamento(destX, "x");

        if (!validaDeslocamento(deslocX)) {
            return false;
        }

        deslocamento = deslocX;

        return true;
    }
    
    /**
     * se o peão tentar se movimentar para trás
     * @param x
     * @return 
     */
    private boolean tentouMovimentarParaTras(int x){
        boolean valida;
        
        if ( isBranca() ){
            valida = x < coord.getX();
        } else {
            valida = x > coord.getX();
        }
        
        return valida;
    }
    
    private int calculaDeslocamento(int n, String dir){
        return "x".equals(dir) ? n - coord.getX() : 
                    "y".equals(dir) ? n - coord.getY() : 0;
    }
    
    private boolean validaDeslocamento(int desloc){
        boolean valida = true;
        
        if (desloc > 2 || desloc < -2){
            valida = false;
        } else if ( isBranca() && desloc <= 0){
            valida = false;
        } else if ( isPreta() && desloc >= 0){
            valida = false;
        } else if ( isPrimeiroMovimento() && (desloc == 2 || desloc == -2) ){
            valida = false;
        }
        
        return valida;
    }
}