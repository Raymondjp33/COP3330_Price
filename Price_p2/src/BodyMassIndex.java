public class BodyMassIndex
{

    public static double userBMI;
    public static String userCategory;
    
    BodyMassIndex(double height, double weight)
    {
        userBMI = findUserBMI(height, weight);
        findUserCategory(userBMI);
    }


    public static double findUserBMI(double height, double weight)
    {
        double BMI;
        BMI = (703 * weight) / (height * height);
        return BMI;
    }


    public static String findUserCategory(double userBMI)
    {
        if(userBMI < 18.5)
        {
            userCategory = "Underweight";
        }
        if((userBMI >= 18.5) && (userBMI < 25))
        {
            userCategory = "Normal Weight";
        }
        if((userBMI >= 25) && (userBMI < 30))
        {
            userCategory = "Overweight";
        }
        if(userBMI >= 30)
        {
            userCategory = "Obese";
        }
        return userCategory;
    }



}
