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
public class Sprite{
    private int move_x, move_y;
    public Sprite(){
        this.move_x = 0;
        this.move_y = 0;
    }
    
    public void move_up(){
        this.move_y -= 3;
    }
    
    public void move_right(){
        this.move_x += 3;
    }
    
    public void move_left(){
        this.move_x -= 3;
    }
    
    public void move_down(){
        this.move_y += 3;
    }
    
    public void pinta(Graphics g){
        g.setColor(Color.white);
        g.fillRect(this.move_x,this.move_y,30,30);
    }
}
