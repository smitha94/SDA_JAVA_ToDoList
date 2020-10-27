package model;

import filepackage.FileHandler;
import model.Taskfeild;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
public class TaskList implements Serializable
{
    private ArrayList<Taskfeild> taskList;
    private FileHandler fh = new FileHandler();
    public TaskList()
    {
        taskList = fh.readAsObject();

    }
    /**
     * --------------------sorting tasklist----------
     */

    public void getSortedByProject() {
        taskList = (ArrayList<Taskfeild>) taskList.stream()
                .sorted(Comparator.comparing(Taskfeild::getprojectlistname))
                //.forEach(task -> System.out.println(task.gettaskItem()))
                .collect(Collectors.toList());
    }

    public void getsortbydate() {

        taskList = (ArrayList<Taskfeild>) taskList.stream()
                .sorted(Comparator.comparing(Taskfeild::getDate))
                //.forEach(task -> System.out.println(task.gettaskItem()))git
                .collect(Collectors.toList());

    }
    /**
     *
     * @return ture if the list has record and display the all the record by index no
     *     else     false otherwise
     */
    public boolean printList ()
    {
        if (taskList.isEmpty()) {
            System.out.println(" ****     WARNING   ::   Task List is Empty  ******** ");
            System.out.println("------------------------------------------------------");
            return false;
        }
        else
        {
            for (int i =0; i < taskList.size(); i++) {
                System.out.print("No" + i + ": ");
                System.out.println(taskList.get(i)+"\n");
            }
            return true;
        }
    }
    public int getSize() { //TODO
        return taskList.size();
    }
    public ArrayList<Taskfeild> getList() {return taskList;}

    /**
     * This is used for editing the new updated task from the list from the user
     * @param project
     * @param date
     * @param name
     * @param status
     */

    public void addTask(String project, LocalDate date, String name,String status)
    {
        Taskfeild task = new Taskfeild(project, date,name,status);
        taskList.add(task);
        //this.printList();
    }
    /**
     *
     * @param index
     */
    public void removeTask(int index)
    {
        Taskfeild t = taskList.remove(index); //todo
        System.out.println(t + " details removed from the tasklist ");
        System.out.println("--------------------------------------------------");

    }
    public void save()
    {
        fh.writeAsObject(taskList);
    }
}
