package br.ifpr.jogo.modelo;

import javax.swing.ImageIcon;;

public class Tiro extends ElementoGrafico {

    private static final int VELOCIDADE = -2;

    public Tiro(int posicaoPersonagemEmX, int posicaoPersonagemEmY) {
        this.carregar();
        this.setPosicaoEmX(posicaoPersonagemEmX - (this.getAlturaImagem() / 2));
        this.setPosicaoEmY(posicaoPersonagemEmY);

    }
    

    public void carregar() {
        ImageIcon carregando = new ImageIcon("Recursos\\tiro_nave.png");
        this.setImagem(carregando.getImage());
        this.setAlturaImagem(carregando.getImage().getHeight(null));
        this.setLarguraImagem(carregando.getImage().getWidth(null));
    
    }
    public void carregarRaduken() {
        ImageIcon carregando = new ImageIcon("Recursos\\raduken.png");
        this.setImagem(carregando.getImage());
        this.setAlturaImagem(carregando.getImage().getHeight(null));
        this.setLarguraImagem(carregando.getImage().getWidth(null));
    }

    public void atualizar() {
        this.setPosicaoEmY(this.getPosicaoEmY() + VELOCIDADE);
    }

}
