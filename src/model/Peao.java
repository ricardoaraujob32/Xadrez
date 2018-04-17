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
public class Peao extends PecaComPrimeiroMovimento {
    /**
     * 
     */
    private boolean andouDuasCasas;

    /**
     *
     * @param x
     * @param y
     * @param id_jogador
     */
    public Peao(int x, int y, int id_jogador)
    {
        super(x, y, id_jogador);
        this.andouDuasCasas = false;
    }

    /**
     *
     */
    public void setAndouDuasCasas(){
        this.andouDuasCasas = true;
    }
    
    /**
     *
     * @return
     */
    public boolean andouDuasCasas(){
        return this.andouDuasCasas;
    }

//    @Override
//    public void movimentar(int x, int y) 
//            throws ArrayIndexOutOfBoundsException, JogadaIlegalException
//    {
//       super.movimentar(x, y);
//       
//       //        se é o primeiro movimento
//       if ( primeiroMovimento ){
//           setNotPrimeiroMovimento();
//           
////            se andou duas casas
//           if (desloc == 2){
//               setAndouDuasCasas();
//           }
//       }
//    }

    public boolean validaCaptura(int x, int y) 
    {
       boolean valido = true;
        
       // se a peça tentar se mover para fora do tabuleiro
       if ( !t.validaLimites(x, y) ){
           valido = false;
//           throw new ArrayIndexOutOfBoundsException("Tentou movimentar a peça para fora do tabuleiro.");
       }
       
       // se o peão tentar se movimentar para trás
       if (ID_JOGADOR == Xadrez_Cores.BRANCA && x < this.x ||
               ID_JOGADOR == Xadrez_Cores.PRETA && x > this.x){
           valido = false;
//           throw new JogadaIlegalException("Um peão não pode capturar para trás.");
       }
       
       int deslocX, deslocY;
       
       if (ID_JOGADOR == Xadrez_Cores.BRANCA){
           deslocX = x - this.x;
       } else {
           deslocX = this.x - x;
       }
       
       deslocY = y - this.y;
       
       if (deslocX != 1 || deslocY != 1 || deslocY != -1){
           valido = false;
//           throw new JogadaIlegalException("Um peão só pode capturar uma peça adjacente em diagonal.");
       }
       
       return valido;
       
               
    }
    
    public void capturar(int x, int y){
        if ( validaCaptura(x, y) ){
            setX(x);
            setY(y);
            
//             se é o primeiro movimento
            if ( isPrimeiroMovimento() ){
                setNotPrimeiroMovimento();
            }
       
//        anuncia a mudança para os observadores
            setChanged();
        }
    }

    @Override
    public boolean validaMovimento(int destX, int destY) {
        boolean valido = true;

//        se a peça tentar se mover para fora do tabuleiro
       if (!t.validaLimites(destX, destY)){
           valido = false;
//           throw new ArrayIndexOutOfBoundsException("Tentou movimentar a peça para fora do tabuleiro.");
       }
              
//        se o peão tentar mudar de coluna
       if (destY != y){
           valido = false;
//           throw new JogadaIlegalException("Um peão deve se mover na mesma coluna em que começou.");
       }
       
//        se o peão tentar se movimentar para trás
       if (ID_JOGADOR == Xadrez_Cores.BRANCA && destX < x ||
               ID_JOGADOR == Xadrez_Cores.PRETA && destX > x){
           valido = false;
//           throw new JogadaIlegalException("Um peão não pode se mover para trás.");
       }      
       
       int desloc;
       
       if (ID_JOGADOR == Xadrez_Cores.BRANCA){
           desloc = destX - x;
       } else {
           desloc = x - destX;
       }
       
//        se o deslocamento for maior do que o permitido
       if (desloc != 1 || desloc != 2){
           valido = false;
//           throw new JogadaIlegalException("Um peão não pode andar mais do que 2 casas.");
       } else if ( desloc == 2 && !isPrimeiroMovimento() ){
           valido = false;
//           throw new JogadaIlegalException("Um peão só pode andar 2 casas no primeiro movimento.");
       }
       
       return valido;
    }
}