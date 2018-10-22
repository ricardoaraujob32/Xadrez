/*
 * 
 * 
 * 
 */

package model;

/**
 * Esta classe representa uma peça dentro do jogo.
 * 
 * 
 * @author Ricardo de Araújo Balduino
 */
public abstract class Peca {
    
    /**
     *
     */
    protected Coordenada coord;
    
    /**
     *
     */
    protected int corJogador;
    
    /** 
     * A referência única que representa o tabuleiro 
     */
    protected Tabuleiro t;
    
    /**
     * Constrói uma peça para um determinado jogador
     */
    public Peca() {
        t = Tabuleiro.getInstancia();
    }

    /**
     *
     * @param x
     * @param y
     * @throws IllegalArgumentException
     */
    public void setCoord(int x, int y) throws IllegalArgumentException
    {
        if ( !t.validaLimites(x, y) ){
            throw new IllegalArgumentException("Tentou posicionar a peça fora do tabuleiro.");
        }
        
        coord.setX(x);
        coord.setY(y);
    }
    
    /**
     *
     * @param c
     * @throws IllegalArgumentException
     */
    public void setCoord(Coordenada c) throws IllegalArgumentException
    {
        setCoord( c.getX(), c.getY() );
    }

    /**
     *
     * @return
     */
    public Coordenada getCoord() {
        return coord;
    }

    public void setCorJogador(int corJogador){
        this.corJogador = corJogador;
    }
    
     public int getCorJogador(){
         return corJogador;
     }
     
    /**
     *
     * @return
     */
    public boolean isBranca(){
         return corJogador == Xadrez_Cores.BRANCA;
     }
     
    /**
     *
     * @return
     */
    public boolean isPreta(){
         return corJogador == Xadrez_Cores.PRETA;
     }
            
    /**
     * 
     * @param x
     * @param y 
     */
    public void movimentar(int x, int y) 
    {
        if ( validaMovimento(x, y) ){
            coord.setX(x);
            coord.setY(y);
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
