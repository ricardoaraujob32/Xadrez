/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 * Esta classe representa um jogador em uma partida.
 * Há apenas dois jogadores em uma partida. Esta classe fornece acesso global para duas instâncias,
 * uma para cada jogador, que devem ser acessadas por seus respectivos métodos de acesso.
 * Esta classe fornece informações sobre os jogadores, como a quantidade de peças que eles têm, mas 
 * não contém referências para as peças. 
 * 
 * @author Ricardo de Araújo Balduino
 * @version 1.0
 * @since 1.0
 */
public class Jogador {       
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
    private int numReis;
    
    /**
     * Inicializa o jogador com o número apropriado de peças.
     */
    public Jogador()
    {        
        this.numPeoes = 8;
        this.numCavalos = 2;
        this.numBispos = 2;
        this.numTorres = 2;
        this.numDamas = 1;
        this.numReis = 1;
    }
         
    /**
     * Recebe o código de uma peça e decrementa o seu respectivo contador em uma unidade.
     * Este método deve ser usado quando uma peça for retirada do jogo; entretanto, não deve
     * ser usado diretamente quando um peão é promovido. Clientes devem usar o método promoverPeao,
     * que chamará este método
     * @param id_peca
     * @throws IllegalArgumentException 
     */
    public void perderPeca(int id_peca)
            throws IllegalArgumentException
    {
        switch (id_peca){
            case Xadrez_Pecas.BISPO:
                if (numBispos > 0)
                    numBispos--;
            break;
                
            case Xadrez_Pecas.CAVALO:
                if (numCavalos > 0)
                    numCavalos--;
            break;
                
            case Xadrez_Pecas.DAMA:
                if (numDamas > 0)
                    numDamas--;
            break;
                
            case Xadrez_Pecas.PEAO:
                if (numPeoes > 0)
                    numPeoes--;
            break;
                
            case Xadrez_Pecas.TORRE:
                if (numTorres > 0)
                    numTorres--;
            break;
                
            default:
                throw new IllegalArgumentException("Esta peça não existe.");
        }
    }
    
    /**
     * 
     * @param id_peca
     * @throws IllegalArgumentException 
     */
    public void promoverPeao(int id_peca)
            throws IllegalArgumentException
    {
        switch (id_peca){
            case Xadrez_Pecas.BISPO:
                numBispos++;
            break;
                
            case Xadrez_Pecas.CAVALO:
                numCavalos++;
            break;
                
            case Xadrez_Pecas.DAMA:
                numDamas++;
            break;
                
            case Xadrez_Pecas.TORRE:
                numTorres++;
            break;
                
            default:
                throw new IllegalArgumentException("Esta peça não existe.");
        }
        
        perderPeca( Xadrez_Pecas.PEAO );
    }
    
    /**
     * Quantos bispos este jogador tem
     * @return A quantidade de bispos
     */
    public int getNumBispos() {
        return numBispos;
    }

    /**
     * Quantos cavalos este jogador tem
     * @return A quantidade de cavalos
     */
    public int getNumCavalos() {
        return numCavalos;
    }

    /**
     * Quantas damas este jogador tem
     * @return A quantidade de damas
     */
    public int getNumDamas() {
        return numDamas;
    }

    /**
     * Quantos peões este jogador tem
     * @return A quantidade de peões
     */
    public int getNumPeoes() {
        return numPeoes;
    }

    /**
     * Quantas torres este jogador tem
     * @return A quantidade de torres
     */
    public int getNumTorres() {
        return numTorres;
    }

    /**
     * Quantos reis este jogador tem
     * @return A quantidade de reis
     */
    public int getNumReis() {
        return numReis;
    }

    /**
     * Quantas peças este jogador tem
     * @return A quantidade de peças
     */
    public int getNumPecas() {
        return numBispos + numCavalos + numDamas + numPeoes + numReis + numTorres;
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
}
