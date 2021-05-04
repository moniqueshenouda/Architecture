package controller;


import java.util.Stack;
import java.awt.Graphics;
import java.awt.Shape;
import java.util.ArrayList;

public class UndoCommand implements command  {
 caretaker caretaker=new caretaker();

 
  
 public Memento execute() {
	
	return caretaker.undo();
 }
 
}
