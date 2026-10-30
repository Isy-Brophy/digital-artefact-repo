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

    public boolean setStatus(String newStatus){
        if (newStatus.equalsIgnoreCase("in progress")|| newStatus.equalsIgnoreCase("needs review") || newStatus.equalsIgnoreCase("need assistance") || newStatus.equalsIgnoreCase("completed") ){
             this.status = newStatus;
             return true;
        } else{
            return false;
        }
    }

    public void setCompleted(){
        //if (this.status.equalsIgnoreCase("completed") ||)
    }

    


}
