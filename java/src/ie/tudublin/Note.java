package ie.tudublin;

import processing.data.TableRow;

public class Note
{
    private char note;
    private int duration;
    
    public Note(char note, int duration)
    {
        this.note = note;
        this.duration = duration;
    }


    public char getNote() {
        return note;
    }


    public void setNote(char note) {
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


    @Override
    public String toString() 
    {
        String tmp;

        if(duration == 2)
        {
            tmp = "Crotchet";
        }
        else
        {
            tmp = "Quaver";
        }
        return note + "\t" + duration + "\t" + tmp;
    }
    
    
    

    
}

