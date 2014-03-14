import java.awt.*;
import java.applet.*;
import java.awt.event.*;


public class CircleDraw extends Applet implements ActionListener{
	Graphics2D g2d;
	public void actionPerformed(ActionEvent arg0) {
	
		
		
	}
	
	
    // circle center xi,yi and point on circle xf,yf  
    public void circle(Graphics g,int xi, int yi, int xf, int yf){  
        // calculate radius of circle
    	axis_transformation(g);
        int radius=(int)(Math.sqrt((xf-xi)*(xf-xi)+(yf-yi)*(yf-yi)));  
        g2d = (Graphics2D)g;
        int x1,x2,y1,y2;
        int d1 = 3 - (2 * radius);  
        int x = 0, i1=x1, i2=x2;  
      
        int y = radius;  
        boolean rov=true;  
      
        // for one eights, while x is not >= y  
        while (rov){  
            if (x>=y){rov=false;}  
            if (d1 < 0) { d1 = d1 + (4 * x) + 6; }  
            else{ d1 = d1 + 4 * (x - y) + 10; // (1)  
                y = y - 1;  
            }  
          
            // draw following circle points   
            setpix((x1+x),(y1+y),g);  
            setpix((x1+x),(y1-y),g);  
            setpix((x1-x),(y1+y),g);  
            setpix((x1-x),(y1-y),g);  
              
            setpix((x1+y),(y1+x),g);  
            setpix((x1+y),(y1-x),g);  
            setpix((x1-y),(y1+x),g);  
            setpix((x1-y),(y1-x),g);  
            x++;  
        }  
    }  

    public void setpix(int x, int y, int d, Graphics g) {
		//g.setColor(Farba);
		g.fillRect(x - (d/2), y - (d/2), d, d);
	}
    void axis_transformation(Graphics g)
    {
    	Graphics2D g2d = (Graphics2D)g;
    	g2d.setColor(Color.black);  

    // Transform the coordinate system
    	g2d.translate(center_x,center_y); 
    	g2d.scale(1.0,-1.0);

    // draw vertical line
    	g2d.drawLine(0,-center_y,0,center_y);

    // draw horizontal line
         	g2d.drawLine(-center_x,0,center_x,0);

    } // END

    
    
}
