/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.wordpress.ricardoanalistadesistemas.xadrez.model.Xadrez_Colunas;
import com.wordpress.ricardoanalistadesistemas.xadrez.model.Xadrez_Fileiras;

/**
 *
 * @author ricardobalduino
 */
public class TesteCorCasa {
    public static void main(String[] args) {
        for (int i = Xadrez_Fileiras.OITAVA; i >= Xadrez_Fileiras.PRIMEIRA; i--){
            for (int j = Xadrez_Colunas.A; j <= Xadrez_Colunas.H; j++){
                switch (i){
                    case Xadrez_Fileiras.PRIMEIRA:
                    case Xadrez_Fileiras.TERCEIRA:
                    case Xadrez_Fileiras.QUINTA:
                    case Xadrez_Fileiras.SETIMA:
                        if (j == Xadrez_Colunas.A || j == Xadrez_Colunas.C ||
                                j == Xadrez_Colunas.E || j == Xadrez_Colunas.G){
                            System.out.print("PRETA" + "\t");
                        } else {
                            System.out.print("BRANCA" + "\t");
                        }
                    break;
                        
                    default:
                        if (j == Xadrez_Colunas.A || j == Xadrez_Colunas.C ||
                                j == Xadrez_Colunas.E || j == Xadrez_Colunas.G){
                            System.out.print("BRANCA" + "\t");
                        } else {
                            System.out.print("PRETA" + "\t");
                        }
                    break;
                } // fim do switch
            } // fim do for j
            
            System.out.println();
        } // fim do for i 
    }
}
