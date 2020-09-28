import java.util.*;
public class App
{

    public static void main(String[] args)
    {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }


    public static boolean moreInput()
    {

       Scanner in = new Scanner(System.in);
       String yes = "Y";

       System.out.println("Enter Y or N");
       String input = in.nextLine();

       if(yes.equals(input))
       {
           return true;
       }
       else
       {
           return false;
       }
    }


    public static double getUserHeight()
    {

        Scanner in = new Scanner(System.in);
        double input = -1;

        while(input <= 0)
        {
            System.out.println("Enter your height in inches");
            input = in.nextDouble();
            in.nextLine();

            if(input <= 0)
            {
                System.out.println("Invalid input, try again");
            }
        }

        return input;
    }


    public static double getUserWeight()
    {

        Scanner in = new Scanner(System.in);
        double input = -1;

        while(input <= 0)
        {
            System.out.println("Enter your weight in pounds");
            input = in.nextDouble();
            in.nextLine();

            if(input <= 0)
            {
                System.out.println("Invalid input, try again");
            }
        }

        return input;
    }

    public static double totals = 0;

    public static void displayBmiInfo(BodyMassIndex BMI)
    {
        totals += BMI.userBMI;
        System.out.printf("Your BodyMassIndex Score is %.2f\n", BMI.userBMI);
        System.out.printf("Your BodyMassIndex Category is %s\n", BMI.userCategory);
    }


    public static void displayBmiStatistics(ArrayList data)
    {
        int size = data.size();
        double average;

        average = totals / size;
        System.out.printf("The average of the scores is %.2f", average);

    }

}

