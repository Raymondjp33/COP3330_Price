import java.util.Scanner;

public class TaskApp
{

    public static void run()
    {
        int i = 0;

        while (i != 3)
        {
            i = getIndexTaskApp(1);

            if (i == 1)
            {
                TaskList list = new TaskList();
                TaskListHandler(list);
            }


            if (i == 2)
               FileHandler.LoadTaskList();
        }
    }

    public static void TaskListHandler(TaskList list)
    {
        int i = 0;

        while (i != 8)
        {
            i = getIndexTaskApp(2);

            if (i == 1)
                list.PrintList(list.ItemList, 1);

            if (i == 2)
                list.AddItem();

            if (i == 3)
                list.EditItem();

            if (i == 4)
                list.RemoveItem();

            if (i == 5)
                list.MarkItem();

            if (i == 6)
                list.UnmarkItem();

            if (i == 7)
            {
                FileHandler.SaveTaskList(list);
                i = 8;
            }
        }
    }

    private static int getIndexTaskApp(int i)
    {
        String Input;
        int numInput;
        Scanner sc = new Scanner(System.in);

        if (i == 1)
            PrintTaskMenu();
        if (i == 2)
            PrintOperationsMenu();

        Input = sc.nextLine();
        numInput = getValidInt(Input, i);

        return numInput;
    }

    private static int getValidInt(String str, int i)
    {
        int retval;

        if (str.length() > 1)
        {
            System.out.print("\nInvalid input\n\n");
            return getIndexTaskApp(i);
        }
        try
        {
            retval = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.print("\nInvalid input, please input a number.\n\n");
            return getIndexTaskApp(i);
        }

        if (i == 1 && (retval > 3 || retval < 1))
        {
            System.out.print("\nPlease input a number between 1 and 3\n\n");
            return getIndexTaskApp(i);
        }
        if (i == 2 && (retval > 8 || retval < 1))
        {
            System.out.print("\nPlease input a number between 1 and 8\n\n");
            return getIndexTaskApp(i);
        }

        return retval;
    }

    private static void PrintTaskMenu()
    {
        System.out.print("TaskApp Main Menu\n" +
                         "-----------------\n\n" +
                         "1) Create a new task list\n" +
                         "2) Load an existing task list\n" +
                         "3) Exit the program\n\n");
    }

    private static void PrintOperationsMenu()
    {
        System.out.print("List Operations Menu\n" +
                         "--------------------\n\n" +
                         "1) View the list\n" +
                         "2) Add an item to the list\n" +
                         "3) Edit an item on the list\n" +
                         "4) Remove an item on the list\n" +
                         "5) Mark an item as completed\n" +
                         "6) Unmark an item as completed\n" +
                         "7) Save the current list\n" +
                         "8) Exit to the main menu\n\n");
    }
}
