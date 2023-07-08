package br.ifpr.jogo.principal;
import javax.swing.JFrame;
import br.ifpr.jogo.modelo.FaseUm;

public class Principal extends JFrame {
    public Principal(){
        FaseUm fase = new FaseUm();
        super.add(fase);
        super.setVisible(true);
        super.setSize(1000, 1000);
        super.setTitle("Meu jogo");
        super.setLocationRelativeTo(null);
        
    }
    public static void main(String[] args) {

        Principal principal = new Principal();
        
    }
    
}
