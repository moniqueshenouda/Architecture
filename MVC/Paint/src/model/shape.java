package model;

import java.awt.Graphics;

public interface shape {
	
	public void setPosition(java.awt.Point position);
	public java.awt.Point getPosition();
	public void setProperties(java.util.Map<String, Double> properties);
	public java.util.Map<String, Double> getProperties();
	public void setColor(java.awt.Color color);
	public java.awt.Color getColor();
	public void setFillColor(java.awt.Color color);
	public java.awt.Color getFillColor();
	/* redraw the shape on the canvas,
	for swing, you will cast canvas to java.awt.Graphics */
	public void draw(Graphics g);
	/* create a deep clone of the shape */
	public Object clone() throws CloneNotSupportedException;
}
