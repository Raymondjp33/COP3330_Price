import java.util.Scanner;

public class MainApp
{

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        int i = 0;

        while (i != 3)
        {
            i = getIndexMain();

            if (i == 1)
                TaskApp.run();

             if (i == 2)
                ContactApp.run();
        }
    }

    private static int getIndexMain()
    {
        String Input;
        int numInput;
        Scanner sc = new Scanner(System.in);

        PrintMenu();
        Input = sc.nextLine();
        numInput = getValidInt(Input);

        return numInput;
    }

    private static int getValidInt(String str)
    {
        int retval;

        if (str.length() > 1)
        {
            System.out.print("\nInvalid input\n\n");
            return getIndexMain();
        }
        try
        {
            retval = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.print("\nInvalid input, please input a number.\n\n");
            return getIndexMain();
        }

        if (retval > 3 || retval < 1)
        {
            System.out.print("\nPlease input a number between 1 and 3\n\n");
            return getIndexMain();
        }

        return retval;
    }

    private static void PrintMenu()
    {
        System.out.print("Select Your Application\n-----------------------\n\n" +
                         "1) Task List\n2) Contact List\n3) Quit\n\n");
    }

}
