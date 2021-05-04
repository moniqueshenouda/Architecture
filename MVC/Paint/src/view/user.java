package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.util.*;
import model.*;
import controller.*;
public class user implements drawingengine{

	private JFrame frmPaint;
	private String modes=new String();
	private Point Start=null,End=null,moveSt=new Point(),moveEnd=new Point(),updateSt=new Point(),updateEnd=new Point();
	public ArrayList<Shape> shapes= new ArrayList();
	private JPanel panel_1 = new JPanel(); 
	Graphics g;
	public static Shape currentShape;
	public static Shape now,changed,newSh,now2,now3;
	public static boolean draw=false;
	public static int preX=0,preY=0;
	Color paint = null;
	caretaker care=new caretaker();
	Memento M=new Memento(shapes);
	UndoCommand UN= new UndoCommand();
	Memento N = new Memento (shapes);
	RedoCommand RD = new RedoCommand();
	Json J= new Json();
	private Point St=new Point(),En=new Point();
	/**
	 * Launch the application.
	
	 */

	 public void refresh(Graphics g) {
		
			for(int i=0;i<shapes.size();i++) {
				Shape s=shapes.get(i);
				
				if(s instanceof rectangle) {
					
					((rectangle) s).draw(g);
					}
				else if(s instanceof square) {
					
					((square) s).draw(g);
					}
				
				else if(s instanceof circle) {
					
					((circle) s).draw(g);}
				
				else if(s instanceof oval) {
					
					((oval) s).draw(g);
					}
				else if(s instanceof line) {
					((line) s).draw(g);}
				
				else if(s instanceof triangle) {
					((triangle) s).draw(g);}
				}
			
				}
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user window = new user();
					window.frmPaint.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public user() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPaint = new JFrame();
		frmPaint.setTitle("Paint");
		frmPaint.setBounds(100, 100, 575, 481);
		frmPaint.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPaint.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmPaint.getContentPane().add(panel, "name_257171083486030");
		panel.setLayout(null);
		
		
		
		
		JButton rec = new JButton("");
		rec.setIcon(new ImageIcon("C:\\Users\\Mounique\\Downloads\\rsz_software_shape_rectangle-512.png"));
		
