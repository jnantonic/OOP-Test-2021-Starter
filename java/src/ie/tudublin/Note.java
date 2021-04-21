package ie.tudublin;

public class Note
{
    private char note;
    private int duration;
    private String type;

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
    public String getType()
    {
        return type;
    }
    public void setType(String type)
    {
        this.type = type;
    }
    @Override
    public String toString()
    {
        return "Note [duration=" + duration + ", note=" + note + ", type=" + type + "]";
    }

    

    
}
