package controller;
import java.util.Stack;
import java.awt.Graphics;
import java.awt.Shape;
import java.util.ArrayList;



public class caretaker {
	
	static Stack <Memento>  undostack = new Stack<Memento>() ;
	static Stack <Memento>  redostack = new Stack<Memento>() ;
	
	public Memento undo() { 
		 if(redostack.size()>20) {
			redostack.remove(0);
		}
		
		redostack.push(undostack.pop());
		return undostack.peek();
	
	}
	
	public void addmemento (Memento m){
		if(undostack.size()==0) {
			Memento empty = new Memento();
			undostack.push(empty);}
		else if(undostack.size()>20) {
			undostack.remove(0);
		}
		undostack.push(m);
		
		
	}
	public Memento redo() { 
		
		Memento n=redostack.pop();
		
		if(redostack.size()==0) {
			Memento empty = new Memento();
			redostack.push(empty);}
		
		else {
		undostack.push(n);
		}
		return n;
	}

}