		rec.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));   
            	
				modes="rectangle";
				draw=true;
			}
		});
		rec.setBounds(10, 11, 52, 43);
		panel.add(rec);
		
		JButton cir = new JButton("");
		cir.setIcon(new ImageIcon("C:\\Users\\Mounique\\Downloads\\rsz_29783-1-circle-hd.png"));
		cir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));   
            	
			modes="circle";
			draw=true;
			}
		});
		cir.setBounds(72, 65, 52, 43);
		panel.add(cir);
		JButton squ = new JButton("");
		squ.setIcon(new ImageIcon("C:\\Users\\Mounique\\Downloads\\rsz_white_small_square_u25ab_icon_256x256.png"));
		
		squ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));   
            	
				modes="square";
				draw=true;
			}
		});
		squ.setBounds(10, 65, 52, 43);
		panel.add(squ);
		
		JButton line = new JButton("");
		line.setIcon(new ImageIcon("C:\\Users\\Mounique\\Downloads\\rsz_12000px-draw-1-black-linesvg.png"));
		
		line.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));   
            	
				modes="line";
				draw=true;
				
			}
		});
		line.setBounds(10, 119, 52, 43);
		panel.add(line);
		
		JButton oval = new JButton("");
		oval.setIcon(new ImageIcon("C:\\Users\\Mounique\\Downloads\\rsz_112993-200.png"));
		oval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));   
            	
			modes="oval";
			draw=true;
			}
		});
		oval.setBounds(72, 11, 52, 43);
		panel.add(oval);

		JButton triangle = new JButton("");
		triangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));   
            	
				modes="triangle";
						draw=true;
			}
		});
		triangle.setIcon(new ImageIcon("C:\\Users\\Mounique\\Downloads\\rsz_alchemy_fire_symbolsvg (1).png"));
		triangle.setBounds(72, 119, 51, 43);
		panel.add(triangle);
		
		JPanel panel_1 = new JPanel() {
			Point pointEnd= null;
			Map<String, Double> prop= new HashMap <String,Double>();
			
			{
			
				addMouseListener(new MouseAdapter() {
					
		                public void mousePressed(MouseEvent e) {
		                   Start=e.getPoint();
		                    
		                }
		                public void mouseReleased(MouseEvent e) {
		                	if(!draw)return;
		                	if (modes.equalsIgnoreCase("rectangle")) {
				            	rectangle r= new rectangle(Start,End);
				            	addShape(r);


				            	
				            }

				            else if (modes.equalsIgnoreCase("square")) {
				            	square sq= new square(Start,End);
				            	addShape(sq);
				            	
				            	
				            
				            }
				            else if (modes.equalsIgnoreCase("oval")) {
				            	 oval o= new oval(Start,End);
				            	 addShape(o);
				            	
				            }
				            else if (modes.equalsIgnoreCase("line")) {
				            	line l= new line(Start,End);
				            	addShape(l);
				            	
				            }
				            else if (modes.equalsIgnoreCase("circle")) {
				            	circle c= new circle(Start,End);
				            	addShape(c);
				            	
				            }
				            else if (modes.equalsIgnoreCase("triangle")) {
				            	triangle t= new triangle(Start,End);
				            	addShape(t);
				            	
				            }
		                	 
		                	Start=null;
		                	
		                }
		                
					});
				addMouseMotionListener(new MouseMotionAdapter() {
	                public void mouseMoved(MouseEvent e) {
	                	End=e.getPoint();
	                	
	                	}
	                

	                public void mouseDragged(MouseEvent e) {
	                	End=e.getPoint();
	                	repaint();
	                	
	                }
				
				});
				
			}    
		
			
			
			 public void paint(Graphics g) {
try {		  super.paint(g);
               
	
		            if (modes.equalsIgnoreCase("rectangle")) {
		            	
		            	rectangle r=new rectangle(Start,End);
		            	r.draw(g);
   
		            }

		            else if (modes.equalsIgnoreCase("square")) {
		            	square sq= new square(Start,End);
		            	 sq.draw(g);
		            	 
		            }
		            else if (modes.equalsIgnoreCase("oval")) {
		            	 oval o= new oval(Start,End);
		            	 o.draw(g);
		            	
		            }
		            else if (modes.equalsIgnoreCase("line")) {
		            	line l= new line(Start,End);
		            	 l.draw(g);
		            	 
		            }
		            else if (modes.equalsIgnoreCase("circle")) {
		            	circle c= new circle(Start,End);
		            	 c.draw(g);
		            	 	            }
		           
		            else if (modes.equalsIgnoreCase("triangle")) {
		            	triangle t= new triangle(Start,End);
		            	 t.draw(g);
		            	 	            }

refresh(g);

}
catch(NullPointerException e) {}
		           
}	
		};
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(134, 11, 415, 420);
		panel.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		
		JButton colorChooser = new JButton("");
		colorChooser.setBackground(Color.WHITE);
		colorChooser.setForeground(Color.WHITE);
		colorChooser.setIcon(new ImageIcon("C:\\Users\\Mounique\\Downloads\\rsz_21download.jpg"));
		colorChooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modes="color";
				 panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                 
				paint=JColorChooser.showDialog(frmPaint.getComponent(0), "color", paint);
                     panel_1.addMouseListener(new MouseAdapter() {
					
	                public void mousePressed(MouseEvent e) {
	                	if(!modes.equalsIgnoreCase("color"))return;
	                	try {
		                	boolean foundShape = false;
			                for (int i = shapes.size() - 1; i >= 0; i--) {
			                	Shape s=shapes.get(i);
			                
			                	boolean n=containsPoint(s,e.getPoint());
			                	if(n) {
			                		
			                		 currentShape=s;
			                         foundShape = true;
			                	
			                	}
			                }
		                	}
		                	catch(NullPointerException ex) {}
	                }
	                public void mouseReleased(MouseEvent e) {
	                    
	                	 if (currentShape != null) {
			                   
	                		 if(modes.equalsIgnoreCase("color")) {
	                				if(currentShape instanceof rectangle) {
	                			   	   now=(rectangle)currentShape;
	                			   	   ((rectangle) now).setFillColor(paint);
	                			   	   
	                			      }
	                			      else if(currentShape instanceof square) {
	                			   	   now=(square)currentShape;
	                			   	 ((square) now).setFillColor(paint);
	                			   }
	                			      else if(currentShape instanceof circle) {
	                			   	   now=(circle)currentShape;
	                			   	((circle) now).setFillColor(paint);
	                			   }
	                			      else if(currentShape instanceof oval) {
	                			   	   now=(oval)currentShape;
	                			   	((oval) now).setFillColor(paint);
	                			    }
	                			      else if(currentShape instanceof triangle) {
		                			   	   now=(triangle)currentShape;
			                			   	((triangle) now).setFillColor(paint);
			                			    }
	                			      else if(currentShape instanceof line) {
		                			   	   now=(line)currentShape;
			                			   	((line) now).setFillColor(paint);
			                			    }
	  			       
	  			       updateShape(currentShape,now);  
	  						 }}
	  		            panel_1.paint(g);
	                	
	                	panel_1.updateUI();
	                }
	                
				});
							}
		});
		colorChooser.setBounds(10, 281, 52, 43);
		panel.add(colorChooser);
		
		
		JButton resize = new JButton("");
		resize.setIcon(new ImageIcon("C:\\Users\\Mounique\\Downloads\\rsz_resize_large-512.png"));
		resize.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				modes="resize";
				panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));   
            	
				panel_1.addMouseListener(new MouseAdapter() {
					
	                public void mousePressed(MouseEvent e) {
	                   
	                    
	                }
	                public void mouseReleased(MouseEvent e) {
	                	if(!modes.equalsIgnoreCase("resize"))return;
	                	updateShape(currentShape,now2);
	                    
	                }
	                
				});
				
		        panel_1. addMouseMotionListener(new MouseMotionListener() {
		        	
		            @Override
		            public void mouseMoved(MouseEvent e) {
                      if (!modes.equalsIgnoreCase("resize"))return; 
                    	  try {
		                //deals with identifying shape to resize
		               
		                boolean foundShape = false;
		                for (int i = shapes.size() - 1; i >= 0; i--) {
		                	Shape s=shapes.get(i);
		                	
		                	boolean n=containsPoint(s,e.getPoint());
		                	if(n) {
		                		
		                		 currentShape = s;
		                         foundShape = true;
		                	}
		                }
		                if(!foundShape){
		                    //Reset the shape and cursor only if needed
		                    if(currentShape != null){
		                        currentShape = null;
		                        panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		                    }
		                } else {
		                    panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR));
		                }
                    	  }
                    	  catch(NullPointerException ex) {}}
                      

					@Override
					public void mouseDragged(MouseEvent e) {
						if(!modes.equalsIgnoreCase("resize"))return;
						 if (currentShape != null) {
			                   
			           if(currentShape instanceof rectangle) {
			        	   now2=(rectangle)currentShape;
			        	   ((rectangle) now2).setPosition2(e.getPoint());
			           }
			           else if(currentShape instanceof square) {
			        	   now2=(square)currentShape;
			        	   ((square) now2).setPosition2(e.getPoint());
			           }
			           else if(currentShape instanceof circle) {
			        	   now2=(circle)currentShape;
			        	   ((circle) now2).setPosition2(e.getPoint());
			           }
			           else if(currentShape instanceof oval) {
			        	   now2=(oval)currentShape;
			        	   ((oval) now2).setPosition2(e.getPoint());
			           }
			           else if(currentShape instanceof line) {
			        	   now2=(line)currentShape;
			        	   ((line) now2).setPosition2(e.getPoint());
						 
						}
			           else if(currentShape instanceof triangle) {
			        	   now2=(triangle)currentShape;
			        	   ((triangle) now2).setPosition2(e.getPoint());
			          
						 
						}
						 }
						}
		            
		        });
              
               
               panel_1.paint(g);
               
			}
		
			
			    });
		resize.setBounds(10, 173, 52, 43);
		panel.add(resize);
		
		
		JButton delete = new JButton("");
		delete.setIcon(new ImageIcon("C:\\Users\\Mounique\\Downloads\\rsz_delete-sign.png"));
		delete.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				modes="delete";
				panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));   
            	
				panel_1.addMouseListener(new MouseAdapter() {
					
	                public void mousePressed(MouseEvent e) {
	                	if(!modes.equalsIgnoreCase("delete"))return;
	                	try {
		                	boolean foundShape = false;
			                for (int i = shapes.size() - 1; i >= 0; i--) {
			                	Shape s=shapes.get(i);
			                
			                	boolean n=containsPoint(s,e.getPoint());
			                	if(n) {
			                		
			                		 currentShape=s;
			                         foundShape = true;
			                         panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				      			       
			                	}
			                }
		                	}
		                	catch(NullPointerException ex) {}
	                }
	                public void mouseReleased(MouseEvent e) {
	                    if(!modes.equalsIgnoreCase("delete"))return;
	                    removeShape(currentShape);
	                    panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	      			   	panel_1.paint(g);
	                	panel_1.updateUI();
	                }
	                
				});
			
				
			}
		});
		delete.setBounds(72, 173, 52, 43);
		panel.add(delete);
		 
		JButton moveSh = new JButton("");
		moveSh.setIcon(new ImageIcon("C:\\Users\\Mounique\\Downloads\\rsz_img_72036.png"));
		moveSh.setForeground(Color.WHITE);
		moveSh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modes="move";
				panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));   
            		
           panel_1.	addMouseListener(new MouseAdapter() {
            	
	                public void mousePressed(MouseEvent e) {
	                	if(!modes.equalsIgnoreCase("move"))
	                		return;
	                    try {
			                	boolean foundShape = false;
				                for (int i = shapes.size() - 1; i >= 0; i--) {
				                	Shape s=shapes.get(i);
				                	
				                	boolean n=containsPoint(s,e.getPoint());
				                	if(n) {
				                		
				                		 currentShape=s;
				                         foundShape = true;
				                         panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
				      			       
				                	
				                	}
				                	 }
				                if(currentShape instanceof rectangle) {
				                	now3=(rectangle) currentShape;
				                	moveSt=((rectangle) now3).getPosition();
				                	moveEnd=((rectangle) now3).getPosition2();
				                } 
				                else if(currentShape instanceof square) {
				                	 now3=(square) currentShape;
				                	moveSt=((square) now3).getPosition();
				                	moveEnd=((square) now3).getPosition2();
				                } 
				                else if(currentShape instanceof circle) {
				                	now3=( circle) currentShape;
				                	moveSt=((circle) now3).getPosition();
				                	moveEnd=((circle) now3).getPosition2();
				                } 
				                else if(currentShape instanceof oval) {

                                    now3=(oval) currentShape;
				                	moveSt=((oval) now3).getPosition();
				                	moveEnd=((oval) now3).getPosition2();
				                } 
				                else if(currentShape instanceof triangle) {

                                    now3=(triangle) currentShape;
				                	moveSt=((triangle) now3).getPosition();
				                	moveEnd=((triangle) now3).getPosition2();
				                } 
				                else if(currentShape instanceof line) {

                                    now3=(line) currentShape;
				                	moveSt=((line) now3).getPosition();
				                	moveEnd=((line) now3).getPosition2();
				                } 
				                
				                preX=e.getX();
				                preY=e.getY();
				                
				              }
			                	catch(NullPointerException ex) {}
	                }
	                public void mouseReleased(MouseEvent e) {
	                	if(!modes.equalsIgnoreCase("move"))return;
	                	moveSt=new Point();
	                	moveEnd=new Point();
	                	preX=0;
	                	preY=0;
	                	updateEnd=new Point();
	                	updateSt=new Point();
	                	updateShape(currentShape,changed);
	                	 panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	      			       
	                    
	                }
	                
				});
				
		        panel_1. addMouseMotionListener(new MouseMotionListener() {
		        	
		        	
		            @Override
		            public void mouseMoved(MouseEvent e) {
		            	        
                     }

					@Override
					public void mouseDragged(MouseEvent ev) {
						if(!modes.equalsIgnoreCase("move"))return;
						int transferX=ev.getX()-preX;
						int transferY=ev.getY()-preY;
						
						 if(currentShape instanceof rectangle) {
			                	 changed=(rectangle)currentShape;
			                	    updateSt.x=moveSt.x+transferX;
				                	updateSt.y=moveSt.y+transferY;
				                    ((rectangle) changed).setPosition(updateSt);
				                    updateEnd.x=moveEnd.x+transferX;
				                	updateEnd.y=moveEnd.y+transferY;
				                    ((rectangle) changed).setPosition2(updateEnd);
				                	 } 
						 else if(currentShape instanceof square) {
		                	 changed=(square)currentShape;
		                	 updateSt.x=moveSt.x+transferX;
			                	updateSt.y=moveSt.y+transferY;
			                    ((square) changed).setPosition(updateSt);
			                    updateEnd.x=moveEnd.x+transferX;
			                	updateEnd.y=moveEnd.y+transferY;
			                    ((square) changed).setPosition2(updateEnd);
			                	 } 
						 else if(currentShape instanceof circle) {
				                	 changed=(circle)currentShape;
				                	    updateSt.x=moveSt.x+transferX;
					                	updateSt.y=moveSt.y+transferY;
					                    ((circle) changed).setPosition(updateSt);
					                    updateEnd.x=moveEnd.x+transferX;
					                	updateEnd.y=moveEnd.y+transferY;
					                    ((circle) changed).setPosition2(updateEnd);
					                	 } 
						 else if(currentShape instanceof oval) {
						       changed=(oval)currentShape;
				        	    updateSt.x=moveSt.x+transferX;
			                	updateSt.y=moveSt.y+transferY;
			                	((oval) changed).setPosition(updateSt);
				                updateEnd.x=moveEnd.x+transferX;
			                	updateEnd.y=moveEnd.y+transferY;
			                	((oval) changed).setPosition2(updateEnd);
							                	 } 
						 else if(currentShape instanceof triangle) {
		                	 changed=(triangle)currentShape;
		                	    updateSt.x=moveSt.x+transferX;
			                	updateSt.y=moveSt.y+transferY;
			                    ((triangle) changed).setPosition(updateSt);
			                    updateEnd.x=moveEnd.x+transferX;
			                	updateEnd.y=moveEnd.y+transferY;
			                    ((triangle) changed).setPosition2(updateEnd);
			                	 } 
						 
						 else if(currentShape instanceof line) {
		                	 changed=(line)currentShape;
		                	    updateSt.x=moveSt.x+transferX;
			                	updateSt.y=moveSt.y+transferY;
			                    ((line) changed).setPosition(updateSt);
			                    updateEnd.x=moveEnd.x+transferX;
			                	updateEnd.y=moveEnd.y+transferY;
			                    ((line) changed).setPosition2(updateEnd);
			                	 } 
						 
					}
		            
		        });
              
               
               panel_1.paint(g);
               panel_1.updateUI();
 	
			}
		});
		moveSh.setBounds(10, 227, 52, 43);
		panel.add(moveSh);
		
		JButton copySh = new JButton("");
		copySh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				modes="copy";
				panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
 			     
			 panel_1.	addMouseListener(new MouseAdapter() {
	            	public void mousePressed(MouseEvent e) {
	            		if(!modes.equalsIgnoreCase("copy"))return;	
	                    
			
				
                try {
	                	boolean foundShape = false;
	                	Point newSP=new Point(),newEP=new Point();
	                	int prex,prey;
		                for (int i = shapes.size() - 1; i >= 0; i--) {
		                	Shape s=shapes.get(i);
		                	
		                	boolean n=containsPoint(s,e.getPoint());
		                	if(n) {
		                		
		                		 currentShape=s;
		                         foundShape = true;
		                           
}
		                }
		                if(currentShape instanceof rectangle) {
		                	St=((rectangle)currentShape).getPosition();
			                En=((rectangle)currentShape).getPosition2();
		                	prex=En.x-St.x;
		                	prey=En.y-St.y;
		                	newSP.x=0;
		                	newSP.y=0;
		                	newEP.x=prex;
		                	newEP.y=prey;
		                	newSh=new rectangle(newSP,newEP);
		                	if(!(((rectangle)currentShape).getFillColor().equals(Color.WHITE)))
		                	((rectangle) newSh).setFillColor(((rectangle)currentShape).getFillColor());
		                	
		                } 
		                else  if(currentShape instanceof square) {
		                	St=((square)currentShape).getPosition();
			                En=((square)currentShape).getPosition2();
		                	prex=En.x-St.x;
		                	prey=En.y-St.y;
		                	newSP.x=0;
		                	newSP.y=0;
		                	newEP.x=prex;
		                	newEP.y=prey;
		                	newSh=new square(newSP,newEP);
		                	if(!(((square)currentShape).getFillColor().equals(Color.WHITE)))
		                	((square) newSh).setFillColor(((square)currentShape).getFillColor());
		                	
		                } 
		                else  if(currentShape instanceof circle) {
		                	St=((circle)currentShape).getPosition();
			                En=((circle)currentShape).getPosition2();
		                	prex=En.x-St.x;
		                	prey=En.y-St.y;
		                	newSP.x=0;
		                	newSP.y=0;
		                	newEP.x=prex;
		                	newEP.y=prey;
		                	newSh=new circle(newSP,newEP);
		                	if(!(((circle)currentShape).getFillColor().equals(Color.WHITE)))
		                	((circle) newSh).setFillColor(((circle)currentShape).getFillColor());
		                	
		                } 
		                else  if(currentShape instanceof oval) {
		                	St=((oval)currentShape).getPosition();
			                En=((oval)currentShape).getPosition2();
		                	prex=En.x-St.x;
		                	prey=En.y-St.y;
		                	newSP.x=0;
		                	newSP.y=0;
		                	newEP.x=prex;
		                	newEP.y=prey;
		                	newSh=new oval(newSP,newEP);
		                	if(!(((oval)currentShape).getFillColor().equals(Color.WHITE)))
		                	((oval) newSh).setFillColor(((oval)currentShape).getFillColor());
		                	
		                }
		                else  if(currentShape instanceof triangle) {
		                	
		                	St=((triangle)currentShape).getPosition();
			                En=((triangle)currentShape).getPosition2();
		                	prex=En.x-St.x;
		                	prey=En.y-St.y;
		                	newSP.x=100;
		                	newSP.y=0; 
		                	newEP.x=prex+100;
		                	newEP.y=prey;
		                	newSh=new triangle(newSP,newEP);
		                	if(!(((triangle)currentShape).getFillColor().equals(Color.WHITE)))
		                	((triangle) newSh).setFillColor(((triangle)currentShape).getFillColor());
		                	
		                }  
		                else  if(currentShape instanceof line) {
		                	
		                	St=((line)currentShape).getPosition();
			                En=((line)currentShape).getPosition2();
		                	prex=En.x-St.x;
		                	prey=En.y-St.y;
		                	newSP.x=100;
		                	newSP.y=100; 
		                	newEP.x=prex+100;
		                	newEP.y=prey+100;
		                	newSh=new line(newSP,newEP);
		                	if(!(((line)currentShape).getFillColor().equals(Color.WHITE)))
		                	((line) newSh).setFillColor(((line)currentShape).getFillColor());
		                	
		                }  
		                
		                
		              }
	                	catch(NullPointerException ex) {}
            }
            public void mouseReleased(MouseEvent e) {
            if(!modes.equalsIgnoreCase("copy"))return;	
            	
            	addShape(newSh);
            	panel_1.paint(g);
            	panel_1.updateUI();    
            }
            
            
        });
      
       
       
			}
		});
		copySh.setIcon(new ImageIcon("C:\\Users\\Mounique\\Downloads\\rsz_56560-copy-document-with-circular-button.png"));
		copySh.setBounds(72, 227, 52, 43);
		panel.add(copySh);
		
		JButton undo = new JButton("");
		undo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{try {
				undo();
				panel_1.paint(g);
				panel_1.updateUI();}
				catch(EmptyStackException e) {
						
				}}
				catch(ArrayIndexOutOfBoundsException e){
					
				}
			}
		});
		undo.setIcon(new ImageIcon("C:\\Users\\Mounique\\Downloads\\rsz_action_undo_1-512.png"));
		undo.setBounds(10, 335, 52, 43);
		panel.add(undo);
		
		JButton save = new JButton("");
		save.setIcon(new ImageIcon("C:\\Users\\Mounique\\Downloads\\rsz_9016-200.png"));
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final JFileChooser fs;
				fs = new JFileChooser("C:\\"); 
				fs.addChoosableFileFilter(new FileNameExtensionFilter( "XML",  "xml"));
				fs.addChoosableFileFilter(new FileNameExtensionFilter( "JSON",  "Json"));

		if( fs.showSaveDialog(panel) == JFileChooser.APPROVE_OPTION)
    	{
	    	String place= fs.getSelectedFile().getPath();
	    		place+="."+ fs.getFileFilter().getDescription().toLowerCase(); 
	    		J.save( shapes, place);
		    	JOptionPane.showMessageDialog(null, "Saving successful");
	    	
    	}}});
		save.setBounds(71, 281, 53, 43);
		panel.add(save);
		
		JButton redo = new JButton("");
		redo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{try {
					redo();
					panel_1.paint(g);
					panel_1.updateUI();}
					catch(EmptyStackException e) {
							
					}}
					catch(ArrayIndexOutOfBoundsException e){
						
					}
				
			}
		});
		redo.setIcon(new ImageIcon("C:\\Users\\Mounique\\Downloads\\rsz_action_redo_1-512.png"));
		redo.setBounds(72, 335, 52, 43);
		panel.add(redo);
		
		JButton load = new JButton("");
		load.setIcon(new ImageIcon("C:\\Users\\Mounique\\Downloads\\rsz_computer-from-floppy-load-512.png"));
		load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final JFileChooser fs;
				fs = new JFileChooser("C:\\"); 
				fs.setFileFilter(new FileNameExtensionFilter( "XML",  "xml"));
				fs.setFileFilter(new FileNameExtensionFilter( "JSON",  "Json"));

		if( fs.showOpenDialog(panel) == JFileChooser.APPROVE_OPTION)
    	{
	    	String place= fs.getSelectedFile().getPath();
	    	
	    		shapes=J.load(place);
		    	panel_1.paint(g);
		    	panel_1.updateUI();
		    	System.out.println(shapes.size());
	    	
    	}}});
		load.setBounds(10, 388, 114, 43);
		panel.add(load);
		
		
		}

	

	@Override
	public void addShape(Shape shape) {
		shapes.add(shape);
		 care.addmemento(M.change(shapes));
		
	}

	
	public boolean containsPoint(Shape s,Point c) {
		Point a = new Point(),b = null;
		boolean check=false;
		if(s instanceof rectangle){
			a=((rectangle)s).getPosition();
		    b=((rectangle)s).getPosition2();
		    check=((c.x>=a.x)&&(c.x<=b.x))&&((c.y>=a.y)&&(c.y<=b.y));}
		else if(s instanceof square){
			a=((square)s).getPosition();
		    b=((square)s).getPosition2();
		    check=((c.x>=a.x)&&(c.x<=b.x))&&((c.y>=a.y)&&(c.y<=b.y));}
		else if(s instanceof circle){
			a=((circle)s).getPosition();
		    b=((circle)s).getPosition2();
		    check=((c.x>=a.x)&&(c.x<=b.x))&&((c.y>=a.y)&&(c.y<=b.y));}
		
		else if(s instanceof oval){
			a=((oval)s).getPosition();
		    b=((oval)s).getPosition2();
		    check=((c.x>=a.x)&&(c.x<=b.x))&&((c.y>=a.y)&&(c.y<=b.y));}
		else if(s instanceof triangle){
			
			a=((triangle)s).getPosition();
			 b=((triangle)s).getPosition2();
			 check=((c.x>=a.x)&&(c.x<=b.x))&&((c.y>=a.y)&&(c.y<=b.y));
		   }
		else if(s instanceof line)	{
			
			a=((line)s).getPosition();
			 b=((line)s).getPosition2();
			 check=((c.x>=a.x)&&(c.x<=b.x)); 
			 check=((c.x>=a.x)&&(c.x<=b.x))&&(((c.y>=a.y)&&(c.y<=b.y))||((c.y<=a.y)&&(c.y>=b.y)));
			  
		}
		if(check)
			return true;
		else return false;}
	
	@Override
	public void refresh(Object canvas) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeShape(Shape shape) {
		shapes.remove(shape);
		 care.addmemento(M.change(shapes));
		
	}

	@Override
	public void updateShape(Shape oldShape, Shape newShape) {
		Shape s = null;
		for(int i=0;i<shapes.size();i++) {
			if(shapes.get(i).equals(oldShape))
				s=shapes.get(i);
		}
		if(modes.equalsIgnoreCase("color")) {
			if(s instanceof rectangle)
		((rectangle) s).setFillColor(((rectangle) newShape).getFillColor());
			else if(s instanceof square)
				((square) s).setFillColor(((square) newShape).getFillColor());
			else if(s instanceof triangle)
				((triangle) s).setFillColor(((triangle) newShape).getFillColor());
			else if(s instanceof circle)
				((circle) s).setFillColor(((circle) newShape).getFillColor());
			else if(s instanceof oval)
				((oval) s).setFillColor(((oval) newShape).getFillColor());
			else if(s instanceof line)
				((line) s).setFillColor(((line) newShape).getFillColor());
		
		}
		else if(modes.equalsIgnoreCase("resize")) {
			if(s instanceof rectangle)
				((rectangle) s).setPosition2(((rectangle) newShape).getPosition2());
			else if(s instanceof square)
				((square) s).setPosition2(((square) newShape).getPosition2());
			else if(s instanceof triangle)
				((triangle) s).setPosition2(((triangle) newShape).getPosition2());
			else if(s instanceof circle)
				((circle) s).setPosition2(((circle) newShape).getPosition2());
			else if(s instanceof oval)
				((oval) s).setPosition2(((oval) newShape).getPosition2());
			else if(s instanceof line)
				((line) s).setPosition2(((line) newShape).getPosition2());
			
		}
		else if(modes.equalsIgnoreCase("move")) {
		
			if(s instanceof rectangle) {
				((rectangle) s).setPosition(((rectangle) newShape).getPosition());
				((rectangle) s).setPosition2(((rectangle) newShape).getPosition2());
			
			}			
			else if(s instanceof square) {
				((square) s).setPosition(((square) newShape).getPosition());
				((square) s).setPosition2(((square) newShape).getPosition2());
			}					
			else if(s instanceof triangle) {
				((triangle) s).setPosition(((triangle) newShape).getPosition());
				((triangle) s).setPosition2(((triangle) newShape).getPosition2());}
			else if(s instanceof circle) {
			    ((circle) s).setPosition(((circle) newShape).getPosition());
				((circle) s).setPosition2(((circle) newShape).getPosition2());}
			else if(s instanceof oval) {
				((oval) s).setPosition(((oval) newShape).getPosition());	
				((oval) s).setPosition2(((oval) newShape).getPosition2());}
			else if(s instanceof line) {
				((line) s).setPosition(((line) newShape).getPosition());	
				((line) s).setPosition2(((line) newShape).getPosition2());}
			
		}
		 care.addmemento(M.change(shapes));
	}

	
	@Override
	public Shape[] getShapes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
				modes = "undo";
				Memento M=UN.execute();
				shapes=M.getState();
				
			
		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		modes="redo";
		Memento N=RD.execute();
		shapes=N.getState();
		
	}
}