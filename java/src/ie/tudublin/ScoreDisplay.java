package ie.tudublin;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;


public class ScoreDisplay extends PApplet
{
	

	String score = "DEFGABcd";
	//String score = "D2E2F2G2A2B2c2d2";
	//String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";
	
	ArrayList<Note> note = new ArrayList<Note>();

	private float border;

	public void loadScore()
	{
		Table table = loadTable("score.csv", "header");
		for(TableRow row:table.rows())
		{
			Note n = new Note(row);
			note.add(n);
		}
	}

	public void printScore()
	{
		for(Note n:note)
		{
			println(n);
		}
	}

	public void settings()
	{
		size(1000, 500);

		// How to convert a character to a number
		char c = '7'; // c holds the character 7 (55)
		int i = c - '0'; // i holds the number 7 (55 - 48) 
		println(i);
	}

	public void setup() 
	{
		loadScore();
		printScore();
		border = width * 0.1f;

	}

	public void draw()
	{
		background(255);
		drawNotes();
	}



	void drawNotes()
	{

		for(int i = 0; i < note.size(); i ++)
		{
			Note n = note.get(i);
			float x = map(i, 0, note.size(), border, width - border);
			noStroke();
			fill(0);
			textAlign(CENTER);
			textSize(20);
			text(n.getNote(), x + 10, height / 2 - 50);

		}


		for(int i = 1; i <= 5; i ++)
		{
			float y = map(i, 1, 5, height / 2, height / 2 + 100);
			stroke(0);
			strokeWeight(3);
			line(border, y, width - border, y);
		}


		
	}
}
