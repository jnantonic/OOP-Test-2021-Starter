package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class ScoreSol extends PApplet
{
	
	String score = "DEFGABcd";
	//String score = "D2E2F2G2A2B2c2d2";
	//String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";
	float[] c;
	float colour = 0;
	
	ArrayList<Note> note = new ArrayList<Note>();
		
	private float border;
	public float hh;
	
	public void loadScore()
	{
		int t = 1;
		for(int i = 0; i < score.length(); i++)
		{
			char c = score.charAt(i);
			if(Character.isLetter(c))
			{
				if(Character.isDigit(i + 1))
				{
					t = score.charAt(i + 1) - '0';
				}
				Note n = new Note(c, t);
				note.add(n);
				 
			}
		}
		c = new float[note.size()];
		for(int i = 0; i < c.length; i++)
		{
			Note n = note.get(i);
			c[i] = n.getNote();
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
		fill(colour, 0, 0);
		drawNotes();
	}

	

	void drawNotes()
	{
		hh = height / 2;
		for(int i = 0; i < note.size(); i ++)
		{
			Note n = note.get(i);
			float x = map(i, 0, note.size(), border, width - border);
			
			noStroke();
			fill(0);
			textAlign(CENTER);
			textSize(20);
			text(n.getNote(), x + 15, hh - 50);

			if(i < c.length)
			{
				stroke(0);
				strokeWeight(3);
				
				if(c[i] == 'D' || c[i] == 'd')
				{
					if(c[i] == 'D')
					{
						if(i == 0)
						{
							line(x + 20, hh + 50, x + 33, hh + 63);
						}
						if(dist(mouseX, mouseY, x + 10, hh + 113) < 21)
						{
							colour = 255;
						}
						else
						{
							colour = 0;
						}
						fill(colour, 0, 0); 
						line(x + 20, hh + 50, x + 20, hh + 113);
						circle(x + 10, hh + 113, 21);
					}
					if(c[i] == 'd')
					{
						if(i == 0)
						{
							line(x + 20, hh + 50, x + 33, hh + 63);
						}
						if(dist(mouseX, mouseY, x + 10, hh + 31) < 21)
						{
							colour = 255;
						}
						else
						{
							colour = 0;
						}
						fill(colour, 0, 0); 
						line(x + 20, hh + 31, x + 20, hh - 35);
						circle(x + 10, hh + 31, 21);
					}
				}

				else if(c[i] == 'c')
				{
					if(i == 0)
					{
						line(x + 20, hh + 50, x + 33, hh + 63);
					}
					if(dist(mouseX, mouseY, x + 10, hh + 40) < 21)
					{
						colour = 255;
					}
					else
					{
						colour = 0;
					}
					fill(colour, 0, 0); 
					line(x + 20, hh + 40, x + 20, hh - 25);
					circle(x + 10, hh + 40, 21);
				}

				else if(c[i] == 'E')
				{
					if(i == 1 || i == 5)
					{
						line(x + 20, hh + 35, x + 33, hh + 48);
					}
					if(dist(mouseX, mouseY, x + 10, hh + 99) < 21)
					{
						colour = 255;
					}
					else
					{
						colour = 0;
					}
					fill(colour, 0, 0); 
					line(x + 20, hh + 35, x + 20, hh + 99);
					circle(x + 10, hh + 99, 21);
				}

				else if(c[i] == 'F')
				{
					if(i == 6 || i == 11)
					{
						line(x + 20, hh + 25, x + 33, hh + 38);
					}
					if(dist(mouseX, mouseY, x + 10, hh + 88) < 21)
					{
						colour = 255;
					}
					else
					{
						colour = 0;
					}
					fill(colour, 0, 0); 
					line(x + 20, hh + 25, x + 20, hh + 88);
					circle(x + 10, hh + 88, 21);
				}

				else if(c[i] == 'G')
				{
					if(dist(mouseX, mouseY, x + 10, hh + 77) < 21)
					{
						colour = 255;
					}
					else
					{
						colour = 0;
					}
					fill(colour, 0, 0); 
					line(x + 20, hh + 14, x + 20, hh + 77);
					circle(x + 10, hh + 77, 21);
				}

				else if(c[i] == 'A')
				{
					if(i == 10)
					{
						line(x + 20, hh, x + 33, hh + 13);
					}

					if(dist(mouseX, mouseY, x + 10, hh + 63) < 21)
					{
						colour = 255;
					}
					else
					{
						colour = 0;
					}
					fill(colour, 0, 0); 
					line(x + 20, hh, x + 20, hh + 63);
					circle(x + 10, hh + 63, 21);
				}

				else
				{
					if(dist(mouseX, mouseY, x + 10, hh + 55) < 21)
					{
						colour = 255;
					}
					else
					{
						colour = 0;
					}
					fill(colour, 0, 0); 
					line(x + 20, hh - 10, x + 20, hh + 55);
					circle(x + 10, hh + 55, 21);
				}
			}
		}

		for(int i = 1; i <= 5; i ++)
		{
			hh = height / 2;
			float y = map(i, 1, 5, hh, hh + 100);
			stroke(0);
			strokeWeight(3);
			line(border, y, width - border, y);
		}


		
	}
}