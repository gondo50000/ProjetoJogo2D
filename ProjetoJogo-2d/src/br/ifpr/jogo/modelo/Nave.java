package br.ifpr.jogo.modelo;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Nave extends ElementoGrafico {

    private int deloscamentoEmX;
    private int deslocamentoEmY;
    private ArrayList<Tiro> tiros;
    private ArrayList<Tiro> tiroEspecial;

    private static final int DESLOCAMENTO = 3;
    private static final int POSICAO_INICIAL_EM_X = 500;
    private static final int POSICAO_INICIAL_EM_Y = 500;

    public Nave() {
        this.setPosicaoEmX(POSICAO_INICIAL_EM_X);
        this.setPosicaoEmY(POSICAO_INICIAL_EM_Y);
        this.tiros = new ArrayList<Tiro>();
        this.tiroEspecial = new ArrayList<Tiro>();
    }

    public void carregar() {
        ImageIcon carregando = new ImageIcon("Recursos\\Imagem_nave.png");
        this.setImagem(carregando.getImage());
        this.setAlturaImagem(carregando.getImage().getHeight(null));
        this.setLarguraImagem(carregando.getImage().getWidth(null));
    }

    public void atualizar() {
        this.setPosicaoEmX(this.getPosicaoEmX() + deloscamentoEmX);
        this.setPosicaoEmY(this.getPosicaoEmY() + deslocamentoEmY);
    }

    public void atirar() {
        int meioDanave = this.getPosicaoEmY();
        int frenteDaNave = this.getPosicaoEmX() + (this.getLarguraImagem() / 2);
        Tiro tiro = new Tiro(frenteDaNave, meioDanave);
        this.tiros.add(tiro);
    }

     public void carregarRaduken() {
        int meioDanave = this.getPosicaoEmY();
        int frenteDaNave = this.getPosicaoEmX() + (this.getLarguraImagem() / 2);
        Tiro tiro2 = new Tiro(frenteDaNave, meioDanave);
        this.tiroEspecial.add(tiro2);
    }

    public void mover(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();
        switch (codigo) {
            case KeyEvent.VK_UP:
                this.deslocamentoEmY = -DESLOCAMENTO;
                break;
            case KeyEvent.VK_DOWN:
                this.deslocamentoEmY = DESLOCAMENTO;
                break;
            case KeyEvent.VK_LEFT:
                this.deloscamentoEmX = -DESLOCAMENTO;
                break;
            case KeyEvent.VK_RIGHT:
                this.deloscamentoEmX = DESLOCAMENTO;
                break;
            case KeyEvent.VK_W:
                this.deslocamentoEmY = -DESLOCAMENTO;
                break;
            case KeyEvent.VK_S:
                this.deslocamentoEmY = DESLOCAMENTO;
                break;
            case KeyEvent.VK_D:
                this.deloscamentoEmX = DESLOCAMENTO;
                break;
            case KeyEvent.VK_A:
                this.deloscamentoEmX = -DESLOCAMENTO;
                break;

            default:
                break;
        }
    }

    public void parar(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();
        switch (codigo) {
            case KeyEvent.VK_UP:
                deslocamentoEmY = 0;
                break;
            case KeyEvent.VK_DOWN:
                deslocamentoEmY = 0;
                break;
            case KeyEvent.VK_LEFT:
                deloscamentoEmX = 0;
                break;
            case KeyEvent.VK_RIGHT:
                deloscamentoEmX = 0;
                break;
            case KeyEvent.VK_W:
                deslocamentoEmY = 0;
                break;
            case KeyEvent.VK_S:
                deslocamentoEmY = 0;
                break;
            case KeyEvent.VK_D:
                deloscamentoEmX = 0;
                break;
            case KeyEvent.VK_A:
                deloscamentoEmX = 0;
                break;

            default:
                break;

        }
    }

    public int getdeloscamentoEmX() {
        return this.deloscamentoEmX;
    }

    public void setdeloscamentoEmX(int deloscamentoEmX) {
        this.deloscamentoEmX = deloscamentoEmX;
    }

    public int getDeslocamentoEmY() {
        return this.deslocamentoEmY;
    }

    public void setDeslocamentoEmY(int DeslocamentoEmY) {
        this.deslocamentoEmY = DeslocamentoEmY;
    }

    public ArrayList<Tiro> getTiros() {
        return this.tiros;
    }

    public void setTiros(ArrayList<Tiro> tiros) {
        this.tiros = tiros;
    }

    public ArrayList<Tiro> getTirosEspecial() {
        return this.tiroEspecial;
    }

    public void setTirosEspecial(ArrayList<Tiro> tiros) {
        this.tiros = tiroEspecial;
    }

}
