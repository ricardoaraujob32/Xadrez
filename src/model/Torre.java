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
public class Torre extends PecaComPrimeiroMovimento implements IPodeFazerRoque {

    /**
     *
     * @param x
     * @param y
     * @param id_jogador
     */
    public Torre(int x, int y, int id_jogador)
    {
        super(x, y, id_jogador);
    }
      
    @Override
    public void movimentar(int x, int y)
    {
        super.movimentar(x, y);
        
        if ( isPrimeiroMovimento() ){
            setNotPrimeiroMovimento();
        }
    }

    @Override
    public boolean validaMovimento(int x, int y) {
        boolean valido = true;

//      se a peça tentar se mover para fora do tabuleiro
        if ( !t.validaLimites(x, y) ){
            valido = false;
//            throw new ArrayIndexOutOfBoundsException("Tentou movimentar para fora do tabuleiro.");
        }
        
        // se a torre tentar se mover em diagonal
        if (x != this.x && y != this.y){
            valido = false;
//            throw new JogadaIlegalException("Uma torre não pode se mover em diagonal.");
        }
        
        return valido;
    }

    @Override
    public void roque() throws JogadaIlegalException {
        if ( !podeFazerRoque() ){
            throw new JogadaIlegalException("A torre já foi movida uma vez!");
        }
        
        if ( y == Xadrez_Colunas.A ){
            setY( Xadrez_Colunas.D );
        } else {
            setY( Xadrez_Colunas.F );
        }
    }

    @Override
    public boolean podeFazerRoque() {
        return isPrimeiroMovimento();
    }
}