class Assignment{
    String title;
    String deadline;
    String priority;
    String status;

    public Assignment (String title, String deadline, String priority, String status){
        this.title = title;
        this.deadline = deadline;
        this.priority = priority; 
        this.status = status;
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
}