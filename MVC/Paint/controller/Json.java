package controller;

import java.util.Stack;
import java.awt.Graphics;
import java.awt.Shape;
import java.io.FileWriter;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.json.simple.JSONObject;
import model.*;

public class Json  {  


	

	public void save (ArrayList <Shape> shapes,String place) {
JSONObject mother=new JSONObject ();	
mother.put("Shapeno",""+shapes.size());
JSONObject obj ;
for(int c=0;c<shapes.size();c++) {
	Shape sh = shapes.get(c);
	obj=new JSONObject();
	if (sh instanceof rectangle ) { 
	obj.put("name", ((rectangle)sh).getClass().getCanonicalName());
	obj.put("posX", ((rectangle)sh).getPosition().getX());
	obj.put("posY", ((rectangle)sh).getPosition().getY());
	obj.put("Color", ((rectangle)sh).getColor());
	if (!(((rectangle)sh).getFillColor().equals(Color.WHITE)))
		obj.put("FillColor",((rectangle)sh).getFillColor().getRGB());
	else obj.put("FillColor",((rectangle)sh).getFillColor().getRGB());
	obj.put("Properties", ((rectangle)sh).getProperties()); }
	else if (sh instanceof square ) { 
		obj.put("name", ((square)sh).getClass().getCanonicalName());
		obj.put("posX", ((square)sh).getPosition().getX());
		obj.put("posY", ((square)sh).getPosition().getY());
		obj.put("Color", ((square)sh).getColor().getRGB());
		if (((square)sh).getFillColor()!=null)
			obj.put("FillColor",((square)sh).getFillColor().getRGB());
	else obj.put("FillColor",((square)sh).getFillColor().getRGB());
		obj.put("Properties",((square)sh).getProperties()); }
	else if (sh instanceof circle  ) { 
		obj.put("name", ((circle)sh).getClass().getCanonicalName());
		obj.put("posX",((circle)sh).getPosition().getX());
		obj.put("posY", ((circle)sh).getPosition().getY());
		obj.put("Color", ((circle)sh).getColor());
		if (!(((circle)sh).getFillColor().equals(Color.WHITE)))
			obj.put("FillColor",((circle)sh).getFillColor().getRGB());
			else obj.put("FillColor",((circle)sh).getFillColor().getRGB());
		obj.put("Properties", ((circle)sh).getProperties()); }
	else if (sh instanceof oval ) { 
		obj.put("name", ((oval)sh).getClass().getCanonicalName());
		obj.put("posX", ((oval)sh).getPosition().getX());
		obj.put("posY", ((oval)sh).getPosition().getY());
		obj.put("Color", ((oval)sh).getColor());
		if (!(((oval)sh).getFillColor().equals(Color.WHITE)))
			obj.put("FillColor",((oval)sh).getFillColor().getRGB());
			else obj.put("FillColor",((oval)sh).getFillColor().getRGB());
		obj.put("Properties", ((oval)sh).getProperties()); }
	else if (sh instanceof line  ) { 
		obj.put("name", ((line)sh).getClass().getCanonicalName());
		obj.put("posX", ((line)sh).getPosition().getX());
		obj.put("posY", ((line)sh).getPosition().getY());
		obj.put("Color", ((line)sh).getColor());
		if (!(((line)sh).getFillColor().equals(Color.WHITE)))
			obj.put("FillColor",((line)sh).getFillColor().getRGB());
			else obj.put("FillColor",((line)sh).getFillColor().getRGB());
		obj.put("Properties",((line)sh).getProperties()); }
	else if (sh instanceof triangle ) { 
		obj.put("name", ((triangle)sh).getClass().getCanonicalName());
		obj.put("posX", ((triangle)sh).getPosition().getX());
		obj.put("posY", ((triangle)sh).getPosition().getY());
		obj.put("Color",((triangle)sh).getColor());
		if (!(((triangle)sh).getFillColor().equals(Color.WHITE)))
			obj.put("FillColor",((triangle)sh).getFillColor().getRGB());
			else obj.put("FillColor",((triangle)sh).getFillColor().getRGB());
		obj.put("Properties", ((triangle)sh).getProperties()); }
	mother.put(""+c,obj); 
}
try {
	FileWriter FWriter = new FileWriter(place);
	FWriter.write(mother.toJSONString());
	FWriter.close();
}
catch (Exception e) {
	e.printStackTrace();
}
}
}