/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.ricardoanalistadesistemas.xadrez.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

/**
 *
 * @author ricardobalduino
 */
public class TabuleiroView extends JPanel implements Observer {
    private CasaView[][] btnCasa;
    
    public TabuleiroView() {
        btnCasa = new CasaView[8][8];
        setLayout( new GridLayout(8, 8) );
        
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                btnCasa[i][j] = new CasaView(i, j);
                btnCasa[i][j].setFocusable(false);
                //btnCasa[i][j].addActionListener(a);
                
                switch (i){
                    case Xadrez_Constantes._1:
                    case Xadrez_Constantes._3:
                    case Xadrez_Constantes._5:
                    case Xadrez_Constantes._7:
                        if (j == Xadrez_Constantes.A || j == Xadrez_Constantes.C ||
                                j == Xadrez_Constantes.E || j == Xadrez_Constantes.G){
                            btnCasa[i][j].setBackground(Color.BLACK);
                            btnCasa[i][j].setIcon(ico1);
                        } else {
                            btnCasa[i][j].setBackground(Color.WHITE);
                            btnCasa[i][j].setIcon(ico2);
                        }
                    break;
                        
                    default:
                        if (j == Xadrez_Constantes.A || j == Xadrez_Constantes.C ||
                                j == Xadrez_Constantes.E || j == Xadrez_Constantes.G){
                            btnCasa[i][j].setBackground(Color.WHITE);
                            btnCasa[i][j].setIcon(ico4);
                        } else {
                            btnCasa[i][j].setBackground(Color.BLACK);
                            btnCasa[i][j].setIcon(ico3);
                        }
                } // fim do switch
                
                add(btnCasa[i][j]);
            }
        }
    }

    
    
    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}
