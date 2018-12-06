import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * @author David Meyer
 * class that provides the methods for moving the data from the linked list
 * to the priority queue
 *
 */
public class ListToQueue {
	static PriorityQueueMaker pq = new PriorityQueueMaker(reader.ll.getSize());
	static String filePath;
	public static void insertToPQ() {
		int i=0;
		while(reader.ll.getSize() != 0){
			int d =0;
			i++;
			String s = reader.ll.peek();
			String[] strArr = s.split("\\,",-1);
			d=(strArr.length -1);
			pq.insert(i, d, reader.ll.peek());
			reader.ll.remove(reader.ll.peek());
		}
		JOptionPane.showMessageDialog(null,"Action successful: inserted: " + (i) + " items.");
		Frontend.b3.setEnabled(true);
		Frontend.b2.setEnabled(false);
	}
	/**
	 * takes the data from the priority queue and writes it to a file.
	 * @throws IOException
	 */
	public static void writeToFile() throws IOException {
		FileWriter fileWriter = new FileWriter(filePath);
		fileWriter.write("\"Co\",\"BusUnit\",\"Journal\",\"JournalDate\",\"UnitIU\",\"Unpost\",\"Year\",\"Period\",\"LedgerGrp\",\"Reversal\",\"ReversalDate\",\"Source\",\"SJEType\",\"PostedDate\",\"Description\",\"LongDescription\",\"DetailUnit\",\"GLJournal\",\"LineNum\",\"Acct\",\"DeptID\",\"Prod\",\"Proj\",\"Affl\",\"Amount\",\"Currency\",\"Ref\",\"LineDescription\",\"DocumentType\",\"EntryNumber\",\"Delimiters\""+ System.getProperty("line.separator"));
		while(!pq.isEmpty())
			fileWriter.write(pq.remove().toString() + System.getProperty("line.separator"));
	    fileWriter.close();
	    JOptionPane.showMessageDialog(null, "File ready!");
	    Frontend.b1.setEnabled(true);
	    Frontend.b4.setEnabled(false);
	}
}
