package Formainpackage;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * /* ToDoListMain
 *  * --- ToDoListMain class contains the main() method of the ToDoList application.
 *  * --- MVC(model-view-controller) pattern is used to implement ToDOList application
 *  * 		# Task and Project classes the model classes
 *  * 		# User class is the view class
 *  * 		# ToDoList class is the controller class
 *  * --- main() method invokes the Todoprogramaction(); method of User class to start the application, and invokes saveAndQuit() method during end
 *  * 	   of the application
 *  */

public class Main implements Serializable
{
    public static void main(String[] args) throws ParseException {
        Todoprogram todo = new Todoprogram();

            todo.Todoprogramaction();

    }
}