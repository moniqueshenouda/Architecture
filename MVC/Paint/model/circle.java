package model;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.util.HashMap;
import java.util.Map;


public class circle extends AbstractShape implements shape{

	private static Map<String, Double> prop=new HashMap<String,Double>();
	private Color col,fill=Color.WHITE;
    private Point start,end;
    
	public circle(Point start,Point end) {
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
		prop.put("r",  Math.abs(start.getX()-end.getX()));}
		
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
    		g2d.fillOval(getPosition().x, getPosition().y,getProperties().get("r").intValue(),getProperties().get("r").intValue());
    	    }
    	  
		g2d.drawOval(getPosition().x, getPosition().y,getProperties().get("r").intValue(),getProperties().get("r").intValue());
	    }}
	
	public Object clone() {
		Shape s=new circle(this.start,this.end);
		((circle)s).setPosition(start);
		((circle)s).setPosition2(end);
		((circle)s).setProperties(new HashMap<String,Double>(this.prop));
		((circle)s).setFillColor(getFillColor());
		return s;
	}
	
    
	
	
}
