import java.util.ArrayList;
import java.util.Scanner;

public class studentAssignmentManager {

    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<module> modulesList = new ArrayList<>();

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
            System.out.println("7. View assignment statistics");
            System.out.println("8. View current assignments");
            System.out.println("9. Exit");

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
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;  
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    System.out.println("Shutting down the program, goodbye");
                    run = false;
                    break;

            }


        }
    }
}