package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.util.HashMap;
import java.util.Map;

public class oval extends AbstractShape implements shape{
	private static Map<String, Double> prop=new HashMap<String,Double>();
	private Color col,fill=Color.WHITE;
    private Point start=null,end=null;
    
	public oval(Point start,Point end) {
		this.start=start;
		this.end=end;
		
		
	}
	@Override
	public void setPosition(Point position) {
		// TODO Auto-generated method stub
		
		start=position;
		
	}

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		
		return start;
	}
	public void setPosition2(Point position) {
		// TODO Auto-generated method stub
		
		end=position;
		
	}

	
	public Point getPosition2() {
		// TODO Auto-generated method stub
		
		return end;
	}

	@Override
	public void setProperties(Map<String, Double> properties) {
		// TODO Auto-generated method stub
		this.prop=properties;
       
	}
	
	@Override
	public Map<String, Double> getProperties() {
		// TODO Auto-generated method stub
		try {
		prop.put("h1",  Math.abs(start.getX()-end.getX()));
		prop.put("h2",  Math.abs(start.getY()-end.getY()));}
		
		catch (NullPointerException e) {}
			
		
		return this.prop;
		
	}

	@Override
	public void setColor(Color color) {
		this.col=color;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return this.col;
	}
	@Override
	public void setFillColor(Color color) {
		// TODO Auto-generated method stub
		
		this.fill=color;
	}
	@Override
	public Color getFillColor() {
		// TODO Auto-generated method stub
		return this.fill;
	}
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
       	if(getPosition()!=null) {
       		Graphics2D g2d=(Graphics2D) ((Graphics2D)g).create();
			
    	if(!(getFillColor().equals(Color.WHITE))) {
    		g2d.setColor(getFillColor());
    		g2d.fillOval(getPosition().x, getPosition().y,getProperties().get("h1").intValue(),getProperties().get("h2").intValue());
    	    }
    	  
		g2d.drawOval(getPosition().x, getPosition().y,getProperties().get("h1").intValue(),getProperties().get("h2").intValue());
	    }}
	
	public Object clone() {
		Shape s=new oval(this.start,this.end);
		((oval)s).setPosition(start);
		((oval)s).setPosition2(end);
		((oval)s).setProperties(new HashMap<String,Double>(this.prop));
		((oval)s).setFillColor(getFillColor());
		return s;
	}

	}
