import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class reader {
	public static void main(String[] args) throws FileNotFoundException
    {
        int linesRead = 0; 
		//Get scanner instance
        Scanner scanner = new Scanner(new File("E:/Import/MapleCo01GL_2008.csv"));
         
        //Set the delimiter used in file
        scanner.useDelimiter(",");
        
        LinkedList ll = new LinkedList();
         
        //Get all tokens and store them in some data structure
        //I am just printing them
        while (scanner.hasNext())
        {
            String line = scanner.nextLine();
            ll.add(line);
        	//System.out.print(line + "|");
            linesRead ++;
        }
        //ll.print();
        System.out.print("lines read in = " + linesRead+ " lines in linked list = " + ll.getSize());
        //Do not forget to close the scanner 
        scanner.close();
    }
}
