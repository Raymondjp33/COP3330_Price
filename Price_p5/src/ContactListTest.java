import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactListTest
{

// ---------------------------------------------------------------------------------------------------------- //
//                                      Index Methods Tests
// ---------------------------------------------------------------------------------------------------------- //

    @Test
    void BadIndexCheckReturnsTrueWithNegativeInteger()
    {
        ContactList list = new ContactList();
        list.ContactList.add(new ContactItem("First", "Last", "8005617777", "test@gmail.com"));
        assertTrue(list.BadIndexCheck(list.ContactList, -5));
    }

    @Test
    void BadIndexCheckReturnsTrueWithPositiveOutOfBoundsIndex()
    {
        ContactList list = new ContactList();
        list.ContactList.add(new ContactItem("First", "Last", "8005617777", "test@gmail.com"));
        assertTrue(list.BadIndexCheck(list.ContactList, 10));
    }

    @Test
    void BadIndexCheckReturnsFalseWithIndexInBounds()
    {
        ContactList list = new ContactList();
        list.ContactList.add(new ContactItem("First", "Last", "8005617777", "test@gmail.com"));
        assertFalse(list.BadIndexCheck(list.ContactList, 0));
    }

    @Test
    void getValidIntReturnsBadWhenStringIsALetter()
    {
        assertEquals(-1, ContactList.getValidInt("a"));
    }

    @Test
    void getValidIntReturnsIntWhenStringIsAValidInt1()
    {
        assertEquals(1, ContactList.getValidInt("1"));
    }

    @Test
    void getValidIntReturnsIntWhenStringIsAValidInt10()
    {
        assertEquals(10, ContactList.getValidInt("10"));
    }


// ---------------------------------------------------------------------------------------------------------- //
//                                      Editing Items In List Tests
// ---------------------------------------------------------------------------------------------------------- //

    @Test
    void editingItemsFailsWithAllBlankValues()
    {
        ContactList list = new ContactList();
        list.ContactList.add(new ContactItem("First", "Last", "8005617777", "test@gmail.com"));
        list.ContactList.get(0).EditItem("", "", "", "");

        assertEquals("First", list.ContactList.get(0).getFirstName());
        assertEquals("Last", list.ContactList.get(0).getLastName());
        assertEquals("8005617777", list.ContactList.get(0).getPhoneNumber());
        assertEquals("test@gmail.com", list.ContactList.get(0).getEmailAddress());
    }

    @Test
    void editingSucceedsWithBlankFirstName()
    {
        ContactList list = new ContactList();
        list.ContactList.add(new ContactItem("First", "Last", "8005617777", "test@gmail.com"));
        list.ContactList.get(0).EditItem("", "Last", "8005617777", "test@gmail.com");

        assertEquals("", list.ContactList.get(0).getFirstName());
        assertEquals("Last", list.ContactList.get(0).getLastName());
        assertEquals("8005617777", list.ContactList.get(0).getPhoneNumber());
        assertEquals("test@gmail.com", list.ContactList.get(0).getEmailAddress());
    }

    @Test
    void editingSucceedsWithBlankLastName()
    {
        ContactList list = new ContactList();
        list.ContactList.add(new ContactItem("First", "Last", "8005617777", "test@gmail.com"));
        list.ContactList.get(0).EditItem("First", "", "8005617777", "test@gmail.com");

        assertEquals("First", list.ContactList.get(0).getFirstName());
        assertEquals("", list.ContactList.get(0).getLastName());
        assertEquals("8005617777", list.ContactList.get(0).getPhoneNumber());
        assertEquals("test@gmail.com", list.ContactList.get(0).getEmailAddress());
    }

    @Test
    void editingSucceedsWithBlankPhone()
    {
        ContactList list = new ContactList();
        list.ContactList.add(new ContactItem("First", "Last", "8005617777", "test@gmail.com"));
        list.ContactList.get(0).EditItem("First", "Last", "", "test@gmail.com");

        assertEquals("First", list.ContactList.get(0).getFirstName());
        assertEquals("Last", list.ContactList.get(0).getLastName());
        assertEquals("", list.ContactList.get(0).getPhoneNumber());
        assertEquals("test@gmail.com", list.ContactList.get(0).getEmailAddress());
    }

    @Test
    void editingSucceedsWithNonBlankValues()
    {
        ContactList list = new ContactList();
        list.ContactList.add(new ContactItem("First", "Last", "8005617777", "test@gmail.com"));
        list.ContactList.get(0).EditItem("First", "Last", "8005617777", "test@gmail.com");

        assertEquals("First", list.ContactList.get(0).getFirstName());
        assertEquals("Last", list.ContactList.get(0).getLastName());
        assertEquals("8005617777", list.ContactList.get(0).getPhoneNumber());
        assertEquals("test@gmail.com", list.ContactList.get(0).getEmailAddress());
    }

    @Test
    void editingFailsWithNumberInFirstName()
    {
        ContactList list = new ContactList();
        list.ContactList.add(new ContactItem("First", "Last", "8005617777", "test@gmail.com"));
        list.ContactList.get(0).EditItem("First12", "Last", "8005617777", "test@gmail.com");

        assertEquals("First", list.ContactList.get(0).getFirstName());
        assertEquals("Last", list.ContactList.get(0).getLastName());
        assertEquals("8005617777", list.ContactList.get(0).getPhoneNumber());
        assertEquals("test@gmail.com", list.ContactList.get(0).getEmailAddress());
    }

    @Test
    void editingFailsWithNumberInLastName()
    {
        ContactList list = new ContactList();
        list.ContactList.add(new ContactItem("First", "Last", "8005617777", "test@gmail.com"));
        list.ContactList.get(0).EditItem("First", "Last12", "8005617777", "test@gmail.com");

        assertEquals("First", list.ContactList.get(0).getFirstName());
        assertEquals("Last", list.ContactList.get(0).getLastName());
        assertEquals("8005617777", list.ContactList.get(0).getPhoneNumber());
        assertEquals("test@gmail.com", list.ContactList.get(0).getEmailAddress());
    }

    @Test
    void editingFailsWithLettersInPhoneNumber()
    {
        ContactList list = new ContactList();
        list.ContactList.add(new ContactItem("First", "Last", "8005617777", "test@gmail.com"));
        list.ContactList.get(0).EditItem("First", "Last", "8005aa7777", "test@gmail.com");

        assertEquals("First", list.ContactList.get(0).getFirstName());
        assertEquals("Last", list.ContactList.get(0).getLastName());
        assertEquals("8005617777", list.ContactList.get(0).getPhoneNumber());
        assertEquals("test@gmail.com", list.ContactList.get(0).getEmailAddress());
    }

    @Test
    void editingFailsWithLessThen10DigitsInPhoneNumber()
    {
        ContactList list = new ContactList();
        list.ContactList.add(new ContactItem("First", "Last", "8005617777", "test@gmail.com"));
        list.ContactList.get(0).EditItem("First", "Last", "800561", "test@gmail.com");

        assertEquals("First", list.ContactList.get(0).getFirstName());
        assertEquals("Last", list.ContactList.get(0).getLastName());
        assertEquals("8005617777", list.ContactList.get(0).getPhoneNumber());
        assertEquals("test@gmail.com", list.ContactList.get(0).getEmailAddress());
    }

    @Test
    void editingFailsWithMoreThen10DigitsInPhoneNumber()
    {
        ContactList list = new ContactList();
        list.ContactList.add(new ContactItem("First", "Last", "8005617777", "test@gmail.com"));
        list.ContactList.get(0).EditItem("First", "Last", "800561777777777", "test@gmail.com");

        assertEquals("First", list.ContactList.get(0).getFirstName());
        assertEquals("Last", list.ContactList.get(0).getLastName());
        assertEquals("8005617777", list.ContactList.get(0).getPhoneNumber());
        assertEquals("test@gmail.com", list.ContactList.get(0).getEmailAddress());
    }

    @Test
    void editingFailsWithInvalidEmailFormat1()
    {
        ContactList list = new ContactList();
        list.ContactList.add(new ContactItem("First", "Last", "8005617777", "test@gmail.com"));
        list.ContactList.get(0).EditItem("First", "Last", "8005617777", "@testgmail.com");

        assertEquals("First", list.ContactList.get(0).getFirstName());
        assertEquals("Last", list.ContactList.get(0).getLastName());
        assertEquals("8005617777", list.ContactList.get(0).getPhoneNumber());
        assertEquals("test@gmail.com", list.ContactList.get(0).getEmailAddress());
    }

    @Test
    void editingFailsWithInvalidEmailFormat2()
    {
        ContactList list = new ContactList();
        list.ContactList.add(new ContactItem("First", "Last", "8005617777", "test@gmail.com"));
        list.ContactList.get(0).EditItem("First", "Last", "8005617777", "testgmail@.com");

        assertEquals("First", list.ContactList.get(0).getFirstName());
        assertEquals("Last", list.ContactList.get(0).getLastName());
        assertEquals("8005617777", list.ContactList.get(0).getPhoneNumber());
        assertEquals("test@gmail.com", list.ContactList.get(0).getEmailAddress());
    }

    @Test
    void editingFailsWithInvalidEmailFormat3()
    {
        ContactList list = new ContactList();
        list.ContactList.add(new ContactItem("First", "Last", "8005617777", "test@gmail.com"));
        list.ContactList.get(0).EditItem("First", "Last", "8005617777", "test.com@gmail");

        assertEquals("First", list.ContactList.get(0).getFirstName());
        assertEquals("Last", list.ContactList.get(0).getLastName());
        assertEquals("8005617777", list.ContactList.get(0).getPhoneNumber());
        assertEquals("test@gmail.com", list.ContactList.get(0).getEmailAddress());
    }

    @Test
    void editingFailsWithInvalidEmailFormat4()
    {
        ContactList list = new ContactList();
        list.ContactList.add(new ContactItem("First", "Last", "8005617777", "test@gmail.com"));
        list.ContactList.get(0).EditItem("First", "Last", "8005617777", "testgmail.com");

        assertEquals("First", list.ContactList.get(0).getFirstName());
        assertEquals("Last", list.ContactList.get(0).getLastName());
        assertEquals("8005617777", list.ContactList.get(0).getPhoneNumber());
        assertEquals("test@gmail.com", list.ContactList.get(0).getEmailAddress());
    }


// ---------------------------------------------------------------------------------------------------------- //
//                                      Other Method Tests
// ---------------------------------------------------------------------------------------------------------- //

    @Test
    void removingItemsDecreasesSize()
    {
        ContactList list = new ContactList();
        list.ContactList.add(new ContactItem("First", "Last", "8005617777", "test@gmail.com"));
        list.ContactList.add(new ContactItem("FirstTwo", "LastTwo", "8007775601", "test2@gmail.com"));
        assertEquals(2, list.ContactList.size());
        list.ContactList.remove(1);
        assertEquals(1, list.ContactList.size());
    }

    @Test
    void newListIsEmpty()
    {
        ContactList list = new ContactList();
        assertEquals(0, list.ContactList.size());
    }


}
