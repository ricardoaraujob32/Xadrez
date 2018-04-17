/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import model.Bispo;
import model.Cavalo;
import model.Dama;
import model.Peao;
import model.Rei;
import model.Torre;

/**
 *
 * @author ricardobalduino
 */
public class PecaFactory {
    
    /**
     *
     * @param x
     * @param y
     * @param id_jogador
     * @return
     * @throws IllegalArgumentException
     */
    public static Peao criarPeao(int x, int y, int id_jogador){
        return new Peao(x, y, id_jogador);
    }
    
    /**
     *
     * @param x
     * @param y
     * @param id_jogador
     * @return
     * @throws IllegalArgumentException
     */
    public static Bispo criarBispo(int x, int y, int id_jogador){
        return new Bispo(x, y, id_jogador);
    }
    
    /**
     *
     * @param x
     * @param y
     * @param id_jogador
     * @return
     * @throws IllegalArgumentException
     */
    public static Cavalo criarCavalo(int x, int y, int id_jogador){
        return new Cavalo(x, y, id_jogador);
    }
    
    /**
     *
     * @param x
     * @param y
     * @param id_jogador
     * @return
     * @throws IllegalArgumentException
     */
    public static Torre criarTorre(int x, int y, int id_jogador){
        return new Torre(x, y, id_jogador);
    }
    
    /**
     *
     * @param x
     * @param y
     * @param id_jogador
     * @return
     * @throws IllegalArgumentException
     */
    public static Dama criarDama(int x, int y, int id_jogador){
        return new Dama(x, y, id_jogador);
    }
    
    /**
     *
     * @param x
     * @param y
     * @param id_jogador
     * @return
     * @throws IllegalArgumentException 
     */
    public static Rei criarRei(int x, int y, int id_jogador){
        return new Rei(x, y, id_jogador);
    }
//    
//    public final Icon getImagem(int x, int y, Observable o)
//            throws IllegalArgumentException, NullPointerException
//    {
//        if (o == null) {
//            throw new NullPointerException("Não existe imagem para esse parâmetro");
//        }
//        
//        if (x < Xadrez_Constantes._1 || x > Xadrez_Constantes._8||
//                y < Xadrez_Constantes.A || y > Xadrez_Constantes.H ||
//                !(o instanceof Peca)) {
//            throw new IllegalArgumentException("Não existe imagem para esse parâmetro");
//        }
//        
//        final int PRETO = 0;
//        final int BRANCO = 1;
//        int cor;
//        
//        switch (x) {
//            case Xadrez_Constantes._1:
//            case Xadrez_Constantes._3:
//            case Xadrez_Constantes._5:
//            case Xadrez_Constantes._7:
//                if (y == Xadrez_Constantes.A || y == Xadrez_Constantes.C || y == Xadrez_Constantes.E || y == Xadrez_Constantes.G) {
//                    cor = BRANCO;
//                } else {
//                    cor = PRETO;
//                }
//                break;
//                
//            default:
//                if (y == Xadrez_Constantes.A || y == Xadrez_Constantes.C || y == Xadrez_Constantes.E || y == Xadrez_Constantes.G) {
//                    cor = PRETO;
//                } else {
//                    cor = BRANCO;
//                }
//        }
//        
//        Icon icone = null;
//        Peca peca = (Peca) o;
//        
//        if (peca instanceof Bispo) {
//            if (cor == PRETO) {
//            } else {
//            }
//        } else if (peca instanceof Cavalo) {
//            if (cor == PRETO) {
//            } else {
//            }
//        } else if (peca instanceof Dama) {
//            if (cor == PRETO) {
//            } else {
//            }
//        } else if (peca instanceof Peao) {
//            if (cor == PRETO) {
//            } else {
//            }
//        } else if (peca instanceof Rei) {
//            if (cor == PRETO) {
//            } else {
//            }
//        } else {
//            if (cor == PRETO) {
//            } else {
//            }
//        }
//        
//        return icone;
//    }    
}
