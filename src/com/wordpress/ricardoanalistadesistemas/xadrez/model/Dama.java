/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.ricardoanalistadesistemas.xadrez.model;

import java.util.Iterator;

/**
 *
 * @author Ricardo de Araújo Balduino
 */
public class Dama extends AbstractPeca {   

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
        } else {
            // obtém lista de casas possíveis para se mover
            Iterator<Coordenada> iterator = t.getCasasAcessiveisDiretamente( coord.getX(), coord.getY() ).iterator();
            Coordenada c;

            while ( iterator.hasNext() ) {
                c = iterator.next();

                // se foi a escolhida, posiciona a peça lá
                if ( c.getX() == destX && c.getY() == destY ) {
                    return true;
                }
            }
        }
                 
        return false;
    }
}