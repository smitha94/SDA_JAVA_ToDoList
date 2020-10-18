import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
    private String projectname;
    private Date duedate;
    private Boolean status;
    private String taskname;
    DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-DD");;


    public Task(String projectlistname, Date duedate, Boolean status,String taskname)  {
        this.projectname =projectlistname;
        this.duedate = duedate;
        this.status= false;
        this.taskname= taskname;
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

    }
    public void setprojectlistname(String projectlistname) {
        this.projectname = projectlistname;
    }
    public String getprojectlistname() { return projectname ; }

    public void setDate(Date duedate) {
        this.duedate = duedate;
    }
    public Date getDate() { return duedate; }

    public void setStatus( Boolean isDone) { this.status = status; }
    public  Boolean getStatus() { return status; }

    public void setUsername( int assign){ this.taskname= taskname;}
    public String getusername (){ return taskname;}


    public  String gettaskItem(){
        return  projectname + ": " + duedate + ": "+ status +": " +taskname +"\n";
     }

     @Override
    public String toString(){
        StringBuilder taskSB = new StringBuilder("");

        taskSB.append("Project name   :: " + projectname +"\n");
        taskSB.append("Due date  :: "  + duedate+"\n");
        taskSB.append("Status   ::  " + status+"\n");
         taskSB.append("task name ::" + taskname);
        return taskSB.toString();
     }

}