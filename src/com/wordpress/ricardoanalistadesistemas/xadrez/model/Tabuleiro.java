/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wordpress.ricardoanalistadesistemas.xadrez.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

/**
 *
 * @author Ricardo de Araújo Balduino
 */
public class Tabuleiro extends Observable {
    /**
     * 
     */
    private static Tabuleiro instancia;
    
    /**
     * 
     */
    private Map<Casa, Peca> mapa;
    
    /**
     * 
     */
    private Tabuleiro(){
        mapa = new HashMap<>(64);
        
        for (int i = Xadrez_Fileiras.OITAVA; i >= Xadrez_Fileiras.PRIMEIRA; i--){
            for (int j = Xadrez_Colunas.A; j <= Xadrez_Colunas.H; j++){
                switch (i){
                    case Xadrez_Fileiras.PRIMEIRA:
                    case Xadrez_Fileiras.TERCEIRA:
                    case Xadrez_Fileiras.QUINTA:
                    case Xadrez_Fileiras.SETIMA:
                        if (j == Xadrez_Colunas.A || j == Xadrez_Colunas.C ||
                                j == Xadrez_Colunas.E || j == Xadrez_Colunas.G){
                            mapa.put( new Casa( i, j, Xadrez_Cores.PRETA ), null);
                        } else {
                            mapa.put( new Casa( i, j, Xadrez_Cores.BRANCA ), null);
                        }
                    break;
                        
                    default:
                        if (j == Xadrez_Colunas.A || j == Xadrez_Colunas.C ||
                                j == Xadrez_Colunas.E || j == Xadrez_Colunas.G){
                            mapa.put( new Casa( i, j, Xadrez_Cores.BRANCA ), null);
                        } else {
                            mapa.put( new Casa( i, j, Xadrez_Cores.PRETA ), null);
                        }
                    break;
                } // fim do switch
            } // fim do for j
        } // fim do for i 
    }
    
    /**
     * 
     * @return 
     */
    public static Tabuleiro getInstancia(){
        if (instancia == null){
            instancia = new Tabuleiro();
        }
        
        return instancia;
    }
     
    /**
     * 
     * @param x
     * @param y
     * @return 
     */
    public boolean validaLimites(int x, int y){        
        return x >= Xadrez_Fileiras.PRIMEIRA && x <= Xadrez_Fileiras.OITAVA &&
                y >= Xadrez_Colunas.A && y <= Xadrez_Colunas.H;
    }
    
    /**
     * 
     * @param x
     * @param y
     * @return 
     */
    public int getCorCasa(int x, int y){
        Set<Casa> set = mapa.keySet();
        int cor = -1;
        
        for (Casa c : set){
            if ( c.getX() == x && c.getY() == y ){
                cor =  c.getCor();
            }
        }
        
        return cor;
    }
    
//    Retorna as demais 7 casas que estão em uma fileira, excluindo a casa parâmetro
    /**
     * 
     * @param x
     * @param y
     * @return
     * @throws ArrayIndexOutOfBoundsException 
     */
    public Collection<Coordenada> getCasasFileira(int x, int y) throws ArrayIndexOutOfBoundsException
    {
        // Valida se está dentro dos limites
          if ( !validaLimites(x, y) ) {
              throw new ArrayIndexOutOfBoundsException("A casa desejada não existe");
          }
          
//          Cria uma fila de coordenadas com no máximo 7 elementos
          Collection<Coordenada> lista = new ArrayList<>(7);
          
//          Guarda um par de coordenadas em um ponto
          Coordenada c = new Coordenada();          
          
          // Obtém as casas na mesma fileira à esquerda
          int auxY = y - 1;                  
                    
          while ( validaLimites(x, auxY) ){
              c.setX(x);
              c.setY(auxY);
              lista.add(c);
              auxY--;
          }
          
          // Obtém as casas na mesma fileira à direita
          auxY = y + 1;
                    
          while (validaLimites(x, auxY)){
              c.setX(x);
              c.setY(auxY);
              lista.add(c);
              auxY++;
          }
                    
          return lista;
    }
    
    /**
     * 
     * @param x
     * @param y
     * @return
     * @throws ArrayIndexOutOfBoundsException 
     */
    public Collection<Coordenada> getCasasColuna(int x, int y) throws ArrayIndexOutOfBoundsException
    {
        // Valida se está dentro dos limites
          if ( !validaLimites(x, y) ) {
              throw new ArrayIndexOutOfBoundsException("A casa desejada não existe");
          }
          
//          Cria uma fila de coordenadas com no máximo 7 elementos
          Collection<Coordenada> lista = new ArrayList<>(7);
          
//          Guarda um par de coordenadas em um ponto
          Coordenada c = new Coordenada(); 
          
          // Obtém as casas na mesma coluna abaixo
          int auxX = x - 1;
          
          while (validaLimites(auxX, y)){
              c.setX(auxX);
              c.setY(y);
              lista.add(c);
              auxX--;
          }
          
          // Obtém as casas na mesma coluna acima
          auxX = x + 1;          
          
          while (validaLimites(auxX, y)){
              c.setX(auxX);
              c.setY(y);
              lista.add(c);
              auxX++;
          }
                    
          return lista;
    }
    
