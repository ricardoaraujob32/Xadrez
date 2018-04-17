/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author ricardobalduino
 */
public class Rei extends PecaComPrimeiroMovimento implements IPodeFazerRoque {
    private boolean emXeque;

    /**
     *
     * @param x
     * @param y
     * @param id_jogador
     */
    public Rei(int x, int y, int id_jogador)
    {
        super(x, y, id_jogador);
        this.emXeque = false;
    }
            
    public void setEmXeque(boolean b){
        this.emXeque = b;
    }
    
    public boolean isEmXeque(){
        return emXeque;
    }
    
    @Override
    public void movimentar(int x, int y)
    {
        super.movimentar(x, y);
        
        if ( isPrimeiroMovimento() ){
            setNotPrimeiroMovimento();
        }
    }
    
    public void roque(int x, int y)
    {
        if ( validaRoque(x, y) ){
            setX(x);
            setY(y);
            
            if ( isPrimeiroMovimento() ){
                setNotPrimeiroMovimento();
            }
            
            setChanged();
        }
    }

    @Override
    public boolean validaMovimento(int destX, int destY) {
        boolean valido = true;
        
        if ( !t.validaLimites(destX, destY) ){
            valido = false;
//            throw new ArrayIndexOutOfBoundsException("Tentou movimentar para fora do tabuleiro.");
        }
        
        int deslocX = destX - x;
        int deslocY = destY - y;
        
        if (deslocX > 1 || deslocX < -1 || deslocY > 1 || deslocY < -1){
            valido = false;
//            throw new JogadaIlegalException("O rei só pode se mover uma casa por vez");
        }
        
        return valido;
    }
    
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
        
        if (ID_JOGADOR == Xadrez_Cores.BRANCA && destX != 0 ||
                ID_JOGADOR == Xadrez_Cores.PRETA && destX != 7){
            valido = false;
//            throw new JogadaIlegalException("Fileira inválida para o roque.");
        }
        
        if (destY != Xadrez_Colunas.C || destY != Xadrez_Colunas.G){
            valido = false;
//            throw new JogadaIlegalException("Coluna inválida para o roque.");
        }
        
        return valido;
    }

    @Override
    public void roque() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean podeFazerRoque() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}