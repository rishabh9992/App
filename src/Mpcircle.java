import java.io.*;
import java.util.*;
import java.math.*;
import java.applet.*;
import java.awt.*;
public class Mpcircle extends Applet {

	
	public void paint (Graphics g)
	{
		int xc=0;
		int yc = 0;
		int radius= 150;
		int x=0, y=radius, p=1-radius;
		
		g.setColor(Color.red);
		plotpt(xc,yc,x,y);
	}
	void plotpt(int xc, int yc, int x, int y)
	{
		Graphics g;
		g.setPixel(xc-x,yc+y);
		
		
	}
}
