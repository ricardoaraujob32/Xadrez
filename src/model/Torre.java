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
public class Torre extends PecaQuePodeFazerRoque {
      
    @Override
    public void movimentar(int x, int y)
    {
        if ( validaMovimento(x, y) ) {
            super.movimentar(x, y);

            if ( isPrimeiroMovimento() ) {
                setNaoEhPrimeiroMovimento();
            }
            
            if ( !isFezRoque() && isPodeFazerRoque() ){
                setNaoPodeFazerRoque();
            }
        }
    }

    @Override
    public boolean validaMovimento(int x, int y) {
        return t.validaLimites(x, y) && !moveuEmDiagonal(x, y);
    }

    @Override
    public void roque(int x, int y) {
        coord.setY(y);
        setFezRoque();
        setNaoPodeFazerRoque();
        
        if ( isPrimeiroMovimento() ){
            setNaoEhPrimeiroMovimento();
        }
    }

    @Override
    public boolean podeFazerRoque() {
        return isPrimeiroMovimento() && !isFezRoque() && isPodeFazerRoque();
    }
    
    private boolean moveuEmDiagonal(int x, int y){
        return x != coord.getX() && y != coord.getY();
    }
}