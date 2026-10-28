import java.util.ArrayList; 
public class module {
    String moduleName;
    String moduleCode;
    ArrayList<Assignment> moduleAssignments;

    public module (String moduleName, String moduleCode){
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

    }

}
