import java.util.*;

public class Encrypter
{


    public String encrypt(String code)
    {

        int num;
        String newCode;
        int codeNew[];

        num = Integer.parseInt(code);
        codeNew = number_scrambler(num);
        newCode = Arrays.toString(codeNew);

        return newCode;
    }

    public static int[] number_scrambler(int num)
    {
        int codeNew[] = new int[4];

        codeNew[0] = (((num / 10) % 10) + 7) % 10;
        codeNew[1] = ((num % 10) + 7) % 10;
        codeNew[2] = ((num / 1000) + 7) % 10;
        codeNew[3] = (((num / 100) % 10) + 7) % 10;

        return codeNew;
    }

}

