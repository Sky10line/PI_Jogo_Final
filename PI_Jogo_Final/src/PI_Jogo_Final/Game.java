/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PI_Jogo_Final;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import java.awt.Toolkit;
/**
 *
 * @author rodrigoaoki
 */
public class Game extends Canvas{
    private BufferStrategy strategy;
    private boolean game_activated = true; //Game loop ativado
    
    //teclas
    private boolean waitingForKeyPress = true;
    private boolean right_key = false;
    private boolean left_key = false;
    private boolean up_key = false;
    private boolean down_key = false;
    
    private int width;
    private int height;
    
    public Game(){
        //pega as medidas da tela
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        final Dimension scrnsize = toolkit.getScreenSize();
        this.width = (int)scrnsize.getWidth();
        this.height = (int)scrnsize.getHeight();
        
        JFrame screen = new JFrame("Jogo Final"); //Cria o JFrame
        screen.setExtendedState(MAXIMIZED_BOTH); //Extende a tela
        screen.setUndecorated(true); //Tira a barra e efetivamente extende a tela

        JPanel painel = (JPanel) screen.getContentPane();//Cria o JPanel e adiciona no frame
	painel.setPreferredSize(new Dimension(width, height));
	painel.setLayout(null);
        
        setBounds(0,0,width,height);
	painel.add(this); //Adiciona o canvas no panel
        
        setIgnoreRepaint(true); //Faz o AWT não repintar o Canvas
        
        //faz a tela aparecer
        screen.pack();
	screen.setResizable(false);
	screen.setVisible(true);
        
        addKeyListener(new KeyInputHandler());
		
	
	requestFocus(); //faz com que os eventos sejam levados a nós

	
	createBufferStrategy(2); //Cria uma estrátegia de desenhar em 2 quadros
                
	strategy = getBufferStrategy(); // atribui a estratégia a uma variavel
        
    }
    public void gameLoop() {
        long lastLoopTime = System.currentTimeMillis();
        Sprite teste = new Sprite();
        while (game_activated) {
            long delta = System.currentTimeMillis() - lastLoopTime;
            lastLoopTime = System.currentTimeMillis();
			
            Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
            g.setColor(Color.black);
            g.fillRect(0,0, width,height);
            
            if(up_key == true){
                teste.move_up();
            }
            if(right_key == true){
                teste.move_right();
            }
            if(left_key == true){
                teste.move_left();
            }
            if(down_key == true){
                teste.move_down();
            }
            
            teste.pinta(g);
            
            g.dispose();
            strategy.show();
        }
    }
    
    
    //classe que lê as teclas pressionadas
    private class KeyInputHandler extends KeyAdapter {
		/** The number of key presses we've had while waiting for an "any key" press */
		private int pressCount = 1;
		
		/**
		 * Notification from AWT that a key has been pressed. Note that
		 * a key being pressed is equal to being pushed down but *NOT*
		 * released. Thats where keyTyped() comes in.
		 *
		 * @param e The details of the key that was pressed 
		 */
		public void keyPressed(KeyEvent e) {
			// if we're waiting for an "any key" typed then we don't 
			// want to do anything with just a "press"
//			if (waitingForKeyPress) {
//				return;
//			}
//			
//			
			if (e.getKeyCode() == KeyEvent.VK_W) {
                            up_key = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_D) {
                            right_key = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_A) {
                            left_key = true;
			}
                        if(e.getKeyCode() == KeyEvent.VK_S){
                            down_key = true;
                        }
		} 
		
		/**
		 * Notification from AWT that a key has been released.
		 *
		 * @param e The details of the key that was released 
		 */
		public void keyReleased(KeyEvent e) {
			// if we're waiting for an "any key" typed then we don't 
			// want to do anything with just a "released"
//			if (waitingForKeyPress) {
//				return;
//			}
//			
			if (e.getKeyCode() == KeyEvent.VK_W) {
                            up_key = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_D) {
                            right_key = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_A) {
                            left_key = false;
			}
                        if(e.getKeyCode() == KeyEvent.VK_S){
                            down_key = false;
                        }
		}

		/**
		 * Notification from AWT that a key has been typed. Note that
		 * typing a key means to both press and then release it.
		 *
		 * @param e The details of the key that was typed. 
		 */
		public void keyTyped(KeyEvent e) {
			// if we're waiting for a "any key" type then
			// check if we've recieved any recently. We may
			// have had a keyType() event from the user releasing
			// the shoot or move keys, hence the use of the "pressCount"
			// counter.
//			if (waitingForKeyPress) {
//				if (pressCount == 1) {
//					// since we've now recieved our key typed
//					// event we can mark it as such and start 
//					// our new game
//					waitingForKeyPress = false;
//					startGame();
//					pressCount = 0;
//				} else {
//					pressCount++;
//				}
//			}
//			
//			// if we hit escape, then quit the game
//			if (e.getKeyChar() == 27) {
//				System.exit(0);
//			}
		}
	}
}
    