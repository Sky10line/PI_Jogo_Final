/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PI_Jogo_Final;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics; //eh necessário para conseguir alterar o método paint
import java.awt.Color; //eh necessário para conseguir alterar o método paint
import java.awt.Font;
/**
 *
 * @author rodrigoaoki
 */
public class render extends JFrame{
    public render(int x, int y){
        super("PI"); //inicia uma variavel como sendo a tela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set do botao "x" para fechar a tela que abre
        //this.setLocationRelativeTo(null);//set para que a posição da janela seja no meio
        this.setSize(x, y); //set de tamanho da tela
        this.setResizable(false);
    }
    
    public void add_panel(){
        JPanel painel = new JPanel();
        this.add(painel);
        painel.setBackground(Color.white);
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.black);
        
        g.fillOval(150, 200, 200, 40); g.setColor(Color.red);
        g.fillOval(100, 80, 150, 150); g.setColor(Color.pink);
        g.fillOval(120, 105, 30, 30); g.setColor(Color.blue);
        g.setFont(new Font("Arial Bold", Font.PLAIN, 36)); g.drawString("Projeto Integrador III", 30, 450);
}

}