    /**
     * 
     * @param x
     * @param y
     * @return
     * @throws ArrayIndexOutOfBoundsException 
     */
    public Collection<Coordenada> getCasasDiagonais(int x, int y) throws ArrayIndexOutOfBoundsException
    {
        // Valida se está dentro dos limites
          if ( !validaLimites(x, y) ) {
              throw new ArrayIndexOutOfBoundsException("A casa desejada não existe");
          }
          
//          Cria uma fila de coordenadas com no máximo 16 elementos
          ArrayList<Coordenada> lista = new ArrayList<>();
          
//          Guarda um par de coordenadas em um ponto
          Coordenada c = new Coordenada();
          
          // Obtém as casas na diagonal acima à esquerda
          int auxX = x + 1;
          int auxY = y - 1;
                    
          while (validaLimites(auxX, auxY)){
              c.setX(auxX);
              c.setY(auxY);
              lista.add(c);
              auxX++;
              auxY--;
          }                        
          
          // Obtém as casas na diagonal abaixo à esquerda
          auxX = x - 1;
          auxY = y - 1;
          
          while (validaLimites(auxX, auxY)){
              c.setX(auxX);
              c.setY(auxY);
              lista.add(c);
              auxX--;
              auxY--;
          }
          
          // Obtém as casas na diagonal acima à direita
          auxX = x + 1;
          auxY = y + 1;
          
          while (validaLimites(auxX, auxY)){
              c.setX(auxX);
              c.setY(auxY);
              lista.add(c);
              auxX++;
              auxY++;
          }
          
          // Obtém as casas na diagonal abaixo à direita
          auxX = x - 1;
          auxY = y + 1;
          
          while (validaLimites(auxX, auxY)){
              c.setX(auxX);
              c.setY(auxY);
              lista.add(c);
              auxX--;
              auxY++;
          }
                    
          return lista;
    }
    
    /**
     * 
     * @param x
     * @param y
     * @return
     * @throws ArrayIndexOutOfBoundsException 
     */
    public Collection<Coordenada> getCasasAcessiveisDiretamente(int x, int y)
            throws ArrayIndexOutOfBoundsException
    {
          // Valida se está dentro dos limites
          if ( !validaLimites(x, y) ) {
              throw new ArrayIndexOutOfBoundsException("A casa desejada não existe");
          }
          
//          Obtém as casas na mesma fileira
          Collection<Coordenada> fileira = getCasasFileira(x, y);
          
//          Obtém as casas na mesma coluna          
          Collection<Coordenada> coluna = getCasasColuna(x, y);
          
//          Obtém as casas nas mesmas diagonais          
          Collection<Coordenada> diagonal = getCasasDiagonais(x, y);
           
//          Cria uma fila de coordenadas com no máximo 30 elementos
          Collection<Coordenada> totalCasas = new ArrayList<>(30);
                    
//          Junta todas as casas
          totalCasas.addAll(fileira);
          totalCasas.addAll(coluna);
          totalCasas.addAll(diagonal);
          
          return totalCasas;
    }
    
    /**
     * Verifica quais casas do tabuleiro estão acessíveis a um cavalo na coordenada (x, y)
     * @param x A fileira que será verificada
     * @param y A coluna que será verificada
     * @return Uma Collection com todas as casas acessíveis a um cavalo
     * @throws ArrayIndexOutOfBoundsException Se x o y forem negativos ou maiores que 
     *      Xadrez_Fileiras.OITAVA ou Xadrez_Colunas._H
     */
    public Collection<Coordenada> getCasasAcessiveisPorCavalo(int x, int y)
            throws ArrayIndexOutOfBoundsException
    {
          // Valida se está dentro dos limites
          if ( !validaLimites(x, y) ) {
              throw new ArrayIndexOutOfBoundsException("A casa desejada não existe");
          }
          
//          Cria uma fila de coordenadas com no máximo 8 elementos
          ArrayList<Coordenada> lista = new ArrayList<>(8);
          
//          Guarda um par de coordenadas em um ponto
          Coordenada c = new Coordenada();
          
          // Obtém as casas em sentido anti-horário
          
          // acima e à esquerda
          int auxX = x + 2;
          int auxY = y - 1;
          
          if ( validaLimites(auxX, auxY) ){
              c.setX(auxX);
              c.setY(auxY);
              lista.add(c);
          }
          
          auxX = x + 1;
          auxY = y - 2;
          
          if ( validaLimites(auxX, auxY) ){
              c.setX(auxX);
              c.setY(auxY);
              lista.add(c);
          }
          
          // abaixo e à esquerda          
          auxX = x - 1;
          auxY = y - 2;
          
          if ( validaLimites(auxX, auxY) ){
              c.setX(auxX);
              c.setY(auxY);
              lista.add(c);
          }
          
          auxX = x - 2;
          auxY = y - 1;
          
          if ( validaLimites(auxX, auxY) ){
              c.setX(auxX);
              c.setY(auxY);
              lista.add(c);
          }
          
          // abaixo e à direita
          auxX = x - 2;
          auxY = y + 1;
          
          if ( validaLimites(auxX, auxY) ){
              c.setX(auxX);
              c.setY(auxY);
              lista.add(c);
          }
          
          auxX = x - 1;
          auxY = y + 2;
          
          if ( validaLimites(auxX, auxY) ){
              c.setX(auxX);
              c.setY(auxY);
              lista.add(c);
          }
          
          // acima e à direita
          auxX = x + 1;
          auxY = y + 2;
          
          if ( validaLimites(auxX, auxY) ){
              c.setX(auxX);
              c.setY(auxY);
              lista.add(c);
          }
          
          auxX = x + 2;
          auxY = y + 1;
          
          if ( validaLimites(auxX, auxY) ){
              c.setX(auxX);
              c.setY(auxY);
              lista.add(c);
          }            
                    
          return lista;
    }
       
