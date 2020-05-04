import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class ByteStream {

	public static void main(String[] args) throws IOException{
	FileInputStream source = null;
	FileOutputStream destination = null;
	String Saddress = "C:\\Users\\Admin\\Desktop\\batman.txt"; // Source File Address
	String Daddress = "ByteWrittenFile.txt"; // Destination File Address
	try 
	{
		source = new FileInputStream(Saddress);
		destination = new FileOutputStream(Daddress);
		int temp; 
        while ((temp = source.read()) != -1) 
            destination.write((byte)temp);      
       System.out.println("File Has been read and written Successfully!");
    } 
	catch(FileNotFoundException ex)   // if file doesn't exist, then Display error
	{
		System.out.println("Cannot Read the File,or the address doesn't exist, Check the file address again");
	}
    finally 
    { 
        if (source != null) 
            source.close();             
        if (destination != null)             
            destination.close();             
    } 
} 
}
