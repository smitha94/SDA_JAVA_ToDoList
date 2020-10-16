import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
    private String projectlistname;
    private Date duedate;
    //TODO: Change to boolean
    private Boolean isDone;

    DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-DD");;


    public Task(String projectlistname, Date date, Boolean isDone) {
        this.projectlistname =projectlistname;
        this.duedate = date;
        this.isDone= isDone;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    }
    public void setprojectlistname(String projectlistname) {
        this.projectlistname = projectlistname;
    }
    public String getprojectlistname() { return projectlistname ; }

    public void setDate(Date duedate) {
        this.duedate = duedate;
    }
    public Date getDate() { return duedate; }

    public void setisDone( Boolean isDone) { this.isDone = isDone; }
    public  Boolean getisDone() { return isDone; }

     public  String gettaskItem(){
        return  projectlistname + "" + duedate + "" + isDone;

     }


     @Override
    public String toString(){
        StringBuilder taskSB = new StringBuilder("");
        taskSB.append("Project task   :: " + projectlistname +"\n");
        taskSB.append("Due date  :: "  + duedate+"\n");
        taskSB.append("Status   ::  " + isDone);
        return taskSB.toString();
     }

}