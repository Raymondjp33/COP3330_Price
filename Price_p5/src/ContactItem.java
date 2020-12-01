import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactItem implements Serializable
{
   private String FirstName;
   private String LastName;
   private String PhoneNumber;
   private String EmailAddress;

   public ContactItem(String FirstName, String LastName, String PhoneNumber, String EmailAddress)
   {
       if (isFirstNameValid(FirstName) == 3)
           throw new IllegalFirstNameException("First name may only have letters.");

        if (isLastNameValid(LastName) == 3)
            throw new IllegalLastNameException("Last name may only have letters.");

        if (isPhoneNumberValid(PhoneNumber) == 3)
            throw new IllegalPhoneNumberException("Input for phone number must be numbers and have 10 digits.");

        if (isEmailValid(EmailAddress) == 3)
            throw new IllegalEmailException("Invalid email address.");

        if (allEmpty(FirstName, LastName, PhoneNumber, EmailAddress))
            throw new IllegalAllEmptyException("All Inputs were empty :(");

       this.FirstName = FirstName;
       this.LastName = LastName;
       this.PhoneNumber = PhoneNumber;
       this.EmailAddress = EmailAddress;
   }

   public void EditItem(String FirstName, String LastName, String PhoneNumber, String EmailAddress)
   {
       if (allEmpty(FirstName, LastName, PhoneNumber, EmailAddress))
       {
           System.out.print("\nAll Inputs were empty :(\n\n");
           return;
       }

       if (isFirstNameValid(FirstName) == 3)
       {
           System.out.print("\nFirst name may only have letters.\n\n");
           return;
       }
       if (isLastNameValid(LastName) == 3)
       {
           System.out.print("\nLast name may only have letters.\n\n");
           return;
       }
       if (isPhoneNumberValid(PhoneNumber) == 3)
       {
           System.out.print("\nInput for phone number must be numbers and have 10 digits.\n\n");
           return;
       }
       if (isEmailValid(EmailAddress) == 3)
       {
           System.out.print("\nInvalid email address.\n\n");
           return;
       }


       this.FirstName = FirstName;
       this.LastName = LastName;
       this.PhoneNumber = PhoneNumber;
       this.EmailAddress = EmailAddress;
   }

   public int isFirstNameValid(String FirstName)
   {
       int i;

       if (FirstName.length() < 1)
           return 2;

       for (i = 0; i < FirstName.length(); i++)
       {
           if ((FirstName.charAt(i) >= 'a' && FirstName.charAt(i) <= 'z') || (FirstName.charAt(i) >= 'A' && FirstName.charAt(i) <= 'Z'))
           ;
           else
               return 3;
       }
       return 1;
   }

   public int isLastNameValid(String LastName)
   {
       int i;

       if (LastName.length() < 1)
           return 2;

       for (i = 0; i < LastName.length(); i++)
       {
           if ((LastName.charAt(i) >= 'a' && LastName.charAt(i) <= 'z') || (LastName.charAt(i) >= 'A' && LastName.charAt(i) <= 'Z'))
               ;
           else
               return 3;
       }
       return 1;
   }

   public int isPhoneNumberValid(String PhoneNumber)
   {
       int i;

       if (PhoneNumber.length() < 1)
           return 2;
       if (PhoneNumber.length() != 10)
           return 3;

       for (i = 0; i < 10; i++)
       {
           if (PhoneNumber.charAt(i) < '0' || PhoneNumber.charAt(i) > '9')
               return 3;
       }
       return 1;
   }

   public int isEmailValid(String Email)
   {
       if (Email.length() < 1)
           return 2;

       String Regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
       Pattern Pat = Pattern.compile(Regex, Pattern.CASE_INSENSITIVE);
       Matcher matcher = Pat.matcher(Email);

       if (matcher.find())
           return 1;
       else
           return 3;
   }

   public boolean allEmpty(String FirstName, String LastName, String PhoneNumber, String Email)
   {
       int counter = 0;

       if (isFirstNameValid(FirstName) == 2)
           counter++;
       if (isLastNameValid(LastName) == 2)
           counter++;
       if (isPhoneNumberValid(PhoneNumber) == 2)
           counter++;
       if (isEmailValid(Email) == 2)
           counter++;

       return counter == 4;
   }

   public String getFirstName()
   {
       return FirstName;
   }

   public String getLastName()
   {
       return LastName;
   }

   public String getPhoneNumber()
   {
       return PhoneNumber;
   }

   public String getEmailAddress()
   {
       return EmailAddress;
   }

   public String getItem()
   {
       return "Name: " + FirstName + " " + LastName + "\n" +
               "Phone Number: " + PhoneNumber + "\n" +
               "Email Address: " + EmailAddress;
   }

   static class IllegalFirstNameException extends IllegalArgumentException
   {
        public IllegalFirstNameException(String msg)
        {
            super(msg);
        }
   }

   static class IllegalLastNameException extends IllegalArgumentException
   {
       public IllegalLastNameException(String msg)
       {
           super(msg);
       }
   }

   static class IllegalPhoneNumberException extends IllegalArgumentException
   {
       public IllegalPhoneNumberException(String msg)
       {
           super(msg);
       }
   }

   static class IllegalEmailException extends IllegalArgumentException
   {
       public IllegalEmailException(String msg)
       {
           super(msg);
       }
   }

   static class IllegalAllEmptyException extends IllegalArgumentException
   {
       public IllegalAllEmptyException(String msg)
        {
            super(msg);
        }
   }
}
