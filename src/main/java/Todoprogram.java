//import com.company.CommandWords;

import javax.swing.*;
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
                case 2:
                    addlist();
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
    public void showtasklist() {
        if (tasklist.isEmpty()) {
            System.out.println("WARNING   ::   Task List is Empty  ");
            System.out.println("*********************************");
            printwelcome();
        } else {
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
    public void getSortedByProject() {
        tasklist.stream()
                .sorted(Comparator.comparing(Task::getprojectlistname))
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
        //inputlistname += scanner.next();

        System.out.println(" Enter the status  true or false");
        Scanner instate = new Scanner(System.in);
        Boolean inputstatus = instate.nextBoolean();

       /* boolean Y = true;
        do {
            String command = "y" ;
            switch (command) {
                case "y":
                    Boolean inputstatus = instate.nextBoolean();
                    break;
                case "n":
                    System.out.println("please selcect y or n");
                    break;
             default:
                    System.out.println("Wrong  Input");
                    break;
            }
        } while (Y != false);
*/
        System.out.println("Enter date of task  : dd/mm/yyyy ");  //  get Date of the task from user
        String inputdate1 = scanner.next();
        try {
            Date dateFormat = new SimpleDateFormat("dd/mm/yyyy").parse(inputdate1);
            Task task = new Task(inputlistname, dateFormat, inputstatus);
            tasklist.add(task);
            System.out.println("-------list is addded -------------------");
            printwelcome();
        } catch (ParseException e) {
            System.out.println(" wrong input date Please add again");
            addlist();
            e.printStackTrace();
            return;
        }
        Todoprogramaction();
        System.out.println("-------list is addded -------------------");
        printwelcome();
        Todoprogramaction();

    }

    //----------------------Deleteing from the list------------------------------
    public void deletelist() {
        if (tasklist.isEmpty()) {
            System.out.println("List Task is Empty ,Add Task  name, duedate, staus First");
            addlist();
        } else {
            System.out.println(" please select task no");
            Scanner scanner = new Scanner(System.in);
            int deletetasknum = scanner.nextInt();
            for (int inde = 0; inde < tasklist.size(); inde++)  // compare taskname with input from user
            {
                Task removedtask = tasklist.remove(deletetasknum);
                System.out.println(removedtask + "    is Removed fromt the list");
            }
        }
        printwelcome();
    }
//----------------------- Update project --------------------------------------
    /*public void updateproject() {
        if (tasklist.isEmpty()) {
            System.out.println("Insert the Task Project to update");
            if (tasklist.size() == 0)
                System.out.println("No such Task project is added");
                addlist();
        } else {
               System.out.println(" please select task no from the list");
                Scanner scanner = new Scanner(System.in);
               int deletetasknum = scanner.nextInt();
               int inde = tasklist.indexOf(deletetasknum);
               tasklist.set(inde,deletetasknum);
               System.out.println(tasklist);
              //2 - In single step replace D with D_NEW
               tasklist.set( tasklist.indexOf(inde);
            System.out.println(tasklist);*/







         /*  List<Integer> Int =new ArrayList<Integer>();
          System.out.println("enter Project task no to update");
             Scanner in=new Scanner(System.in);
              int num=in.nextInt();
               for(int i=0;i<tasklist.size();i++){
                if ( num == Task.get(i))
                       System.out.println(num+" is  PRESENT at Index "+i);
                      }

                     if(tasklist.lastIndexOf(num)==-1)
                    System.out.println(num+" is NOT PRESENT");
                  }*/








               /* StringBuilder sB = new StringBuilder();
                Iterator<Task> formatIterator = tasklist.iterator();
                while(formatIterator.hasNext())
                {
                    Task tas = formatIterator.next();
                    sB.append(tas.formatter);
                }
                     sB.toString();
            }*/
       // printwelcome();
    //}

         /*   int update = scanner.nextInt();
            for (int inde = 0; inde < tasklist.size(); inde++)  // compare taskname with input from user
            {
                System.out.println("Inserted Task");
                 int x = tasklist.remove(inde);
                System.out.println(" Task Project is Updated  :");
            }
        }*/

//-------------------------------------------------- ------------------------------
         public void Edit() {
             System.out.println("Please select the choice");
             System.out.println("  a) Update ");
             System.out.println("  b) Mark as done");
             System.out.println("  c) Remove");
             System.out.println("  d) Exit");
             Scanner inputedit = new Scanner(System.in);
             boolean Y = true;
             do {
                String command = inputedit.next();
                 switch (command){
                     case "a":
                         //ls
                         // updateproject();
                         break;
                     case "b":
                         System.out.println(" mark as done.. not done yet");
                         break;
                     case "c":
                         deletelist();
                         break;
                     case "d":
                         System.out.println("Your exiting the program");
                         quittask();
                         printwelcome();
                         break;
                     default:
                         System.out.println("Wrong  Input (Please select a,b,c,d) ");
                         break;
                 }
              } while (Y != false);


           }

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















