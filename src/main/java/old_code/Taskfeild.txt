import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Taskfeild {
    private String projectname;
    private Date duedate;
    private String status;
    private String taskname;
    DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-DD");;


    public Taskfeild(String projectlistname, Date duedate, String status,String taskname)  {
        this.projectname =projectlistname;
        this.duedate = duedate;
        this.status= status;
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

    public void setStatus( String isDone) { this.status = status; }
    public  String getStatus() { return status; }

    public void setUsername( int assign){ this.taskname= taskname;}
    public String getusername (){ return taskname;}


    public  String gettaskItem(){
        return  projectname + ": " + duedate + ": "+ status +": " +taskname +"\n";
     }

     @Override
    public String toString(){
        StringBuilder taskSB = new StringBuilder("");
        taskSB.append("Project name:" +projectname+" ,Due date : "+ duedate+ ",Status :" + status+",Task name :" + taskname);
        return taskSB.toString();
     }



        }