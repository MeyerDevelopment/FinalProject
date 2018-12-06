import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

/**
 * @author David Meyer
 *Class that provides the frontend for the program
 */
@SuppressWarnings("serial")
public class Frontend extends JFrame implements ItemListener{
	static JFrame f; 
    static JLabel l, l1; 
    static JComboBox<String> c1; 
    static JButton b1;
    static JButton b2;
    static JButton b3;
    static JButton b4;
    static JTextField tf1;
    /**
     * class that contains all the building blocks for the swing frontend,
     * contains all the action listeners and the event listeners
     * @param args
     */
    public static void main(String[] args) 
    {  
        f = new JFrame("Conversion Application");  
        Frontend s = new Frontend(); 
        f.setLayout(new GridBagLayout());
        String s1[] = {"Football Co.", "Maple Co."}; 
        c1 = new JComboBox<String>(s1); 
        b1 = new JButton("Get File");
        b2 = new JButton("Get Delimiter #s and move to queue");
        b2.setEnabled(false);
        b3 = new JButton("Choose Location for file");
        b3.setEnabled(false);
        tf1= new JTextField();
        tf1.setEditable(false);
        b4 = new JButton("Print File");
        b4.setEnabled(false);
        c1.addItemListener(s);
        b1.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
        	  if (c1.getSelectedItem() == "Football Co.") {
          		reader.setUrl("https://raw.githubusercontent.com/MeyerDevelopment/FinalProject/master/FootballCo15_GL2008.csv");
          		try {
					reader.main(args);
				} catch (IOException e1) {
					e1.addSuppressed(e1);
				}
        	  }else {
          		reader.setUrl("https://raw.githubusercontent.com/MeyerDevelopment/FinalProject/master/MapleCo01GL_2008.csv");
          		try {
					reader.main(args);
					b1.setEnabled(false);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
        	  }
          }
        });
        b2.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
        	ListToQueue.insertToPQ();  
          }
        });
        b3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
	        	JFileChooser fileChooser = new JFileChooser();
	        	fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	        	fileChooser.setAcceptAllFileFilterUsed(false);
	        	 
	            int rVal = fileChooser.showOpenDialog(null);
	            if (rVal == JFileChooser.APPROVE_OPTION) {
	              tf1.setText(fileChooser.getSelectedFile().toString());
            	  ListToQueue.filePath = tf1.getText();
            	  Frontend.b3.setEnabled(false);
            	  Frontend.b4.setEnabled(true);
	            }
            }
        });
        b4.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
        	try {
				ListToQueue.writeToFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}  
          }
        });
        l = new JLabel("Select File to convert:"); 
        l1 = new JLabel("Football Co. selected"); 
        l.setForeground(Color.red); 
        l1.setForeground(Color.blue);  
        JPanel p = new JPanel(); 
        p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
        p.add(l); 
        p.add(c1); 
        p.add(l1); 
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(tf1);
        p.add(b4);
        f.add(p); 
        f.setSize(700, 600);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    } 
    public void itemStateChanged(ItemEvent e) 
    { 
        if (e.getSource() == c1) { 
              l1.setText(c1.getSelectedItem() + " selected");
        } 
    } 
}
