/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.ricardoanalistadesistemas.xadrez.model;

/**
 *
 * @author ricardobalduino
 */
public class JogadaIlegalException extends Exception {

    /**
     * Creates a new instance of <code>JogadaIlegalException</code> without
     * detail message.
     */
    public JogadaIlegalException() {
    }

    /**
     * Constructs an instance of <code>JogadaIlegalException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public JogadaIlegalException(String msg) {
        super(msg);
    }
}
