import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskListTest
{

// ---------------------------------------------------------------------------------------------------------- //
//                                      Index Methods Tests
// ---------------------------------------------------------------------------------------------------------- //

    @Test
    void BadIndexCheckReturnsTrueWithNegativeInteger()
    {
        TaskList list = new TaskList();
        list.ItemList.add(new TaskItem("2025-01-01", "Test", "Test Description"));
        assertTrue(list.BadIndexCheck(list.ItemList, -5));
    }

    @Test
    void BadIndexCheckReturnsTrueWithPositiveOutOfBoundsIndex()
    {
        TaskList list = new TaskList();
        list.ItemList.add(new TaskItem("2025-01-01", "Test", "Test Description"));
        assertTrue(list.BadIndexCheck(list.ItemList, 10));
    }

    @Test
    void BadIndexCheckReturnsFalseWithIndexInBounds()
    {
        TaskList list = new TaskList();
        list.ItemList.add(new TaskItem("2025-01-01", "Test", "Test Description"));
        assertFalse(list.BadIndexCheck(list.ItemList, 0));
    }

    @Test
    void getValidIntReturnsBadWhenStringIsALetter()
    {
        assertEquals(-1, TaskList.getValidInt("a"));
    }

    @Test
    void getValidIntReturnsIntWhenStringIsAValidInt1()
    {
        assertEquals(1, TaskList.getValidInt("1"));
    }

    @Test
    void getValidIntReturnsIntWhenStringIsAValidInt10()
    {
        assertEquals(10, TaskList.getValidInt("10"));
    }


// ---------------------------------------------------------------------------------------------------------- //
//                                      Editing Items Tests
// ---------------------------------------------------------------------------------------------------------- //

    @Test
    void editingItemDescriptionSucceedsWithExpectedValue()
    {
        TaskList list = new TaskList();
        list.ItemList.add(new TaskItem("2025-01-01", "Test", "Test Description"));
        assertEquals("Test Description", list.ItemList.get(0).getDescription());

        list.ItemList.get(0).EditItem("2025-01-01", "Test", "New Test Description");
        assertEquals("New Test Description", list.ItemList.get(0).getDescription());

    }

    @Test
    void editingItemDueDateSucceedsWithExpectedValue()
    {
        TaskList list = new TaskList();
        list.ItemList.add(new TaskItem("2025-01-01", "Test", "Test Description"));
        assertEquals("2025-01-01", list.ItemList.get(0).getDueDate());

        list.ItemList.get(0).EditItem("2025-12-12", "Test", "Test Description");
        assertEquals("2025-12-12", list.ItemList.get(0).getDueDate());
    }

    @Test
    void editingItemTitleFailsWithEmptyString()
    {
        TaskList list = new TaskList();
        list.ItemList.add(new TaskItem("2025-01-01", "Test", "Test Description"));
        list.ItemList.get(0).EditItem("2025-01-01", "", "Test Description");
        assertEquals("2025-01-01", list.ItemList.get(0).getDueDate());
        assertEquals("Test:", list.ItemList.get(0).getTitle());
        assertEquals("Test Description", list.ItemList.get(0).getDescription());
    }

    @Test
    void editingItemTitleSucceedsWithExpectedValue()
    {
        TaskList list = new TaskList();
        list.ItemList.add(new TaskItem("2025-01-01", "Test", "Test Description"));
        assertEquals("Test:", list.ItemList.get(0).getTitle());

        list.ItemList.get(0).EditItem("2025-01-01", "New Test", "Test Description");
        assertEquals("New Test:", list.ItemList.get(0).getTitle());
    }

    @Test
    void editingTaskItemDueDateFailsWithInvalidDateFormat()
    {
        TaskList list = new TaskList();
        list.ItemList.add(new TaskItem("2025-01-01", "Test", "Test Description"));
        assertEquals("2025-01-01", list.ItemList.get(0).getDueDate());

        list.ItemList.get(0).EditItem("Invalid Date Format", "Test", "Test Description");
        assertEquals("2025-01-01", list.ItemList.get(0).getDueDate());
    }

    @Test
    void editingTaskItemDueDateFailsWithInvalidYYYMMDD()
    {
        TaskList list = new TaskList();
        list.ItemList.add(new TaskItem("2025-01-01", "Test", "Test Description"));
        assertEquals("2025-01-01", list.ItemList.get(0).getDueDate());

        list.ItemList.get(0).EditItem("2020-01-01", "Test", "Test Description");
        assertEquals("2025-01-01", list.ItemList.get(0).getDueDate());
    }


// ---------------------------------------------------------------------------------------------------------- //
//                                   Removing, Marking, and Unmarking Items Tests
// ---------------------------------------------------------------------------------------------------------- //

    @Test
    void TaskItemStartsIncomplete()
    {
        TaskList list = new TaskList();
        list.ItemList.add(new TaskItem("2025-01-01", "Test", "Test Description"));

        assertFalse(list.ItemList.get(0).getCompletion());
    }

    @Test
    void completingTaskItemChangesStatus()
    {
        TaskList list = new TaskList();
        list.ItemList.add(new TaskItem("2025-01-01", "Test", "Test Description"));
        list.ItemList.get(0).setCompletion();

        assertTrue(list.ItemList.get(0).getCompletion());
    }

    @Test
    void newListIsEmpty()
    {
        TaskList list = new TaskList();
        assertEquals(0, list.ItemList.size());
    }

    @Test
    void removingItemsDecreasesSize()
    {
        TaskList list = new TaskList();
        list.ItemList.add(new TaskItem("2025-01-01", "Test", "Test Description"));
        assertEquals(1, list.ItemList.size());

        list.ItemList.remove(0);
        assertEquals(0, list.ItemList.size());
    }

    @Test
    void unmarkingTaskItemChangesStatus()
    {
        TaskList list = new TaskList();
        list.ItemList.add(new TaskItem("2025-01-01", "Test", "Test Description"));
        list.ItemList.get(0).setCompletion();
        assertTrue(list.ItemList.get(0).getCompletion());
        list.ItemList.get(0).unsetCompletion();
        assertFalse(list.ItemList.get(0).getCompletion());
    }

}

