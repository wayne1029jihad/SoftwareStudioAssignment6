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
	
	private MainApplet parent;
	private ArrayList<Character> characters;
	int circleX,circleY;
	int addallX, addallY;      
	int clearX, clearY; 
	int circleRadius;
	int addallSize=50,clearSize=50;
	int whichCharacter;
	int circleWeight;//the weight of circle's line
	boolean clickCharacter=false;
	Character currentCharecter;
	public Network(MainApplet parent){			
		this.parent = parent;
		whichCharacter = -1;//initial to nobody in circle
		circleWeight = 1;//initial to thin
		circleX = 700;//circle center's X
		circleY = 325;//circle center's Y
		circleRadius = 245;
	}

	public void display(){
		parent.fill(70, 70, 121);
		if(inCircle() == true)
			circleWeight = 7;
		else
			circleWeight = 3;
		parent.strokeWeight(circleWeight);		
		parent.ellipseMode(parent.RADIUS);
		parent.ellipse(circleX, circleY, circleRadius, circleRadius);
		parent.fill(255);
		parent.stroke(0);
		parent.strokeWeight(1);
		parent.noStroke();
		parent.fill(70, 207, 191);
		parent.rect(910, 25, 200, 60);		
		parent.textSize(26);
		parent.fill(255);
		parent.text("ADD ALL", 955, 40, 150, 40);
		parent.noStroke();
		parent.fill(70, 207, 191);
		parent.rect(910, 95, 200, 60);		
		parent.textSize(26);
		parent.fill(255);
		parent.text("CLEAR", 975, 110 ,150, 40);
		
	}
	public void mouseMoved()
	{
		
	}
	private void putoncircle(Character last)
	{
		characters.add(last);
	}
	
	public void mouseReleased()
	{
		if(clickCharacter)//if cursor control one character
			//圓內放開character-->回到原位// release
			if(inCircle() == true)
			{
				if(whichCharacter != -1)//mean it already in circle
					characters.get(whichCharacter).setPosition(1, 2);
				else
					putoncircle(currentCharecter);
			}
			//圓外放開character-->被踢出圓內+重整character
			else
			{
				if(whichCharacter != -1)
				{
					characters.get(whichCharacter).resetPosition();
					characters.remove(whichCharacter);
				}
				else
					currentCharecter.resetPosition();
			}
	}
		
	public void clickCharacter()
	{
		if(parent.mousePressed)//boolean
		{
			if(inCircle() == true)
			{
				for(int i  = 0; i < characters.size(); i++)
				{
					if(characters.get(i).getLocked())//boolean
						 { 
							whichCharacter = i;
							clickCharacter = true;
							break;
						 }
				}
			}
			else//圓外
			{
				if(inCircle() == true)
				{
					for(int i  = 0; i < parent.characters.size(); i++)
					{
						if(parent.characters.get(i).getLocked())//boolean
							 { 
								whichCharacter = -1;
								currentCharecter = parent.characters.get(i);
								clickCharacter = true;
								break;
							 }
					}
				}
					
			}			
		}
	}
	public boolean inCircle()
	{
		if((circleX - parent.mouseX)*(circleX - parent.mouseX)+(circleY - parent.mouseY)* (circleY - parent.mouseY) < circleRadius * circleRadius)
			return true;
		else
			return false;
	}
	
}