    /**
     * Recebe o código de uma peça e decrementa o seu respectivo contador em uma unidade.
     * Este método deve ser usado quando uma peça for retirada do jogo; entretanto, não deve
     * ser usado diretamente quando um peão é promovido. Clientes devem usar o método promoverPeao,
     * que chamará este método
     * @param id_peca
     * @throws NullPointerException 
     */
    public Coordenada removePeca(Peca peca)
    {
        Objects.requireNonNull(peca, "Não há uma peça para remover");
                
        Iterator<Casa> iterator = mapa.keySet().iterator();
        Coordenada coord = ( (AbstractPeca) peca).getCoord();
        Casa c;
        
        while ( iterator.hasNext() ) {
            c = iterator.next();
            
            if ( coord.equals( c.getCoordenada() ) ){
                mapa.replace(c, peca, null);
                break;
            }            
        }
        
        return coord;
    }
    
    /**
     *
     * @param pecaNova
     * @param posNova
     * @throws IllegalArgumentException
     * @throws JogadaIlegalException
     */
    public void movimentaPeca(Peca pecaNova, Coordenada posNova)
            throws JogadaIlegalException
    {
        if (pecaNova == null || posNova == null){
            throw new IllegalArgumentException("Não é possível movimentar a peça");
        }
        
        Iterator<Casa> iterator = mapa.keySet().iterator();
        Coordenada posAtual = ( (AbstractPeca) pecaNova).getCoord();
        Casa c;
        
        while ( iterator.hasNext() ) {
            c = iterator.next();
            
            if ( posNova.equals( c.getCoordenada() ) ){
                AbstractPeca pecaCapturada = (AbstractPeca) mapa.get(c);
                
                if (pecaCapturada == null){
                    mapa.put(c, pecaNova);
                } else {
                    if ( pecaCapturada.getCorJogador() == ( (AbstractPeca) pecaNova).getCorJogador() ){
                        throw new JogadaIlegalException("Você não pode capturar sua própria peça");
                    } else {
                        removePeca(pecaCapturada);
                        mapa.replace(c, null, pecaNova);
                        
                        Iterator<Casa> it = mapa.keySet().iterator();
                        
                        while ( it.hasNext() ) {
                            c = it.next();
                            
                            if ( posAtual.equals( c.getCoordenada() ) ){
                                mapa.replace(c, pecaNova, null);
                            }
                            
                        }
                        
                    }
                }
            }
            
        }
    }
    
    public void movimentar(Coordenada origem, Coordenada destino){
        
    }
    
    /**
     *
     * @param peao
     * @param idPeca
     * @return
     * @throws IllegalArgumentException
     */
    public Peca promoverPeao(Peao peao, int idPeca)
            throws IllegalArgumentException
    {
        if (peao == null || idPeca == Xadrez_Pecas.PEAO || idPeca == Xadrez_Pecas.REI){
            throw new IllegalArgumentException();
        }
        
        Iterator<Casa> iterator = mapa.keySet().iterator();
        Coordenada coord = peao.getCoord();
        int cor = peao.getCorJogador();
        Casa c = null;
        
        while ( iterator.hasNext() ) {
            c =  iterator.next();
            
            if ( coord.equals( c.getCoordenada() ) ){
                mapa.replace(c, peao, null);
            }            
        }
        
        AbstractPeca peca = null;
        
        switch (idPeca){
            case Xadrez_Pecas.DAMA:
                peca = new Dama();
            break;
            
            case Xadrez_Pecas.TORRE:
                peca = new Torre();
            break;
            
            case Xadrez_Pecas.CAVALO:
                peca = new Cavalo();
            break;
            
            case Xadrez_Pecas.BISPO:
                peca = new Bispo();
            break;
        }
        
        peca.setCoord(coord);
        peca.setCorJogador(cor);
        mapa.replace(c, null, peca);
        
        return peca;
    }
        
    public final Map<Casa, Peca> getVisaoGeralTabuleiro() {
        return mapa;
    }
}

