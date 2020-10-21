
import java.io.*;
import java.util.ArrayList;

public class FileHandler
{
    private String path = "/Users/smithairvathraya/Desktop/ToDoListSDAproject/src/main/resources/"; // This is my path to my file

    ///Users/smithairvathraya/Desktop/ToDoListSDAproject/src/main/resources/taskFiles.txt

    public File createFile() throws IOException {
        File file = new File("taskFiles.txt");
        file.createNewFile();
        return file;
    }

    //Object Stream
    public void writeAsObject(ArrayList<Taskfeild> list)
    {
        try {
            FileOutputStream file = new FileOutputStream(new File(path + "taskFiles.txt"));
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
            //File fil = createFile();
            FileInputStream file = new FileInputStream(new File(path + "taskFiles.txt"));
            ObjectInputStream stream = new ObjectInputStream(file);

            // read thing from the stream
            list = (ArrayList<Taskfeild>) stream.readObject();
            stream.close();
            file.close();
        }
        catch (EOFException e)
        {
            System.out.println("The file is empty");
        }
        catch(IOException  e)
        {
            System.out.println("File doesn't found " +  e);
            System.out.println(e.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("problems inside the file " + e);
        }

        return list;
    }
}
