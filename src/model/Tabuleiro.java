/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
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
     * Quantos peões cada jogador tem.
     * Deve começar com 8.
     */
    private int numPeoes;
    
    /**
     * Quantos cavalos cada jogador tem.
     * Deve começar com 2.
     */
    private int numCavalos;
    
    /**
     * Quantos bispos cada jogador tem.
     * Deve começar com 2.
     */
    private int numBispos;
    
    /**
     * Quantas torres cada jogador tem.
     * Deve começar com 2.
     */
    private int numTorres;
    
    /**
     * Quantas damas cada jogador tem.
     * Deve começar com 1.
     */
    private int numDamas;
    
    /**
     * Quantos reis cada jogador tem.
     * Deve começar com 1.
     */
    private final int numReis;
    
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
    
    public Peao criaPeao(){
        return new Peao();
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
            throws NullPointerException
    {
        if (peca == null){
            throw new NullPointerException("Não há uma peça para remover");
        }
        
        Iterator<Casa> iterator = mapa.keySet().iterator();
        Coordenada coord = peca.getCoord();
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
            throws NullPointerException, JogadaIlegalException
    {
        if (pecaNova == null || posNova == null){
            throw new IllegalArgumentException("Não é possível movimentar a peça");
        }
        
        Iterator<Casa> iterator = mapa.keySet().iterator();
        Coordenada posAtual = pecaNova.getCoord();
        Casa c;
        
        while ( iterator.hasNext() ) {
            c = iterator.next();
            
            if ( posNova.equals( c.getCoordenada() ) ){
                Peca pecaCapturada = mapa.get(c);
                
                if (pecaCapturada == null){
                    mapa.put(c, pecaNova);
                } else {
                    if ( pecaCapturada.getCorJogador() == pecaNova.getCorJogador() ){
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
        
        Peca peca = null;
        
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
    
    /**
     * Quantos bispos este jogador tem
     * @return A quantidade de bispos
     */
    public int getNumBispos(int cor) {
        Iterator<Peca> iterator = mapa.values().iterator();
        Peca p;
        int cont = 0;
        
        while ( iterator.hasNext() ) {
            if( ( p = iterator.next() ) instanceof Bispo && p.getCorJogador() == cor ){
                cont++;
            }
        }
        
        return cont;
    }

    /**
     * Quantos cavalos este jogador tem
     * @return A quantidade de cavalos
     */
    public int getNumCavalos(int cor) {
        Iterator<Peca> iterator = mapa.values().iterator();
        Peca p;
        int cont = 0;
        
        while ( iterator.hasNext() ) {
            if( ( p = iterator.next() ) instanceof Cavalo && p.getCorJogador() == cor ){
                cont++;
            }
        }
        
        return cont;
    }

    /**
     * Quantas damas este jogador tem
     * @return A quantidade de damas
     */
    public int getNumDamas(int cor) {
        Iterator<Peca> iterator = mapa.values().iterator();
        Peca p;
        int cont = 0;
        
        while ( iterator.hasNext() ) {
            if( ( p = iterator.next() ) instanceof Dama && p.getCorJogador() == cor ){
                cont++;
            }
        }
        
        return cont;
    }

    /**
     * Quantos peões este jogador tem
     * @return A quantidade de peões
     */
    public int getNumPeoes(int cor) {
        Iterator<Peca> iterator = mapa.values().iterator();
        Peca p;
        int cont = 0;
        
        while ( iterator.hasNext() ) {
            if( ( p = iterator.next() ) instanceof Peao && p.getCorJogador() == cor ){
                cont++;
            }
        }
        
        return cont;
    }

    /**
     * Quantas torres este jogador tem
     * @return A quantidade de torres
     */
    public int getNumTorres(int cor) {
        Iterator<Peca> iterator = mapa.values().iterator();
        Peca p;
        int cont = 0;
        
        while ( iterator.hasNext() ) {
            if( ( p = iterator.next() ) instanceof Torre && p.getCorJogador() == cor ){
                cont++;
            }
        }
        
        return cont;
    }

    /**
     * Quantos reis este jogador tem
     * @return A quantidade de reis
     */
    public int getNumReis(int cor) {        
        return 1;
    }

    /**
     * Quantas peças este jogador tem
     * @return A quantidade de peças
     */
    public int getNumPecas(int cor) {
        Iterator<Peca> iterator = mapa.values().iterator();
        int cont = 0;
        
        while ( iterator.hasNext() ) {
            if( iterator.next().getCorJogador() == cor ){
                cont++;
            }
        }
        
        return cont;
    }
    
    /**
     * Verifica se este jogador tem peças suficientes para continuar jogando.
     * Este método pode ser usado para verificar condições de empate por falta de material.
     * Além disso, se este jogador não tem material suficiente, mas o outro tem, é um indicativo
     * de que será derrotado em breve ou de que deveria desistir da partida.
     * 
     * @return true se este jogador tem material suficiente, do contrário false.
     */
    public boolean temPecasSuficientes(){
        return (numPeoes > 0) ||
               (numDamas > 0) ||
               (numTorres > 0) ||
               ( numCavalos > 0 && numBispos > 0 );
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

