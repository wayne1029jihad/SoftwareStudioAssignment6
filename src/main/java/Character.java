package main.java;

import processing.core.PApplet;
import java.util.ArrayList;
/**
* This class is used to store states of the characters in the program.
* You will need to declare other variables depending on your implementation.
*/
public class Character {
	
	private MainApplet parent;
	public float x, y, radius;
	private String name;	
	private ArrayList<Character> targets;

	public Character(MainApplet parent){

		this.parent = parent;
		
	}

	public void display(){
		parent.fill(0);
		parent.fill(255);
		parent.rect(x-15, y-15, 70, 20);
		parent.fill(0);
		if((x - parent.mouseX)*(x - parent.mouseX)+(y - parent.mouseY)* (y - parent.mouseY) < radius * radius)
			parent.text(name, x, y);
	}
	
	void mouseMoved() {
		
	}
	public void addTarget(Character target){
		targets.add(target);		
	}
	
	public ArrayList<Character> getTargets(){
		return this.targets;
	}
	
}

package main.java;

import java.util.ArrayList;

import processing.core.PApplet;

/**
* This class is used to store states of the characters in the program.
* You will need to declare other variables depending on your implementation.
*/
public class Character {
	
	private MainApplet parent;
	String name,colour;
	private ArrayList<Character> targets;
	private ArrayList<Character> values;
	int number;

	public Character(MainApplet parent,String name,String colour){

		this.parent = parent;
		this.name=name;
		this.colour=colour;
		targets = new ArrayList<Character>();
		values = new ArrayList<Character>();
	}

	public void display(){

	}
	public void addTarget(Character target) {
		this.targets.add(target);
	}
	public void addValue(Character value) {
		this.values.add(value);
	}
	public ArrayList<Character> getTargets(){ return this.targets; }
	public ArrayList<Character> getValues(){ return this.values; }
	public void setnumber(int n)
	{
		number=n;
	}
}

