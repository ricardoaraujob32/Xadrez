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
public class TesteColuna {
    public static void main(String[] args) {
        int[] v = {1, 2, 3, 4, 5, 6, 7, 8};

        for (int coluna : v) {

            for (int fileira : v) {
                CoordenadaTeste c = new CoordenadaTeste();
                c.setX(fileira);
                c.setY(coluna);
                System.out.println("Recebeu coordenada " + c.toString());

                int auxX = fileira - 1;

                while (validaLimites(auxX, coluna)) {
                    c.setX(auxX);
                    c.setY(coluna);
                    System.out.println( c.toString() );
                    auxX--;
                }

                // Obtém as casas na mesma fileira à direita
                auxX = fileira + 1;

                while (validaLimites(auxX, coluna) ) {
                    c.setX(auxX);
                    c.setY(coluna);
                    System.out.println( c.toString() );
                    auxX++;
                }
            }

            System.out.println();
            System.out.println();
            System.out.println();
        }
       
         
          
//      
          
         
          
          
          // Obtém as casas na mesma coluna acima
          
          
    }
    
    public static boolean validaLimites(int x, int y){        
        return x >= 1 && x <= 8 && y >= 1 && y <= 8;
    }
}

    

