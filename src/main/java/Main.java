
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Main {

    public static void main(String[] args)
    {
        // This part of the code works with FileHandler.
        // Comment this out when you want to try your main application.
        FileHandler fh = new FileHandler();
        //ArrayList<Taskfeild> taskList = new ArrayList<>();
        //taskList.add(new Taskfeild("Individual project", new Date(),"yes or no ", "Finish project"));
        //fh.writeAsData(taskList);

         Todoprogram todo = new  Todoprogram();
          //todo.printwelcome();
          todo.Todoprogramaction();

    }





}