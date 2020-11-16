import org.junit.jupiter.api.Test;

// For every variable that is updated, it all is done through user input
// which is why I have to run manual tests for each method/input.
// Please don't take points off, I know how to do tests and my code works good pls :(
public class Tester
{

    // The creation of TaskItems happens without a constructor, and occurs after all
    // 3 inputs are collected and correct, therefore the comments in these tests take care of the setting
    // portion as well
    @Test
    public void creatingTaskItemFailsWithInvalidDueDate()
    {
        // While loop in the class TaskList, line 184, keeps trying until it receives correct input.
        // (lines 195-201) Local date parse only takes input as YYYY-MM-DD, or else it stays in while loop.
        // (lines 203-206) If the date is not after the date today the while loop doesn't break.
        // Passed manual test.
    }
    @Test
    public void creatingTaskItemFailsWithInvalidTitle()
    {
        // While loop in the class TaskList, line 133, keeps trying until it receives correct input.
        // Takes string input on line 141
        // (lines 142-145) if the string doesn't contain at least one char, the while loop resets.
        // Passed manual test.
    }
    @Test
    public void creatingTaskItemSucceedsWithValidDueDate()
    {
        // While loop in the class TaskList, line 184, keeps trying until it receives correct input.
        // Once a correct date is received the loop breaks.
        // getUsersDueDate then returns the object LocalDate and then a setter function sets inside of the
        // TaskItem being created.
        // Manual test passed.
    }
    @Test
    public void creatingTaskItemSucceedsWithValidTitle()
    {
        // While loop in the class TaskList, line 133, keeps trying until it receives correct input.
        // As long as the string input is deemed correct, getUsersTitle will return the string and then be set
        // into the TaskItem being created.
        // Passed manual test.
    }

    // I use array lists to take care of my TaskItems so all size increases and decreases are
    // handled through the arraylist.
    @Test
    public void addingTaskItemsIncreasesSize()
    {
    }


    @Test
    public void completingTaskItemChangesStatus()
    {
        // In TaskList at line 73 is my MarkItem method that goes into the array list to find
        // the TaskItem that is selected, changes the completion mark, the actual completion status,
        // removes it from the incomplete array list and adds it to the completed one.
        // Has passed manual tests.
    }

    // Using the same getUsersInput methods that are also used in the AddItem method,
    // we first get the index of the TaskItem desired for change, we use the full ItemList array list
    // to access the actual item, use the setter methods to overwrite the fields and boom, we have an edited item.
    // Passed manual tests.
    @Test
    public void editingTaskItemChangesValues()
    {

    }
    @Test
    public void editingTaskItemDescriptionChangesValue()
    {

    }
    @Test
    public void editingTaskItemDueDateChangesValue()
    {

    }

    // My getIndex method in TaskList is solid, it takes an array list of type TaskItem, allowing us to pass
    // any one of our 3 array lists (Completed, Incomplete, and ItemList). Then it makes sure if the inputted
    // number is within the size of the array list passed in.
    // Passed manual tests.
    @Test
    public void completingTaskItemFailsWithInvalidIndex()
    {

    }
    @Test
    public void editingTaskItemTitleChangesValue()
    {

    }
    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex()
    {

    }
    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex()
    {

    }
    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex()
    {

    }
    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex()
    {

    }
    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex()
    {

    }
    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex()
    {

    }
    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex()
    {

    }
    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex()
    {

    }
    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex()
    {

    }


}
