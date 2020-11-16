import java.io.Serializable;
import java.time.LocalDate;

public class TaskItem implements Serializable
{
    private LocalDate DueDate;
    private String Title;
    private String Description;
    private String CompletionMark = "";
    private boolean Completed = false;


    public void setDueDate(LocalDate date)
    {
        DueDate = date;
    }

    public void setTitle(String Title)
    {
        this.Title = Title;
    }

    public void setDescription(String Description)
    {
        this.Description = Description;
    }

    public void setCompletionMark()
    {
        this.CompletionMark = "***";
    }

    public void unsetCompletionMark()
    {
        this.CompletionMark = "";
    }

    public void setComplete()
    {
        this.Completed = true;
    }

    public void setIncomplete()
    {
        this.Completed = false;
    }

    public boolean getCompletion()
    {
        return Completed;
    }

    public String getItem()
    {
        return CompletionMark + " " + "[" + DueDate + "]" + " " + Title + " " + Description;
    }

}
