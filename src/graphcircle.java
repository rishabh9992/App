import java.io.*;
import java.awt.*;
import java.applet.*;
import java.util.*;
public class graphcircle extends Applet{
    public void paint(Graphics g){
        int x = 0,j = 50,y = 1000,r = 1,dt = 0,ds = 0,di = 0;
        dt = ((x + 1)*(x + 1)) +  ((y)*(y)) - (r * r);
        ds = ((x + 1)*(x + 1)) +  ((y - 1)*(y - 1)) - (r * r);
        di = dt + ds;
        while(j >= 0){
            x++;
            if( di < 0 ){
                di = di + (4*x) + 6;
            }else{
                y--;
                di = di + ((x - y)*4) + 10;
            }
            System.out.println(di);
            System.out.println(x);
            System.out.println(y);
            j--;
            g.fillOval(x+100,y+100,5,5);
        }
    }
    
    public void init() 
    {
    	app_width=getSize().width;
     	app_height=getSize().height;
    	center_x=app_width/2;
    	center_y=app_height/2;
	setBackground(Color.white);
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

}	// END class	
}
/*
<applet code = "circle.class" CodeBase="" width = 500 height = 500></applet>
*/