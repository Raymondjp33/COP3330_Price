import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskItemTest
{

// ---------------------------------------------------------------------------------------------------------- //
//                                     Creation Fail Tests (Different Possible Inputs)
// ---------------------------------------------------------------------------------------------------------- //

    @Test
    void constructorFailsWithInvalidDueDateFormatString()
    {
        assertThrows(TaskItem.IllegalDDFormatEx.class, () -> new TaskItem("Invalid Date Format", "Test", "Test Description"));
    }

    @Test
    void constructorFailsWithInvalidDueDateFormat1()
    {
        assertThrows(TaskItem.IllegalDDFormatEx.class, () -> new TaskItem("2025-12", "Test", "Test Description"));
    }

    @Test
    void constructorFailsWithInvalidDueDateFormat2()
    {
        assertThrows(TaskItem.IllegalDDFormatEx.class, () -> new TaskItem("01-2025-01", "Test", "Test Description"));
    }

    @Test
    void constructorFailsWithInvalidDueDateFormat3()
    {
        assertThrows(TaskItem.IllegalDDFormatEx.class, () -> new TaskItem("01-01-2025", "Test", "Test Description"));
    }

    @Test
    void constructorFailsWithInvalidDueDateFormat4()
    {
        assertThrows(TaskItem.IllegalDDFormatEx.class, () -> new TaskItem("01012025", "Test", "Test Description"));
    }

    @Test
    void constructorFailsWithInvalidDueDateFormat5()
    {
        assertThrows(TaskItem.IllegalDDFormatEx.class, () -> new TaskItem("2025/01/01", "Test", "Test Description"));
    }

    @Test
    void constructorFailsWithImpossibleDueDate()
    {
        assertThrows(TaskItem.IllegalDDDateEx.class, () -> new TaskItem("2020-01-01", "Test", "Test Description"));
    }

    @Test
    void constructorFailsWithInvalidTitle()
    {
        assertThrows(TaskItem.IllegalTitleEx.class, () -> new TaskItem("2025-01-01", "", "Test Description"));
    }


// ---------------------------------------------------------------------------------------------------------- //
//                                      Creation Success Tests (Different Possible Inputs)
// ---------------------------------------------------------------------------------------------------------- //

    @Test
    void constructorSucceedsWithValidDueDate()
    {
        assertDoesNotThrow(() -> new TaskItem("2025-01-01", "Test", "Test Description"));
    }

    @Test
    void constructorSucceedsWithValidTitle()
    {
        assertDoesNotThrow(() -> new TaskItem("2025-01-01", "Test", "Test Description"));
    }

    @Test
    void constructorSucceedsWithSpaceInTitle()
    {
        assertDoesNotThrow(() -> new TaskItem("2025-01-01", "Test Space", "Test Description"));
    }

    @Test
    void constructorSucceedsWithNumbersInTitle()
    {
        assertDoesNotThrow(() -> new TaskItem("2025-01-01", "Test 1", "Test Description"));
    }

    @Test
    void constructorSucceedsWithNumbersInDescription()
    {
        assertDoesNotThrow(() -> new TaskItem("2025-01-01", "Test", "Test Description 1"));
    }

    @Test
    void constructorSucceedsWithBlankDescription()
    {
        assertDoesNotThrow(() -> new TaskItem("2025-01-01", "Test", ""));
    }


// ---------------------------------------------------------------------------------------------------------- //
//                                      Editing Tests (Different Possible Inputs)
// ---------------------------------------------------------------------------------------------------------- //

    @Test
    void editingDescriptionSucceedsWithExpectedValue()
    {
        TaskItem item = new TaskItem("2025-01-01", "Test", "Test Description");
        String desc = item.getDescription();

        assertEquals("Test Description", desc);

        item.EditItem("2025-01-01", "Test", "New Test Description");
        desc = item.getDescription();

        assertEquals("New Test Description", desc);
    }

    @Test
    void editingDueDateFailsWithInvalidDateFormat()
    {
        TaskItem item = new TaskItem("2025-01-01", "Test", "Test Description");
        String date = item.getDueDate();

        assertEquals("2025-01-01", date);

        item.EditItem("Invalid Date Format", "Test", "Test Description");
        date = item.getDueDate();

        assertNotEquals("Invalid Date Format", date);
    }

    @Test
    void editingDueDateFailsWithInvalidYYYYMMDD()
    {
        TaskItem item = new TaskItem("2025-01-01", "Test", "Test Description");
        String date = item.getDueDate();

        assertEquals("2025-01-01", date);

        item.EditItem("2020-01-01", "Test", "Test Description");
        date = item.getDueDate();

        assertNotEquals("2020-01-01", date);

    }

    @Test
    void editingDueDateSucceedsWithExpectedValue()
    {
        TaskItem item = new TaskItem("2025-01-01", "Test", "Test Description");
        String date = item.getDueDate();

        assertEquals("2025-01-01", date);

        item.EditItem("2025-12-12", "Test", "Test Description");
        date = item.getDueDate();

        assertEquals("2025-12-12", date);
    }

    @Test
    void editingTitleFailsWithEmptyString()
    {
        TaskItem item = new TaskItem("2025-01-01", "Test", "Test Description");
        String title = item.getTitle();

        assertEquals("Test:", title);

        item.EditItem("2025-01-01", "", "Test Description");
        title = item.getTitle();

        assertNotEquals("", title);
    }

    @Test
    void editingTitleSucceedsWithExpectedValue()
    {
        TaskItem item = new TaskItem("2025-01-01", "Test", "Test Description");
        String title = item.getTitle();

        assertEquals("Test:", title);

        item.EditItem("2025-01-01", "New Test", "Test Description");
        title = item.getTitle();

        assertEquals("New Test:", title);
    }
}
