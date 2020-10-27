import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TaskfeildTest {
    Taskfeild task = new Taskfeild("Programming In Depth", new Date(), "true", "JavaScript");
    @Test
    void setprojectlistname() {
        task.setprojectlistname("Software Engineering");
        assertEquals("Software Engineering", task.getprojectlistname());
        assertEquals(true, true);
    }

    @Test
    void getprojectlistname() {
        assertEquals("Programming In Depth", task.getprojectlistname());
    }

    @Test
    void additionTest() {
        assertEquals(2, 1 + 1); // Expected: 2 Actual: 2 Beacuse 1 + 1 = 2
    }

    @Test
    void setDate() {
    }

    @Test
    void getDate() {
    }

    @Test
    void setStatus() {
    }

    @Test
    void getStatus() {
    }

    @Test
    void setUsername() {
    }

    @Test
    void getusername() {
    }

    @Test
    void gettaskItem() {
    }
}