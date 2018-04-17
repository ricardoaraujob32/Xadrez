/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

/**
 *
 * @author ricardobalduino
 */
public class BtnConfiguracoesEventHandler implements ActionListener {
    private JDialog dialogo;

    public BtnConfiguracoesEventHandler(Frame f, String s) {
        dialogo = new JDialog(f, s, true);
        Container container = dialogo.getContentPane();
        ButtonGroup grupo = new ButtonGroup();
        JRadioButton rdBrancas = new JRadioButton("Jogar como brancas", true);
        JRadioButton rdPretas = new JRadioButton("Jogar como pretas");
        
        container.setLayout(new FlowLayout());
        grupo.add(rdBrancas);
        grupo.add(rdPretas);
        container.add(rdBrancas);
        container.add(rdPretas);
        
        dialogo.setSize(100, 300);
        dialogo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        dialogo.setVisible(true);
    }
    
}
