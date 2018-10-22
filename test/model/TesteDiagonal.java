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
public class TesteDiagonal {
    public static void main(String[] args) {
        int[] v = {1, 2, 3, 4, 5, 6, 7, 8};

        for (int fileira : v) {

            for (int coluna : v) {
                CoordenadaTeste c = new CoordenadaTeste();
                c.setX(fileira);
                c.setY(coluna);
                System.out.println("Recebeu coordenada " + c.toString());

                // Obtém as casas na diagonal acima à esquerda
                int auxX = fileira + 1;
                int auxY = coluna - 1;

                while (validaLimites(auxX, auxY)) {
                    c.setX(auxX);
                    c.setY(auxY);
                    System.out.println(c.toString());
                    auxX++;
                    auxY--;
                }

                // Obtém as casas na diagonal abaixo à esquerda
                auxX = fileira - 1;
                auxY = coluna - 1;

                while (validaLimites(auxX, auxY)) {
                    c.setX(auxX);
                    c.setY(auxY);
                    System.out.println(c.toString());
                    auxX--;
                    auxY--;
                }

                // Obtém as casas na diagonal acima à direita
                auxX = fileira + 1;
                auxY = coluna + 1;

                while (validaLimites(auxX, auxY)) {
                    c.setX(auxX);
                    c.setY(auxY);
                    System.out.println(c.toString());
                    auxX++;
                    auxY++;
                }

                // Obtém as casas na diagonal abaixo à direita
                auxX = fileira - 1;
                auxY = coluna + 1;

                while (validaLimites(auxX, auxY)) {
                    c.setX(auxX);
                    c.setY(auxY);
                    System.out.println(c.toString());
                    auxX--;
                    auxY++;
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
