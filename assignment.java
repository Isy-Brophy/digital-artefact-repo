import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Assignment{
    String title;
    String deadline;
    String priority;
    String status;
    Boolean completed;

    public Assignment (String title, String deadline, String priority, String status){
        this.title = title;
        this.deadline = deadline;
        this.priority = priority; 
        this.status = status;
        this.completed = false;
    }
    
    public String getTitle(){
        return title;
    }

    public String getDeadline(){
        return deadline;
    }

    public String getPriority(){
        return priority;
    }
    
    public String getStatus(){
        return status;
    }

    public Boolean getCompleted(){
        return completed;
    }

    public boolean setStatus(String newStatus){
        if (newStatus.equalsIgnoreCase("in progress")|| newStatus.equalsIgnoreCase("needs review") || newStatus.equalsIgnoreCase("need assistance") || newStatus.equalsIgnoreCase("completed") || newStatus.equalsIgnoreCase("missed deadline")){
             this.status = newStatus;
             return true;
        } else{
            return false;
        }
    }

    public void setCompleted(){
        String dateFormat = "dd/MM/yyyy"; // sets the allowed format 
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(dateFormat);
        LocalDate currentDate = LocalDate.now();
        LocalDate deadlineDate = LocalDate.parse(this.deadline, dateFormatter);
        if (this.status.equalsIgnoreCase("completed")){
            this.completed = true;
        } else if (currentDate.isAfter(deadlineDate)){
            this.status = "missed deadline";
            this.completed = true;
        } else {
            this.completed = false; 


        }
    }

    


}
