package br.ifpr.jogo.modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class FaseUm extends JPanel implements ActionListener, KeyListener, IFase {
    private Image imagemFundo;
    private Nave nave;
    private Timer timer;
    protected boolean emJogo = true;
    private static final int DELAY = 5;
    private static final int LARGURA_DA_JANELA = 940;
    private ArrayList<Inimigo> inimigos;
    private static final int QTDE_DE_INIMIGOS = 100;

    public FaseUm() {
        setFocusable(true);
        setDoubleBuffered(true);
        ImageIcon carregando = new ImageIcon("Recursos\\Espaco_fundo.jpg");
        imagemFundo = carregando.getImage();
        nave = new Nave();
        nave.carregar();
        this.inicializaInimigos();
        addKeyListener(this);
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void inicializaInimigos() {
        inimigos = new ArrayList<Inimigo>();
        for (int i = 0; i < QTDE_DE_INIMIGOS; i++) {
            int x = (int) (Math.random() * LARGURA_DA_JANELA);
            int y = (int) (Math.random() * -7000);
            Inimigo inimigo = new Inimigo(x, y);
            inimigos.add(inimigo);
        }
    }

    public void paint(Graphics g) {
        Graphics2D graficos = (Graphics2D) g;
        if(emJogo){
            graficos.drawImage(imagemFundo, 0, 0, null);
            graficos.drawImage(nave.getImagem(), nave.getPosicaoEmX(), nave.getPosicaoEmY(), this);
            ArrayList<Tiro> tiros = nave.getTiros();
            ArrayList<Tiro> tiro2 = nave.getTiros();
            for (Tiro tiro : tiros) {
                tiro.carregar();
                graficos.drawImage(tiro.getImagem(), tiro.getPosicaoEmX(), tiro.getPosicaoEmY(), this);
            }
            for (Tiro tiro : tiro2) {
                tiro.carregarRaduken();
                graficos.drawImage(tiro.getImagem(), tiro.getPosicaoEmX(), tiro.getPosicaoEmY(), this);
            }
            for (Inimigo inimigo : inimigos) {
                inimigo.carregar();
                graficos.drawImage(inimigo.getImagem(), inimigo.getPosicaoEmX(), inimigo.getPosicaoEmY(), this);
            }
        }
            
        else{
            ImageIcon gameOver = new ImageIcon("Recursos\\GameOver.png");
            graficos.drawImage(gameOver.getImage(), 0, 0, null);
            }
        
        g.dispose();
        }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
            nave.atirar();
        
        if(e.getKeyCode() == KeyEvent.VK_Q)
            nave.carregarRaduken();
        
        else
            nave.mover(e);
    }


    @Override
    public void keyReleased(KeyEvent e) {
        nave.parar(e);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        nave.atualizar();
        ArrayList<Tiro> tiros = nave.getTiros();
        for (int i = 0; i < tiros.size(); i++) {
            Tiro tiro = tiros.get(i);
       if (tiro.getPosicaoEmX() > LARGURA_DA_JANELA || !tiro.getEhVisivel())
           tiros.remove(tiro);
        else
            tiro.atualizar();
        }
        ArrayList<Tiro> tiros2 = nave.getTiros();
        for (int i = 0; i < tiros.size(); i++) {
            Tiro tiro2 = tiros.get(i);
       if (tiro2.getPosicaoEmX() > LARGURA_DA_JANELA || !tiro2.getEhVisivel())
           tiros.remove(tiro2);
        else
            tiro2.atualizar();
        }
        for (int i = 0; i < this.inimigos.size(); i++) {
            Inimigo inimigo = this.inimigos.get(i);
        if (inimigo.getPosicaoEmX() < 0 || !inimigo.getEhVisivel())
            inimigos.remove(inimigo);
        else
            inimigo.atualizar();
    }
        this.verificarColisoes();
    repaint();
}

    public void verificarColisoes(){
        Rectangle formaPersonagem = this.nave.getRectangle();
    for (int i = 0; i < this.inimigos.size(); i++) {
        Inimigo inimigo = inimigos.get(i);
        Rectangle formaInimigo = inimigo.getRectangle();
        if (formaInimigo.intersects(formaPersonagem)) {
            this.nave.setEhVisivel(false);
            inimigo.setEhVisivel(false);
            emJogo = false;
        }
        ArrayList<Tiro> tiros = this.nave.getTiros();
        for (int j = 0; j < tiros.size(); j++) {
            Tiro tiro = tiros.get(j);
            Rectangle formaTiro = tiro.getRectangle();
            if (formaInimigo.intersects(formaTiro)) {
                inimigo.setEhVisivel(false);
                tiro.setEhVisivel(false);
                }
            }
    
        }
    }

}

