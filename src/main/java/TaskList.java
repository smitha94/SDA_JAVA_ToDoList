import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TaskList
{
    private ArrayList<Taskfeild> taskList;
    private FileHandler fh = new FileHandler();

    public TaskList()
    {
        taskList = fh.readAsObject();

    }

    //_------------------------sorting tasklist----------
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
     * @return ture if ...
     *          false otherwise
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
            for (int i = 0; i < taskList.size(); i++) {
                System.out.print("" + i + ": ");
                System.out.println(taskList.get(i)+"\n");
            }

            System.out.println(".......................................................");
            return true;
        }
    }

    public int getSize() { //TODO
        return taskList.size();
    }

    public ArrayList<Taskfeild> getList() {return taskList;}

    public void addTask(String project, LocalDate date, String status, String name) {
        Taskfeild task = new Taskfeild(project, date, status, name);
        taskList.add(task);
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
