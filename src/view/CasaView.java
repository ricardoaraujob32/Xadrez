/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import controller.Xadrez_Constantes;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.JButton;

/**
 *
 * @author ricardobalduino
 */
public class CasaView extends JButton {
//    public static final String ICONE_REI_PRETO = "C:\\Users\\ricardobalduino\\Desktop\\Projetos Java\\Xadrez\\Rei preto.gif";
    
    private int fileira;
    private int coluna;
    
    public CasaView(int fileira, int coluna)
            throws IllegalArgumentException
    {
        this(fileira, coluna, null);
    }

    public CasaView(int fileira, int coluna, Icon icon)
            throws IllegalArgumentException
    {
        super(icon);
        
        if (fileira < 0 || fileira >= 8 || coluna < 0 || coluna >= 8) {
            throw new IllegalArgumentException("Está fora dos limites do tabuleiro");
        }
        
        this.fileira = fileira;
        this.coluna = coluna;
                        
        setFocusable(false);
                        
        switch (fileira){
            case Xadrez_Constantes._1:
            case Xadrez_Constantes._3:
            case Xadrez_Constantes._5:
            case Xadrez_Constantes._7:
                if (coluna == Xadrez_Constantes.A || coluna == Xadrez_Constantes.C ||
                        coluna == Xadrez_Constantes.E || coluna == Xadrez_Constantes.G){
                    setBackground(Color.WHITE);
                } else {
                    setBackground(Color.BLACK);
                }
            break;
                        
            default:
                if (coluna == Xadrez_Constantes.A || coluna == Xadrez_Constantes.C ||
                        coluna == Xadrez_Constantes.E || coluna == Xadrez_Constantes.G){
                    setBackground(Color.BLACK);
                } else {
                    setBackground(Color.WHITE);
                }
            break;
        }
        
        //addActionListener(a);
    }

    public int getFileira() {
        return fileira;
    }

    public int getColuna() {
        return coluna;
    }
    
    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public void setSelected(boolean b) {
        super.setSelected(false);
    }

    @Override
    public void doClick() {}
    
    
    
    
    
    
}
