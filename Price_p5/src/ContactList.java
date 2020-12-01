import java.io.Serializable;
import java.util.ArrayList;

public class ContactList implements Serializable
{
    ArrayList<ContactItem> ContactList = new ArrayList<>();

    public void AddItem()
    {
        System.out.print("Please enter a first name: ");
        String FirstName = MainApp.sc.nextLine();

        System.out.print("Please enter a last name: ");
        String LastName = MainApp.sc.nextLine();

        System.out.print("Please enter a phone number (10 digits): ");
        String PhoneNumber = MainApp.sc.nextLine();

        System.out.print("Please enter a valid email address: ");
        String EmailAddress = MainApp.sc.nextLine();
        System.out.print("\n");

        try{
            ContactItem item = new ContactItem(FirstName, LastName, PhoneNumber, EmailAddress);
            ContactList.add(item);
        }catch(Exception ex)
        {
            System.out.print(ex.getMessage() + "\n\n");
        }
    }

    public void EditItem()
    {
        int i;

        PrintList(ContactList);
        i = getIndex(ContactList);
        if (i == -1)
            return;

        System.out.print("Please enter a new first name: ");
        String FirstName = MainApp.sc.nextLine();

        System.out.print("Please enter a new last name: ");
        String LastName = MainApp.sc.nextLine();

        System.out.print("Please enter a new phone number (10 digits): ");
        String PhoneNumber = MainApp.sc.nextLine();

        System.out.print("Please enter a new valid email address: ");
        String EmailAddress = MainApp.sc.nextLine();

        ContactList.get(i).EditItem(FirstName, LastName, PhoneNumber, EmailAddress);
    }

    public void RemoveItem()
    {
        int i;

        PrintList(ContactList);
        i = getIndex(ContactList);
        if (i == -1)
            return;

        ContactList.remove(i);
    }

    public int getIndex(ArrayList<ContactItem> list)
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

    public boolean BadIndexCheck(ArrayList<ContactItem> list, int i)
    {
        return i < 0 || i >= list.size();
    }

    public void PrintList(ArrayList<ContactItem> list)
    {
        int i;

        System.out.print("Contact List\n" +
                         "------------\n\n");

        for (i = 0; i < list.size(); i++)
            System.out.printf("%d) %s\n", i, list.get(i).getItem());

        System.out.print("\n");
    }
}
