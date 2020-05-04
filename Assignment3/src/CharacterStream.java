
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStream { 

	public static void main(String[] args) throws IOException{
       FileReader sourceFile = null;
       FileWriter destFile = null;
       String SAddress="C:\\Users\\Admin\\Desktop\\Thor.txt";  // Source File Address
       String DAddress="CharacStreamFile.txt";   // Destination File Address
       try {
    	   sourceFile = new FileReader(SAddress);
    /*
    The ouput file will have same contents as input file if both of them
    are in same encoding format, our source file is in ANSI format which matches
    the output file format i.e. ANSI 
     */
    	destFile = new FileWriter(DAddress);
   		int temp; 
           while ((temp = sourceFile.read()) != -1) 
               destFile.write((char)temp);      
          System.out.println("File Has been read and written Successfully!");
       } 
   	catch(FileNotFoundException ex)   // if file doesn't exist, then Display error
   	{
   		System.out.println("Cannot Read the File,or the address doesn't exist, Check the file address again");
   	}
       finally 
       { 
           if (sourceFile != null) 
               sourceFile.close();             
           if (destFile != null)             
               destFile.close();             
       } 
       }
       
	}

