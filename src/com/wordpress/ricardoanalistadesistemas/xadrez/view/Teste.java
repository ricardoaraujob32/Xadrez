/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.ricardoanalistadesistemas.xadrez.view;

import java.lang.reflect.Field;

/**
 *
 * @author ricardobalduino
 */
public class Teste {
     
	public static String TESTE;
	private String nome;
	private int idade;
	
        public static void main(String[] args){
		Class c = Teste.class;
		Field[] properties = c.getDeclaredFields();
                System.out.println("Todas os campos:");
		for(Field field : properties){
			System.out.println("properties = "+field.getType()+" "+field.getName());
		}
		properties = c.getFields();
                System.out.println("\n\nTodos os campos estáticos:");
		for(Field field : properties){
			System.out.println("field = "+field.getType()+" "+field.getName());
		}
	}

}
