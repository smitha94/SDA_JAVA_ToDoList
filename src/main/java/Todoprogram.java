//import com.company.CommandWords;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.*;
import java.util.Date;
import java.util.stream.*;

public class Todoprogram {
    List<Taskfeild> listOfTask = new ArrayList<>(); //new fileHandler.resd
    TaskList taskList = new TaskList();
    private boolean setExit = false;
    //------------    Functions of List begins here ---------------
    public void Todoprogramaction() {

        Scanner inputval = new Scanner(System.in);
        boolean Y = true;
        do {
            printwelcome();
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
                    Y = false;
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
                 int array[] ={1,2,3,4};
                int x = scanner.nextInt();
               if (x > array.length)
                   Todoprogramaction();
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
        System.out.println("(3) Edit (Update,Mark as done ,Remove task name)");
        System.out.println("(4) Save and Quit");
        System.out.println("------------------------------------------");
    }
    //--------------   Show all the inserted task   ------------------------------
    public void showtasklist() {
        boolean x = taskList.printList(null);
        if (x == true) {
            Scanner userchoice = new Scanner(System.in);
            boolean Y = true;
            do {
                System.out.println("----------------------------------------------------");
                System.out.println(" a ) Enter Sort by date wise ");
                System.out.println( "b ) Sort by project task name  wise ");
                System.out.println("c ) exit and Back to the main menu");
               String command = userchoice.next();
                switch (command) {
                    case "a":
                        ArrayList<Taskfeild> sort = taskList.getsortbydate();
                        taskList.printList(sort);
                        //getsortbydate();
                        //Y = false; // one way to exit
                        break;
                    case "b":
                         getSortedByProject();
                        System.out.println("Total no in ToDo List are " + taskList.getSize());
                        //return;  //another way to exit
                        break;
                    case "c":
                        //quittask();
                        //printwelcome();
                        Y = false;
                        break;
                    default:
                        System.out.println("Wrong  Input");
                         //quittask();
                        break;
                }
            } while (Y != false);
            System.out.println("----    **       ---------");
            //printwelcome();
        }
    }

    //_------------------------sorting tasklist----------
    public void getSortedByProject() {
         List<Taskfeild> sortedList = listOfTask.stream()
                .sorted(Comparator.comparing(Taskfeild::getprojectlistname))
                //.forEach(task -> System.out.println(task.gettaskItem()))
                .collect(Collectors.toList());
        for (int i = 0; i < sortedList.size(); i++) {
            System.out.println(sortedList.get(i));
            System.out.println("Sorted project list" );
            //printwelcome();
        }
}
    //----------------------------------------------------------------------
    public void getsortbydate() {

        List<Taskfeild> sortedList = listOfTask.stream()
                .sorted(Comparator.comparing(Taskfeild::getDate))
                //.forEach(task -> System.out.println(task.gettaskItem()))
                .collect(Collectors.toList());
        for (int i = 0; i < sortedList.size(); i++) {
            System.out.println(sortedList.get(i));
            System.out.println("Sorted Datewise");
            //quittask();
            //printwelcome();
        }
    }
//--------------------------------------------------------------------
    public void addlist() {


        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Add project name   : ");
            String inputprojectname = scanner.nextLine().toLowerCase(); // get name from user

            System.out.print(" Enter the status  yes or no  :");
            // Loop until they enter either yes or no.
            String inputstatus =scanner.nextLine();
            boolean a=true;
           do{
                // Use this to check if it is yes or no
                if(inputstatus.equalsIgnoreCase("yes")){
                    // Process yes
                    break;
                }else if(inputstatus.equalsIgnoreCase("no")){
                    // Process no
                    break;
                }
               System.out.println(" Please enter yes or no");

            }while (a!=true);
            System.out.print("Enter task name:");
            String inputtaskname =scanner.next();

            System.out.print ("Enter date of task¨  : dd/mm/yyyy    :");  //  get Date of the task from user
            String inputdate1 = scanner.next();

            Date dateFormat = new SimpleDateFormat("dd-mm-yy").parse(inputdate1);
            Taskfeild task = new Taskfeild(inputprojectname, dateFormat, inputstatus,inputtaskname);
            listOfTask.add(task);
            System.out.println("-------list is addded -------------------");
            printwelcome();
        } catch (ParseException e) {
            System.out.println(" Wrong input date Please add again");
            addlist();
            e.printStackTrace();
            return;
        }
        Todoprogramaction();
        System.out.println("--   ****  list is addded   ***------------------");
        System.out.println("-------------------------------------------------");
        printwelcome();
        Todoprogramaction();
    }
    //--------------------Edit function -------------------------------------------------------
    public void Edit() {
        if (listOfTask.isEmpty()) {
            System.out.println(" ****     WARNING   ::   Task List is Empty  ******** ");
            System.out.println("------------------------------------------------------");
            //printwelcome();
        } else {
            System.out.println("Please select the choice");
            System.out.println("  1) Update / Edit  ");
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
                        updateproject();
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
        if (listOfTask.isEmpty()) {
            System.out.println("List Task is Empty,ADD project name ,Task  name, duedate, staus First");
            addlist();
        } else {

            System.out.println("Total no in ToDo List are :" + listOfTask.size() +"\n");
               for (int i = 0; i < listOfTask.size(); i++) {
                System.out.println("Ths task number " + i + ": ");
                System.out.println(listOfTask.get(i)+"\n");
                System.out.println(" Task list  names" + listOfTask.get(i).getprojectlistname());
                System.out.println(".......................................................");
            }

            System.out.println(" please select Task no");
            Scanner scanner = new Scanner(System.in);
            int deletetask = scanner.nextInt();
            for (int inde = 0; inde < listOfTask.size(); inde++)  // compare taskname with input from user
            {
                Taskfeild removetask = listOfTask.remove(deletetask);
                System.out.println(removetask + " details removed from the tasklist ");
                System.out.println("--------------------------------------------------");
              boolean y=true;
            }

        }
     printwelcome();
    }
    //-------------------Mark as done -----------------------------------------
    public void markasdone(){

    }
//----------------------- Update project --------------------------------------
    public void updateproject()
    {
      /*if (listOfTask.isEmpty()) {
            System.out.println("Insert the Task Project to update");
            if (listOfTask.size() == 0)
                System.out.println("No such Task project is added");
                addlist();
        } else {*/
        boolean x = taskList.printList(listOfTask);
        if (x == true){
             for (int i = 0; i < listOfTask.size(); i++) {
                 System.out.println(i +" please select task no for edit");
                 System.out.println(listOfTask.get(i)+"\n");
                 }
               Scanner scanner = new Scanner(System.in);
               String projectno = scanner.nextLine();
               int projno = Integer.parseInt(projectno);

            if(listOfTask.size()< projno) {
              System.out.println("index doesnot exits");
                }
               Taskfeild tsk = listOfTask.get(projno);
               System.out.println("  1-projectname ,  2 -duedate,, 3-taskname;");
               String whattoupdate  = scanner.nextLine();

            int chooseupdate = Integer.parseInt(whattoupdate);
                switch (chooseupdate)
                {
                    case 1:
                        System.out.println(" Please  new  projet name ");
                        String newprojectname = scanner.nextLine();
                        tsk.setprojectlistname(newprojectname);
                        System.out.println(" edited text"+tsk.toString());

                        break;
                    case 2 :
                        System.out.println(" Please  new  date ");
                        String newpdate =  scanner.nextLine();
                        try {
                            Date dateFor = new SimpleDateFormat("dd/mm/yyyy").parse(newpdate);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        tsk.setprojectlistname(newpdate);
                        break;
                    case 3:
                       System.out.println(" Please  new  satus ");
                       String newtaskname = scanner.nextLine();
                       tsk.setprojectlistname(newtaskname);
                       break;
                    default:
                        System.out.println("wrong input");
                        break;
                }


          }
    }

//----------------------for exiting the application-------------------------------
        public void quittask () {
            System.out.println(" Task list is exiting");
            System.out.println(" Program is exiting  byeeeee");
            System.exit(0);
            setExit = true;
        }
}

  //-----------   End of the todo application code   ------------------















