import java.util.ArrayList;
import java.util.Map;

// This class handles the completion and importance functions for tasks in the To-Do List manager. Its methods that modify
// the inputs in the desired fashion use a declarative style of programming.

public class taskCompletionAndImportance {

    // Initialising the 5 fields that directly correlate to values in the main class when called. 'currentList' stores
    // the ArrayList in our Hashmap (i.e. an individual To-Do List) that we want to modify. 'completedTask' is a task
    // that the user has selected to be marked as completed. 'importantTask' is the task that the user has selected to
    // be marked as important. 'listName' is the name of the To-Do List we are modifying. 'mapOfLists' is the set of all
    // To-Do Lists we currently have, stored as a HashMap.
    private ArrayList<String> currentList;

    private String completedTask;

    private String importantTask;

    private String listName;

    private Map<String,ArrayList<String>> mapOfLists;

    // Constructor for the case where a user wants to mark a To-Do List task as complete.
    public taskCompletionAndImportance(ArrayList<String> currentList, String listName, Map<String, ArrayList<String>> mapOfLists, String completedTask) {
        this.currentList = currentList;
        this.listName = listName;
        this.mapOfLists = mapOfLists;
        this.completedTask = completedTask;
    }

    // Constructor for the case where a user wants to mark a To-Do List task as important.
    public taskCompletionAndImportance(ArrayList<String> currentList,  String listName, Map<String, ArrayList<String>> mapOfLists, String completedTask, String importantTask) {
        this.currentList = currentList;
        this.listName = listName;
        this.mapOfLists = mapOfLists;
        this.completedTask = completedTask;
        this.importantTask = importantTask;
    }

    // Constructor for the case where a user wants to see all important tasks across all To-Do Lists.
    public taskCompletionAndImportance(Map<String, ArrayList<String>> mapOfLists) {
        this.mapOfLists = mapOfLists;
    }

    // Note: getters and setters have not been included in this class because they were simply not used. They could
    // however easily be added for future use if needed.

    // A method which is called upon in the main class on an instance of this class which is created when the
    // user selects to mark a task in a To-Do List as completed.

    public ArrayList<String> completedTask() {
        if (currentList.contains(completedTask)) {
        } else {
            completedTask = ("\033[0;4m" + completedTask + "\033[0m");
        }
        int i = currentList.indexOf(completedTask);
        currentList.set(i, completedTask + " (Completed)");
        return mapOfLists.replace(listName, currentList);
    }

    // A method which is called upon in the main class on an instance of this class which is created when the
    // user selects to mark a task in a To-Do List as important.

    public ArrayList<String> importantTask() {
        int j = currentList.indexOf(importantTask);
        currentList.set(j, "\033[0;4m" + importantTask + "\033[0m");
        return mapOfLists.replace(listName, currentList);
    }

    // A method which is called upon in the main class on an instance of this class which is created when the
    // user selects to see all important tasks across all To-Do Lists.
    public ArrayList<String> getAllImportantTasks() {
        ArrayList<String> importants = new ArrayList<>();
        for (String key : mapOfLists.keySet()) {
            ArrayList<String> newCurrentList = mapOfLists.get(key);
            for (String task : newCurrentList) {
                if (task.contains("\033[0;4m")) {
                    importants.add(task);
                }
            }
        }
        return importants;
    }
}
