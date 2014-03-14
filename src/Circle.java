import java.io.*;
import java.util.*;
import java.math.*;
import java.applet.*;
import java.awt.*;
public class Circle extends Applet		/*bresenham's algo*/
{
public void paint(Graphics g)
{
int r=150;
int d=3-2*r;
int x=0;
int y=r;
long s,e,time;
s=System.currentTimeMillis();
g.drawLine(200,0,200,768);
g.drawLine(0,200,1024,200);
do
{
g.setColor(Color.red);
g.drawLine(y+200,x+200,y+200,x+200 );
g.drawLine(x+200,y+200,x+200,y+200);
g.drawLine(x+200,-y+200,x+200,-y+200);
g.drawLine(y+200,-x+200,y+200,-x+200 );
g.drawLine(-y+200,-x+200,-y+200,-x+200 );
g.drawLine(-x+200,-y+200,-x+200,-y+200 );
g.drawLine(-x+200,y+200,-x+200,y+200 );
g.drawLine(-y+200,x+200,-y+200,x+200 );


if(d<0)
{
d=d+2*x+3;
}
else
{
d=d+2*(x-y)+5;                         
y=y-1;              
}
x=x+1;
}
while (x<y);
e=System.currentTimeMillis();
time=e-s;
System.out.println("TimeTaken"+time+"msec");	

}
}
/*
<applet code ="Circle" width=400 height=400>
</applet>
*/