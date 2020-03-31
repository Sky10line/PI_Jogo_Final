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
    public render(){
        super("PI"); //inicia uma variavel como sendo a tela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set do botao "x" para fechar a tela que abre
        this.setExtendedState(MAXIMIZED_BOTH); //extende toda a tela
        this.setBackground(Color.black);
        this.setUndecorated(true); //Desaparece a barra superior
    }
    
    public void add_panel(){
        JPanel painel = new JPanel();
        this.add(painel);
        painel.setBackground(Color.black);
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(550, 150, 800, 700); 
        
}

}
