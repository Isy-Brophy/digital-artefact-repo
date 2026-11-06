import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class studentAssignmentManager {


    public static Boolean isDateValid(String unvalidatedDate){ //validate that a date inout is in the correct format and isn't in the past
        String dateFormat = "dd/MM/yyyy"; // sets the allowed format 
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(dateFormat);
        LocalDate currentDate = LocalDate.now();

        try{ // allows for the user to enter a date that could cause an error ut insteda of crashing a program, it handles the error and allows it to continue
            LocalDate date = LocalDate.parse(unvalidatedDate, dateFormatter);
            if (date.isBefore(currentDate)){
                System.out.println("The date cannot be in the past, enter the assignment deadline in the format dd/mm/yyyy ");
                return false;
            } else {
                return true;
            }
        } catch (Exception e){ // only trigger when its in the wrong format 
            System.out.println("Invalid date format, enter the assignment deadline in the format dd/mm/yyyy");
            return false;
        }

    }

    public static void displayAllModules(ArrayList<Module> modulesList){ // prints out all the modules and their module code
        for (int i = 0; i < modulesList.size(); i++){
            Module theModule = modulesList.get(i);
            System.out.println((i+1) + ". " + theModule.getModuleName() + " (" + theModule.getModuleCode() + ")");
        }
        
    }

    public static Module selectModule(ArrayList<Module> modulesList, Scanner scanner){ // allows the user to select a module
        if (modulesList.isEmpty()){
            System.out.println("There are no modules to select, please add one first");
            return null;
        } else {
            Module chosenModule = null;
            while (chosenModule == null){
                try{ // allows for the code to handle the user entering a non integer 
                    System.out.println("Select a module");
                    displayAllModules(modulesList);
                    int choose = scanner.nextInt();
                    scanner.nextLine();
                    // ensures the user chooses a valid number
                    while (choose <= 0 || choose > modulesList.size()){
                        System.out.println("Please choose a valid module number");
                        choose = scanner.nextInt();
                        scanner.nextLine();
                    }

                    chosenModule = modulesList.get(choose-1);
                } catch (Exception e){
                    System.out.println("Please enter a valid number");
                    scanner.nextLine();
                }
            }
            return chosenModule;

        }
    }
   
    public static Assignment selectAssignment(Module chosenModule, Scanner scanner){ // allows the user to select an assignment in a module
        if (chosenModule.getModuleAssignments().isEmpty()){
            System.out.println("There are no assignments in this module");
            return null;
        } else{

            chosenModule.displayAssignments();
            Assignment chosenAssignment = null;
            while (chosenAssignment == null){
                try { // allows for the code to handle the user entering a upon integer
                    System.out.println("select an assignment");
                    int num = scanner.nextInt();
                    scanner.nextLine();

                    // ensures the user chooses a valid number
                    while (num <= 0 || num > (chosenModule.getModuleAssignments().size())){
                        System.out.println("Please choose a valid module number");
                        num = scanner.nextInt();
                        scanner.nextLine();
                    }
                    chosenAssignment = chosenModule.getModuleAssignments().get(num-1);
                } catch (Exception e) {
                    System.out.println("Please enter a valid number");
                    scanner.nextLine();
                }
            }
            return chosenAssignment;
        }
    }

    public static void addNewModule(Scanner scanner, ArrayList<Module> modulesList){
        // creates an instance of the module class and adds it to the moduleList
        System.out.println("Please enter the module name: ");
        String moduleName = scanner.nextLine();
        System.out.println("Please enter the module code: ");
        String moduleCode = scanner.nextLine();
        Module newModule = new Module(moduleName, moduleCode);
        modulesList.add(newModule);
    }
    
    public static void addNewAssignment(Scanner scanner, ArrayList<Module> modulesList){
        // creates an instance of the assignment class and adds it to the attribute moduleAssignments which is a list that contains all of the assignments for that module
        Module chosenModule = selectModule(modulesList, scanner);
        if (chosenModule != null){
            System.out.println("Enter your assignment title: ");
            String theTitle = scanner.nextLine();
            System.out.println("Enter the assignment deadline in the format dd/mm/yyyy : ");
            String theDeadline;
            do{ 
                theDeadline = scanner.nextLine();
            } 
            while (isDateValid(theDeadline)!= true);
            
            System.out.println("Enter the priority");
            String thePriority = scanner.nextLine();
            String theStatus = "not started";
            // creates an assignment object and adds it to the chosen module's assignment list
            Assignment newAssignment = new Assignment(theTitle, theDeadline, thePriority, theStatus);
            chosenModule.addAssignment(newAssignment);
        }
    } 

    public static void displayEverySingleAssignment(Scanner scanner, ArrayList<Module> modulesList){
        if (modulesList.isEmpty() ){
            System.out.println("You don't have any modules or assignments, please add a module first and add your assignments");
        } else {
            for (int i = 0; i< modulesList.size(); i++){
                Module theModule = modulesList.get(i);
                System.out.println("Module: " + theModule.getModuleName() + " (" + theModule.getModuleCode() + ")");
                theModule.displayAssignments();
            }
        }
    }

    public static void updateStatus(Scanner scanner, ArrayList<Module> modulesList ){
        System.out.println("Choose the module that contains the assignment you want to update");
        // allows the user to choose a module
        Module chosenModule = selectModule(modulesList, scanner);
        
        if (chosenModule != null){
            // allows the user to choose an assignment in the chosen module
            Assignment chosenAssignment = selectAssignment(chosenModule, scanner);
            if (chosenAssignment != null){
                System.out.println("Select an assignment that you want to oupdate the status of");

                System.out.println("What would you like to change the status to? in progress/needs review/need assistance/completed");
                String newStatus = scanner.nextLine();
                
                // ensures that the user chooses a valid status
                while (chosenAssignment.setStatus(newStatus)!= true){
                    System.out.println("Please choose a valid status? in progress/needs review/need assistance/completed");
                    newStatus = scanner.nextLine();
                }
            }
            
        }
    }
    
    public static boolean isAssignments(Module theModule){
        return !theModule.getModuleAssignments().isEmpty(); 
    }
    
    public static void viewUncompletedAssigments(Scanner scanner,ArrayList<Module> modulesList){
        if (modulesList.isEmpty() ){
            System.out.println("You don't have any modules and assignments, please add a module first and add your assignments");
        } else {
            for (int i = 0; i< modulesList.size(); i++){
                Module theModule = modulesList.get(i);
                if (isAssignments(theModule)){
                    System.out.println("Module: " + theModule.getModuleName() + " (" + theModule.getModuleCode() + ")");
                    theModule.displayNotCompletedAssignments();
                } else {
                    System.out.println("You have no assignments");
                }

            }
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Module> modulesList = new ArrayList<>();

        boolean run = true;

        // main menu loop
        while (run== true){
            
            try { // alows for the code to handle non integer inputs
            System.out.println("=================================");
            System.out.println(" STUDENT ASSIGNMENT MANAGER");
            System.out.println("=================================");
            System.out.println("Please select an option:");
            System.out.println("1. Add a new module");
            System.out.println("2. View your modules");            
            System.out.println("3. Add a new assignment");
            System.out.println("4. View all assignments in a module");
            System.out.println("5. View all assignments");
            System.out.println("6. Update an assignment status");
            System.out.println("7. View current assignments");
            System.out.println("8. Exit");

            //takles in the users input
            int input = scanner.nextInt();
            scanner.nextLine();

            //checks if the users input is valid - it must be between 1 and 8
             while (input<=0 || input >= 9){
                System.out.println("Please enter a number between 1-8");
                input = scanner.nextInt();
                scanner.nextLine();
            }

            
            // handles the user choosing an option 
            switch(input)
            {
                case 1: // allows the user to add a new module 
                    // creates an instance of the module class and adds it to the moduleList
                    addNewModule(scanner, modulesList);
                    break;

                case 2: // displays all modules
                    if (modulesList.isEmpty()){
                        System.out.println("You have no modules, please add a modue first");
                    } else {
                        displayAllModules(modulesList);
                    }
                    break;
                
                case 3: // adds a new assignment to a module
                    addNewAssignment(scanner, modulesList);
                    break;

                case 4: // displays all the assignments in a chosen module
                    Module chosenModule = selectModule(modulesList, scanner);
                    if (chosenModule != null){
                        chosenModule.displayAssignments();
                    }
                    break;

                case 5: // displays all of the assignments in all modules
                    displayEverySingleAssignment(scanner, modulesList);
                    break;

                case 6: // updates the status of a chosen assignment 
                    updateStatus(scanner, modulesList);
                    break;  
                
                case 7: // view all assignments that have not yet been completed/ are before their deadline
                    viewUncompletedAssigments(scanner, modulesList);
                    break;
                
                case 8: // close the program
                    System.out.println("Shutting down the program, goodbye");
                    run = false;
                    break;

            }
            } catch (Exception e){
                System.out.println("please enter a valid number");
                scanner.nextLine();
            }
        }
    }
}
