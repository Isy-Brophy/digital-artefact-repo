import java.util.ArrayList;
import java.util.Scanner;

public class studentAssignmentManager {

    

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Module> modulesList = new ArrayList<>();

        boolean run = true;

        // main menu loop
        while (run== true){
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

            //checks if the users input is valid - it must be between 1 and 9 
             while (input<=0 || input >= 10){
                System.out.println("Please enter a number between 1-9");
                input = scanner.nextInt();
                scanner.nextLine();

            }

            
            // handles the user choosing an option 
            switch(input)
            {
                case 1: // allows the user to add a new module 
                    // creates an instance of the module class and adds it to the moduleList
                    System.out.println("Please enter the module name: ");
                    String moduleName = scanner.nextLine();
                    System.out.println("Please enter the module code: ");
                    String moduleCode = scanner.nextLine();
                    Module newModule = new Module(moduleName, moduleCode);
                    modulesList.add(newModule);
                    break;

                case 2: // displays all modules
                    // checks if the moduleList is empty 
                    if (modulesList.isEmpty()){
                        System.out.println("No modules have been added yet");
                    } else {
                        for (int i = 0; i < modulesList.size(); i++){
                        Module theModule = modulesList.get(i);
                        System.out.println("Module " + (i+1) + ":");
                        System.out.println(theModule.getModuleName() + " (" + theModule.getModuleCode() + ")");
                        }
                    }
                    break;
                
                case 3: // adds a new assignment to a module
                    // creates an instance of the assignment class and adds it to the attribute moduleAssignments which is a list that contains all of the assignments for that module
                    if (modulesList.isEmpty()){
                    System.out.println("There are no modules to add an assignment to, please add a module first");
                    } else {
                        // displays all the modules the user can choose and allows them to select one (regarding that the user selects a module number that exists) 
                        System.out.println("Please select a module to add an assignment to:");
                        for (int i = 0; i< modulesList.size(); i++){
                            Module theModule = modulesList.get(i);
                            System.out.println((i+1) + ". " + theModule.getModuleName() + " (" + theModule.getModuleCode() + ")");
                        }

                        int choose = scanner.nextInt();
                        scanner.nextLine();
                        // ensures the user chooses a valid number
                        while (choose <= 0 || choose > modulesList.size()){
                            System.out.println("Please choose a valid module number");
                            choose = scanner.nextInt();
                            scanner.nextLine();
                        }

                        Module chosenModule = modulesList.get(choose-1);
                        System.out.println("Enter your assignment title: ");
                        String theTitle = scanner.nextLine();
                        System.out.println("Enter the assignment deadline in the format dd/mm/yyyy : ");
                        String theDeadline = scanner.nextLine();
                        System.out.println("Enter the priority");
                        String thePriority = scanner.nextLine();
                        String theStatus = "not started";
                        // creates an assignment object and adds it to the chosen module's assignment list
                        Assignment newAssignment = new Assignment(theTitle, theDeadline, thePriority, theStatus);
                        chosenModule.addAssignment(newAssignment);
                    }

                    break;

                case 4: // displays all the assignments in a chosen module
                    if (modulesList.isEmpty()){
                    System.out.println("There are no modules to view assignments for, please add a module first");
                    } else {
                        // displays all the modules the user can choose and allows them to select one (regarding that the user selects a module number that exists) 
                        System.out.println("Please select a module to view it's assignments:");
                        for (int i = 0; i< modulesList.size(); i++){
                            Module theModule = modulesList.get(i);
                            System.out.println((i+1) + ". " + theModule.getModuleName() + " (" + theModule.getModuleCode() + ")");
                        }

                        int choose = scanner.nextInt();
                        scanner.nextLine();
                        // ensures the user chooses a valid number
                        while (choose <= 0 || choose > modulesList.size()){
                            System.out.println("Please choose a valid module number");
                            choose = scanner.nextInt();
                            scanner.nextLine();
                        }
                        Module chosenModule = modulesList.get(choose-1);
                        chosenModule.displayAssignments();
                    }
                    break;

                case 5: // displays all of the assignments in all modules
                    if (modulesList.isEmpty() ){
                        System.out.println("You don't have any modules or assignments, please add a module first and add your assignments");
                    } else {
                        for (int i = 0; i< modulesList.size(); i++){
                            Module theModule = modulesList.get(i);
                            System.out.println("Module: " + theModule.getModuleName() + " (" + theModule.getModuleCode() + ")");
                            theModule.displayAssignments();
                        }
                    }
                    break;

                case 6: // updates the status of a chosen assignment 
                    System.out.println("Choose the module that contains the assignment you want to update");
                    if (modulesList.isEmpty()){
                    System.out.println("There are no modules to view assignments for, please add a module first");
                    } else {
                        // displays all the modules the user can choose and allows them to select one (regarding that the user selects a module number that exists) 
                        for (int i = 0; i< modulesList.size(); i++){
                            Module theModule = modulesList.get(i);
                            System.out.println((i+1) + ". " + theModule.getModuleName() + " (" + theModule.getModuleCode() + ")");
                        }
                        int choose = scanner.nextInt();
                        scanner.nextLine();
                        // ensures the user chooses a valid number
                        while (choose <= 0 || choose > modulesList.size()){
                            System.out.println("Please choose a valid module number");
                            choose = scanner.nextInt();
                            scanner.nextLine();
                        }
                        Module chosenModule = modulesList.get(choose-1);
                        System.out.println("Select an assignment that you want to oupdate the status of");
                        // prints out all the assignments if there are any
                        chosenModule.displayAssignments();
                        int num = scanner.nextInt();
                        scanner.nextLine();

                        // ensures the user chooses a valid number
                        while (choose <= 0 || num > (chosenModule.getModuleAssignments().size())){
                            System.out.println("Please choose a valid module number");
                            choose = scanner.nextInt();
                            scanner.nextLine();
                        }

                        Assignment chosenAssignment = chosenModule.getModuleAssignments().get(num-1);
                        System.out.println("What would you like to change the status to? in progress/needs review/need assistance/completed");
                        String newStatus = scanner.nextLine();
                        
                        // ensures that the user chooses a valid status
                        while (chosenAssignment.setStatus(newStatus)!= true){
                            System.out.println("Please choose a valid status? in progress/needs review/need assistance/completed");
                            newStatus = scanner.nextLine();
                        }
                        
                    }
                    break;  


                case 7: // view all assignments that have not yet been completed/ are before their deadline
                    break;
                case 8: // close the program
                    System.out.println("Shutting down the program, goodbye");
                    run = false;
                    break;

            }


        }
    }
}
