import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ContactItemTest {

// ---------------------------------------------------------------------------------------------------------- //
//                                      Creation Fail Tests (Different Possible Inputs)
// ---------------------------------------------------------------------------------------------------------- //

    @Test
    void creationFailsWithNumberFirstName()
    {
        assertThrows(ContactItem.IllegalFirstNameException.class, () -> new ContactItem("123", "Last", "8005617777", "test@gmail.com"));
    }

    @Test
    void creationFailsWithNumberLastName()
    {
        assertThrows(ContactItem.IllegalLastNameException.class, () -> new ContactItem("First", "123", "8005617777", "test@gmail.com"));
    }

    @Test
    void creationFailsWithLetterPhoneNumber()
    {
        assertThrows(ContactItem.IllegalPhoneNumberException.class, () -> new ContactItem("First", "Last", "abc", "test@gmail.com"));
    }

    @Test
    void creationFailsWithLessThen10DigitsPhoneNumber()
    {
        assertThrows(ContactItem.IllegalPhoneNumberException.class, () -> new ContactItem("First", "Last", "123456789", "test@gmail.com"));
    }

    @Test
    void creationFailsWithMoreThen10DigitsPhoneNumber()
    {
        assertThrows(ContactItem.IllegalPhoneNumberException.class, () -> new ContactItem("First", "Last", "80056177771", "test@gmail.com"));
    }

    @Test
    void creationFailsWithOneNumberInputForEmail()
    {
        assertThrows(ContactItem.IllegalEmailException.class, () -> new ContactItem("First", "Last", "8005617777", "1"));
    }

    @Test
    void creationFailsWithOneLetterInputForEmail()
    {
        assertThrows(ContactItem.IllegalEmailException.class, () -> new ContactItem("First", "Last", "8005617777", "a"));
    }

    @Test
    void creationFailsWithNormalStringInputForEmail()
    {
        assertThrows(ContactItem.IllegalEmailException.class, () -> new ContactItem("First", "Last", "8005617777", "Normal String"));
    }

    @Test
    void creationFailsWithInvalidFormattedAt1()
    {
        assertThrows(ContactItem.IllegalEmailException.class, () -> new ContactItem("First", "Last", "8005617777", "@test"));
    }

    @Test
    void creationFailsWithInvalidFormattedAt2()
    {
        assertThrows(ContactItem.IllegalEmailException.class, () -> new ContactItem("First", "Last", "8005617777", "test@"));
    }

    @Test
    void creationFailsWithInvalidFormattedAt3()
    {
        assertThrows(ContactItem.IllegalEmailException.class, () -> new ContactItem("First", "Last", "8005617777", "testgmail.com@"));
    }

    @Test
    void creationFailsWithInvalidFormat1()
    {
        assertThrows(ContactItem.IllegalEmailException.class, () -> new ContactItem("First", "Last", "8005617777", "test@.com"));
    }

    @Test
    void creationFailsWithInvalidFormat2()
    {
        assertThrows(ContactItem.IllegalEmailException.class, () -> new ContactItem("First", "Last", "8005617777", "@testgmail.com"));
    }

    @Test
    void creationFailsWithInvalidFormat3()
    {
        assertThrows(ContactItem.IllegalEmailException.class, () -> new ContactItem("First", "Last", "8005617777", ".comtest@gmail"));
    }


// ---------------------------------------------------------------------------------------------------------- //
//                                      Creation Success Tests (Different Possible Inputs)
// ---------------------------------------------------------------------------------------------------------- //

    @Test
    void creationSucceedsWithOneLetterFirstName()
    {
        assertDoesNotThrow(() -> new ContactItem("a", "Last", "8005617777", "test@gmail.com"));
    }

    @Test
    void creationSucceedsWithOneLetterLastName()
    {
        assertDoesNotThrow(() -> new ContactItem("First", "a", "8005617777", "test@gmail.com"));
    }

    @Test
    void creationSucceedsWithUnderScoreInEmail()
    {
        assertDoesNotThrow(() -> new ContactItem("First", "Last", "8005617777", "test_underscore@gmail.com"));
    }

    @Test
    void creationSucceedsWithOneCapsInEmail()
    {
        assertDoesNotThrow(() -> new ContactItem("First", "Last", "8005617777", "TesT@gmail.com"));
    }

    @Test
    void creationSucceedsWithPeriodInEmail()
    {
        assertDoesNotThrow(() -> new ContactItem("First", "Last", "8005617777", "test.period@gmail.com"));
    }

    @Test
    void creationSucceedsWithRandomWebsiteEmail()
    {
        assertDoesNotThrow(() -> new ContactItem("First", "Last", "8005617777", "test@testsite.com"));
    }

    @Test
    void creationSucceedsWithCrazyEmail()
    {
        assertDoesNotThrow(() -> new ContactItem("First", "Last", "8005617777", "teSt555.crazy@gmail.com"));
    }

// ---------------------------------------------------------------------------------------------------------- //
//                                     Blank Value Tests (Creation and Editing)
// ---------------------------------------------------------------------------------------------------------- //

    @Test
    void creationFailsWithAllBlankValues()
    {
        assertThrows(ContactItem.IllegalAllEmptyException.class, () -> new ContactItem("", "", "", ""));
    }

    @Test
    void creationSucceedsWithBlankEmail()
    {
        assertDoesNotThrow(() -> new ContactItem("First", "Last", "8005617777", ""));
    }

    @Test
    void creationSucceedsWithBlankFirstName()
    {
        assertDoesNotThrow(() -> new ContactItem("", "Last", "8005617777", "test@gmail.com"));
    }

    @Test
    void creationSucceedsWithBlankLastName()
    {
        assertDoesNotThrow(() -> new ContactItem("First", "", "8005617777", "test@gmail.com"));
    }

    @Test
    void creationSucceedsWithBlankPhone()
    {
        assertDoesNotThrow(() -> new ContactItem("First", "Last", "", "test@gmail.com"));
    }

    @Test
    void creationSucceedsWithNonBlankValues()
    {
        assertDoesNotThrow(() -> new ContactItem("First", "Last", "8005617777", "test@gmail.com"));
    }

    @Test
    void editingFailsWithAllBlankValues()
    {
        ContactItem item = new ContactItem("First", "Last", "8005617777", "test@gmail.com");

        item.EditItem("", "", "", "");
        assertEquals("First", item.getFirstName());
        assertEquals("Last", item.getLastName());
        assertEquals("8005617777", item.getPhoneNumber());
        assertEquals("test@gmail.com", item.getEmailAddress());
    }

    @Test
    void editingSucceedsWithBlankEmail()
    {
        ContactItem item = new ContactItem("First", "Last", "8005617777", "test@gmail.com");

        item.EditItem("NewFirst", "NewLast", "7778889999", "");
        assertEquals("NewFirst", item.getFirstName());
        assertEquals("NewLast", item.getLastName());
        assertEquals("7778889999", item.getPhoneNumber());
        assertEquals("", item.getEmailAddress());
    }

    @Test
    void editingSucceedsWithBlankFirstName()
    {
        ContactItem item = new ContactItem("First", "Last", "8005617777", "test@gmail.com");

        item.EditItem("", "NewLast", "7778889999", "Newtest@gmail.com");
        assertEquals("", item.getFirstName());
        assertEquals("NewLast", item.getLastName());
        assertEquals("7778889999", item.getPhoneNumber());
        assertEquals("Newtest@gmail.com", item.getEmailAddress());
    }

    @Test
    void editingSucceedsWithBlankLastName()
    {
        ContactItem item = new ContactItem("First", "", "8005617777", "test@gmail.com");

        item.EditItem("NewFirst", "", "7778889999", "Newtest@gmail.com");
        assertEquals("NewFirst", item.getFirstName());
        assertEquals("", item.getLastName());
        assertEquals("7778889999", item.getPhoneNumber());
        assertEquals("Newtest@gmail.com", item.getEmailAddress());
    }

    @Test
    void editingSucceedsWithBlankPhone()
    {
        ContactItem item = new ContactItem("First", "Last", "8005617777", "test@gmail.com");

        item.EditItem("NewFirst", "NewLast", "", "Newtest@gmail.com");
        assertEquals("NewFirst", item.getFirstName());
        assertEquals("NewLast", item.getLastName());
        assertEquals("", item.getPhoneNumber());
        assertEquals("Newtest@gmail.com", item.getEmailAddress());
    }

    @Test
    void editingSucceedsWithNonBlankValues()
    {
        ContactItem item = new ContactItem("First", "Last", "8005617777", "test@gmail.com");

        item.EditItem("NewFirst", "NewLast", "7778889999", "Newtest@gmail.com");
        assertEquals("NewFirst", item.getFirstName());
        assertEquals("NewLast", item.getLastName());
        assertEquals("7778889999", item.getPhoneNumber());
        assertEquals("Newtest@gmail.com", item.getEmailAddress());
    }



}
