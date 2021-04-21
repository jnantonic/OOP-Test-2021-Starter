package ie.tudublin;

import processing.data.TableRow;

public class Note
{
    private String note;
    private int duration;
    private String type;

    public Note(TableRow row)
    {   
        this
        (
            row.getString("Note"),
            row.getInt("Duration"),
            row.getString("Type")
        );
    }

    
    public Note(String note, int duration, String type)
    {
        this.note = note;
        this.duration = duration;
        this.type = type;
    }


    public String getNote() {
        return note;
    }


    public void setNote(String note) {
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
    public String getType()
    {
        return type;
    }
    public void setType(String type)
    {
        this.type = type;
    }


    @Override
    public String toString() {
        return "Note [duration=" + duration + ", note=" + note + ", type=" + type + "]";
    }
    
    
    

    
}
