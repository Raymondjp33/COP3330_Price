import java.io.Serializable;
import java.util.ArrayList;
import java.time.LocalDate;

public class TaskList implements Serializable
{
    private final LocalDate Today = LocalDate.now();
    ArrayList<TaskItem> ItemList = new ArrayList<>();
    ArrayList<TaskItem> CompleteItemList = new ArrayList<>();
    ArrayList<TaskItem> IncompleteItemList = new ArrayList<>();




    public void AddItem()
    {
        LocalDate DueDate;
        String Title;
        String Description;
        TaskItem task = new TaskItem();

        Title = getUsersTitle(1);
        Description = getUsersDescription(1);
        DueDate = getUsersDueDate(1);

        task.setTitle(Title);
        task.setDescription(Description);
        task.setDueDate(DueDate);

        ItemList.add(task);
        IncompleteItemList.add(task);
    }

    public void EditItem()
    {

        LocalDate DueDate;
        String Title;
        String Description;
        int i;

        PrintList(ItemList);
        i = getIndex(ItemList);
        if (i == -1)
            return;

        Title = getUsersTitle(2);
        Description = getUsersDescription(2);
        DueDate = getUsersDueDate(2);

        ItemList.get(i).setTitle(Title);
        ItemList.get(i).setDescription(Description);
        ItemList.get(i).setDueDate(DueDate);
    }

    public void RemoveItem()
    {
        int i;

        PrintList(ItemList);
        i = getIndex(ItemList);
        if (i == - 1)
            return;

        if (ItemList.get(i).getCompletion())
            CompleteItemList.remove(ItemList.get(i));
        else
            IncompleteItemList.remove(ItemList.get(i));

        ItemList.remove(i);
    }

    public void MarkItem()
    {
        int i;

        PrintNotCompletedList(IncompleteItemList);
        i = getIndex(IncompleteItemList);
        if (i == - 1)
            return;

        IncompleteItemList.get(i).setCompletionMark();
        IncompleteItemList.get(i).setComplete();
        CompleteItemList.add(IncompleteItemList.get(i));
        IncompleteItemList.remove(i);
    }

    public void UnmarkItem()
    {
        int i;

        PrintCompletedList(CompleteItemList);
        i = getIndex(CompleteItemList);
        if (i == - 1)
            return;

        CompleteItemList.get(i).unsetCompletionMark();
        CompleteItemList.get(i).setIncomplete();
        IncompleteItemList.add(CompleteItemList.get(i));
        CompleteItemList.remove(i);
    }

    private int getIndex(ArrayList<TaskItem> list)
    {
        int i = 0;
        int loop = 1;

        if (list.size() == 0)
        {
            System.out.print("No tasks in this list\n\n");
            return -1;
        }

        while (loop == 1)
        {
            System.out.print("\nPlease select the desired task by inputting the corresponding index:  ");
            i = App.sc.nextInt();
            App.sc.nextLine();

            if ((i < 0) || (i >= list.size()))
                System.out.print("\nInvalid index, please try again.\n\n");
            else
                loop = 0;
        }

        return i;
    }

    private String getUsersTitle(int i)
    {
        String Title;

        while(true)
        {
            if (i == 1)
                System.out.print("Task Title:  ");
            if (i == 2)
                System.out.print("New task Title:  ");


            Title = App.sc.nextLine();
            if (Title.length() == 0)
                System.out.println("\nTitle must have at least 1 character.\n");
            else
                break;
        }
        return Title;
    }

    private String getUsersDescription(int i)
    {
        String Description;

        while(true)
        {
            if (i == 1)
                System.out.print("Task description:  ");
            if (i == 2)
                System.out.print("New task description:  ");


            Description = "| " + App.sc.nextLine();
            if (Description.length() == 0)
                System.out.print("\nDescription must have at least 1 character.\n\n");
            else
                break;
        }
        return Description;
    }

    private LocalDate getUsersDueDate(int i)
    {
        LocalDate DueDate;
        String Date;

        while(true)
        {
            if (i == 1)
                System.out.print("Task due date (YYYY-MM-DD):  ");
            if (i == 2)
                System.out.print("New task due date (YYYY-MM-DD):  ");


            Date = App.sc.nextLine();
            System.out.print("\n\n");

            try
            {
                DueDate = LocalDate.parse(Date);
            }catch(Exception ex) {
                System.out.print("Please enter date in correct format (YYYY-MM-DD).\nMake sure to include zeros in dates.\n\n");
                continue;
            }

            if (!DueDate.isAfter(Today))
                System.out.print("Date must be after the date today.\n");
            else
                break;
        }
        return DueDate;
    }

    public static void PrintList(ArrayList<TaskItem> list)
    {
        int i;
        System.out.print("Current tasks\n-------------\n\n");
        for (i = 0; i < list.size(); i++)
            System.out.printf("%d) %s\n", i, list.get(i).getItem());
        System.out.print("\n");
    }

    private static void PrintCompletedList(ArrayList<TaskItem> list)
    {
        int i;
        System.out.print("Completed tasks\n-------------\n\n");
        for (i = 0; i < list.size(); i++)
            System.out.printf("%d) %s\n", i, list.get(i).getItem());
        System.out.print("\n");
    }

    private static void PrintNotCompletedList(ArrayList<TaskItem> list)
    {
        int i;
        System.out.print("Incomplete tasks\n-------------\n\n");
        for (i = 0; i < list.size(); i++)
            System.out.printf("%d) %s\n", i, list.get(i).getItem());
        System.out.print("\n");
    }

}
