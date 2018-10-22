/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.Map;
import java.util.Set;
import model.Casa;
import model.Peca;
import model.Tabuleiro;
import model.Xadrez_Colunas;
import model.Xadrez_Cores;
import model.Xadrez_Fileiras;

/**
 *
 * @author ricardobalduino
 */
public class ArbitroPartida {
    private static ArbitroPartida instancia;
    private Tabuleiro tabuleiro;
    
    private boolean vezBrancas;
    private boolean brancaVenceu;
    private boolean pretaVenceu;
    private boolean jogoAcabou;
    private boolean jogadaValida;

    private ArbitroPartida() {
        tabuleiro = Tabuleiro.getInstancia();
        
    }

    public static ArbitroPartida getInstancia() {
        if (instancia == null){
            instancia = new ArbitroPartida();
        }
        
        return instancia;
    }
//
//    public void setJogadaValida(boolean jogadaValida) {
//        this.jogadaValida = jogadaValida;
//    }
//
//    
//        
    private void iniciarPartida(){
//      as brancas começam
        vezBrancas = true;        
        brancaVenceu = false;
        pretaVenceu = false;
        jogoAcabou = false;
        jogadaValida = false;
    
        Map<Casa, Peca> mapa = tabuleiro.getVisaoGeralTabuleiro();
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
    
//    
//    private void comecarJogo(){
//        initPartida();
//        
//        while ( !jogoAcabou ){
//            while ( !jogadaValida ){
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException ex) {
//                    ex.printStackTrace();
//                }
//            }
//            
//            setJogadaValida(false);
//            
////            cede a vez ao oponente
//            vezBrancas = !vezBrancas;
//        }
//    }
//
//    public boolean isJogoAcabou() {
//        return brancaVenceu || pretaVenceu;
//    }
//
//          
//    
//    
//    
//    
//    public void verificarResultado(){
//        
//    }
//    
//    public void finalizarJogada(){
//        
////        cede a vez ao oponente
//        vezBrancas = !vezBrancas;
//    }
//    
//    public boolean validaJogada(int xOrigem, int yOrigem, int xDest, int yDest){
//        Point coordOrigem = new Point(xOrigem, yOrigem);
//        Point coordDest = new Point(xDest, yDest);
//        final Map<Point, Observable> mapa = tabuleiro.getVisaoGeralTabuleiro();
//        Peca pecaOrigem, pecaDest;
//        boolean valido = true;
//        
//        if ( mapa.containsKey(coordOrigem) && mapa.containsKey(coordDest) ){
//            if ( mapa.get(coordOrigem) == null ){
//                valido = false;
//            } else {
//                pecaOrigem = (Peca) mapa.get(coordOrigem);
//                
//                if ( mapa.get(coordDest) == null){
//                    if ( pecaOrigem.validaMovimento(xDest, yDest) ){
//                        
//                    }
//                    
//                    pecaDest = (Peca) mapa.get(coordDest);
//                    
//                    if (pecaOrigem.ID_JOGADOR != pecaDest.ID_JOGADOR){
//                        
//                    }
//                }
//            }
//                 
//        }
//        
//        return valido;        
//    }
//    
//    public boolean validarRoque(Jogador jogador){
//        Rei rei = (Rei) jogador.getRei();
//        Torre torre[] = (Torre[]) jogador.getTorres();
//        
//        
//        return !rei.isEmXeque() && rei.isPrimeiroMovimento() && (torre[0].isPrimeiroMovimento() || torre[1].isPrimeiroMovimento());
//    }
//    
//    public boolean validarEnPassant(){
//        
//    }
    
}
