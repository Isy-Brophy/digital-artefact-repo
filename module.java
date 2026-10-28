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

}


