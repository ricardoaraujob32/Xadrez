/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ricardobalduino
 */
public class TesteFileira {
    public static void main(String[] args) {
        int[] v = {1, 2, 3, 4, 5, 6, 7, 8};
        
        for (int fileira : v) {
            
            
            for (int coluna : v) {
                CoordenadaTeste c = new CoordenadaTeste();
                c.setX(fileira);
                c.setY(coluna);
                System.out.println("Recebeu coordenada " + c.toString() );
                
                int auxY = coluna - 1;

                while (validaLimites(fileira, auxY)) {
                    c.setX(fileira);
                    c.setY(auxY);
                    System.out.println( c.toString() );
                    auxY--;
                }
                
               

                // Obtém as casas na mesma fileira à direita
                auxY = coluna + 1;

                while (validaLimites(fileira, auxY)) {
                    c.setX(fileira);
                    c.setY(auxY);
                    System.out.println( c.toString() );
                    auxY++;
                }
            }

            System.out.println();
            System.out.println();
            System.out.println();
        }
        
          
//          Guarda um par de coordenadas em um ponto
                    
          
          // Obtém as casas na mesma fileira à esquerda
          
    }
    
    public static boolean validaLimites(int x, int y){        
        return x >= 1 && x <= 8 && y >= 1 && y <= 8;
    }
}
