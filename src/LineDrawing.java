
import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class LineDrawing extends Applet implements ActionListener
{
    	int app_width, app_height,center_x,center_y,p1,q1,p2,q2,w,t,e,r,gr,b;
	int count=0;
	String a;
	Color c;
       
	Graphics2D g2d;
	//Label algo=new Label("Enter algorithm : DDA_or_Bresenham"); 
	Choice algorithm = new Choice ();

	//Label type=new Label("(Line type : 1-Solid, 2-Dashed, 3-Dotted, 4-Dashed dotted)"); 
	Choice line_type = new Choice();

	//Label width=new Label("Enter width of line"); 
	TextField line_width = new TextField("Width");

	//Label cap=new Label("(End caps : 1-Butt end, 2-Rounded, 3-Projected Square)"); 
	Choice end_cap = new Choice();

	TextField red = new TextField("Red_value");
	TextField green = new TextField("Green_value");
	TextField blue = new TextField("Blue_value");

	TextField x1_input = new TextField("x1");
	TextField y1_input = new TextField("y1");
	TextField x2_input = new TextField("x2");
	TextField y2_input = new TextField("y2");

public LineDrawing()
{
	add(algorithm);
		algorithm.add("DDA");
		algorithm.add("Bresenham");
	add(line_type);
		line_type.add("Solid");
		line_type.add("Dashed");
		line_type.add("Dotted");
		line_type.add("Dashed dotted");
	add(line_width);
	add(end_cap);
		end_cap.add("Butt end");
		end_cap.add("Rounded");
		end_cap.add("Projected Square");
	add(x1_input); 
	add(y1_input); 
	add(x2_input); 
	add(y2_input); 
	//add(type);		
	//add(cap);
	add(red);
	add(green);
	add(blue);
	
	x1_input.addActionListener(this);
	y1_input.addActionListener(this);
	x2_input.addActionListener(this);
	y2_input.addActionListener(this);
	line_width.addActionListener(this);
	red.addActionListener(this);
	green.addActionListener(this);
	blue.addActionListener(this);

}
    
   public void init() 
    {
    	app_width=getSize().width;
     	app_height=getSize().height;
    	center_x=app_width/2;
    	center_y=app_height/2;
	setBackground(Color.white);
    }

public void actionPerformed(ActionEvent event) 
{
	
   	p1 = Integer.parseInt(x1_input.getText());
	x1_input.setText("x1");  

	q1 = Integer.parseInt(y1_input.getText());
	y1_input.setText("y1");     

	p2 = Integer.parseInt(x2_input.getText());
	x2_input.setText("x2");     

	q2 = Integer.parseInt(y2_input.getText());
	y2_input.setText("y2"); 
	
	a = algorithm.getSelectedItem();

	t = line_type.getSelectedIndex();
	//line_type.setText("Line_type");       

	w = Integer.parseInt(line_width.getText());
	line_width.setText("Width");       

	e = end_cap.getSelectedIndex();
	//end_cap.setText("End_caps");       

	r=Integer.parseInt(red.getText());
	red.setText("Red_value");
	gr=Integer.parseInt(green.getText());
	green.setText("Green_value");
	b=Integer.parseInt(blue.getText());
	blue.setText("Blue_value");


repaint();
}


public void paint(Graphics g) 
{
	axis_transformation(g);

	if((a.equals("Bresenham")) || (a.equals("bresenham")) || (a.equals("BRESENHAM")) || (a.equals("bres")))
	{
		bresenham(g,p1,q1,p2,q2,t,w,e,r,gr,b);
 	}       	

	else if((a.equals("DDA")) || (a.equals("dda")))
	{
		DDA(g,p1,q1,p2,q2,t,w,e,r,gr,b);
 	}       


} //END paint()


void DDA (Graphics g, int x1, int y1, int x2, int y2, int line_type, int line_width, int cap_style,int r,int gr,int b)
{
int dx=x2-x1, dy=y2-y1, steps,k,r_x,r_y,lt=0,i=0;
float xInc, yInc, x=x1, y=y1;
g2d = (Graphics2D)g;
c=new Color(r,gr,b);
g2d.setColor(c); 

	if(Math.abs(dx)>=Math.abs(dy))
		steps=Math.abs(dx);
	else
		steps=Math.abs(dy);

	xInc=dx/(float)steps;
	yInc=dy/(float)steps;
	r_x=Math.round(x);
	r_y=Math.round(y);

	//if(lt==0)
	g2d.fillRect(r_x,r_y,line_width,line_width);

	for(k=0;k<steps;k++)
	{
	if(t==1)					//solid
		lt=0;				
	else if(t==2)				//dashed
		lt=(count/4)%2;		
	else if(t==3)				//dotted
 		lt=(count/2)%3;
	else if(t==4)				//dashed-dotted
	{
		if(i%4==0)
			 lt=(count/4)%2;
		if(i%4!=0)
			lt=(count/2)%3;
	}
		x=x+xInc;
		y=y+yInc;
		r_x=Math.round(x);
		r_y=Math.round(y);
		if (lt==0 || lt==3)
		g2d.fillRect(r_x,r_y,line_width,line_width);
		count=count+1;
		i=i+1;
	}

int radius;
radius=line_width/2;

	switch(e)
	{
		case 1:
			//g2d.setColor(Color.red); 
			/*
			Rectangle rect1 = new Rectangle(x1+radius*4/5,y1-line_width-radius*2/5,line_width*2,line_width+radius*3/5);
			g2d.rotate(Math.toRadians(45));
    			g2d.draw(rect1);
			g2d.fill(rect1);
			*/
			break;
		case 2:
			g2d.fillOval(x1-radius/2,y1-radius/2,line_width+radius*4/5,line_width+radius*4/5);
			g2d.fillOval(x2-radius/2,y2-radius/2,line_width+radius*4/5,line_width+radius*4/5);
			break;
		case 3:
			//g2d.fillRect(x1-radius/2,y1-radius/4,line_width+radius/2,line_width+radius/2);
			break;
	}
}

// for positive slope
void bresenham(Graphics g,int x1,int y1,int x2,int y2,int line_type,int line_width,int cap_style,int r,int gr,int b)
{
	int i=0,lt=0;
	g2d = (Graphics2D)g;
	c=new Color(r,gr,b);
	g2d.setColor(c); 

	int dx=Math.abs(x2-x1);
	int dy=Math.abs(y2-y1);
	int p=(2*dy)-dx;
	int twoDy=2*dy, twoDyDx=2*(dy-dx);
	int x,y,xLast=0;

	if (x1>x2)
	{
		x=x2;
		y=y2;
		xLast=x1;
	}
	else
	{
		x=x1;
		y=y1;
		xLast=x2;
	}

	g2d.fillRect(x,y,line_width,line_width);

		while(x<xLast)
		{

			if(t==1)					//solid
				lt=0;				
			else if(t==2)				//dashed
				lt=(count/4)%2;		
			else if(t==3)				//dotted
 				lt=(count/2)%3;
			else if(t==4)				//dashed-dotted
			{
				if(i%4==0)
			 		lt=(count/4)%2;
				if(i%4!=0)
					lt=(count/2)%3;
			}

		x++;
			if(p<0)
				p=p+twoDy;
			else
			{
				y++;
				p=p+twoDyDx;	
			}

		if(lt==0)
			g2d.fillRect(x,y,line_width,line_width);
	
		count=count+1;
		i++;
		}	

int radius;
radius=line_width/2;

	switch(e)
	{
		case 1:
			//g2d.fillRect(x1-radius/2,y1-radius/2,radius,line_width);
			break;
		case 2:
			g2d.fillOval(x1-radius/2,y1-radius/2,line_width+radius*4/5,line_width+radius*4/5);
			g2d.fillOval(x2-radius/2,y2-radius/2,line_width+radius*4/5,line_width+radius*4/5);
			break;
		case 3:
			//g2d.fillRect(x1-radius/2,y1-radius/4,line_width+radius/2,line_width+radius/2);
			break;

	}

	
} // END bresenham()


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