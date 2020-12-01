import java.io.Serializable;
import java.util.ArrayList;

public class TaskList implements Serializable
{
    ArrayList<TaskItem> ItemList = new ArrayList<>();
    ArrayList<TaskItem> CompleteItemList = new ArrayList<>();
    ArrayList<TaskItem> IncompleteItemList = new ArrayList<>();


    public void AddItem()
    {
        System.out.print("Enter Task Due Date: ");
        String DueDate = MainApp.sc.nextLine();

        System.out.print("Enter Task Title: ");
        String Title = MainApp.sc.nextLine();

        System.out.print("Enter Task Description: ");
        String Description = MainApp.sc.nextLine();
        System.out.print("\n");

        try{
            TaskItem item = new TaskItem(DueDate, Title, Description);
            ItemList.add(item);
            IncompleteItemList.add(item);
        }catch(Exception ex)
        {
            System.out.print(ex.getMessage() + "\n\n");
        }
    }

    public void EditItem()
    {
        int i;

        PrintList(ItemList, 1);
        i = getIndex(ItemList);
        if (i == -1)
            return;

        System.out.print("Enter Task Due Date: ");
        String DueDate = MainApp.sc.nextLine();

        System.out.print("Enter Task Title: ");
        String Title = MainApp.sc.nextLine();

        System.out.print("Enter Task Description: ");
        String Description = MainApp.sc.nextLine();
        System.out.print("\n");

        ItemList.get(i).EditItem(DueDate, Title, Description);
    }

    public void RemoveItem()
    {
        int i;

        PrintList(ItemList, 1);
        i = getIndex(ItemList);
        if (i == -1)
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

        PrintList(IncompleteItemList, 3);
        i = getIndex(IncompleteItemList);
        if (i == -1)
            return;

        IncompleteItemList.get(i).setCompletion();
        CompleteItemList.add(IncompleteItemList.get(i));
        IncompleteItemList.remove(i);
    }

    public void UnmarkItem()
    {
        int i;

        PrintList(CompleteItemList, 3);
        i = getIndex(CompleteItemList);
        if (i == -1)
            return;

        CompleteItemList.get(i).unsetCompletion();
        IncompleteItemList.add(CompleteItemList.get(i));
        CompleteItemList.remove(i);
    }

    public int getIndex(ArrayList<TaskItem> list)
    {
        int i;
        String input;

        if (list.size() == 0)
        {
            System.out.print("No tasks in this list\n\n");
            return -1;
        }

        System.out.print("\nPlease select the desired task by inputting the corresponding index:  ");
        input = MainApp.sc.nextLine();
        i = getValidInt(input);

        if (i != -1 && BadIndexCheck(list, i))
        {
            System.out.print("\nInvalid index, please try again.\n\n");
            return -1;
        }

        return i;
    }

    public static int getValidInt(String str)
    {
        int i;

        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.print("\nCharacter inputted must be a number\n\n");
            return -1;

        }
        return i;
    }

    public boolean BadIndexCheck(ArrayList<TaskItem> list, int i)
    {
        return i < 0 || i >= list.size();
    }

    public void PrintList(ArrayList<TaskItem> list, int i)
    {
        if (i == 1)
            System.out.print("All tasks\n-------------\n\n");

        if (i == 2)
            System.out.print("Completed tasks\n-------------\n\n");

        if (i == 3)
            System.out.print("Incomplete tasks\n-------------\n\n");


        for (i = 0; i < list.size(); i++)
            System.out.printf("%d) %s\n", i, list.get(i).getItem());

        System.out.print("\n");
    }
}
