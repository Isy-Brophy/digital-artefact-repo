import java.util.ArrayList; 

public class Module {
    String moduleName;
    String moduleCode;
    ArrayList<Assignment> moduleAssignments;

    public Module (String moduleName, String moduleCode){
        this.moduleName = moduleName;
        this.moduleCode = moduleCode;
        this.moduleAssignments = new ArrayList<>();
    }

    public String getModuleName(){
        return moduleName;
    }

    public String getModuleCode(){
        return moduleCode;
    }
    
    public ArrayList<Assignment> getModuleAssignments(){
        return moduleAssignments;
    }


    public void addAssignment(Assignment theAssignment){
        moduleAssignments.add(theAssignment);
    }

    public void displayAssignments(){ // prints all of the assignments in the class
        if (moduleAssignments.isEmpty()){
            System.out.println("No assignments have been added");
        } else {
            for (int i = 0; i < moduleAssignments.size(); i++){
                Assignment theAssignment = moduleAssignments.get(i);
                System.out.println((i+1) + ". "+ theAssignment.getTitle() + ": ");
                System.out.println("   Deadline: "+ theAssignment.getDeadline());
                System.out.println("   Priority: " + theAssignment.getPriority());
                System.out.println("   Status: " + theAssignment.getStatus());

            }
        }
    }
}


