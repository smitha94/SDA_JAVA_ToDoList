//import com.company.CommandWords;

import java.io.IOError;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.*;
import java.util.Date;
import java.util.Collections;
import java.util.concurrent.Callable;

public class Todoprogram {

    List<Task> tasklist = new ArrayList<>();
   //------------    Functions of List begins here ---------------
    public void Todoprogramaction() {

        Scanner inputval = new Scanner(System.in);
        boolean Y = true;
        do {
            int command = inputval.nextInt();
            switch (command) {
                case 1:
                   showtasklist();
                    break;
                case 2:addlist();
                    break;
                case 3:
                    Edit();
                    break;
                case 4:
                    quittask();
                    break;
                default:
                    System.out.println("Wrong  Input");
                    break;
            }
        } while (Y != false);
    }
//--------------   Show all the inserted task   ------------------------------
    public void showtasklist()
    {
        if (tasklist.isEmpty())
        {
            System.out.println("WARNING   ::   Task List is Empty  ");
            System.out.println("*********************************");
           printwelcome();
        } else
        {
            System.out.println("Total no in ToTo List are " + tasklist.size());
            for (int i = 0; i < tasklist.size(); i++)
                System.out.println(tasklist.get(i));

            //System.out.println( tasklist.get(j).getlistname());

               System.out.println("----    **       ---------");
                        /* Iterator<Task> itr = tasklist.iterator(); // second type to get the values
                           while (itr.hasNext()) {
                           System.out.println(itr.next());

                         }*/
            printwelcome();
        }
    }
 //_------------------------sorting tasklist----------
    public void getSortedByProject(){
        tasklist.stream()
                .sorted(Comparator.comparing(Task::getlistname))
                .forEach(task -> System.out.println(task.gettaskItem()));
    }

//------------------------------------------------------------------
    public void printwelcome() {
        System.out.println("Welcome to ToDo List");
        System.out.println("(1) Show Task List");
        System.out.println("(2) Add");
        System.out.println("(3) Edit (update,mark as done ,remove)");
        System.out.println("(4) Save and Quit");
        System.out.println("------------------------------------------");
    }
//--------------------------------------------------------------------
    public void addlist() {
        System.out.println("Add task name");
        Scanner scanner = new Scanner(System.in);
        String inputlistname = scanner.nextLine(); // get name from user

        System.out.println("Add Status       Y , N ");
        String inputstatus = scanner.nextLine(); // get status from user

        System.out.println("Enter date of task  : dd/mm/yyyy ");  //  get Date of the task from user
        String inputdate1 =  scanner.nextLine();

        try{
            Date dateFormat = new SimpleDateFormat("dd/mm/yyyy").parse(inputdate1);
            Task task = new Task(inputlistname, dateFormat, inputstatus);
            tasklist.add(task);
            System.out.println("-------list is addded -------------------");
            printwelcome();
            Todoprogramaction();
        }catch (ParseException e){
            System.out.println(" wrong input date Please add again");
            addlist();
            e.printStackTrace();
            return;
        }
    }
//----------------------Deleteing from the list------------------------------
     public void deletelist() {
        if (tasklist.isEmpty()) {
            System.out.println("List Task is Empty ,Add Task  name, duedate, staus First");
          addlist();
        }
        else
            {
                System.out.println(" please select task no");
                Scanner scanner = new Scanner(System.in);
                int deletetasknum = scanner.nextInt();
                for (int inde = 0; inde < tasklist.size(); inde++)  // compare taskname with input from user
                {
                    Task  removedtask = tasklist.remove(deletetasknum);
                    System.out.println( removedtask + "    is Removed fromt the list");
                }
            }
            printwelcome();
        }

//-------------------------------------------------- ------------------------------
         public void Edit() {
             Scanner inputedit = new Scanner(System.in);
            /* boolean Y = true;
             do {
                 int command = inputedit.nextInt();
                 switch (command) {
                     case 1:
                         showtasklist();
                         break;*/

                     System.out.println("Insert the Task name to search");
                     Scanner d = new Scanner(System.in);
                     String de = d.nextLine();
                     Iterator ite = tasklist.iterator();
                     while (ite.hasNext()) {
                         if (ite.next().equals(de)) {
                             System.out.println(de + "    exists");
                         }
                     }
                     if (tasklist.isEmpty()) {
                         System.out.println("Task List is Empty  and Insert the Task name");
                         if (tasklist.size() == 0)
                             addlist();
                     } else
                         System.out.println("Inserted Task");
                     for (int i = 0; i < tasklist.size(); i++)
                         System.out.println(tasklist.get(i));
                     System.out.println("Total no in ToTo List are " + tasklist.size());
                     printwelcome();
                 }
                 //List<Integer> I=new ArrayList<Integer>();
          /*  System.out.println("enter no to search");
             Scanner in=new Scanner(System.in);
              int num=in.nextInt();
               for(int i=0;i<tasklist.size();i++){
                if ( num== tasklist.get(i))
                       System.out.println(num+" is  PRESENT at Index "+i);
                      }

                     if(tasklist.lastIndexOf(num)==-1)
                    System.out.println(num+" is NOT PRESENT");
                  }   */


  //----------------------------------------------------------------
            public void quittask () {
                System.out.println(" Task list is exiting");
                // boolean y=true;
                //if (y= false)
                //{
                // System.out.println(" Program is exiting  byeeeee");
                System.exit(0);
                // }
            }
   }
  //_------------     EDIT TASK       -------------















