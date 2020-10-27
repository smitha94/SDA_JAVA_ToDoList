package Formainpackage;//import com.company.CommandWords;

import model.*;
// or  import  model.TaskList;
import java.io.Serializable;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.*;

/**
 * This this the main class all the user input functions are mentioned in this class
 * User functions like Add, delete, Update, sorting .
 */
public class Todoprogram implements Serializable
{
    TaskList taskList = new TaskList();
    Scanner scanner = new Scanner(System.in);

    /**
     * This method comes after main menu . User has to select his choise of action
     * @throws ParseException
     */
    // ------------    Functions of List begins here ---------------
    public void Todoprogramaction() throws ParseException {
        boolean Y = true;
        do {
            printwelcome();
            int command= Integer.parseInt(scanner.nextLine());

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
                    savequittask();
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

    /**
     *  ----------User functions display the Formainpackage.Main menu in the application---------
     */

    public void printwelcome() {
        System.out.println("Welcome to ToDo List");
        System.out.println("(1) Show Task List");
        System.out.println("(2) Add");
        System.out.println("(3) Edit (Update,Remove task name)");
        System.out.println("(4) Save and Quit");
        System.out.println("------------------------------------------");
    }

    /**
     *----   Show all the inserted task  from the user  ---
     * user can view inserted entries by sorting details of date wise and project name wise
     *
     * @throws ParseException
     */

    public void showtasklist() throws ParseException {
        boolean s = taskList.printList();
        if (s == true) {
            Scanner userchoice = new Scanner(System.in);
            boolean Y = true;
            do {
                System.out.println("------Choose the option ( a, b, c )--------");
                System.out.println(" a ) Enter Sort by date wise ");
                System.out.println("b ) Sort by  task name  wise ");
                System.out.println("c ) Exit and Back to the main menu");

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
                    case "c":
                           Todoprogramaction();
                         break;
                    default:
                        System.out.println("Wrong  Input");
                        break;
                }
            } while (Y != false);
            System.out.println("----    **       ---------");
        }
    }

    /**
     *  ----------------   Adding the user input  details--------------------
     *  This method is used create or add an task to the project. ---
     *      * 	 * This method accepts task name,project name ,duedate,status from the user
     * @throws ParseException
     */

    public void addlist() throws ParseException {

                System.out.print("Add project name   : ");
                String inputprojectname = scanner.nextLine().toLowerCase(); // get name from user

                System.out.print(" Enter the status  yes or no  :");
                // Loop until they enter either yes or no.
                String inputstatus = scanner.nextLine();
//                boolean aa = true;
//                do {
//                    // Use this to check if it is yes or no
//                    if (inputstatus.equalsIgnoreCase("yes")) {
//                        // Process yes
//                        break;
//                    } else if (inputstatus.equalsIgnoreCase("no")) {
//                        // Process no
//                        break;
//                    }
//                    System.out.println(" Please enter yes or no");
//                } while (aa != true);

                System.out.print("Enter task name:");
                String inputtaskname = scanner.nextLine();

                System.out.print("Enter date of task¨  : dd-MM-yyyy  :");  //  get Date of the task from user
                String inputdate1 = scanner.nextLine();

                DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate date = LocalDate.parse(inputdate1, dateFormat);
                System.out.println(LocalDate.now());

                taskList.addTask(inputprojectname, date, inputtaskname, inputstatus);
                System.out.println("-------  **  List is addded **---------------------------");
    }


    /**
     * ---------Edit function  for already inserted task list--------------------
     * user can update the details,delete the list
     *
     * @throws ParseException
     */
    public void Edit() throws ParseException {
        boolean ed= taskList.printList();
        if (ed== true) {

                do {
                    System.out.println("Please select the choice");
                    System.out.println("  1) Update / Edit  ");
                    System.out.println("  2) Remove");
                    System.out.println("  3) Exit to Formainpackage.Main MENU");
                    System.out.println(" .....................");
                   String dd = scanner.nextLine();
                    int op = Integer.parseInt(dd);

                    switch (op) {
                        case 1:

                            updateproject();
                            break;
                        case 2:
                            deletelist();
                            break;
                        case 3:
                             Todoprogramaction();
                             break;
                        default:
                            System.out.println("Wrong  Input (Please select 1,2,3) ");
                            break;
                    }
                } while (ed != false);
            }
        }

    /**
     * ----------Deleteing from the list------
     */

    public void deletelist() {
        if (taskList.printList())
        {
           // taskList.printList();
            System.out.println(" please select Task no");
            int deletetask = Integer.parseInt(scanner.nextLine());
            //scanner.nextLine(); //tODO
            taskList.removeTask(deletetask);
        }
    }

    /**
     * ---- Update project -------------
     */

    public void updateproject() {
        if (taskList.printList()) {
            System.out.println("Select the index of the task you want to edit: ");
            String input = scanner.nextLine();

            int projno = Integer.parseInt(input);
            if (taskList.getSize() < projno) {
                System.out.println("index doesnot exits: " + projno);
            } else {
                System.out.println("project no");// printing the all  list of task
                Taskfeild tsk = taskList.getList().get(projno);

                System.out.println("  1-projectname ,  2 -duedate,, 3-taskname 4- status (mark as done)");
                String whattoupdate = scanner.nextLine();

                System.out.println("what to update: " + whattoupdate);

                int chooseupdate = Integer.parseInt(whattoupdate);
                switch (chooseupdate) {
                    case 1:
                        System.out.println(" Please  new  project name ");
                        String newprojectname = scanner.nextLine();
                        tsk.setprojectlistname(newprojectname);
                        System.out.println(" Edited text : " + tsk.toString());
                        break;
                    case 2:
                        System.out.println(" Please  new  date ");
                        String newpdate = scanner.nextLine();
                        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        LocalDate date = LocalDate.parse(newpdate, dateFormat);
                        tsk.setDate(date);
                        System.out.println(" Edited text  :  " + tsk.toString());
                        break;
                    case 3:

                        System.out.println(" Please  new Task name ");
                        String newtask = scanner.nextLine();
                        tsk.settaskname(newtask);
                        System.out.println(" Edited  text :  " + tsk.toString());
                        break;
                    case 4:
                        System.out.println(" Status,   yes / no;");
                        String newstatus = scanner.nextLine();
                        tsk.setStatus(newstatus);
                        System.out.println(" edited new status   " + tsk.toString());
                        break;

                    default:
                        System.out.println("Wrong input");
                        break;
                }
            }
        }
    }

    /**
     * ----for exiting the application----------
     */

    public void savequittask() {
        taskList.save();
        System.out.println(" Task list is exiting");
        System.out.println(" Program is exiting  byeeeee");
        System.exit(0);
    }
}
//-----------   End of the todo application code   ------------------















