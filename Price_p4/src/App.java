import java.io.*;
import java.util.Scanner;


public class App
{
    public static Scanner sc = new Scanner(System.in);


    public static void main(String[] args)
    {
        int Input = 0;

        while (Input != 3)
        {
            Input = getInput(1);

            if (Input == 1)
            {
                TaskList list = new TaskList();
                TaskListHandler(list);
            }

            if (Input == 2)
            {
                TaskList list = LoadFile();
                if (list == null)
                    continue;

                TaskListHandler(list);
            }
        }

    }

    private static void TaskListHandler(TaskList list)
    {
        int numInput = 0;

        while (numInput != 8)
        {
            numInput = getInput(2);

            if (numInput == 1)
                TaskList.PrintList(list.ItemList);

            if (numInput == 2)
                list.AddItem();

            if (numInput == 3)
                list.EditItem();

            if (numInput == 4)
                list.RemoveItem();

            if (numInput == 5)
                list.MarkItem();

            if (numInput == 6)
                list.UnmarkItem();

            if (numInput == 7)
            {
                SaveList(list);
                numInput = 8;
            }

        }
    }

    private static int getInput(int i)
    {
        String Input;
        int numInput;
        Scanner sc = new Scanner(System.in);

        if (i == 1)
           PrintMenu();
        if (i == 2)
            PrintTaskMenu();
        Input = sc.nextLine();

        if (Input.length() > 1)
        {
            System.out.print("\nInvalid input\n\n");
            return getInput(i);
        }
        try
        {
            numInput = Integer.parseInt(Input);
        } catch (NumberFormatException e) {
            System.out.print("\nInvalid input, please input a number.\n\n");
            return getInput(i);
        }

        if (i == 2 && (numInput > 8 || numInput < 1))
        {
            System.out.print("\nPlease input a number between 1 and 8\n\n");
            return getInput(i);
        }
        if (i == 1 && (numInput > 3 || numInput < 1))
        {
            System.out.print("\nPlease input a number between 1 and 3\n\n");
            return getInput(i);
        }
        return numInput;
    }

    private static void SaveList(TaskList list)
    {
        Scanner sc = new Scanner(System.in);
        String FileName;
        System.out.print("\nEnter a name for the file to save as\n\n");
        FileName = sc.nextLine();

        try
        {
            FileOutputStream fileOut = new FileOutputStream(FileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(list);
            out.close();
            fileOut.close();
            System.out.print("\nSaved list successfully!!\n\n");
        }catch(FileNotFoundException e)
        {
            System.out.print("\nFile not found\n\n");
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    private static TaskList LoadFile()
    {
        Scanner sc = new Scanner(System.in);
        String FileName;
        System.out.print("\nEnter the name of the file you want to load\n\n");
        FileName = sc.nextLine();
        TaskList list;

        try
        {
            FileInputStream fileIn = new FileInputStream(FileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            list = (TaskList) in.readObject();
            in.close();
            fileIn.close();
            System.out.print("\nLoaded list successfully!!\n\n");
        }catch(FileNotFoundException e)
        {
            System.out.print("\nFile not found\n\n");
            return null;
        }catch(IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
            return null;
        }

        return list;
    }

    private static void PrintTaskMenu()
    {
        System.out.print("\nList Operation Menu\n-------------------\n\n1) View the list\n2) Add an item to the list\n3) Edit an item on the list\n");
        System.out.print("4) Remove an item on the list\n5) Mark an item as completed\n6) Unmark an item as completed\n7) Save the current list\n8) Exit to main menu\n\n");
    }


    private static void PrintMenu()
    {
        System.out.print("Main Menu\n ---------\n\n1) Create a new task\n2) Load an existing task\n3) Exit the program\n\n");
    }

}
