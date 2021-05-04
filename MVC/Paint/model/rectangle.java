package model;

import java.awt.*;
import java.util.*;

public class rectangle extends AbstractShape implements shape {
	
	private static Map<String, Double> prop=new HashMap<String,Double>();
	private Color col=new Color(0),fill=Color.white;
    private Point start=new Point(),end=new Point();
   
	public rectangle(Point start,Point end) {
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
		prop.put("l",  Math.abs(start.getY()-end.getY()));
		prop.put("w", Math.abs(start.getX()-end.getX()));}
		
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
	public void setFillColor(java.awt.Color color) {
		this.fill=color;
	}
	@Override
	public java.awt.Color getFillColor(){
		
		return this.fill;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
       	if(getPosition()!=null) {
       		Graphics2D g2d=(Graphics2D) ((Graphics2D)g).create();
			
    	if(!(getFillColor().equals(Color.WHITE))) {
    		g2d.setColor(getFillColor());
    		g2d.fillRect(getPosition().x, getPosition().y,getProperties().get("w").intValue(),getProperties().get("l").intValue());
    	    }
    	  
		g2d.drawRect(getPosition().x, getPosition().y,getProperties().get("w").intValue(),getProperties().get("l").intValue());
	    }}
	public Object clone() {
		Shape s=new rectangle(this.start,this.end);
		((rectangle)s).setPosition(start);
		((rectangle)s).setPosition2(end);
		((rectangle)s).setProperties(new HashMap<String,Double>(this.prop));
		((rectangle)s).setFillColor(getFillColor());
		return s;
	}
	
}
