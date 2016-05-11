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
	private float setX, setY;
	public float nowX,nowY;
	private String name,colour;	
	private ArrayList<Character> targets;
	private ArrayList<Integer> values;
	private Network network;
	int color;
	private boolean on = false;//to decide the cursor is on the character circle
	private boolean locked = false;//to decide the cursor is on the character circle and mouse pressed
	int number;//decide  initial position
	public Character(MainApplet parent,Network network,String name,String colour, int nunber){
		this.network = network;
		this.parent = parent;
		this.name=name;
		this.colour=colour;
		this.number=nunber;
		color = this.parent.unhex(this.colour.substring(1));
		iniY = (number%10*50)+30;
		iniX = (number/10*100)+30;
		nowY =iniY;
		nowX = iniX;
		targets = new ArrayList<Character>();//record how is connection with this character
		values = new ArrayList<Integer>();//record value of targets, decide how width the connection line
	}

	public void display(){
		parent.fill(0);
		
		if((nowX - parent.mouseX)*(nowX - parent.mouseX)+(nowY - parent.mouseY)* (nowY - parent.mouseY) < radius * radius)
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
		parent.fill(color);
		parent.ellipse(nowX, nowY, radius, radius);
		if(on)
		{
			parent.fill(255);
			parent.rect(nowX-15, nowY-15, 100, 20);
			parent.fill(0);
			parent.textSize(15);
			parent.text(name, nowX, nowY);
			bigRadius(true);
		}
		else
		{
			bigRadius(false);
		}
		
	}
	
	public void mouseDragged()
	{
		if(locked)
		{
			nowX = parent.mouseX;
			nowY = parent.mouseY;
		}
		else
		{
			nowX = iniX;
			nowY = iniY;
		}
	}
	public void mouseReleased()
	{
		locked = false;
		if(network.inCircle())
		{
			nowX = setX;
			nowY = setY;
		}
		else
			resetPosition();
	}

	public void mousePressed() 
	{
		
	  if(on)
	  { 
		  locked = true; 
		  parent.fill(255, 255, 255);
		  System.out.println("Lock");
	  } 
	  else 
	  {
		  locked = false;
	  }	
	}	
	
	public void addTarget(Character target) {
		this.targets.add(target);
	}
	public void addValue(Integer value) {
		this.values.add(value);
	}
	public ArrayList<Character> getTargets(){ return this.targets; }
	public ArrayList<Integer> getValues(){ return this.values; }
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
		setX = X;
		setY = Y;
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



