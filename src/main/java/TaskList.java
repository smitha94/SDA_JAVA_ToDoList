import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TaskList
{
    private ArrayList<Taskfeild> taskList;
    public TaskList()
    {
        taskList = new FileHandler().readAsObject();
        //taskList = new ArrayList<>(); //TODO make a call to fileHandler to read all the task from a file
    }

    public ArrayList<Taskfeild> getsortbydate() {

        ArrayList<Taskfeild> sortedList = (ArrayList<Taskfeild>) taskList.stream()
                .sorted(Comparator.comparing(Taskfeild::getDate))
                //.forEach(task -> System.out.println(task.gettaskItem()))
                .collect(Collectors.toList());
        return sortedList;
    }

    public boolean printList (List<Taskfeild> list)
    {
        if (list.isEmpty()) {
            System.out.println(" ****     WARNING   ::   Task List is Empty  ******** ");
            System.out.println("------------------------------------------------------");
            return false;
        }
        else
        {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
            return true;
        }
    }

    public int getSize() { //TODO
        return 0;
    }
}
