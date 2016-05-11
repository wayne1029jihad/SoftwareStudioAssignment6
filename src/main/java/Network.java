package main.java;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import processing.core.PApplet;

/**
* This class is used for the visualization of the network.
* Depending on your implementation, you might not need to use this class or create a class on your own.
* I used the class to draw the circle and re-arrange nodes and links.
* You will need to declare other variables.
*/

public class Network{
	
	private PApplet parent;
	public ArrayList<Character> characters;
	int addallX, addallY;      
	int clearX, clearY; 
	int addallSize=50,clearSize=50,incirclesize;
	int radius=250,centerX=700,centerY=325;
	int who;
	boolean in=true;
	
	public Network(PApplet parent){

		this.parent = parent;
		parent.ellipseMode(parent.RADIUS);
		parent.ellipse(centerX, centerY, radius, radius);
		parent.stroke(153);
		parent.noFill();
		
		/*parent.noStroke();
		parent.fill(2, 247, 141);
		parent.rect(1120, 20, "ADD ALL".length()*10+5, 20);		
		parent.textSize(26);
		parent.fill(255);
		parent.text("ADD ALL", 1123, 20,1123+"ADD ALL".length(),40);
		parent.noStroke();
		parent.fill(2, 247, 141);
		parent.rect(1120, 50, "CLEAR".length()*10+5, 70);		
		parent.textSize(26);
		parent.fill(255);
		parent.text("CLEAR", 1123, 50,1123+"CLEAR".length(),70);*/
			
		
	}

	public void display(){
		for (int i = 0; i < characters.size(); i++) 
			{
			for(int j=i+1;j<characters.size();j++)
			{
				for(int k=0;k<characters.getTargets.size();k++)
				{
					if(characters.get(i).getTargets.get(k)==characters.get(j))
				{
						parent.strokeWeight((characters.get(i).getTargets.get(k).getTargetsvalue()/5)+1);
						parent.bezier(characters.get(i).getX(), characters.get(i).getY(), 
						characters.get(i).getX()+10,characters.get(i).getY()+30,
						characters.get(i).getTargets.get(k).getX(), 
						characters.get(i).getTargets.get(k).getY(),
						characters.get(i).getTargets.get(k).getX()+10, 
						characters.get(i).getTargets.get(k).getY()+30);		
				}
				}
			
			}
			
			}
	}
	public void mouseMoved()
	{
		parent.strokeWeight(4);
	}
	public void putoncircle(ArrayList<Character> a,int size)
	{
		incirclesize=characters.size();
		for(int i=0;i<incirclesize;i++)
		{
			float deg=360*i/size;
			float rad= radians (deg);
			characters.get(i).setPosition(centerX+radius*cos(rad),centerY+radius*sin(rad));
		}
	}
	public void CLEARALL()
	{
		for(int i=0;i<characters.size();i++)
		{
			characters.get(i).resetPosition();
			characters.remove(characters.get(i));
		}
	}
	public void mousePressed(boolean in,int num)
	{
		if(in)
		{
			//圓內放開character-->回到原位
			if((parent.mouseX-700)*(parent.mouseX-700)+( parent.mouseY -325)*( parent.mouseY -325)<=250*250)//圓內
			{
				putoncircle(characters,characters.size());
			}
			//圓外放開character-->被踢出圓內+重整character
			else
			{
				//logic?
				characters.get(num).resetPosition();
				characters.remove(characters.get(num));
				putoncircle(characters,characters.size());
			}
		}
		else
		{
			//圓內放開character-->被加進character
			if((parent.mouseX-700)*(parent.mouseX-700)+( parent.mouseY -325)*( parent.mouseY -325)<=250*250)//圓內
			{
				characters.add(parent.characters.get(num));
				putoncircle(characters,characters.size());
			}
			//圓外放開character-->回到原位
			else
			{
				characters.get(num).resetPosition();
				putoncircle(characters,characters.size());
			}
		}
	}	
	public void clickCharacter()
	{
		if(parent.mousePressed)//boolean
		{
			if((parent.mouseX-700)*(parent.mouseX-700)+( parent.mouseY -325)*( parent.mouseY -325)<=250*250)
				//圓內
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
			{
				for(int i  = 0; i < parent.characters.size(); i++)
				{
					if(parent.characters.get(i).getOn())
						{
							who =  i;
							mousePressed(!in,i);
							break;
						}
				}
		
			}
		}
	}

}
