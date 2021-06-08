
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;



public class Game extends Canvas implements Runnable,MouseListener{
    
    public static final int WIDTH = 480, HEIGHT = 480;
    
    public static int vida = 100;
    
    public static int pontuacao = 0;
    
    public static int mx, my;
    public static boolean clicado = false;
    
    public Spawner spawner;
    
    public boolean gameOver = false;
    
    public Game(){
        Dimension dimension = new Dimension(WIDTH,HEIGHT);
        this.setPreferredSize(dimension);
        this.addMouseListener(this);
        
        spawner = new Spawner();
    }
    
    public void update(){
        
   
        if(vida<=0){
            gameOver = true;
        }else{
            spawner.update();
        }
        
    }
    
    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        if(gameOver == false){
            g.setColor(Color.white);

            g.setFont(new Font ("Arial",Font.BOLD,23));

            g.drawString("Pontos: "+ Game.pontuacao, WIDTH/2 - 220, 30);


            g.setColor(Color.red);
            g.fillRect(Game.WIDTH/2 - 100, 20, vida*3, 20);
            g.setColor(Color.white);
            g.drawRect(Game.WIDTH/2 - 100, 20, 300, 20);


            spawner.render(g);
        }else{
            g.setColor(Color.white);
            g.setFont(new Font ("Arial",Font.BOLD,23));
            g.drawString("Game Over", WIDTH/2 - 80, HEIGHT/2 - 80);
            g.drawString("Pontuação: "+ pontuacao, WIDTH/2 - 80, HEIGHT/2 - 50);
            //g.drawString("Press Enter", WIDTH/2 - 100, HEIGHT/2 + 10);




            
        }
        
        bs.show();
        
    }

    
    public static void main(String [] args){
        Game game = new Game();
        JFrame jframe = new JFrame("Game");
        jframe.add(game);
        jframe.pack();
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLocationRelativeTo(null);

        
        jframe.setVisible(true);
        
        new Thread(game).start();
        
    }
    
    @Override
    public void run() {
        
        while(true){
            
            update();
            render();
            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        clicado = true;
        mx = e.getX();
        my = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}