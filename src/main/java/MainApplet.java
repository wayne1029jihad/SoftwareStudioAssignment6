package main.java;
import java.lang.Object;
import java.awt.Button;
import java.util.ArrayList;
import java.awt.*;
import processing.core.PApplet;
import processing.data.JSONArray;
import processing.data.JSONObject;

/**
* This class is for sketching outcome using Processing
* You can do major UI control and some visualization in this class.  
*/
@SuppressWarnings("serial")
public class MainApplet extends PApplet{
	int ep = 1;
	private String path = "main/resources/";
	private String file = "starwars-episode-"+ep+"-interactions.json";
	 
	private ArrayList<Character> characters;
	private Network network = new Network(this);
	private final static int width = 1200, height = 600;
	JSONObject data;
	
	public void setup() {
		size(width, height);
		characters = new ArrayList<Character>();
		this.noStroke();/*
		this.fill(2, 247, 141);
		this.rect(1120, 20, "ADD ALL".length()+5, 20);		
		textSize(26);
		this.fill(255);
		this.text("ADD ALL", 1123, 20,1123+"ADD ALL".length(),40);
		this.fill(2, 247, 141);
		this.rect(1120, 50, "CLEAR".length()+5, 70);		
		textSize(26);
		this.fill(255);
		this.text("CLEAR", 1123, 50,1123+"CLEAR".length(),70);*/
		smooth();
		loadData();		
	}

	public void draw() {
		background(220);
		
		for(Character character : characters)
			character.display();
		network.display();
		fill(0);
		textSize(30);
		text("Star Wars "+ep, 600, 20,600+"ADD ALL".length(),40);
	}

	

	private void loadData(){
			
			file = "starwars-episode-"+ep+"-interactions.json";
			data=loadJSONObject(path+file);
			JSONArray nodes=data.getJSONArray("nodes"), links=data.getJSONArray("links");
			for (int i = 0; i < nodes.size(); i++) {
				JSONObject node = nodes.getJSONObject(i);
				characters.add(new Character(this, node.getString("name"), node.getString("colour"), i));
				characters.get(i).setnumber(i);
				}
			for(int i=0;i<links.size();i++)
			{
				JSONObject link = links.getJSONObject(i);
				characters.get(link.getInt("source")).addTarget(characters.get(link.getInt("target")));
			}
	}
	
	public void mouseDragged()
	{
		for(Character character : characters)
			character.mouseDragged();
	}
	public void mouseReleased()
	{
		for(Character character : characters)
			character.mouseReleased();
	}
	public void mousePressed() 
	{
		for(Character character : characters)
			character.mousePressed();
	}
	public void keyPressed(){
		if(key >= '1' && key <= '7')
		{
			ep = key-'0';
			setup();			
		}
	}
}
