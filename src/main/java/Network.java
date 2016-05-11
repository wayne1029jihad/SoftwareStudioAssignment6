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
	private ArrayList<Character> characters = new ArrayList<Character>();
	int circleX,circleY;
	int addallX, addallY;      
	int clearX, clearY; 
	int circleRadius;
	int addallSize=50,clearSize=50;
	int whichCharacter;
	int circleWeight;//the weight of circle's line
	boolean clickCharacter=false;
	boolean onClear = false;
	boolean onAddAll = false;
	Character currentCharecter;
	public Network(MainApplet parent){			
		this.parent = parent;
		whichCharacter = -1;//initial to nobody in circle
		circleWeight = 1;//initial to thin
		circleX = 700;//circle center's X
		circleY = 325;//circle center's Y
		circleRadius = 245;
		clearX = 910;
		clearY = 95;
		addallX = 910;
		addallY = 25;
		System.out.println(characters.size());
	}

	public void display(){
		parent.fill(70, 70, 121);
		if(inCircle() == true)
			circleWeight = 7;
		else
			circleWeight = 3;
		parent.stroke(255);
		parent.strokeWeight(circleWeight);		
		parent.ellipseMode(parent.RADIUS);
		parent.ellipse(circleX, circleY, circleRadius, circleRadius);
		parent.fill(255);
		parent.stroke(0);
		
		
		parent.fill(70, 207, 191);
		if(onAddAll)
		{
			parent.strokeWeight(3);
			parent.stroke(255);
		}
		else
		{
			parent.strokeWeight(1);
			parent.stroke(125);
		}
		
		parent.rect(addallX, addallY, 200, 60);		
		parent.textSize(26);
		parent.fill(255);		
		parent.text("ADD ALL", addallX+45, addallY+15, 150, 40);
		parent.noStroke();
		parent.fill(70, 207, 191);
		if(onClear)
		{
			parent.strokeWeight(3);
			parent.stroke(255);
		}
		else
		{
			parent.strokeWeight(1);
			parent.stroke(125);
		}
		parent.rect(clearX, clearY, 200, 60);
		parent.strokeWeight(1);
		parent.textSize(26);
		parent.fill(255);
		parent.text("CLEAR", clearX+65, clearY+15 ,150, 40);
		/*
		for(Character character : characters)
		{
			for(int i = 0; i < character.getTargets().size();i++)
			{
				character.getTargets().get(i);
				
			}
		}
		*/
		for (int i = 0; i < characters.size(); i++) 
		{
			//全部角色的哪個?
			for(int j=i+1;j<characters.size();j++)
			{
				for(int k=0;k<characters.get(i).getTargets().size();k++)
				{
					if(characters.get(i).getTargets().get(k)==characters.get(j))
					{
						parent.fill(255);
							parent.strokeWeight(characters.get(i).getValues().get(k)/5+1);
							parent.bezier(characters.get(i).getX(), characters.get(i).getY(), 
							characters.get(i).getX()+10,characters.get(i).getY()+30,
							characters.get(i).getTargets().get(k).getX(), 
							characters.get(i).getTargets().get(k).getY(),
							characters.get(i).getTargets().get(k).getX()+10, 
							characters.get(i).getTargets().get(k).getY()+30);
							parent.strokeWeight(1);
					}
				}		
			}
				
		}
	}	
	private void setoncircle(Character last)
	{
		characters.add(last);
		last.setinCircle(true);
		putoncircle();
	}
	public void mousePressed()
	{
		clickCharacter();
		if(onClear)
		{
			ClearAll();
		}
		if(onAddAll)
		{
			addAll();
		}
	}
	public void mouseMoved()
	{
		if(parent.mouseY - clearY < 60 && parent.mouseX - clearX < 200 && parent.mouseY - clearY > 0 && parent.mouseX - clearX > 0)
			onClear  = true;
		else
			onClear  = false;
		if(parent.mouseY - addallY < 60 && parent.mouseX - addallX < 200 && parent.mouseY - addallY > 0 && parent.mouseX - addallX > 0)
			onAddAll = true;
		else
			onAddAll = false;
			
	}
	public void mouseReleased()
	{
		if(clickCharacter)//if cursor control one character
		{			//圓內放開character-->回到原位// release
			if(inCircle() == true)
			{
				if(whichCharacter != -1)//mean it already in circle
					putoncircle();
				else if(currentCharecter.getinCircle())
					setoncircle(currentCharecter);				
			}
			//圓外放開character-->被踢出圓內+重整character
			else
			{
				if(whichCharacter != -1)
				{
					characters.get(whichCharacter).resetPosition();					
					characters.get(whichCharacter).setPosition(characters.get(whichCharacter).getiniX(),characters.get(whichCharacter).getiniY());
					characters.get(whichCharacter).setinCircle(false);
					characters.remove(whichCharacter);
					putoncircle();
				}
				else
					currentCharecter.resetPosition();
			}
			
		}
		clickCharacter = false;
	}
		
	public void clickCharacter()
	{
		System.out.println("click!");
		if(inCircle() == true)
			{
				for(int i  = 0; i < characters.size(); i++)
				{
					if(characters.get(i).getLocked())//boolean
					 { 
						whichCharacter = i;
						clickCharacter = true;
						System.out.println(whichCharacter);
						System.out.println("catch someone in circle!");
						break;
					 }
				}
			}
			else//圓外
			{			
				for(int i  = 0; i < parent.characters.size(); i++)
				{
					if(parent.characters.get(i).getLocked())//boolean
					 { 
						if(parent.characters.get(i).getinCircle())
						{
							for(int j  = 0; j < characters.size(); j++)
							{
								if(characters.get(j).getLocked())//boolean
								 { 
									whichCharacter = j;
									clickCharacter = true;
									System.out.println(whichCharacter);
									System.out.println("catch someone in circle!");
									break;
								 }
							}
						}
						else
						{
							whichCharacter = -1;
							currentCharecter = parent.characters.get(i);
							clickCharacter = true;
							System.out.println("catch someone out circle!");
						}
						break;
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
	public void ClearAll()
	{		
		for(Character character : characters)
		{
			character.resetPosition();
			character.setinCircle(false);
			character.setPosition(character.getiniX(),character.getiniY());
		}
		characters.clear();
		System.out.println(characters.size());
	}
	public void addAll()
	{
		for(Character character : parent.characters)
		{
			if(!character.getinCircle())
				setoncircle(character);
		}
	}
	
	public void putoncircle()
	{
		System.out.println("put on "+characters.size());
		for(int i = 0; i < characters.size(); i++)
		{
			float deg=360*i/characters.size();
			float rad= parent.radians(deg);
			System.out.println(circleX+circleRadius*parent.cos(rad)+" "+circleY+circleRadius*parent.sin(rad));
			characters.get(i).setPosition(circleX+circleRadius*parent.cos(rad),circleY+circleRadius*parent.sin(rad));
			
		}
	}
}
