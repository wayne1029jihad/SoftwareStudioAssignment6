package main.java;

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

}
