package ie.tudublin;

public class Note
{
    private char note;
    private int duration;
    

    @Override
    public String toString()
    {
        return note + "\t" + duration + "\t" + ((duration == 2) ? "Crotchet" : "Quaver");
    }
    

    public Note(char note, int duration)
    {
        this.note = note;
        this.duration = duration;
    }
    
    public char getNote()
    {
        return note;
    }

    public void setNote(char note)
    {
        this.note = note;
    }

    public int getDuration()
    {
        return duration;
    }

    public void setDuration(int duration)
    {
        this.duration = duration;
    }

    private String scale = "DEFGABcd";

    private int noteValue()
    {
        for(int i = 0; i < scale.length(); i++)
        {
            if(note == scale.charAt(i))
            {
                return i;
            }
        }
        return -1;
    }

    public void render(ScoreDisplay sd, float x, boolean highlight)
    {
        float y = sd.bottom - (noteValue() * (sd.gap * 0.5f));
        sd.noStroke();
        if(highlight)
        {
            sd.fill(255, 0, 0);
        }
        else
        {
            sd.fill(0);
        }
        sd.ellipse(x, y, 18, 18);
        sd.strokeWeight(2);

        if(highlight)
        {
            sd.stroke(255, 0, 0);
            sd.fill(255, 0, 0);
        }
        else
        {
            sd.stroke(0);
            sd.fill(0);
        }

        sd.line(x + 8, y, x + 8, y - 50);

        if(duration == 1)
        {
            sd.line(x + 8, y - 50, x + 20, y - 30);
        }
        sd.fill(0);
        sd.textSize(16);
        sd.text(note, x, sd.top - 20);
    }
}
