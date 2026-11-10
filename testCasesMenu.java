
public class testCasesMenu {

    public static int testMenuValidOption(int input){

    try { // alows for the code to handle non integer inputs

        //checks if the users input is valid - it must be between 1 and 8
            while (input<=0 || input >= 9){
            return (0);
        }
            
            // handles the user choosing an option 
        switch(input){
            case 1:
                return (1);
                break;

            case 2: // displays all modules
                return (2);
                break;
                
            case 3: // adds a new assignment to a module
                return (3);
                break;

            case 4: // displays all the assignments in a chosen module
                return (4);
                break;

            case 5: // displays all of the assignments in all modules
                return (5);
            break;

            case 6: // updates the status of a chosen assignment 
                return (6);
                break;  
            
            case 7: // view all assignments that have not yet been completed/ are before their deadline
                return (7);
                break;
            
            case 8: // close the programreturn (8);
                return (8); 
                break;

            }
    } catch (Exception e){
        return(0);
        System.out.println("please enter a valid number");
    }
        
    }