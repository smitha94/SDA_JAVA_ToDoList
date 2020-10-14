import java.time.format.DateTimeFormatter;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
    private String tasklistname;
    private Date date;
    private String status;

    DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-DD");;


    public Task(String tasklistname, Date date, String status) {
        this.tasklistname = tasklistname;
        this.date = date;
        this.status = status;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    }
    public void setlistname(String listname) {
        this.tasklistname = listname;
    }
    public String getlistname() { return tasklistname; }

    public void setDate(Date date) {
        this.date = date;
    }
    public Date getDate() { return date; }

    public void setStatus(String status) { this.status = status; }
    public String getStatus() { return status; }

     public  String gettaskItem(){
        return tasklistname + "" + date + "" + status;

     }

     @Override
    public String toString(){
        StringBuilder taskSB = new StringBuilder("");
        taskSB.append("Task " + tasklistname +"\n");
        taskSB.append("Due date:"  + date+"\n");
        taskSB.append("Status:  " + status);
        return taskSB.toString();
     }









}