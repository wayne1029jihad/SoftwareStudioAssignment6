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
<<<<<<< HEAD
public class MainApplet extends PApplet implements MouseListener,ActionListener{
	int ep ;
=======
public class MainApplet extends PApplet{
	public int ep = 1;
>>>>>>> 3d78c5b77f2a5a72532e6cb93eba64a00f80a986
	private String path = "main/resources/";
	private String file = "starwars-episode-"+ep+"-interactions.json";
	 
	public ArrayList<Character> characters;
	private Network network = new Network(this);
<<<<<<< HEAD
	private final static int width = 1200, height = 650;
	JSONObject data;
	public Button addall,clear;
=======
	private final static int width = 1200, height = 600;
	JSONObject data;
>>>>>>> 3d78c5b77f2a5a72532e6cb93eba64a00f80a986
	
	public void setup() {
		size(width, height);
		characters = new ArrayList<Character>();
<<<<<<< HEAD
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
=======
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
		background(70, 70, 121);
		network.display();
		for(Character character : characters)
			character.display();		
		fill(0);
		textSize(30);
		text("Star Wars "+ep, 600, 20,600+"ADD ALL".length(),40);
>>>>>>> 3d78c5b77f2a5a72532e6cb93eba64a00f80a986
	}

	

	private void loadData(){
			
			file = "starwars-episode-"+ep+"-interactions.json";
			data=loadJSONObject(path+file);
			JSONArray nodes=data.getJSONArray("nodes"), links=data.getJSONArray("links");
			for (int i = 0; i < nodes.size(); i++) {
				JSONObject node = nodes.getJSONObject(i);
<<<<<<< HEAD
				characters.add(new Character(this, node.getString("name"), node.getString("colour"), i));
=======
				characters.add(new Character(this,network,node.getString("name"), node.getString("colour"), i));
>>>>>>> 3d78c5b77f2a5a72532e6cb93eba64a00f80a986
				characters.get(i).setnumber(i);
				}
			for(int i=0;i<links.size();i++)
			{
				JSONObject link = links.getJSONObject(i);
				characters.get(link.getInt("source")).addTarget(characters.get(link.getInt("target")));
			}
	}
<<<<<<< HEAD
=======
	
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
>>>>>>> 3d78c5b77f2a5a72532e6cb93eba64a00f80a986
	public void keyPressed(){
		if(key >= '1' && key <= '7')
		{
			ep = key-'0';
			setup();			
		}
	}
<<<<<<< HEAD

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
=======
}
>>>>>>> 3d78c5b77f2a5a72532e6cb93eba64a00f80a986
