
import java.io.*;
import java.text.Format;
import java.text.ParseException;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileHandler
{
    ////TODO change the path
    // USE THE SAME FILE FOR EVERYTHING
    private String path = "/Users/smithaIrvathraya/Desktop/ToDoListSDAproject/src/java"; // This is my path to my file
    // Use this path and concatenation with file name to get full path to file.

    //Data Stream :
    public void writeAsData(ArrayList<Taskfeild> list)
    {

        try {
            FileWriter fileWriter = new FileWriter(new File(path + "/smithaTodo.text"));
            BufferedWriter br = new BufferedWriter(fileWriter);
            for (Taskfeild task : list)
            {
                br.write(task.toString() + "\n");
            }
            br.close();
        }
        catch (IOException e)
        {
            System.out.println("File doesn't found " +  e);
        }
    }

    public ArrayList<Taskfeild> readAsData()
    {
        ArrayList<Taskfeild> list = new ArrayList<>();
        try
        {
            FileReader fileReader = new FileReader(new File("/Users/smithaIrvathraya/Desktop/ToDoListSDAproject/src/java/smithaTodo.text.text"));
            BufferedReader br = new BufferedReader(fileReader);
            String line = "";
            String[] data ;
            while ( (line = br.readLine()) != null )
            {
                data = line.split("\\*\\*");
                System.out.println(data[1]);
                String stringDate = data[1]; // What does it look like? 2020-01-02 | 10-10-2020 | Thu:05 02 2020
                // 1) Find out the format of the read string.
                // 2) Create a Date object with the correct format
                // 3) Pass the date object into the constructor

                 //Date date = new Date();
                Date date = new SimpleDateFormat("dd-mm-yy").parse(stringDate);

                Taskfeild a = new Taskfeild(data[0], date, data[1], data[2]); // This is the constructor
                // list.add(a);

            }
            br.close();
        }
        catch (IOException | ParseException e)
        {
            System.out.println("File doesn't found " +  e);
        }
        return list;
    }
    //----------------------------------------------------------------
    //Object Stream
    public void writeAsObject(ArrayList<Taskfeild> list)
    {
        try {
            FileOutputStream file = new FileOutputStream(path + "/smithaTodo.text");
            ObjectOutputStream output = new ObjectOutputStream(file);
            // writes objects to output stream
            output.writeObject(list);
            output.close();
            file.close();
        }
        catch(IOException e)
        {
            System.out.println("File doesn't found " +  e);
        }
    }
    public ArrayList<Taskfeild> readAsObject()
    {
        ArrayList<Taskfeild> list = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(path + "objectsmitha.txt");
            ObjectInputStream stream = new ObjectInputStream(file);

            // read thing from the stream
            list = (ArrayList<Taskfeild>) stream.readObject();
            stream.close();
            file.close();
        }
        catch(IOException  e)
        {
            System.out.println("File doesn't found " +  e);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("problems inside the file " + e);
        }

        return list;
    }
}
