package main.java;
import java.lang.Object;
import java.awt.Button;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.JSONArray;
import processing.data.JSONObject;

/**
* This class is for sketching outcome using Processing
* You can do major UI control and some visualization in this class.  
*/
@SuppressWarnings("serial")
public class MainApplet extends PApplet{
	int ep;
	private String path = "main/resources/";
	private String file = "starwars-episode-"+ep+"-interactions.json";
	private ArrayList<Character> characters;
	private final static int width = 1200, height = 650;
	JSONObject data;

	
	
	public void setup() {

		size(width, height);
		characters = new ArrayList<Character>();
		this.noStroke();
		this.fill(2, 247, 141);
		this.rect(1120, 20, "ADD ALL".length()+5, 20);		
		textSize(26);
		this.fill(255);
		this.text("ADD ALL", 1123, 20,1123+"ADD ALL".length(),40);
		this.fill(2, 247, 141);
		this.rect(1120, 50, "CLEAR".length()+5, 70);		
		textSize(26);
		this.fill(255);
		this.text("CLEAR", 1123, 50,1123+"CLEAR".length(),70);
		smooth();
		loadData();
		
	}

	public void draw() {
		for(Character character : characters)
			character.display();
	}

	private void loadData(){
		for(ep=1;ep<8;ep++)
		{
			data=loadJSONObject(file);
			JSONArray nodes=data.getJSONArray("nodes"), links=data.getJSONArray("links");
			for (int i = 0; i < nodes.size(); i++) {
				JSONObject node = nodes.getJSONObject(i);
				characters.add(new Character(this, node.getString("name"), node.getString("colour")));
				}
			for(int i=0;i<links.size();i++)
			{
				JSONObject link = links.getJSONObject(i);
				characters.get(link.getInt("source")).addTarget(characters.get(link.getInt("target")));
				characters.get(link.getInt("source")).addTarget(characters.get(link.getInt("value")));
			}
		}
	}
	//¹ê§@addall,clear
	public void mouseClicked()
	{
		
	}

}
