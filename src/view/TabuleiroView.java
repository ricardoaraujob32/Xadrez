/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import controller.Xadrez_Constantes;
import controller.PecaFactory;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

/**
 *
 * @author ricardobalduino
 */
public class TabuleiroView implements Observer {
    private JFrame frmJanela;
    private JButton btnCasa[][];
    private JPanel painelTelaInicial;
    private JPanel painelTabuleiro;
    private Container container;
    private SwingWorker sw;

    public TabuleiroView(){
        frmJanela = new JFrame("Jogo de xadrez");
        container = frmJanela.getContentPane();
        
        frmJanela.setJMenuBar(initMenuBar());
        painelTelaInicial = initPainelTelaPrincipal();
        painelTabuleiro = initPainelTabuleiro();
        
        container.add(painelTelaInicial, BorderLayout.CENTER);
        frmJanela.setSize(600, 600);
        frmJanela.setVisible(true);
        frmJanela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args){
        new TabuleiroView();
    }
    
    private JMenuBar initMenuBar(){
        // cria a barra de menu
        JMenuBar menuBar = new JMenuBar();
        
        // cria o primeiro menu, seus botões e os tratadores de evento
        JMenu menuOpcoes = new JMenu("Opções");
        JMenuItem novaPartida = new JMenuItem("Nova partida");
        JMenuItem configuracoes = new JMenuItem("Configurações");
        JMenuItem sair = new JMenuItem("Sair");       
        ActionListener aclisNovaPartida;
        ActionListener aclisConfiguracoes;
        ActionListener aclisSair;
        
        
        
        
        novaPartida.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                container.remove(painelTelaInicial);
                container.add(painelTabuleiro, BorderLayout.CENTER);
                frmJanela.pack();
                frmJanela.setSize(600, 600);
                frmJanela.repaint();
            }
        });
        
        menuOpcoes.add(novaPartida);
        menuOpcoes.add(configuracoes);
        menuOpcoes.add(sair);
        
        // cria o segundo menu, seus botões e os tratadores de evento
        JMenu menuAjuda = new JMenu("Ajuda");
        JMenuItem ajuda = new JMenuItem("Ajuda");
        JMenuItem sobreJogo = new JMenuItem("Sobre o jogo");
        ActionListener aclisAjuda;
        ActionListener aclisSobreJogo;
        
        
        menuAjuda.add(ajuda);
        menuAjuda.add(sobreJogo);
        
        // adiciona os menus à barra de menu
        menuBar.add(menuOpcoes);
        menuBar.add(menuAjuda);
        
        return menuBar;
    }
    
    private JPanel initPainelTelaPrincipal(){
        JPanel telaInicial = new JPanel(new BorderLayout());
        telaInicial.setBackground(Color.BLACK);
        
        return telaInicial;
    }
    
    private JPanel initPainelTabuleiro(){        
        JPanel painel = new JPanel(new GridLayout(8, 8));
        
        Icon ico1 = new ImageIcon("C:\\Users\\ricardobalduino\\Desktop\\Projetos Java\\Xadrez\\Rei preto casa branca.gif");
        Icon ico2 = new ImageIcon("C:\\Users\\ricardobalduino\\Desktop\\Projetos Java\\Xadrez\\Rei preto casa preta.gif");
        Icon ico3 = new ImageIcon("C:\\Users\\ricardobalduino\\Desktop\\Projetos Java\\Xadrez\\Rei branco casa branca.gif");
        Icon ico4 = new ImageIcon("C:\\Users\\ricardobalduino\\Desktop\\Projetos Java\\Xadrez\\Rei branco casa preta.gif");
        
        btnCasa = new CasaView[8][8];
        
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                btnCasa[i][j] = new CasaView(i, j);
                btnCasa[i][j].setFocusable(false);
                //btnCasa[i][j].addActionListener(a);
                
                switch (i){
                    case Xadrez_Constantes._1:
                    case Xadrez_Constantes._3:
                    case Xadrez_Constantes._5:
                    case Xadrez_Constantes._7:
                        if (j == Xadrez_Constantes.A || j == Xadrez_Constantes.C ||
                                j == Xadrez_Constantes.E || j == Xadrez_Constantes.G){
                            btnCasa[i][j].setBackground(Color.BLACK);
                            btnCasa[i][j].setIcon(ico1);
                        } else {
                            btnCasa[i][j].setBackground(Color.WHITE);
                            btnCasa[i][j].setIcon(ico2);
                        }
                    break;
                        
                    default:
                        if (j == Xadrez_Constantes.A || j == Xadrez_Constantes.C ||
                                j == Xadrez_Constantes.E || j == Xadrez_Constantes.G){
                            btnCasa[i][j].setBackground(Color.WHITE);
                            btnCasa[i][j].setIcon(ico4);
                        } else {
                            btnCasa[i][j].setBackground(Color.BLACK);
                            btnCasa[i][j].setIcon(ico3);
                        }
                } // fim do switch
                
                painel.add(btnCasa[i][j]);
            }
        }
        
        return painel;
    }

    @Override
    public void update(Observable o, Object arg)
            throws NullPointerException
    {        
        if (o == null || arg == null){
            throw new NullPointerException("O parâmetro não pode ser nulo");
        }
        
        if (!(arg instanceof Map)){
            throw new IllegalArgumentException("Parâmetro inválido");
        }
        
        Map<Point, Observable> mapa = (HashMap<Point, Observable>) arg;        
        Set<Point> set = mapa.keySet();
        PecaFactory fabrica = PecaFactory.getInstancia();
        int x, y;
        
//        para cada casa do tabuleiro
        for (Point p : set) {
            x = (int) p.getX();
            y = (int) p.getY();
            
//            se a casa estiver vazia, retirar imagem; do contrário, colocar imagem
            if (mapa.get(p) == null){
                if (btnCasa[x][y].getIcon() != null){
                    btnCasa[x][y].setIcon(null);
                } 
            } else {
                btnCasa[x][y].setIcon( fabrica.getImagem(x, y, o) );
            }
        }
    }
    
    
    
    
    
}