/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ricardobalduino
 */
public class Tabuleiro {
    
    public Tabuleiro() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    /**
     *
     * @author ricardobalduino
     */
    public static final class Casa {

        /**
         *
         */
        public final int X;
        /**
         *
         */
        public final int Y;
        /**
         *
         */
        public final int COR;

        /**
         *
         * @param x
         * @param y
         * @param cor
         */
        public Casa(int x, int y, int cor) {
            super();
            this.X = x;
            this.Y = y;
            this.COR = cor;
        }
    }
}
