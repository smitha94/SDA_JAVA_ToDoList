//import com.company.CommandWords;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.*;
import java.util.Date;

public class Todoprogram {
    TaskList taskList = new TaskList();
    Scanner scanner = new Scanner(System.in);

    //------------    Functions of List begins here ---------------
    public void Todoprogramaction() throws ParseException {
        boolean Y = true;
        do {
            printwelcome();
            int command= Integer.parseInt(scanner.nextLine());
           // int command = checkInt(1, 4);
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

    public int checkInt(int min, int max) {
        while (true) {
            try {
                //TODO decide one option
                //String input = scanner.nextLine();
                //int x = Integer.parseInt(input);

                int x = Integer.parseInt(scanner.nextLine());
                min=1; max=4;
                if (x >= min && x <= max)
                    return x;
                else
                    System.out.println("the number is too big or too small");
            } catch (InputMismatchException e) {
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
        boolean s = taskList.printList();
        if (s == true) {
            Scanner userchoice = new Scanner(System.in);
            boolean Y = true;
            do {
                System.out.println("----------------------------------------------------");
                System.out.println(" a ) Enter Sort by date wise ");
                System.out.println("b ) Sort by project task name  wise ");
                System.out.println("c ) exit and Back to the main menu");
                String command = userchoice.next();
                switch (command) {
                    case "a":
                        taskList.getsortbydate();
                        taskList.printList();
                        //getsortbydate();
                        //Y = false; // one way to exit
                        break;
                    case "b":
                        taskList.getSortedByProject();
                        taskList.printList();
                        //return;  //another way to exit
                        break;
                    default:
                        System.out.println("Wrong  Input");
                        break;
                }
            } while (Y != false);
            System.out.println("----    **       ---------");
        }
    }

    //--------------------------------------------------------------------
    public void addlist() throws ParseException {
        if (!taskList.getList().isEmpty()) {
            taskList.printList();
        } else {
            System.out.print("Add project name   : ");
            String inputprojectname = scanner.nextLine().toLowerCase(); // get name from user

            System.out.print(" Enter the status  yes or no  :");
            // Loop until they enter either yes or no.
            String inputstatus = scanner.nextLine();
            boolean aa = true;
            do {
                // Use this to check if it is yes or no
                if (inputstatus.equalsIgnoreCase("yes")) {
                    // Process yes
                    break;
                } else if (inputstatus.equalsIgnoreCase("no")) {
                    // Process no
                    break;
                }
                System.out.println(" Please enter yes or no");

            } while (aa != true);
            System.out.print("Enter task name:");
            String inputtaskname = scanner.nextLine();

            System.out.print("Enter date of task¨  : dd-mm-yyyy    :");  //  get Date of the task from user
            String inputdate1 = scanner.nextLine();
            //Date dateFormat = new SimpleDateFormat("dd-mm-yy").parse(inputdate1); //TODO
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate date = LocalDate.parse(inputdate1, dateFormat);
            System.out.println(LocalDate.now());
            //return inputdate1;
            taskList.addTask(inputprojectname, date, inputtaskname, inputstatus);
            System.out.println("-------List is addded -------------------------------");
            printwelcome();
            Todoprogramaction();
        }
    }
    //--------------------Edit function -------------------------------------------------------

    /**
     * this edit method
     *
     * @throws ParseException
     */
    public void Edit() throws ParseException {
        boolean x = taskList.printList();
        if (x == true) {
            if (taskList.printList()) {

                boolean Y = true;
                do {
                    System.out.println("Please select the choice");
                    System.out.println("  1) Update / Edit  ");
                    System.out.println("  2) Mark as done");
                    System.out.println("  3) Remove");
                    System.out.println("  4) Exit");
                    System.out.println(" Enter correct option");
                    int option = Integer.parseInt(scanner.nextLine());
                    switch (option) {
                        case 1:
                            updateproject();
                            break;
                        case 2:
                            markasdone();
                            break;
                        case 3:
                            deletelist();
                            break;
                        default:
                            System.out.println("Wrong  Input (Please select 1,2,3,4) ");
                            break;
                    }
                } while (Y != false);
            }
        }
    }
    //----------------------Deleteing from the list------------------------------
    public void deletelist() {
        if (taskList.printList()) {
            System.out.println(" please select Task no");
            int deletetask = Integer.parseInt(scanner.nextLine());
            //scanner.nextLine(); //tODO
            taskList.removeTask(deletetask);
        }
    }

    //----------------------- Update project --------------------------------------
    public void updateproject() throws ParseException {
        if (taskList.printList()) {
            int projno = Integer.parseInt(scanner.nextLine()); //checkInt(0, taskList.getSize()-1)
            // int projno = checkInt(0, taskList.getSize() - 1);
            if (taskList.getSize() < projno) { //TODO
                System.out.println("index doesnot exits: " + projno);
            } else {
                Taskfeild tsk = taskList.getList().get(projno);

                System.out.println("  1-projectname ,  2 -duedate,, 3-taskname;");
                String whattoupdate = scanner.nextLine();

                System.out.println("what to update: " + whattoupdate);

                int chooseupdate = Integer.parseInt(whattoupdate);
                switch (chooseupdate) {
                    case 1:
                        System.out.println(" Please  new  projet name ");
                        String newprojectname = scanner.nextLine();
                        tsk.setprojectlistname(newprojectname);
                        System.out.println(" edited text" + tsk.toString());

                        break;
                    case 2:
                        System.out.println(" Please  new  date ");
                        String newpdate = scanner.nextLine();
                        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-mm-yyyy");
                        LocalDate date = LocalDate.parse(newpdate, dateFormat);
                        tsk.setprojectlistname(newpdate);
                        System.out.println(" Edited new date" + tsk.toString());
                        break;
                    case 3:
                        System.out.println(" Please  new  task ");
                        String newtaskname = scanner.nextLine();
                        tsk.setprojectlistname(newtaskname);
                        System.out.println(" Edited new task" + tsk.toString());
                        break;
                    default:
                        System.out.println("Wrong input");
                        break;
                }
            }
        }
    }

    //-------------------Mark as done -----------------------------------------
    public void markasdone() {
        if (taskList.printList()) {
            String projectno = scanner.nextLine(); //checkInt(0, taskList.getSize()-1)
            int projno = checkInt(0, taskList.getSize() - 1);
            Taskfeild tsk = taskList.getList().get(projno);
            System.out.println(" Status,   yes / no;");
            String newstatus = scanner.nextLine();
            tsk.setStatus(newstatus);
            System.out.println(" edited text" + tsk.toString());
        }
    }

    //----------------------for exiting the application-------------------------------
    public void quittask() {
        taskList.save();
        System.out.println(" Task list is exiting");
        System.out.println(" Program is exiting  byeeeee");
        System.exit(0);
    }
}

//-----------   End of the todo application code   ------------------















