/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Random;
import org.junit.Assert;

/**
 *
 * @author ricardobalduino
 */
public class TesteValidaLimites {
    public static void main(String[] args) {
        Random r = new Random();
        
        while (true) {            
            int x = r.nextInt(16);
            int y = r.nextInt(16);
            System.out.println("x = " + x + " y = " + y);
            boolean b = x >= Xadrez_Fileiras.PRIMEIRA && x <= Xadrez_Fileiras.OITAVA
                    && y >= Xadrez_Colunas.A && y <= Xadrez_Colunas.H;
            Assert.assertTrue("Fora dos limites", b);
        }
        
    }
}
