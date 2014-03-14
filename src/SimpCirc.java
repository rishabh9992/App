import java.io.*;
import java.util.*;
import java.math.*;
import java.applet.*;
import java.awt.*;
public class SimpCirc extends Applet{
	public void paint(Graphics g)
	{
		int i;
		g.drawLine(512,0,512,768);
		g.drawLine(0,384,1024,384);
		long s,e,time;
		float x,y,xc=-23,yc=-45;
		int r=250;
		xc=xc+512;
		yc=384-yc;
		
		s=System.currentTimeMillis();
		for(i=0;i<360;i++)
		{
			y=(float)(yc+r*Math.sin((Math.PI*i)/180));
			x=(float)(xc+r*Math.cos((Math.PI*i)/180));
			g.fillOval((int)x,(int)y,3,3);
			
			
		}
		e=System.currentTimeMillis();
		time=e-s;
	System.out.println("TimeTaken"+time+"msec");	
	}
}

/*
<applet code ="SimpCirc" width=400 height=400>
</applet>
*/