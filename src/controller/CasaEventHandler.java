	/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import view.CasaView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ricardobalduino
 */
public class CasaEventHandler implements ActionListener {
    public static final String SELECIONAR_CASA = "selecionar casa";
    public static final String MOVER_PECA = "mover peça";
    
    private int xOrigem;
    private int yOrigem;
    private int xDestino;
    private int yDestino;

    public CasaEventHandler() {
        this.xOrigem = -1;
        this.yOrigem = -1;
        this.xDestino = -1;
        this.yDestino = -1;
    }
    
    private void limparCoordenadas(){
        this.xOrigem = -1;
        this.yOrigem = -1;
        this.xDestino = -1;
        this.yDestino = -1;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
            throws IllegalArgumentException
    {
        CasaView casa = (CasaView) e.getSource();
        
        switch ( e.getActionCommand() ) {
            // se a ação for "selecionar casa"
            case SELECIONAR_CASA:
                xOrigem = casa.getFileira();
                yOrigem = casa.getColuna();   
            break;
            // se a ação for "mover peça"
            case MOVER_PECA:
                // se a casa de origem e a casa de destino são a mesma
                if (casa.getFileira() == xOrigem && casa.getColuna() == yOrigem){
                    limparCoordenadas();
                    
                    return;
                } else {
                    xDestino = casa.getFileira();
                    yDestino = casa.getColuna();
                    
                    ArbitroPartida controlador = ArbitroPartida.getInstancia();
                    
                    if ( controlador.validaJogada(xOrigem, yOrigem, xDestino, yDestino) ){
                        controlador.setJogadaValida(true);
                    }
                }
                
                limparCoordenadas();
                    
                break;
            // ação inválida
            default:
                throw new IllegalArgumentException("Ação desconhecida.");
        }
    }
    
}