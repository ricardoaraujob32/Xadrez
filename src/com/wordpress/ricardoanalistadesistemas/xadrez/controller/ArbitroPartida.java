/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.ricardoanalistadesistemas.xadrez.controller;

import java.util.Map;
import java.util.Set;
import com.wordpress.ricardoanalistadesistemas.xadrez.model.Casa;
import com.wordpress.ricardoanalistadesistemas.xadrez.model.AbstractPeca;
import com.wordpress.ricardoanalistadesistemas.xadrez.model.Peca;
import com.wordpress.ricardoanalistadesistemas.xadrez.model.Tabuleiro;
import com.wordpress.ricardoanalistadesistemas.xadrez.model.Xadrez_Colunas;
import com.wordpress.ricardoanalistadesistemas.xadrez.model.Xadrez_Cores;
import com.wordpress.ricardoanalistadesistemas.xadrez.model.Xadrez_Fileiras;

/**
 *
 * @author ricardobalduino
 */
public class ArbitroPartida {
    private Tabuleiro tabuleiro;    
    private boolean vezBrancas;
    private boolean brancaVenceu;
    private boolean pretaVenceu;
    private boolean jogoAcabou;
    private boolean jogadaValida;
    private Peca pecaSelecionada;

    public ArbitroPartida() {
        tabuleiro = Tabuleiro.getInstancia();
        pecaSelecionada = null;
    }
    
    private void iniciarPartida(){
//      as brancas começam
        vezBrancas = true;        
        brancaVenceu = false;
        pretaVenceu = false;
        jogoAcabou = false;
        jogadaValida = false;
    
        Map<Casa, AbstractPeca> mapa = tabuleiro.getVisaoGeralTabuleiro();
        Set<Casa> set = mapa.keySet();
        
        for (Casa c : set){           
            switch ( c.getX() ){
                case Xadrez_Fileiras.PRIMEIRA:
                    if ( c.Y == Xadrez_Colunas.A || c.Y == Xadrez_Colunas.H ){
                        mapa.put( c, PecaFactory.criarTorre( c.X, c.Y, Xadrez_Cores.BRANCA ) ); 
                    } else if ( c.Y == Xadrez_Colunas.B || c.Y == Xadrez_Colunas.G ){
                        mapa.put( c, PecaFactory.criarCavalo( c.X, c.Y, Xadrez_Cores.BRANCA ) );
                    } else if ( c.Y == Xadrez_Colunas.C || c.Y == Xadrez_Colunas.F ){
                        mapa.put( c, PecaFactory.criarBispo( c.X, c.Y, Xadrez_Cores.BRANCA ) );
                    } else if ( c.Y == Xadrez_Colunas.D ){
                        mapa.put( c, PecaFactory.criarDama( c.X, c.Y, Xadrez_Cores.BRANCA ) );
                    } else {
                        mapa.put( c, PecaFactory.criarRei( c.X, c.Y, Xadrez_Cores.BRANCA) );
                    }
                break;
                    
                case Xadrez_Fileiras.OITAVA:
                    if ( c.Y == Xadrez_Colunas.A || c.Y == Xadrez_Colunas.H ){
                        mapa.put( c, PecaFactory.criarTorre( c.X, c.Y, Xadrez_Cores.PRETA ) ); 
                    } else if ( c.Y == Xadrez_Colunas.B || c.Y == Xadrez_Colunas.G ){
                        mapa.put( c, PecaFactory.criarCavalo( c.X, c.Y, Xadrez_Cores.PRETA ) );
                    } else if ( c.Y == Xadrez_Colunas.C || c.Y == Xadrez_Colunas.F ){
                        mapa.put( c, PecaFactory.criarBispo( c.X, c.Y, Xadrez_Cores.PRETA ) );
                    } else if ( c.Y == Xadrez_Colunas.D ){
                        mapa.put( c, PecaFactory.criarDama( c.X, c.Y, Xadrez_Cores.PRETA ) );
                    } else {
                        mapa.put( c, PecaFactory.criarRei( c.X, c.Y, Xadrez_Cores.PRETA) );
                    }
                break;
                    
                case Xadrez_Fileiras.SEGUNDA:
                    mapa.put( c, PecaFactory.criarPeao( c.X, c.Y, Xadrez_Cores.BRANCA ) );
                break;
                    
                case Xadrez_Fileiras.SETIMA:
                    mapa.put( c, PecaFactory.criarPeao( c.X, c.Y, Xadrez_Cores.PRETA ) );
                break;
                    
                default:
                    mapa.put( c, null );
                break;
            }
            
        }
    }
        
    public void comecarPartida(){
        iniciarPartida();

        while (!jogoAcabou) {                
            
        }
    }        
    
}
