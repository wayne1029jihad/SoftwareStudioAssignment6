package main.java;

import java.util.ArrayList;

import processing.core.PApplet;

/**
* This class is used for the visualization of the network.
* Depending on your implementation, you might not need to use this class or create a class on your own.
* I used the class to draw the circle and re-arrange nodes and links.
* You will need to declare other variables.
*/

public class Network {
	
	private PApplet parent;
	private ArrayList<Character> characters;
	int addallX, addallY;      
	int clearX, clearY; 
	int addallSize=50,clearSize=50;
	int who;
	boolean in=true;
	public Network(PApplet parent){			
		this.parent = parent;
	}

	public void display(){
		//parent.fill(0);		
		parent.ellipseMode(parent.RADIUS);
		parent.ellipse(700, 325, 250, 250);
		parent.fill(255);
		
		parent.noStroke();
		parent.fill(2, 247, 141);
		parent.rect(1120, 20, "ADD ALL".length()+5, 20);		
		parent.textSize(26);
		parent.fill(255);
		parent.text("ADD ALL", 1123, 20,1123+"ADD ALL".length(),40);
		parent.noStroke();
		parent.fill(2, 247, 141);
		parent.rect(1120, 50, "CLEAR".length()+5, 70);		
		parent.textSize(26);
		parent.fill(255);
		parent.text("CLEAR", 1123, 50,1123+"CLEAR".length(),70);
		
	}
	public void mouseMoved()
	{
		parent.strokeWeight(4);
	}
	private void putoncircle(Character a)
	{
		characters.add(a);
	}
	public void mousePressed(boolean in,int num)
	{
		if(in)
		{
			//圓內放開character-->回到原位
			if((parent.mouseX-700)*(parent.mouseX-700)+( parent.mouseY -325)*( parent.mouseY -325)<=250*250)//圓內
			{
				//characters.get(i).
			}
			//圓外放開character-->被踢出圓內+重整character
			else
			{
				
			}
		}
		else
		{
			//圓內放開character-->被加進character
			if((parent.mouseX-700)*(parent.mouseX-700)+( parent.mouseY -325)*( parent.mouseY -325)<=250*250)//圓內
			{
			}
			//圓外放開character-->回到原位
			else
			{
				
			}
		}
	}	
	public void clickCharacter()
	{
		if(parent.mousePressed)//boolean
		{
			if((parent.mouseX-700)*(parent.mouseX-700)+( parent.mouseY -325)*( parent.mouseY -325)<=250*250)//圓內
			{
				for(int i  = 0; i < characters.size(); i++)
				{
					if(characters.get(i).getLocked())//boolean
						 { 
								who=i;
								mousePressed(in,i);
								break;
						 }
				}
			}
			else//圓外
			{/*
				for(int i  = 0; i < parent.characters ; i++)
				{
					if(parent.characters.get(i).getOn())
						{
							who =  i;
							mousePressed(!in,i);
							break;
						}
				}*/
		
			}
		}
	}
}
