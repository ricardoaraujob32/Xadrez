/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
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
    private Map<Casa,Peca> mapa;
    
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
            if (c.X == x && c.Y == y){
                cor =  c.COR;
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
    public Collection<Point> getCasasFileira(int x, int y)
    {
        // Valida se está dentro dos limites
          if ( !validaLimites(x, y) ) {
              throw new ArrayIndexOutOfBoundsException("A casa desejada não existe");
          }
          
//          Cria uma fila de coordenadas com no máximo 7 elementos
          Collection<Point> lista = new ArrayList<>(7);
          
//          Guarda um par de coordenadas em um ponto
          Point p = new Point();          
          
          // Obtém as casas na mesma fileira à esquerda
          int auxY = y - 1;                  
                    
          while (validaLimites(x, auxY)){
              p.setLocation(x, auxY);
              lista.add(p);
              auxY--;
          }
          
          // Obtém as casas na mesma fileira à direita
          auxY = y + 1;
                    
          while (validaLimites(x, auxY)){
              p.setLocation(x, auxY);
              lista.add(p);
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
    public Collection<Point> getCasasColuna(int x, int y)
    {
        // Valida se está dentro dos limites
          if ( !validaLimites(x, y) ) {
              throw new ArrayIndexOutOfBoundsException("A casa desejada não existe");
          }
          
//          Cria uma fila de coordenadas com no máximo 7 elementos
          Collection<Point> lista = new ArrayList<>(7);
          
//          Guarda um par de coordenadas em um ponto
          Point p = new Point(); 
          
          // Obtém as casas na mesma coluna abaixo
          int auxX = x - 1;
          
          while (validaLimites(auxX, y)){
              p.setLocation(auxX, y);
              lista.add(p);
              auxX--;
          }
          
          // Obtém as casas na mesma coluna acima
          auxX = x + 1;          
          
          while (validaLimites(auxX, y)){
              p.setLocation(auxX, y);
              lista.add(p);
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
    public Collection<Point> getCasasDiagonais(int x, int y)
    {
        // Valida se está dentro dos limites
          if ( !validaLimites(x, y) ) {
              throw new ArrayIndexOutOfBoundsException("A casa desejada não existe");
          }
          
//          Cria uma fila de coordenadas com no máximo 16 elementos
          Collection<Point> lista = new ArrayList<>();
          
//          Guarda um par de coordenadas em um ponto
          Point p = new Point();
          
          // Obtém as casas na diagonal acima à esquerda
          int auxX = x + 1;
          int auxY = y - 1;
                    
          while (validaLimites(auxX, auxY)){
              p.setLocation(auxX, auxY);
              lista.add(p);
              auxX++;
              auxY--;
          }                        
          
          // Obtém as casas na diagonal abaixo à esquerda
          auxX = x - 1;
          auxY = y - 1;
          
          while (validaLimites(auxX, auxY)){
              p.setLocation(auxX, auxY);
              lista.add(p);
              auxX--;
              auxY--;
          }
          
          // Obtém as casas na diagonal acima à direita
          auxX = x + 1;
          auxY = y + 1;
          
          while (validaLimites(auxX, auxY)){
              p.setLocation(auxX, auxY);
              lista.add(p);
              auxX++;
              auxY++;
          }
          
          // Obtém as casas na diagonal abaixo à direita
          auxX = x - 1;
          auxY = y + 1;
          
          while (validaLimites(auxX, auxY)){
              p.setLocation(auxX, auxY);
              lista.add(p);
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
    public Collection<Point> getCasasAcessiveisDiretamente(int x, int y)
    {
          // Valida se está dentro dos limites
          if ( !validaLimites(x, y) ) {
              throw new ArrayIndexOutOfBoundsException("A casa desejada não existe");
          }
          
//          Obtém as casas na mesma fileira
          Collection<Point> fileira = getCasasFileira(x, y);
          
//          Obtém as casas na mesma coluna          
          Collection<Point> coluna = getCasasColuna(x, y);
          
//          Obtém as casas nas mesmas diagonais          
          Collection<Point> diagonal = getCasasDiagonais(x, y);
           
//          Cria uma fila de coordenadas com no máximo 30 elementos
          Collection<Point> totalCasas = new ArrayList<>(30);
                    
//          Junta todas as casas em uma única fila
          totalCasas.addAll(fileira);
          totalCasas.addAll(coluna);
          totalCasas.addAll(diagonal);
          
          return totalCasas;
    }
    
    /**
     * 
     * @param x
     * @param y
     * @return
     * @throws ArrayIndexOutOfBoundsException 
     */
    public Collection<Point> getCasasAcessiveisIndiretamente(int x, int y)
    {
          // Valida se está dentro dos limites
          if ( !validaLimites(x, y) ) {
              throw new ArrayIndexOutOfBoundsException("A casa desejada não existe");
          }
          
//          Cria uma fila de coordenadas com no máximo 8 elementos
          Collection<Point> lista = new ArrayList<>(8);
          
//          Guarda um par de coordenadas em um ponto
          Point p = new Point();
          
          // Obtém as casas em sentido anti-horário
          
          // acima e à esquerda
          int auxX = x + 2;
          int auxY = y - 1;
          
          if (validaLimites(auxX, auxY)){
              p.setLocation(auxX, auxY);
              lista.add(p);
          }
          
          auxX = x + 1;
          auxY = y - 2;
          
          if (validaLimites(auxX, auxY)){
              p.setLocation(auxX, auxY);
              lista.add(p);
          }
          
          // abaixo e à esquerda          
          auxX = x - 1;
          auxY = y - 2;
          
          if (validaLimites(auxX, auxY)){
              p.setLocation(auxX, auxY);
              lista.add(p);
          }
          
          auxX = x - 2;
          auxY = y - 1;
          
          if (validaLimites(auxX, auxY)){
              p.setLocation(auxX, auxY);
              lista.add(p);
          }
          
          // abaixo e à direita
          auxX = x - 2;
          auxY = y + 1;
          
          if (validaLimites(auxX, auxY)){
              p.setLocation(auxX, auxY);
              lista.add(p);
          }
          
          auxX = x - 1;
          auxY = y + 2;
          
          if (validaLimites(auxX, auxY)){
              p.setLocation(auxX, auxY);
              lista.add(p);
          }
          
          // acima e à direita
          auxX = x + 1;
          auxY = y + 2;
          
          if (validaLimites(auxX, auxY)){
              p.setLocation(auxX, auxY);
              lista.add(p);
          }
          
          auxX = x + 2;
          auxY = y + 1;
          
          if (validaLimites(auxX, auxY)){
              p.setLocation(auxX, auxY);
              lista.add(p);
          }            
                    
          return lista;
    }
    
    
    
    
    
            
//    public boolean isCasaVazia(int x, int y)
//            throws IllegalArgumentException
//    {
//        Point p = new Point(x, y);
//        
//        return mapa.get(p) == null;
//    }
    
//    public void setCasaVazia(int x, int y)
//            throws IllegalArgumentException
//    {
//        Point p = new Point(x, y);
//        
//        mapa.put(p, null);
//    }
    
//    public void removerPeca(int x, int y)
//            throws IllegalArgumentException
//    {
//        Point ponto = new Point(x, y);
//        
//        if ( !mapa.containsKey(ponto) ){
//            throw new IllegalArgumentException("Casa inválida.");
//        }
//        
//        Set<Point> set = mapa.keySet();
//        
//        for (Point p : set){
//            if ( p.equals(ponto) ){
//                mapa.put(p, null);
//            }
//        }
//    }
    
//    public void posicionarPeca(int x, int y, Peca o)
//            throws IllegalArgumentException
//    {
//        Point ponto = new Point(x, y);
//        
//        if ( !mapa.containsKey(ponto) || o == null ){
//            throw new IllegalArgumentException("Casa ou peça inexistentes.");
//        }
//        
//        Set<Casa> set = mapa.keySet();
//        
//        for (Casa p : set){
//            if ( p.equals(ponto) ){
//                mapa.replace(p, null, o);
//            }
//        }
//    }

    public final Map<Casa,Peca> getVisaoGeralTabuleiro() {
        return mapa;
    }
        
//    public Queue getJogadasPossiveis(Peca p)
//            throws NullPointerException
//    {
//        if (p == null){
//            throw new NullPointerException("Peça inexistente");
//        }
//        
//        int x = p.getX();
//        int y = p.getY();
//        Queue<Point> queue = new ArrayDeque<>(30);
//        
//        if (p instanceof Peao){
//            
//        } else if (p instanceof Bispo) {
//            
//        } if (p instanceof Cavalo) {
//             
//        } else if (p instanceof Dama) {
//            
//        } else if (p instanceof Torre) {
//            Queue<Point> fileira = tabuleiro.getCasasFileira(x, y);
//            Queue<Point> coluna = tabuleiro.getCasasColuna(x, y);
//            
//            int auxY = y - 1;
//            Point ponto = new Point(x, auxY);
//            
//            while ( fileira.contains(ponto) ) {                    
//                if ( ){
//                    queue.add(ponto);
//                }
//            }
//            
//            auxY = y + 1;
//            ponto.setLocation(x, auxY);
//            
//            while ( fileira.contains(ponto) ) {                    
//                if ( ){
//                    queue.add(ponto);
//                }
//            }
//            
//            int auxX = x; 
//            
//            
//                        
//            
//        } else if (p instanceof Rei){
//            
//        }
//        
//        return queue;
//    }

    

}

