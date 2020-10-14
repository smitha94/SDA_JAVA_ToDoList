import com.sun.nio.sctp.PeerAddressChangeNotification;

import java.util.*;
public enum  Commandss {
    /*The  List of  command actions */
    Add(1),Delete(2),Edit(3),Quit(4),
   Display(5),Search_by_Name(6),Search_by_date(7),
    Invalid(8),yesno(1),noyes(0),
    YES("YES" ),yes("yes"),NO("NO") ,no("no");


//----------------------------------
    private String commandstring;
    Commandss( String commandstring)
    {
        this.commandstring=commandstring;
    }
    public String getCommandstring()
    {
        return commandstring;
    }
//----------------------------------------
    private int commandnumber;
    Commandss( int commandnumber)
    {
        this.commandnumber=commandnumber;
    }
    public int getCommandnumber() {
        return commandnumber;
    }
}
//----------------------------------------------
/*class Test{

    // Method to convert characters
    // of a string to opposite case
    static void convertOpposite(StringBuffer str)
    {
        int ln = str.length();

        // Conversion using predefined methods
        for (int i=0; i<ln; i++)
        {
            Character c = str.charAt(i);
            if (Character.isLowerCase(c))
                str.replace(i, i+1, Character.toUpperCase(c)+"");
            else
                str.replace(i, i+1, Character.toLowerCase(c)+"");

        }
        public static void main(String[] args)
     {
         StringBuffer str = new StringBuffer("GeEkSfOrGeEkS");
         // Calling the Method
         convertOpposite(str);

         System.out.println(str);
        }
    } */
