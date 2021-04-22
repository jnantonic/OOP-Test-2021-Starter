package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

// ABC language is a markup file for a music score

public class ScoreDisplay extends PApplet
{
	//String score = "DEFGABcd";
	//String score = "D2E2F2G2A2B2c2d2";
	String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";
	
	ArrayList<Note> notes = new ArrayList<Note>();


	private void printNotes()
	{
		for(Note n:notes)
		{
			System.out.println(n);
		}
	}

	private void parseNotes()
	{
		int i = 0;
		while(i < score.length())
		{
			char c = score.charAt(i);
			int duration = 1;
			if(i < score.length() - 1) // At least one character to read further
			{
				char next = score.charAt(i + 1);
				if(Character.isDigit(next))
				{
					duration = next - '0';
					i++;
				}
			}
			i++;
			Note n = new Note(c, duration);
			notes.add(n);
		}
	}

	float border;
	float top = 100;
	float gap = 20;
	float bottom = top + (gap * 4) + (gap * 0.5f);


	public void drawStaveLines()
	{
		stroke(0);
		for(int i = 0; i < 5; i++)
		{
			float y = top + (i * gap);
			line(border, y, width - border, y);
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
		parseNotes();
		printNotes();

		border = width * 0.1f;
	}

	public void draw()
	{
		background(255);
		drawStaveLines();
		drawNotes();
	}

	void drawNotes()
	{
		for(int i = 0; i < notes.size(); i++)
		{
			float x = border + (i * gap * 2) + 50;
			Note n = notes.get(i);
			n.render(this, x, (mouseX > x - 20 && mouseX < x + 20));
		}
	}
}