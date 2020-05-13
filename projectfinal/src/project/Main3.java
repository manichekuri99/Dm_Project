package project;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import net.atlanticbb.tantlinger.shef.Demo;
import net.atlanticbb.tantlinger.shef.HTMLEditorPane;

public class Main3 {

	static String filepath;
	private static void setpath(String s) {filepath=s;}
	public static void main(String[] args) throws FileNotFoundException {
		List<ChunkType> chunks = new ArrayList<ChunkType>();
		JFrame jFrame=new JFrame("Content Repurposing system"); 
//		jFrame.setLayout(new GridLayout(1, 2));
		JPanel mainPanel = new JPanel(); // main panel
        mainPanel.setLayout(new GridLayout(1, 2));
		JPanel leftPanel = new JPanel(); // main panel
		leftPanel.setLayout(new GridLayout(3, 1));
        JPanel subPanel1 = new JPanel();
        subPanel1.setLayout(new FlowLayout());
	    JButton b=new JButton("Download");   
	    JLabel label = new JLabel();        
	    label.setText("Enter Website URL :");
	    JTextField textfield= new JTextField(20);
	    subPanel1.add(label);
	    subPanel1.add(textfield);
	    subPanel1.add(b);
	                //empty label which will show event after button clicked
	                //textfield to enter name
	    
	    
	    JPanel subPanel2 = new JPanel();
	    subPanel2.setLayout(new FlowLayout());
	    JLabel label1 = new JLabel("Enter Filepath");
	    JTextField browsetext = new JTextField(20);
	    JButton b1=new JButton("Browse");
	    subPanel2.add(label1);
	    subPanel2.add(browsetext);
	    subPanel2.add(b1);
	    
	    JPanel subPanel3 = new JPanel();
	    subPanel3.setLayout(new FlowLayout());
	    JButton b2=new JButton("Chunking");
	    JButton b3=new JButton("Assembling");
	    subPanel3.add(b2);
	    subPanel3.add(b3);
	    
	    leftPanel.add(subPanel1);
	    leftPanel.add(subPanel2);
	    leftPanel.add(subPanel3);
	    mainPanel.add(leftPanel);
	    
	    JPanel rightPanel = new JPanel(); // main panel
		rightPanel.setLayout(new GridLayout(1, 1));
		JEditorPane myPane = new JEditorPane();
	   	myPane.setContentType("text/html"); 
	   	JScrollPane ScrollPane = new JScrollPane(myPane);
	   	ScrollPane.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	   	ScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	   	rightPanel.add(ScrollPane);
	   	mainPanel.add(rightPanel);
	    
	    jFrame.add(mainPanel);
	    
	    
	    b.addActionListener(new ActionListener() {
	        
	        @Override
	        public void actionPerformed(ActionEvent arg0) {
	                //label1.setText("Name has been submitted.");    
	                // create an object of JFileChooser class 
	           try{
//	        	   System.out.println("came");
	        	   	browsetext.setText("");
//	        	   	setpath("/home/bala/Desktop/MYCLG/8_th/Data   Modeling/Project/projectfinal/build/classes/net/atlanticbb/tantlinger/shef/data.html");
	        	   	setpath("./build/classes/net/atlanticbb/tantlinger/shef/Download.html");
		        	URL url = new URL(textfield.getText());
		            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		            BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
		            StringBuilder sb1 = new 
		                    StringBuilder("");
		            String line;
//		            System.out.println("came");
		            while ((line = reader.readLine()) != null) {
			            writer.write(line);
			            sb1.append(line);
			            writer.newLine();
		            }
		            reader.close();
		            writer.close();
		            String dis = sb1 + " ";
		            myPane.setText(dis);
	            } 
	            catch(Exception e) {};
	        
	        }  
	                
	      });
	    
	    

	       
	    
	                        //action listener
	    b1.addActionListener(new ActionListener() {
	        
	        @Override
	        public void actionPerformed(ActionEvent arg0) {
	        	textfield.setText("");
	                //label1.setText("Name has been submitted.");    
	                // create an object of JFileChooser class 
	            JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
	  
	            // invoke the showsOpenDialog function to show the save dialog 
	            j.addChoosableFileFilter(new FileNameExtensionFilter("HTML files", "html"));
	            j.setAcceptAllFileFilterUsed(true);
	            
	            int r = j.showOpenDialog(null); 
	  
	            // if the user selects a file 
	            if (r == JFileChooser.APPROVE_OPTION) 
	  
	            { 
	                // set the label to the path of the selected file 
	            	browsetext.setText(j.getSelectedFile().getAbsolutePath());
	            	setpath(browsetext.getText());
	
	            }
	            try {
	            	String path = "file://"+browsetext.getText();
		            URL url = new URL(path);
		            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
//		            BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
//		            System.out.println("writen to file");
		            StringBuilder sb1 = new 
		                    StringBuilder("");
		            String line;
		            while ((line = reader.readLine()) != null) {
//			            writer.write(line);
			            sb1.append(line);
//			            writer.newLine();
		            }
		            reader.close();
//		            writer.close();
//		            System.out.println("writen to file");
		            String dis = sb1 + " ";
		            myPane.setText(dis);
	            }
	            catch(Exception e) {};
	            
	         }  
	                
	      });
	    b2.addActionListener(new ActionListener() {
	        
	        @Override
	        public void actionPerformed(ActionEvent arg0) {
//	        	System.out.println(filepath);
	        	textfield.setText("");
	        	browsetext.setText("");
		    		try {
		            UIManager.setLookAndFeel(
		                UIManager.getSystemLookAndFeelClassName());
		        } catch(Exception ex){}
		        SwingUtilities.invokeLater(new Runnable() {
		        	Demo d1 = null;
//		        	HTMLEditorPane editor;
		            public void run() {
		               Demo d1 = new Demo(filepath);
//		               editor = d1.geteditor();
//		               jFrame.getContentPane().add(editor);
//		               System.out.println("add editor");
		            }
		        });
				new ChunkUI(chunks);
	        }  
	                
	      });
	    
	    b3.addActionListener(new ActionListener() {
	        
	        @Override
	        public void actionPerformed(ActionEvent arg0) {
	        	jFrame.dispose();
	        	new SearchtoQuery();
	        }  
	                
	      });
	    
	    jFrame.pack();    
	    jFrame.setVisible(true);
	    jFrame.setSize(1200,600);
	    jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
