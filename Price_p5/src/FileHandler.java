import java.io.*;
import java.util.Scanner;

public class FileHandler
{
    static Scanner sc = new Scanner(System.in);

    public static void SaveTaskList(TaskList list)
    {
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

    public static void SaveContactList(ContactList list)
    {
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

    public static void LoadTaskList()
    {
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
            return;
        } catch(Exception e)
        {
            System.out.print("An error occurred :(\n\n");
            return;
        }

        TaskApp.TaskListHandler(list);
    }

    public static void LoadContactList()
    {
        String FileName;
        System.out.print("\nEnter the name of the file you want to load\n\n");
        FileName = sc.nextLine();
        ContactList list;

        try
        {
            FileInputStream fileIn = new FileInputStream(FileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            list = (ContactList) in.readObject();
            in.close();
            fileIn.close();
            System.out.print("\nLoaded list successfully!!\n\n");
        }catch(FileNotFoundException e)
        {
            System.out.print("\nFile not found\n\n");
            return;
        }catch(IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
            return;
        }catch(Exception e)
        {
            System.out.print("An error occurred :(\n\n");
            return;
        }

        ContactApp.ContactListHandler(list);
    }
}
