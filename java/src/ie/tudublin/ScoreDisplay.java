package ie.tudublin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;


public class ScoreDisplay extends PApplet
{
	
	String score = "DEFGABcd";
	String str[] = score.split(",");
	//String score = "D2E2F2G2A2B2c2d2";
	//String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";
	
	ArrayList<Note> note = new ArrayList<Note>();
	List<String> s = new ArrayList<String>();
		

	private float border;
	
	/*public void isDigit()
	{
		for(int i = 0; i < s.size(); i++)
		{
			if(!(s.contains("0") || s.contains("1") || s.contains("2") || s.contains("3")  
				|| s.contains("4") || s.contains("5") || s.contains("6") 
				|| s.contains("7") || s.contains("8") || s.contains("9")))
			{
				 = 1;
			}
		}
			
		return true;
	}*/

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

	float[] c = {0, 1, 2, 2, 2, 1, 2, 4, 4, 5, 4, 2, 0, 1, 0, 0, 0};

	void drawNotes()
	{
		for(int i = 0; i < note.size(); i ++)
		{
			Note n = note.get(i);
			float x = map(i, 0, note.size(), border, width - border);
			//float y = map(i, 1, 5, height / 2, height / 2 + 100);
			
			noStroke();
			fill(0);
			textAlign(CENTER);
			textSize(20);
			text(n.getNote(), x + 15, height / 2 - 50);
			//float y = map(i, 0, c.length, x + 10, height / 2 - 50);
			if(i < c.length)
			{
				stroke(0);
				strokeWeight(3);
				fill(0);
				if(c[i] == 0)
				{
					if(i == 0)
					{
						line(x + 20, height / 2 + 50, x + 33, height / 2 + 63);
					}
					line(x + 20, height / 2 + 50, x + 20, height / 2 + 113);
					circle(x + 10, height / 2 + 113, 21);
				}
				else if(c[i] == 1)
				{
					if(i == 1 || i == 5)
					{
						line(x + 20, height / 2 + 35, x + 33, height / 2 + 48);
					}
					line(x + 20, height / 2 + 35, x + 20, height / 2 + 99);
					circle(x + 10, height / 2 + 99, 21);
				}
				else if(c[i] == 2)
				{
					if(i == 6 || i == 11)
					{
						line(x + 20, height / 2 + 25, x + 33, height / 2 + 38);
					}
					line(x + 20, height / 2 + 25, x + 20, height / 2 + 88);
					circle(x + 10, height / 2 + 88, 21);
				}
				else if(c[i] == 3)
				{
					line(x + 20, height / 2 + 14, x + 20, height / 2 + 77);
					circle(x + 10, height / 2 + 77, 21);
				}
				else if(c[i] == 4)
				{
					if(i == 10)
					{
						line(x + 20, height / 2, x + 33, height / 2 + 13);
					}
					line(x + 20, height / 2, x + 20, height / 2 + 63);
					circle(x + 10, height / 2 + 63, 21);
				}
				else
				{
					line(x + 20, height / 2 - 10, x + 20, height / 2 + 55);
					circle(x + 10, height / 2 + 55, 21);
				}
			}
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