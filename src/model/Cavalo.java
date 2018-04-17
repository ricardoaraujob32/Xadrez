/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.awt.Point;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 *
 * @author ricardobalduino
 */
public class Cavalo extends Peca {

    /**
     * 
     * @param x
     * @param y
     * @param id_jogador 
     */
    
    public Cavalo(int x, int y, int id_jogador)
    {
        super(x, y, id_jogador);
    }

    /**
     * 
     * @param destX
     * @param destY
     * @return 
     */
    
    @Override
    public boolean validaMovimento(int destX, int destY) {        
        if (!t.validaLimites(destX, destY)){
            return false;
//            throw new ArrayIndexOutOfBoundsException("Tentou movimentar para fora do tabuleiro.");
        }
        
        // obtém lista de casas possíveis para se mover
        Queue<Point> queue = t.getCasasAcessiveisIndiretamente(this.x, this.y);
        Point p = new Point();
        
        while ( !queue.isEmpty() ) {            
            try {
                p = queue.remove();
                
                // se foi a escolhida, posiciona a peça lá
                if ( p.getX() == destX && p.getY() == destY ){                
                    return true;                    
                }
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
        }
        
        return false;
                    
        // Se não for uma casa válida, informar o erro
//        throw new JogadaIlegalException("O cavalo só pode se mover em L.");
    }
}