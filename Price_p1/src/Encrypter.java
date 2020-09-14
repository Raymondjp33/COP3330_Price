
import java.util.*;

public class Encrypter
{


    public static String encrypt(String code)
    {

        int num;
        String newCode;
        int codeNew[] = new int[4];

        num = Integer.parseInt(code);

        codeNew[0] = (((num / 10) % 10) + 7) % 10;
        codeNew[1] = ((num % 10) + 7) % 10;
        codeNew[2] = ((num / 1000) + 7) % 10;
        codeNew[3] = (((num / 100) % 10) + 7) % 10;


        newCode = Arrays.toString(codeNew);


        return newCode;
    }

}