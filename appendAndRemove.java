import java.util.ArrayList;

// This class handles the add and remove task functions for the To-Do List manager. Its methods that modify the inputs
// in the desired fashion use a declarative style of programming.
public class appendAndRemove {

    // Initialising the 3 fields that directly correlate to values in the main class when called. 'changeMe' is the
    // specific To-Do list called upon to have a task added or removed from it. 'elementToAdd' is an element the user
    // inputs to be added to the end of the 'changeMe' ArrayList and 'elementToRemove' is an element the user inputs to be
    // removed from the 'changeMe' ArrayList. I used composition between this class and the main one, as from a design point of view,
    // it makes the program as a whole more easily readable.
    private ArrayList<String> changeMe;
    private String elementToAdd;
    private String elementToRemove;

    // Constructor for the case where a user wants to add an element to a To-Do List.
    public appendAndRemove(ArrayList<String> changeMe, String elementToAdd) {
        this.changeMe = changeMe;
        this.elementToAdd = elementToAdd;
    }

    // Constructor for the case where a user wants to remove an element from a To-Do List. ('elementToAdd' is set to null).
    public appendAndRemove(ArrayList<String> changeMe, String elementToAdd, String elementToRemove) {
        this.changeMe = changeMe;
        this.elementToAdd = elementToAdd;
        this.elementToRemove = elementToRemove;
    }

    // Note: getters and setters have not been included in this class because they were simply not used. They could
    // however easily be added for future use if needed.

    // A method which is called upon in the main class on an instance of this class which is created when the
    // user selects to add a task to the end of a To-Do List.
    public ArrayList<String> addElement() {
        changeMe.add(elementToAdd);
        return changeMe;
    }

    // A method which is called upon in the main class on an instance of this class which is created when the
    // user selects to remove a specific task from anywhere within a To-Do List.
    public ArrayList<String> removeElement() {
        if (changeMe.contains(elementToRemove)) {
        } else if ((changeMe.contains((elementToRemove + " (Completed)")))) {
            elementToRemove = (elementToRemove + " (Completed)");
        } else {
            elementToRemove = ("\033[0;4m" + elementToRemove + "\033[0m");

            if (changeMe.contains(elementToRemove)) {
            } else {
                elementToRemove = (elementToRemove + " (Completed)");
            }
        }
        changeMe.remove(elementToRemove);
        return changeMe;
    }
}