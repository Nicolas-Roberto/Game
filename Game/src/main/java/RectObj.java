import java.awt.Color;
import java.awt.Rectangle;
import java.util.Random;
/**
 *
 * @author nicol
 */

public class RectObj extends Rectangle{
    
    Color color;
    
    int speed = 0;
    
    int rotation = 0;
    
    public RectObj(int x, int y, int width, int height){
        super(x,y,width,height);
        
        color = new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255));
        
        speed = new Random().nextInt(6-4)+4;
        
    }


    
    public void update(){
        
        x+=speed;
        rotation++;
        if(rotation >= 360){
            rotation = 0;
        }
        
    }

}

