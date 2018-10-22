/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author ricardobalduino
 * @version 
 * @since 
 */
public class Rei extends PecaQuePodeFazerRoque {
    
    /**
     * 
     */
    private boolean emXeque;

    /**
     *
     * @param x
     * @param y
     * @param id_jogador
     */
    public Rei()
    {
        emXeque = false;
    }
        
    /**
     * 
     * @param b 
     */
    public void setEmXeque(boolean b){
        emXeque = b;
    }
    
    /**
     * 
     * @return 
     */
    public boolean isEmXeque(){
        return emXeque;
    }
    
    /**
     * 
     * @param x
     * @param y 
     */
    @Override
    public void movimentar(int x, int y)
    {
        if ( validaMovimento(x, y) ) {
            super.movimentar(x, y);

            if ( isPrimeiroMovimento() ) {
                setNaoEhPrimeiroMovimento();
                setNaoPodeFazerRoque();
            }
        }
    }
    
    /**
     *
     * @param x
     * @param y
     */
    @Override
    public void roque(int x, int y)
    {
        if ( validaRoque(x, y) ){
            coord.setY(y);
        }
    }

    /**
     * 
     * @param destX
     * @param destY
     * @return 
     */
    @Override
    public boolean validaMovimento(int destX, int destY) {
        if ( !t.validaLimites(destX, destY) ){
            return false;
        }
        
        int deslocX = calculaDeslocamento(destX, "x");
        int deslocY = calculaDeslocamento(destY, "y");
        
        return validaDeslocamento(deslocX, deslocY);
    }
    
    /**
     * 
     * @param destX
     * @param destY
     * @return 
     */
    public boolean validaRoque(int destX, int destY){
        boolean valido = true;
        
        if ( !t.validaLimites(destX, destY) ){
            valido = false;
//            throw new ArrayIndexOutOfBoundsException("Tentou movimentar para fora do tabuleiro.");
        }
        
        if ( !isPrimeiroMovimento() ){
            valido = false;
//            throw new JogadaIlegalException("Não é possível fazer o roque porque o rei já se moveu.");
        }
        
        if ( isEmXeque() ) {
            valido = false;
//            throw new JogadaIlegalException("Não é possível fazer o roque enquanto o rei estiver em xeque.");
        }
        
        if ( isBranca() && destX != Xadrez_Fileiras.PRIMEIRA ||
                isPreta() && destX != Xadrez_Fileiras.OITAVA){
            valido = false;
//            throw new JogadaIlegalException("Fileira inválida para o roque.");
        }
        
        if (destY != Xadrez_Colunas.C || destY != Xadrez_Colunas.G){
            valido = false;
//            throw new JogadaIlegalException("Coluna inválida para o roque.");
        }
        
        return valido;
    }

    /**
     * 
     * @return 
     */
    @Override
    public boolean podeFazerRoque() {
        return isPrimeiroMovimento() && !isEmXeque();
    }
 
    /**
     * 
     * @param n
     * @param dir
     * @return 
     */
    private int calculaDeslocamento(int n, String dir){
        return "x".equals(dir) ? n - coord.getX() : 
                    "y".equals(dir) ? n - coord.getY() : 0;
    }
    
    /**
     * 
     * @param deslocX
     * @param deslocY
     * @return 
     */
    private boolean validaDeslocamento(int deslocX, int deslocY){
        return deslocX <= 1 && deslocX >= -1 && deslocY <= 1 && deslocY >= -1;
    }
    
    private boolean validaDeslocRoque(int desloc){
        return desloc == 2 || desloc == -2;
    }
}