package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.util.HashMap;
import java.util.Map;

public class square extends AbstractShape implements shape{

	private static Map<String, Double> prop=new HashMap<String,Double>();
	private Color col,fill=Color.WHITE;
    private Point start=null,end=null;
   
	public square(Point start,Point end) {
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
		prop.put("s",  Math.abs(start.getX()-end.getX()));}
		
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
    		g2d.fillRect(getPosition().x, getPosition().y,getProperties().get("s").intValue(),getProperties().get("s").intValue());
    	    }
    	  
		g2d.drawRect(getPosition().x, getPosition().y,getProperties().get("s").intValue(),getProperties().get("s").intValue());
	    }}
	
	
  
	public Object clone() {
		Shape s=new square(this.start,this.end);
		((square)s).setPosition(start);
		((square)s).setPosition2(end);
		((square)s).setProperties(new HashMap<String,Double>(this.prop));
		((square)s).setFillColor(getFillColor());
		return s;
	}
		
	 
}