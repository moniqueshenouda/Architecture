package controller;
import java.util.Stack;


import java.awt.Graphics;
import java.awt.Shape;
import java.util.ArrayList;
import model.*;

public class Memento {
	
	
	private ArrayList<Shape> lastaction= new ArrayList <Shape> ();
	// constructor
	Shape s=null;    
		public Memento(ArrayList <Shape> m) {
			
			this.lastaction =new ArrayList<Shape>();
			for( int i=0;i<m.size();i++) {
				s=m.get(i);
				if(s instanceof rectangle ) {
					this.lastaction.add((Shape) ((rectangle) s).clone());
				}
				else if(s instanceof circle ) {
					this.lastaction.add((Shape) ((circle) s).clone());
				}
				else if(s instanceof square ) {
					this.lastaction.add((Shape) ((square) s).clone());
				}
				else if(s instanceof triangle ) {
					this.lastaction.add((Shape) ((triangle) s).clone());
				}
				else if(s instanceof oval ) {
					this.lastaction.add((Shape) ((oval) s).clone());
				}
				else if(s instanceof line ) {
					this.lastaction.add((Shape) ((line) s).clone());
				}
			}
			
		}
		public Memento() {
			// TODO Auto-generated constructor stub
		}
		public Memento change(ArrayList<Shape> m) {
			return new Memento(m);
		}
		
		public ArrayList<Shape> getState(){
			ArrayList<Shape> temp=new ArrayList<Shape>();
			
			for( int i=0;i<lastaction.size();i++) {
				s=lastaction.get(i);
				if(s instanceof rectangle ) {
					temp.add((Shape) ((rectangle) s).clone());
				}
				else if(s instanceof circle ) {
					temp.add((Shape) ((circle) s).clone());
				}
				else if(s instanceof square ) {
					temp.add((Shape) ((square) s).clone());
				}
				else if(s instanceof triangle ) {
					temp.add((Shape) ((triangle) s).clone());
				}
				else if(s instanceof oval ) {
					temp.add((Shape) ((oval) s).clone());
				}
				else if(s instanceof line ) {
					temp.add((Shape) ((line) s).clone());
				}
			}
			return temp;
		}
}

