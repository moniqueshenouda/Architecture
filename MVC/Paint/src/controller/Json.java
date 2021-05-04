package controller;

import java.util.Stack;
import java.awt.Graphics;
import java.awt.Shape;
import java.io.FileReader;
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
import org.json.simple.parser.JSONParser;

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
	obj.put("posX", ((rectangle)sh).getPosition().x);
	obj.put("posY", ((rectangle)sh).getPosition().y);
	try {
	obj.put("Color", ((rectangle)sh).getColor().getRGB());}
	catch(NullPointerException e) {}
	if (!(((rectangle)sh).getFillColor().equals(Color.WHITE)))
		obj.put("FillColor",((rectangle)sh).getFillColor().getRGB());
	else obj.put("FillColor",((rectangle)sh).getFillColor().getRGB());
	obj.put("Properties",((rectangle)sh).getProperties()); 
	
	}
	
	else if (sh instanceof square ) { 
		obj.put("name", ((square)sh).getClass().getCanonicalName());
		obj.put("posX", ((square)sh).getPosition().x);
		obj.put("posY", ((square)sh).getPosition().y);
		try {
		obj.put("Color", ((square)sh).getColor().getRGB());}
		catch(NullPointerException e) {}
		if (((square)sh).getFillColor()!=null)
			obj.put("FillColor",((square)sh).getFillColor().getRGB());
	else obj.put("FillColor",((square)sh).getFillColor().getRGB());
		obj.put("Properties",((square)sh).getProperties()); }
	else if (sh instanceof circle  ) { 
		obj.put("name", ((circle)sh).getClass().getCanonicalName());
		obj.put("posX",((circle)sh).getPosition().x);
		obj.put("posY", ((circle)sh).getPosition().y);
		try {
		obj.put("Color", ((circle)sh).getColor().getRGB());}
		catch(NullPointerException e) {}
		if (!(((circle)sh).getFillColor().equals(Color.WHITE)))
			obj.put("FillColor",((circle)sh).getFillColor().getRGB());
			else obj.put("FillColor",((circle)sh).getFillColor().getRGB());
		obj.put("Properties", ((circle)sh).getProperties()); }
	else if (sh instanceof oval ) { 
		obj.put("name", ((oval)sh).getClass().getCanonicalName());
		obj.put("posX", ((oval)sh).getPosition().x);
		obj.put("posY", ((oval)sh).getPosition().y);
		try {
		obj.put("Color", ((oval)sh).getColor().getRGB());
		}
		catch(NullPointerException e) {}
		if (!(((oval)sh).getFillColor().equals(Color.WHITE)))
			obj.put("FillColor",((oval)sh).getFillColor().getRGB());
			else obj.put("FillColor",((oval)sh).getFillColor().getRGB());
		obj.put("Properties", ((oval)sh).getProperties()); }
	else if (sh instanceof line  ) { 
		obj.put("name", ((line)sh).getClass().getCanonicalName());
		obj.put("posX", ((line)sh).getPosition().x);
		obj.put("posY", ((line)sh).getPosition().y);
		try {
		obj.put("Color", ((line)sh).getColor().getRGB());}
		catch(NullPointerException e) {}
		if (!(((line)sh).getFillColor().equals(Color.WHITE)))
			obj.put("FillColor",((line)sh).getFillColor().getRGB());
			else obj.put("FillColor",((line)sh).getFillColor().getRGB());
		obj.put("Properties",((line)sh).getProperties()); }
	else if (sh instanceof triangle ) { 
		obj.put("name", ((triangle)sh).getClass().getCanonicalName());
		obj.put("posX", ((triangle)sh).getPosition().x);
		obj.put("posY", ((triangle)sh).getPosition().y);
		try {
		obj.put("Color",((triangle)sh).getColor().getRGB());
		}
		catch(NullPointerException e) {}
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
	public ArrayList<Shape> load (String place ){
		ArrayList <Shape> shapes=new ArrayList<Shape>();
		JSONParser parser=new JSONParser();
		Point p =new Point (),p2=new Point() ;
		
		try {
			Object jmother=parser.parse(new FileReader(place));
			JSONObject mother =(JSONObject) jmother;
			
		int num = Integer.parseInt(((String) mother.get("Shapeno")));
		
		for 	 (int i=0;i<num;i++) {
			
	JSONObject obj=(JSONObject)mother.get(i+"");
	
		if (obj.get("name").equals("model.rectangle")) {
		Shape sh=new rectangle();
			p.x=((Long)obj.get("posX")).intValue();
			p.y=((Long)obj.get("posY")).intValue();
			((rectangle)sh).setPosition(p);
			try {
		    ((rectangle)sh).setColor(new Color(((Long)obj.get("Color")).intValue()));}
			catch(NullPointerException e) {}
		    ((rectangle)sh).setFillColor(new Color(((Long)obj.get("FillColor")).intValue()));
		    ((rectangle)sh).setProperties((Map)obj.get("Properties"));
		    shapes.add(sh);
		}
		else if (obj.get("name").equals("model.circle")) {
			System.out.println("here");
			Shape sh =new circle(); 
			
			p.x=((Long)obj.get("posX")).intValue();
			p.y=((Long)obj.get("posY")).intValue();
		    ((circle)sh).setPosition(p);
		    try {
		    ((circle)sh).setColor(new Color(((Long)obj.get("Color")).intValue()));}
			catch(NullPointerException e) {}
		    ((circle)sh).setFillColor(new Color(((Long)obj.get("FillColor")).intValue()));
		    ((circle)sh).setProperties((Map)obj.get("Properties"));
		    shapes.add(sh);
		}
		else if (obj.get("name").equals("model.square")) {
			Shape sh =new square(); 
			
			p.x=((Long)obj.get("posX")).intValue();
			p.y=((Long)obj.get("posY")).intValue();
		    ((square)sh).setPosition(p);
		    try {
		    ((square)sh).setColor(new Color(((Long)obj.get("Color")).intValue()));
		}
		catch(NullPointerException e) {}
		    ((square)sh).setFillColor(new Color(((Long)obj.get("FillColor")).intValue()));
		    ((square)sh).setProperties((Map)obj.get("Properties"));
		    shapes.add(sh);
		}   
		else if (obj.get("name").equals("model.triangle")) {
			Shape sh =new triangle(); 
			
			p.x=((Long)obj.get("posX")).intValue();
			p.y=((Long)obj.get("posY")).intValue();
		    ((triangle)sh).setPosition(p);
		    try {
		    ((triangle)sh).setColor(new Color(((Long)obj.get("Color")).intValue()));}
			catch(NullPointerException e) {}
		    ((triangle)sh).setFillColor(new Color(((Long)obj.get("FillColor")).intValue()));
		    ((triangle)sh).setProperties((Map)obj.get("Properties"));
		    shapes.add(sh);
		} 
		else if (obj.get("name").equals("model.oval")) {
			Shape sh =new oval(); 
			
			p.x=((Long)obj.get("posX")).intValue();
			p.y=((Long)obj.get("posY")).intValue();
		    ((oval)sh).setPosition(p);
		    try {
		    ((oval)sh).setColor(new Color(((Long)obj.get("Color")).intValue()));}
			catch(NullPointerException e) {}
		    ((oval)sh).setFillColor(new Color(((Long)obj.get("FillColor")).intValue()));
		     ((oval)sh).setProperties((Map)obj.get("Properties"));
		    shapes.add(sh);
		}  
		else if (obj.get("name").equals("model.line")) {
			Shape sh =new line(); 
			
			p.x=((Long)obj.get("posX")).intValue();
			p.y=((Long)obj.get("posY")).intValue();
		    ((line)sh).setPosition(p);
		    try {
		    ((line)sh).setColor(new Color(((Long)obj.get("Color")).intValue()));}
			catch(NullPointerException e) {}
		    ((line)sh).setFillColor(new Color(((Long)obj.get("FillColor")).intValue()));
		    ((line)sh).setProperties((Map)obj.get("Properties"));
		    shapes.add(sh);
		} 
		}
		
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return shapes;
	}

}