package main.java;
import java.lang.Object;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
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
public class MainApplet extends PApplet implements MouseListener,ActionListener{
	int ep ;
	private String path = "main/resources/";
	private String file = "starwars-episode-"+ep+"-interactions.json";
	 
	public ArrayList<Character> characters;
	private Network network = new Network(this);
	private final static int width = 1200, height = 650;
	JSONObject data;
	public Button addall,clear;
	
	public void setup() {
		size(width, height);
		characters = new ArrayList<Character>();
		this.noStroke();
		smooth();
		loadData();	
		
		addall=new Button ("Add All");
		addall.setBounds(1000,20,50,30);
		addall.addActionListener(this);
		add(addall);
		addall.setEnabled(true);
		
		clear=new Button ("CLEAR");
		clear.addActionListener(this);
		addall.setBounds(1000,60,50,30);
		add(clear);
		clear.setEnabled(true);
	}

	public void draw() {
		background(220);
		
		for(Character character : characters)
			character.display();
		/*network.display();
		fill(0);
		textSize(30);
		text("Star Wars "+ep, 600, 20,600+"ADD ALL".length(),40);*/
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
	public void keyPressed(){
		if(key >= '1' && key <= '7')
		{
			ep = key-'0';
			setup();			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource()==addall)
		{
			
				network.putoncircle(characters,characters.size());
				for(int i=0;i<characters.size();i++)
					network.characters.add(characters.get(i));
			
		}
		else if(e.getSource()==clear)
		{
			network.CLEARALL();
		}
	}
}