/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.awt.Point;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 *
 * @author Ricardo de Araújo Balduino
 */
public class Dama extends Peca {   

    /**
     * 
     * @param x
     * @param y
     * @param id_jogador 
     */
    
    public Dama(int x, int y, int id_jogador)
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
        if ( !t.validaLimites(destX, destY) ){
            return false;
        }
        
        // obtém lista de casas possíveis para se mover
        Collection<Point> collection = t.getCasasAcessiveisDiretamente(this.x, this.y);
        Point p = new Point();
        
        while ( !collection.isEmpty() ) {            
            try {
                p = collection.remove;
                
                // se foi a escolhida, posiciona a peça lá
                if ( p.getX() == destX && p.getY() == destY ) {
                    return true; 
                }
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
        }
         
        return false;
        // Se não for uma casa válida, informar o erro
//        throw new JogadaIlegalException("A dama não pode se mover para esta casa.");
    }
}