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
 * @author Ricardo de Araújo Balduino
 */
public class Bispo extends Peca {

    /**
     * 
     * @param x
     * @param y
     * @param id_jogador 
     */
    
    public Bispo(int x, int y, int id_jogador)
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
        // se a peça tentar se mover para fora do tabuleiro
        if (!t.validaLimites(destX, destY)){
            return false;
//            throw new ArrayIndexOutOfBoundsException("Tentou movimentar para fora do tabuleiro.");
        }
                
        // obtém lista de casas possíveis para se mover
        Queue<Point> queue = t.getCasasDiagonais(this.x, this.y);
        Point p = new Point();
        
        while ( !queue.isEmpty() ){
            try {
                p = queue.remove();
                
                // se foi a escolhida, posiciona a peça lá
                if (p.getX() == destX && p.getY() == destY){
                    return true;
                }
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
        }
           
        return false;
        // Se a casa não está na diagonal do bispo, informar o erro
//        throw new JogadaIlegalException("Um bispo só pode se mover em diagonal.");
    }
}