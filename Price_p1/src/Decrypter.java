import java.util.*;

public class Decrypter
{


    public static String decrypt(String code)
    {
        int i, num;
        int[] codeNew = new int [4];
        String newCode;

        num = Integer.parseInt(code);

        codeNew[0] = (num/10)%10;
        codeNew[1] = num%10;
        codeNew[2] = num/1000;
        codeNew[3] = (num/100)%10;

        for(i=0; i<4; i++)
        {
            if(codeNew[i] >= 7)
            {
                codeNew[i] = codeNew[i] - 7;
            }
            else
            {
                codeNew[i] = codeNew[i] + 3;
            }
        }

        newCode = Arrays.toString(codeNew);

        return newCode;

    }
}
