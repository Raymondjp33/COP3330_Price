import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BodyMassIndexTest
{
    // Testing the userBMI number to make sure it is correct
    @Test
    public void correctOutputTest1()
    {
        BodyMassIndex test1 = new BodyMassIndex(75, 200);
        assertEquals(24.995555555555555, test1.userBMI);
    }

    @Test
    public void underweightOutputTest()
    {
        String test = BodyMassIndex.findUserCategory(17);
        assertEquals("Underweight", test);
    }

    @Test
    public void normalweightOutputTest()
    {
        String test = BodyMassIndex.findUserCategory(20);
        assertEquals("Normal Weight", test);
    }

    @Test
    public void overweightOutputTest()
    {
        String test = BodyMassIndex.findUserCategory(27);
        assertEquals("Overweight", test);
    }

    @Test
    public void obesityOutputTest()
    {
        String test = BodyMassIndex.findUserCategory(32);
        assertEquals("Obese", test);
    }

}
