import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
    private String tasklistname;
    private Date duedate;
    //TODO: Change to boolean
    private String isDone;

    DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-DD");;


    public Task(String tasklistname, Date date, String status) {
        this.tasklistname = tasklistname;
        this.duedate = date;
        this.isDone = status;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    }
    public void setlistname(String listname) {
        this.tasklistname = listname;
    }
    public String getlistname() { return tasklistname; }

    public void setDate(Date duedate) {
        this.duedate = duedate;
    }
    public Date getDate() { return duedate; }

    public void setIsDone(String isDone) { this.isDone = isDone; }
    public String getIsDone() { return isDone; }

     public  String gettaskItem(){
        return tasklistname + "" + duedate + "" + isDone;

     }


     @Override
    public String toString(){
        StringBuilder taskSB = new StringBuilder("");
        taskSB.append("Task " + tasklistname +"\n");
        taskSB.append("Due date:"  + duedate+"\n");
        taskSB.append("Status:  " + isDone);
        return taskSB.toString();
     }

}