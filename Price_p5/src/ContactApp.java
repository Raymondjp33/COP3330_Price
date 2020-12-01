import java.util.Scanner;

public class ContactApp
{

    public static void run()
    {
        int i = 0;

        while (i != 3)
        {
            i = getIndexContactApp(1);

            if (i == 1)
            {
                ContactList list = new ContactList();
                ContactListHandler(list);
            }


            if (i == 2)
                FileHandler.LoadContactList();
        }
    }

    public static void ContactListHandler(ContactList list)
    {
        int i = 0;

        while (i != 6)
        {
            i = getIndexContactApp(2);

            if (i == 1)
                list.PrintList(list.ContactList);

            if (i == 2)
                list.AddItem();

            if (i == 3)
                list.EditItem();

            if (i == 4)
                list.RemoveItem();

            if (i == 5)
            {
                FileHandler.SaveContactList(list);
                i = 6;
            }
        }
    }

    private static int getIndexContactApp(int i)
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
            return getIndexContactApp(i);
        }
        try
        {
            retval = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.print("\nInvalid input, please input a number.\n\n");
            return getIndexContactApp(i);
        }

        if (i == 1 && (retval > 3 || retval < 1))
        {
            System.out.print("\nPlease input a number between 1 and 3\n\n");
            return getIndexContactApp(i);
        }
        if (i == 2 && (retval > 6 || retval < 1))
        {
            System.out.print("\nPlease input a number between 1 and 6\n\n");
            return getIndexContactApp(i);
        }

        return retval;
    }

    private static void PrintTaskMenu()
    {
        System.out.print("ContactApp Main Menu\n" +
                         "--------------------\n\n" +
                         "1) Create a new contact list\n" +
                         "2) Load an existing contact list\n" +
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
                         "5) Save the current list\n" +
                         "6) Exit to the main menu\n\n");
    }
}
