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
import java.util.stream.*;

public class Todoprogram {
    List<Task> tasklist = new ArrayList<>();
    private boolean setExit = false;
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

    public int checkInt()
    {
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            try{
                int x = scanner.nextInt();
                return x;
            }
            catch(InputMismatchException e)
            {
                System.out.println("please type a number");
            }
        }
    }

    //------------------User functions --------------------------------
    public void printwelcome() {
        System.out.println("Welcome to ToDo List");
        System.out.println("(1) Show Task List");
        System.out.println("(2) Add");
        System.out.println("(3) Edit (update,mark as done ,remove)");
        System.out.println("(4) Save and Quit");
        System.out.println("------------------------------------------");
    }
    //--------------   Show all the inserted task   ------------------------------
    public void showtasklist() {
        if (tasklist.isEmpty()) {
            System.out.println("WARNING   ::   Task List is Empty  ");
            System.out.println("*********************************");
            printwelcome();
        } else {
            System.out.println("Total no in ToDo List are " + tasklist.size());
             for (int i = 0; i < tasklist.size(); i++) {
                System.out.println(tasklist.get(i));

             }
            System.out.println("----------------------------------------------------");
            System.out.println(" a>> Enter Sort by date wise ");
            System.out.println( "b >> Sort by project task name  wise ");
            System.out.println("c >> exit and Back to the main menu");
            Scanner userchoice = new Scanner(System.in);
            boolean Y = true;
            do {
               String command = userchoice.next();
                switch (command) {
                    case "a":
                       // sortbydate();break;
                    case "b":
                         getSortedByProject();
                        System.out.println("Total no in ToDo List are " + tasklist.size());
                        printwelcome();
                        break;
                    case "c":
                        printwelcome();
                        break;
                    default:
                        System.out.println("Wrong  Input");
                        printwelcome();
                        break;
                }
            } while (Y != false);
            System.out.println("----    **       ---------");
            printwelcome();
        }
    }

    //_------------------------sorting tasklist----------
    public void getSortedByProject() {

       //---------------------------------
       /* Collections.sort(tasklist, new Comparator<Task>() {
            @Override
            public String compare(Task o1, Task o2) {
               String sortname= ( o1.getprojectlistname().compareTo(o2.getprojectlistname());
                return sortname;
            }
        });*/

      /* List<String> tasknamesort = Arrays.asList(tasklist));
        List<String> sortedList =tasknamesort.stream().sorted().collect(Collectors.toList());
        sortedList.forEach(System.out::println);
        System.out.println("sorted" );*/

//-----------------------

         List<Task> sortedList = tasklist.stream()
                .sorted(Comparator.comparing(Task::getprojectlistname))
                //.forEach(task -> System.out.println(task.gettaskItem()))
                .collect(Collectors.toList());

        for (int i = 0; i < sortedList.size(); i++) {
            System.out.println(sortedList.get(i));

        }

        //printwelcome();
//--------------------


       /*List result = tasklist.stream().sorted((task1, task2)->task1.gettaskItem().().
                compareTo(task2.gettaskItem().getValue())).
                collect(Collectors.toList());*/

}
    //----------------------------------------------------------------------
    public void getsortbydate() {

      /*  Collections.sort(tasklist, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });
        System.out.println("sort by date wise");*/

    }
