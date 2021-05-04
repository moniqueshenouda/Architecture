package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Shape;
import java.util.HashMap;
import java.util.Map;

public class line extends AbstractShape implements shape{
	private static Map<String, Double> prop=new HashMap<String,Double>();
	private Color col,fill;
    private Point start=null,end=null;
    
    public line() {}
	public line(Point start,Point end) {
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
		prop.put("st", end.getX());
		prop.put("en", end.getY());}
		
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
       		g.setColor(getFillColor());
		g.drawLine(getPosition().x, getPosition().y,getProperties().get("st").intValue(),getProperties().get("en").intValue());
	    }}
	
	public Object clone() {
		Shape s=new line(this.start,this.end);
		((line)s).setPosition(start);
		((line)s).setPosition2(end);
		((line)s).setProperties(new HashMap<String,Double>(this.prop));
		((line)s).setFillColor(getFillColor());
		return s;
	}
}
