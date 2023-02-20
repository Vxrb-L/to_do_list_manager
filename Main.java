import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// This is the main class for the program, that holds the menu from which the user can navigate to different parts of
// the program, as well as being the center of storage for the To-Do lists during each run of the program. In addition
// to these, it has core functionalities in use of a switch statement with the different cases holding different
// desired functionalities of the program. It uses instances of two other classes (and therefore composition) in order
// to make parts less verbose, more readable and a better showcase of functional programming. I felt more classes than
// this could have made the program overly complex for the subject matter. This class utilises a declarative, object-
// oriented approach as I felt it best suited what was required.
public class Main {

    public static void main(String[] args) {

        // Initialising a HashMap of ArrayLists (To-Do Lists) to store tasks.
        int value = 0;
        Map<String, ArrayList<String>> mapOLists = new HashMap<>();

        ArrayList<String> Homework = new ArrayList<>();
        ArrayList<String> Groceries = new ArrayList<>();

        // Adding 2 initial lists with 1 task a-piece to start off the program.
        Homework.add("Maths");
        Groceries.add("Lemon");
        mapOLists.put("Homework", Homework);
        mapOLists.put("Groceries", Groceries);

        // Creating a while loop to allow use of combinations of program functions and a main menu with which to
        // navigate to these different functions.
        while (value != 1) {
            String newline = System.lineSeparator();
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println("\033[0;4m" + "Main Menu:" + "\033[0m");
            System.out.println();
            System.out.println("\033[0;4m" + "What function would you like? (Type Associated Number):" + "\033[0m"
                    + newline + newline
                    + "(0) See All List Names" + newline + "(1) Inspect A List"
                    + newline + "(2) Append A List Task" + newline + "(3) Remove A List Task"
                    + newline + "(4) Create A New List" + newline
                    + "(5) Record Task Completion" + newline + "(6) See/Add To Important Tasks" + newline +
                    "(7) Delete a To-Do List" + newline + "(8) Exit");

            System.out.println("------------------------------------------------------------------------------------");
            Scanner userInput = new Scanner(System.in);
            String userInputToString = userInput.nextLine();

            System.out.println("Are you sure you want to select option " + userInputToString + "?");
            System.out.println("Type p to proceed and any other key to go back to the Main Menu.");

            Scanner checkInput = new Scanner(System.in);
            String userCheckInputToString = checkInput.nextLine();

            // This if statement allows a user to validate their program function choice and proceed to their
            // previously chosen function, or if they instead want to use a different function they can select to go
            // back to the main menu. I felt this was an easy and effective way of allowing the user to navigate back
            // and forth through the program.
            boolean checkSelection = userCheckInputToString.equals("p");
            if (!checkSelection) {
                System.out.println("Returning to Main Menu...");
            } else {
                // Creating a switch statement that allows the user to navigate through the program in an effective way
                // based upon their own input to the program (inputs --> cases).

                switch (userInputToString) {
                    case "0":
                        // This case enables the names of the currently saved To-Do Lists to be displayed.
                        System.out.println(mapOLists.keySet());
                        break;

                    case "1":
                        // This case allows the user to inspect an individual To-Do List.
                        ArrayList<String> inspectList;

                        System.out.println(mapOLists.keySet());
                        System.out.println("What List Would You Like To Inspect?");
                        Scanner userInput2 = new Scanner(System.in);
                        String userInputToString2 = userInput2.nextLine();

                        inspectList = mapOLists.get(userInputToString2);
                        System.out.println(inspectList);
                        break;

                    case "2":
                        // this case allows the user to add a task (with name of their choosing) to a specified To-Do List.
                        ArrayList<String> addToThisList;

                        System.out.println(mapOLists.keySet());
                        System.out.println("What List Would You Like To Inspect?");
                        Scanner userInput3 = new Scanner(System.in);
                        String userInputToString3 = userInput3.nextLine();

                        addToThisList = mapOLists.get(userInputToString3);
                        System.out.println(addToThisList);

                        System.out.println("What Task Would You Like to Add To This List?");
                        Scanner userInput4 = new Scanner(System.in);
                        String newElement = userInput4.nextLine();

                        appendAndRemove optionsAdd = new appendAndRemove(addToThisList, newElement);
                        mapOLists.replace(userInputToString3, optionsAdd.addElement());
                        System.out.println(addToThisList);
                        break;

                    case "3":
                        // This case allows the user to remove a specific task from a specified To-Do list.
                        ArrayList<String> removeFromThisList;

                        System.out.println(mapOLists.keySet());
                        System.out.println("What List Would You Like To Inspect?");
                        Scanner userInput5 = new Scanner(System.in);
                        String userInputToString4 = userInput5.nextLine();

                        removeFromThisList = mapOLists.get(userInputToString4);
                        System.out.println(removeFromThisList);

                        System.out.println("What Task Would You Like to Remove From This List?");
                        Scanner userInput6 = new Scanner(System.in);
                        String deleteElement = userInput6.nextLine();

                        appendAndRemove optionsRemove = new appendAndRemove(removeFromThisList, null, deleteElement);
                        mapOLists.replace(userInputToString4, optionsRemove.removeElement());
                        System.out.println(mapOLists);
                        break;

                    case "4":
                        // This case allows a user to create a new To-Do List with name of their choosing.
                        System.out.println("What Would You Like to Call the New List?");
                        Scanner userInput7 = new Scanner(System.in);
                        String userInputToString5 = userInput7.nextLine();

                        ArrayList<String> newOne = new ArrayList<>();
                        mapOLists.put(userInputToString5, newOne);

                        System.out.println(mapOLists.keySet());
                        break;

                    case "5":
                        // This case allows the user to mark a specific task from a specific To-Do List as completed.
                        ArrayList<String> listWithCompletion;

                        System.out.println(mapOLists.keySet());
                        System.out.println("What List Would You Like To Inspect?");
                        Scanner userInput8 = new Scanner(System.in);
                        String userInputToString6 = userInput8.nextLine();

                        listWithCompletion = mapOLists.get(userInputToString6);
                        System.out.println(listWithCompletion);

                        System.out.println("What Task Would You Like To Mark As Completed?");
                        Scanner userInput9 = new Scanner(System.in);
                        String completedElement = userInput9.nextLine();

                        taskCompletionAndImportance optionsCompleted = new taskCompletionAndImportance(listWithCompletion,userInputToString6, mapOLists,completedElement);
                        System.out.println(optionsCompleted.completedTask());
                        break;

                    case "6":
                        // This case is extra-functionality that allows a user to display the importance of tasks by
                        // underlining them in the console output. I.e. A user can select any individual task to be
                        // classed as 'important' and when inspecting individual To-Do Lists, the underlining can be
                        // seen in the selected tasks (underlining is achieved through use of ANSI escape codes).
                        ArrayList<String> listWithImportance;

                        System.out.println(mapOLists.keySet());
                        System.out.println("What List Would You Like To Inspect? (Type n if you would like to see all " +
                                "tasks currently marked as important)");
                        Scanner userInput10 = new Scanner(System.in);
                        String userInputToString7 = userInput10.nextLine();
                        boolean importanceConditional = userInputToString7.equals("n");

                        if (!importanceConditional) {
                            listWithImportance = mapOLists.get(userInputToString7);
                            System.out.println(listWithImportance);
                            System.out.println("What Task Would You Like To Mark As Important?");
                            Scanner userInput11 = new Scanner(System.in);
                            String importantElement = userInput11.nextLine();

                            taskCompletionAndImportance optionsImportant = new taskCompletionAndImportance(listWithImportance,userInputToString7, mapOLists, null, importantElement);
                            System.out.println(optionsImportant.importantTask());
                        } else {
                            System.out.println("These are the tasks you previously marked as important!");

                            taskCompletionAndImportance optionsAllImportant = new taskCompletionAndImportance(mapOLists);
                            System.out.println(optionsAllImportant.getAllImportantTasks());
                        }
                        break;

                    case "7":
                        System.out.println("What List Would You Like To Delete?");
                        System.out.println(mapOLists.keySet());
                        Scanner userInput12 = new Scanner(System.in);
                        String listToDelete = userInput12.nextLine();
                        mapOLists.remove(listToDelete);
                        break;

                    case "8":
                        // This case allows the user to exit the entire program if they so choose, breaking out of the
                        // while loop by meeting its 'value' condition.
                        System.out.println("Exiting Program, Goodbye:)");
                        value = 1;
                        break;

                    default:
                        // This is the default case which tells the user to enter a valid command if they don't choose a
                        // valid program function from the main menu screen.
                        System.out.println("Please Enter a Valid Command! (Number from 0-8)");
                }
            }
        }
    }
}

