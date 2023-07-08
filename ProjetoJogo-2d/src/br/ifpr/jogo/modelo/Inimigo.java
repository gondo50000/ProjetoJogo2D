package br.ifpr.jogo.modelo;

import javax.swing.ImageIcon;

public class Inimigo extends ElementoGrafico {

    private static final int VELOCIDADE = 2;

    public Inimigo(int xAleatorio, int yAleatorio) {
        this.setPosicaoEmX(xAleatorio);
        this.setPosicaoEmY(yAleatorio);

    }

    public void carregar() {
        ImageIcon carregando = new ImageIcon("Recursos\\inimigo.png");
        this.setImagem(carregando.getImage());
        this.setAlturaImagem(carregando.getImage().getHeight(null));
        this.setLarguraImagem(carregando.getImage().getWidth(null));
    }

    public void atualizar() {
        this.setPosicaoEmY(this.getPosicaoEmY() + VELOCIDADE);
    }

}
