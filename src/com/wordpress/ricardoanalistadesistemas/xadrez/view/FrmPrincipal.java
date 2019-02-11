/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.ricardoanalistadesistemas.xadrez.view;

import controller.Xadrez_Constantes;
import com.wordpress.ricardoanalistadesistemas.xadrez.controller.PecaFactory;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import com.wordpress.ricardoanalistadesistemas.xadrez.model.Tabuleiro;

/**
 *
 * @author ricardobalduino
 */
public class FrmPrincipal {
    private JFrame frmJanela;
    private JButton btnCasa[][];
    private JPanel painelTelaInicial;
    private JPanel painelTabuleiro;
    private Container container;
    private Tabuleiro tabuleiro;

    public FrmPrincipal(){
        frmJanela = new JFrame("Jogo de xadrez");
        container = frmJanela.getContentPane();
        
        initMenuBar();
        painelTelaInicial = initPainelTelaPrincipal();
        painelTabuleiro = initPainelTabuleiro();
        
        
        
        container.add(painelTelaInicial, BorderLayout.CENTER);
        frmJanela.setSize(600, 600);
        frmJanela.setVisible(true);
        frmJanela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
            
    private void initMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        JMenu menuOpcoes = new JMenu("Opções");
        JMenuItem novaPartida = new JMenuItem("Nova partida");           
        
        novaPartida.addActionListener( (ActionEvent e) -> {
            container.remove(painelTelaInicial);
            container.add(painelTabuleiro, BorderLayout.CENTER);
            frmJanela.pack();
            frmJanela.setSize(600, 600);
            frmJanela.repaint();
        });
        
        menuOpcoes.add(novaPartida);
        menuBar.add(menuOpcoes);
        frmJanela.setJMenuBar(menuBar);
    }
    
    private JPanel initPainelTelaPrincipal(){
        JPanel telaInicial = new JPanel(new BorderLayout());
        telaInicial.setBackground(Color.BLACK);
        
        return telaInicial;
    }
    
    private JPanel initPainelTabuleiro(){        
        JPanel painel = new JPanel();
        
        
        
        
        
        return painel;
    }
    
    public static void main(String[] args){
        try {
            EventQueue.invokeLater(() -> new FrmPrincipal() );
        } catch (Exception e){
            e.printStackTrace();
        }
    }   
}