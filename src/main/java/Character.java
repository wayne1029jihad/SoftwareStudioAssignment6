package main.java;

import processing.core.PApplet;
import java.util.ArrayList;
/**
* This class is used to store states of the characters in the program.
* You will need to declare other variables depending on your implementation.
*/
public class Character {
	
	private MainApplet parent;
	private float iniX, iniY, radius = 15;
	public float nowX,nowY;
	private String name,colour;	
	private ArrayList<Character> targets;
	//private ArrayList<Integer> values;
	private boolean on = false;//to decide the cursor is on the character circle
	private boolean locked = false;//to decide the cursor is on the character circle and mouse pressed
	int number;//decide  initial position
	int value;
	public Character(MainApplet parent,String name,String colour, int nunber){

		this.parent = parent;
		this.name=name;
		this.colour=colour;
		
		targets = new ArrayList<Character>();//record how is connection with this character
		//values = new ArrayList<Integer>();//record value of targets, decide how width the connection line
	}

	public void display(){
		parent.fill(0);
		
		if((iniX - parent.mouseX)*(iniX - parent.mouseX)+(iniY - parent.mouseY)* (iniY - parent.mouseY) < radius * radius)
		{
			 on = true;
			 if(!locked) { 
				 parent.stroke(255); 
				 parent.fill(153);
			    } 
		}
		else 
		{
			on = false;
			parent.stroke(153);
			parent.fill(153);	   
	    }
		if(on)
		{
			parent.fill(255);
			parent.rect(iniX-15, iniY-15, 70, 20);
			parent.fill(0);
			parent.text(name, iniX, iniY);
			bigRadius(true);
		}
		else
		{
			bigRadius(false);
		}
		parent.ellipse(iniX, iniY, radius, radius);
	}
	
	void mouseDragged()
	{
		if(locked)
		{
			nowX = parent.mouseX;
			nowY = parent.mouseY;
		}
	}
	void mouseReleased()
	{
		locked = false;
	}

	void mousePressed() 
	{
	  if(on)
	  { 
		  locked = true; 
		  parent.fill(255, 255, 255);
	  } 
	  else 
	  {
		  locked = false;
	  }	
	}
	
	
	
	
	public void addTarget(Character target) {
		this.targets.add(target);
	}
	/*public void addValue(Integer value) {
		this.values.add(value);
	}*/
	public ArrayList<Character> getTargets(){ return this.targets; }
	//public ArrayList<Integer> getValues(){ return this.values; }
	public void setTargetsvalue(int value)
	{
		this.value=value;
		}
	public int getTargetsvalue()
	{
		return value;
	}
	public void setnumber(int n)
	{
		number=n;
	}
	public float getX()
	{
		return nowX;
	}
	public float getY()
	{
		return nowY;
	}
	public void resetPosition()
	{
		nowX = iniX;
		nowY = iniY;
	}
	public void setPosition(float X,float Y)
	{
		nowX = X;
		nowY = Y;
	}
	public void bigRadius(boolean big)
	{
		if(big)
			radius = 20;
		else
			radius = 15;
	}
	public boolean getOn()
	{
		return on;
	}
	public boolean getLocked()
	{
		return locked;
	}
	
}



