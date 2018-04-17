/*
 * 
 * 
 * 
 */

package model;

import java.util.Observable;

/**
 * Esta classe representa uma peça dentro do jogo.
 * 
 * 
 * @author Ricardo de Araújo Balduino
 */
public abstract class Peca extends Observable {
    
    /** 
     * A fileira atual 
     */
    
    protected int x;
    
    /** 
     * A coluna atual 
     */
    
    protected int y;
    
    /** 
     * O código que representa a qual jogador esta peça pertence 
     */
    
    public final int ID_JOGADOR;
    
    /** 
     * A referência única que representa o tabuleiro 
     */
    
    protected Tabuleiro t;
    
    /**
     * Constrói uma peça para um determinado jogador
     * 
     * @param x
     * @param y
     * @param id_jogador o jogador a quem esta peça pertence. Deve ser um dos seguintes valores:
     *                   (Xadrez_Cores.BRANCA, Xadrez_Cores.PRETA)
     * @see Xadrez_Cores                  
     * @throws IllegalArgumentException se o código do jogador não for válido
     * 
     */

    public Peca(int x, int y, int id_jogador)
    {               
        if (id_jogador != Xadrez_Cores.BRANCA && id_jogador != Xadrez_Cores.PRETA){
            throw new IllegalArgumentException("Jogador inválido.");
        }
        
        this.t = Tabuleiro.getInstancia();
        
        if ( !t.validaLimites(x, y) ){
            throw new IllegalArgumentException("Tentou posicionar a peça fora do tabuleiro.");
        }       
        
        this.x = x;
        this.y = y;
        this.ID_JOGADOR = id_jogador;
    }

    /**
     * Configura a fileira atual
     * @param x a nova fileira
     */
    
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Configura a coluna atual
     * @param y a nova coluna
     */
    
    public void setY(int y) {
        this.y = y;
    }
    
    /**
     * 
     * @return 
     */
    
    public int getX() {
        return x;
    }

    /**
     * 
     * @return 
     */
    
    public int getY() {
        return y;
    }
        
    /**
     * 
     * @param x
     * @param y 
     */
    
    public void movimentar(int x, int y) 
    {
        if ( validaMovimento(x, y) ){
            setX(x);
            setY(y);
            setChanged();
        }
    }
    
    /**
     * Valida o movimento de uma peça.
     * Deve ser implementado por subclasses para garantir que a movimentação da peça seja adequada
     * 
     * @param x a fileira para a qual se pretende mover a peça
     * @param y a coluna para a qual se pretende mover a peça
     * @return true se o movimento for válido, do contrário false
     */
    
    public abstract boolean validaMovimento(int x, int y);
}
