import model.Taskfeild;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TodoprogramTest {
    ArrayList<Taskfeild> taskList = new ArrayList<>();
    @Test
    void todoprogramaction() {
    }
    @Test
    void showtasklist() {
    }

    @Test
    void addlist() {
        Taskfeild task = new Taskfeild("projectnameadd", LocalDate.now(), "true", "JavaScript");
        assertEquals("projectnameadd",task.getprojectlistname());
        assertEquals("true",task.getStatus());
        assertEquals(LocalDate.now(),task.getDate());
        taskList.add(task);
    }
    @Test
    void deletelist() {
        Taskfeild task = new Taskfeild("projectdelete", LocalDate.now(), "true", "JavaScript");
        assertEquals("projectdelete",task.getprojectlistname());
        assertEquals("true",task.getStatus());
        assertEquals("JavaScript",task.gettaskname());
        assertEquals(0, taskList.size());
        taskList.add(task);
        assertEquals(1, taskList.size());
        taskList.remove(0);
        assertEquals(0, taskList.size());

    }
}