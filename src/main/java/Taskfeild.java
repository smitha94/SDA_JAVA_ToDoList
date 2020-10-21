import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;

public class Taskfeild implements Serializable
{
    private String projectname;
    private LocalDate duedate;
    private String status;
    private String taskname;
    DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-DD");;


    public Taskfeild(String projectlistname, LocalDate duedate, String status,String taskname)  {
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

    public void setDate(LocalDate duedate) {
        this.duedate = duedate;
    }
    public LocalDate getDate() { return duedate; }

    public void setStatus( String isDone) { this.status = status; }
    public  String getStatus() { return status; }

    public void settaskname( int assign){ this.taskname= taskname;}
    public String gettaskname (){ return taskname;}


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