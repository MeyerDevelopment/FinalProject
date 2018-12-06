import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * @author David Meyer
 * class that reads the data from a text file and puts it into a linked list
 */
public class reader {
	static int linesReadIn = 0;
	static String url;
	static LinkedList ll = new LinkedList();
	public static String getUrl() {
		return url;
	}
	/**
	 * sets the value for Url, this is done in the frontend class
	 * @param url
	 */
	public static void setUrl(String url) {
		reader.url = url;
	}
	/**
	 * this area reads in the text file and puts it into the linked list.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
    {
		int linesRead = 0; 
        URL stockURL = new URL(url);
        Scanner scanner = new Scanner(new InputStreamReader(stockURL.openStream()));
        scanner.useDelimiter(",");
        while (scanner.hasNext())
        {
        	String line = scanner.nextLine();
            ll.add(line);
            linesRead ++;
        }
        linesReadIn = linesRead;
        JOptionPane.showMessageDialog(null, "Lines read from file = " + linesRead+ " \nLines inserted in linked list = " + ll.getSize());
        scanner.close();
        Frontend.b1.setEnabled(false);
        Frontend.b2.setEnabled(true);
      }	
}
