package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.util.HashMap;
import java.util.Map;

public class triangle extends AbstractShape implements shape{

	private static Map<String, Double> prop=new HashMap<String,Double>();
	private Color col=new Color(0),fill=Color.white;
    private Point start=new Point(),end=new Point();
   
    public triangle() {}
	public triangle(Point start,Point end) {
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
		prop.put("X2",  Math.abs(end.getX()));
		prop.put("X3", Math.abs(2*(start.getX())-end.getX()));
		prop.put("Y2", Math.abs(end.getY()));
		prop.put("Y3", Math.abs(end.getY()));
		}
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
		int xpoints[]= {start.x,getProperties().get("X2").intValue(),getProperties().get("X3").intValue()};
		int ypoints[]= {start.y,getProperties().get("Y2").intValue(),getProperties().get("Y3").intValue()};
		
		
       	if(getPosition()!=null) {
       		Graphics2D g2d=(Graphics2D) ((Graphics2D)g).create();
			
    	if(!(getFillColor().equals(Color.WHITE))) {
    		g2d.setColor(getFillColor());
    		g2d.fillPolygon(xpoints, ypoints, 3);}
    	  
		g2d.drawPolygon(xpoints, ypoints, 3);
	    }}
	public Object clone() {
		Shape s=new triangle(this.start,this.end);
		((triangle)s).setPosition(start);
		((triangle)s).setPosition2(end);
		((triangle)s).setProperties(new HashMap<String,Double>(this.prop));
		((triangle)s).setFillColor(getFillColor());
		return s;
	}
}
