import java.io.Serializable;
import java.time.LocalDate;


public class TaskItem implements Serializable
{
    private final LocalDate Today = LocalDate.now();
    private LocalDate DueDate;
    private String Title;
    private String Description;
    private String Completion = "";

    public TaskItem(String DueDate, String Title, String Description)
    {
        if (isDueDateValid(DueDate) == 1)
            this.DueDate = LocalDate.parse(DueDate);

        if (isDueDateValid(DueDate) == 2)
            throw new IllegalDDFormatEx("Due date must be in format YYYY-MM-DD (Make sure to include zeros).");

        if (isDueDateValid(DueDate) == 3)
            throw new IllegalDDDateEx("Due date must be after the date today.");

        if (isTitleValid(Title))
            this.Title = Title + ":";
        else
            throw new IllegalTitleEx("Title must have at least 1 character.");

        this.Description = Description;
    }

    public void EditItem(String DueDate, String Title, String Description)
    {
        if (isDueDateValid(DueDate) == 2)
        {
            System.out.print("New due date must be in format YYYY-MM-DD.\n\n");
            return;
        }
        if (isDueDateValid(DueDate) == 3)
        {
            System.out.print("New due date must be after the date today.\n\n");
            return;
        }
        if (!isTitleValid(Title))
        {
            System.out.print("New title has to be at least 1 character.\n\n");
            return;
        }
            this.DueDate = LocalDate.parse(DueDate);
            this.Title = Title + ":";
            this.Description = Description;
    }

    public void setCompletion()
    {
        this.Completion = "***";
    }

    public void unsetCompletion()
    {
        this.Completion = "";
    }

    public boolean getCompletion()
    {
        return Completion.length() == 3;
    }

    // Return Values: 1 if valid; 2 if incorrect format; 3 if after today
    public int isDueDateValid(String Date)
    {
        LocalDate test;
        try{
            test = LocalDate.parse(Date);
        }catch(Exception ex){
            return 2;
        }

        if (!test.isAfter(Today))
            return 3;

        return 1;
    }

    public boolean isTitleValid(String Title)
    {
        return Title.length() >= 1;
    }

    public String getDueDate()
    {
        return DueDate.toString();
    }

    public String getTitle()
    {
        return Title;
    }

    public String getDescription()
    {
        return Description;
    }

    public String getItem()
    {
        return Completion + " " + "[" + DueDate + "]" + " " + Title + " " + Description;
    }

    static class IllegalDDFormatEx extends IllegalArgumentException
    {
        public IllegalDDFormatEx(String msg)
        {
            super(msg);
        }
    }
    static class IllegalDDDateEx extends IllegalArgumentException
    {
        public IllegalDDDateEx(String msg)
        {
            super(msg);
        }
    }
    static class IllegalTitleEx extends IllegalArgumentException
    {
        public IllegalTitleEx(String msg)
        {
            super(msg);
        }
    }
}
