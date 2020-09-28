import jdk.jfr.StackTrace;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class Tester
{
@Test
public void testEncrypt1234to0189(){
        Encrypter e=new Encrypter();
        assertEquals("0189",e.encrypt("1234"));
        }


}