//--------------------------------------------------------------------
    public void addlist() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Add project name   : ");
        String inputprojectname = scanner.next(); // get name from user

        System.out.print(" Enter the status  true or false  :");
        Boolean inputstatus =scanner.nextBoolean();


        System.out.print("Enter task name:");
        String inputtaskname =scanner.next();

        System.out.print ("Enter date of task¨  : dd/mm/yyyy    :");  //  get Date of the task from user
        String inputdate1 = scanner.next();

        try {
            Date dateFormat = new SimpleDateFormat("dd/mm/yyyy").parse(inputdate1);
            Task task = new Task(inputprojectname, dateFormat, inputstatus,inputtaskname);
            tasklist.add(task);
            System.out.println("-------list is addded -------------------");
            printwelcome();
        } catch (ParseException e) {
            System.out.println(" wrong input date Please add again");
            addlist();
            e.printStackTrace();
            return;
        }

      /*  try{
            Date dateFormat = new SimpleDateFormat("dd/mm/yyyy").parse(inputdate1);
            Task task = new Task(inputprojectname, dateFormat, inputstatus,inputtaskname);
            tasklist.add((inputprojectname, dateFormat, inputstatus,inputtaskname);
            System.out.println("Enter the option");
             = scanInput();
        }catch(IOException f)
        {
            System.out.println("Problem occured when trying to add a record ");
        }
    }*/
        Todoprogramaction();
        System.out.println("--   ****  list is addded   ***----------");
        System.out.println("-------------------------------------------------");
        printwelcome();
        Todoprogramaction();
    }
    //--------------------Edit function -------------------------------------------------------
    public void Edit() {
        if (tasklist.isEmpty()) {
            System.out.println(" ****     WARNING   ::   Task List is Empty  ******** ");
            System.out.println("---------------------------------------------------------");
            printwelcome();
        } else {
            System.out.println("Please select the choice");
            System.out.println("  1) Update ");
            System.out.println("  2) Mark as done");
            System.out.println("  3) Remove");
            System.out.println("  4) Exit");
            Scanner inputedit = new Scanner(System.in);
            System.out.println(" Enter correct option");
            boolean Y = true;
            do {
                int option = inputedit.nextInt();
                switch (option) {
                    case 1:
                        //ls
                        // updateproject();
                        break;
                    case 2:
                        System.out.println(" mark as done.. not done yet");
                        break;
                    case 3:
                        deletelist();
                        printwelcome();
                        break;
                    case 4:
                        System.out.println("Your exiting the program");
                        quittask();
                        printwelcome();
                        break;
                    default:
                        System.out.println("Wrong  Input (Please select 1,2,3,4) ");
                        break;
                }
            } while (Y != false);
        }
    }
    //----------------------Deleteing from the list------------------------------
    public void deletelist() {
        if (tasklist.isEmpty()) {
            System.out.println("List Task is Empty ,Add Task  name, duedate, staus ,user Id,username  First");
            addlist();
        } else {

            System.out.println("Total no in ToDo List are :" + tasklist.size() +"\n");
            for (int i = 0; i < tasklist.size(); i++) {
                System.out.println("Ths task number " + i + ": ");
                System.out.println(tasklist.get(i)+"\n");
                System.out.println(" Task list  names" + tasklist.get(i).getprojectlistname());
                System.out.println("...............................");
            }

            System.out.println(" please select task no");
            Scanner scanner = new Scanner(System.in);
            int deleteuser = scanner.nextInt();
            for (int inde = 0; inde < tasklist.size(); inde++)  // compare taskname with input from user
            {
                Task removeduser = tasklist.remove(deleteuser);
                System.out.println(removeduser + " details removed from the tasklist ");
            }
            printwelcome();
        }

    }
//----------------------- Update project --------------------------------------
   /* public void updateproject() {
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
              Task setnewtask = tasklist.set(inde);
               System.out.println(tasklist);
              //2 - In single step replace D with D_NEW
               tasklist.set( tasklist.indexOf(inde);
            System.out.println(tasklist);*/
//----------------------->
      /*  List<Integer> Int =new ArrayList<Integer>();
            System.out.println("Total no in ToTo List are " + tasklist.size());// first show the all the reocrds before edit
             for (int i = 0,j=1; i < tasklist.size(); i++)
             System.out.println(tasklist.get(i));

             System.out.println("enter Project task no to update");// user can choose the task  by index no
             Scanner inputbyindexno =new Scanner(System.in);
              int num=inputbyindexno.nextInt();

              for(int i=0;i<tasklist.size();i++){
                if ( num == tasklist.get(i))
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
        }**/


//----------------------for exiting the application-------------------------------
        public void quittask () {
            System.out.println(" Task list is exiting");
            System.out.println(" Program is exiting  byeeeee");
            System.exit(0);
            setExit = true;
        }


}

  //_------------     EDIT TASK       -------------















