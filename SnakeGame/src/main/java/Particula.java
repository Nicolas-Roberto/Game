import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
/**
 *
 * @author nicol
 */

public class Particula extends Rectangle{
    
    Color color;
    
    int speed = 0;
    
    int rotation = 0;
    
    int timer = 0;
    
    double xa, ya;
    double dx, dy;
    
    public Particula(int x, int y, int width, int height, Color color){
        super(x,y,width,height);
        
        xa = x;
        ya = y;
        
        this.color = color;
        
        dx = new Random().nextGaussian();
        dy = new Random().nextGaussian();
        
        speed = 8;
        
    }

    
    public void update(){
        
        xa+=dx*speed;
        ya+=dy*speed;
        
        timer++;
        
    }
    
    public void render(Graphics g){
        g.setColor(this.color);
        g.fillRect((int) xa, (int) ya, width, height);
    }

}
