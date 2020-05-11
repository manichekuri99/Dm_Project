package project;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import net.atlanticbb.tantlinger.shef.Demo;
import net.atlanticbb.tantlinger.shef.HTMLEditorPane;


public class main {
	static String filepath;
	private static void setpath(String s) {filepath=s;}
	public static void main(String[] args) throws FileNotFoundException {
		List<ChunkType> chunks = new ArrayList<ChunkType>();
		JFrame f=new JFrame("Content Repurposing system"); 
        f.setSize(1500,1500);
                //submit button
	    JButton b=new JButton("Download");
	    b.setBounds(800,70,110, 30);    
	                //enter name label
	    JLabel label = new JLabel();        
	    label.setText("Enter Website URL :");
	    label.setBounds(300, 70, 200, 30);
	                //empty label which will show event after button clicked
	                //textfield to enter name
	    JTextField textfield= new JTextField();
	    textfield.setBounds(550, 70, 200, 30);
	    
	    
	    JLabel label1 = new JLabel("Enter Filepath");
	    label1.setBounds(300, 100, 200, 30);
	    JTextField browsetext = new JTextField();
	    browsetext.setBounds(550, 100, 200, 30);
	    JButton b1=new JButton("Browse");
	    b1.setBounds(800,100,110, 30);
	    
	    JButton b2=new JButton("Open");
	    b2.setBounds(550,150,110, 30);
	    
	    b.addActionListener(new ActionListener() {
	        
	        @Override
	        public void actionPerformed(ActionEvent arg0) {
	                //label1.setText("Name has been submitted.");    
	                // create an object of JFileChooser class 
	           try{
	        	   	setpath("/home/bala/Desktop/MYCLG/8_th/Data   Modeling/Project/projectfinal/build/classes/net/atlanticbb/tantlinger/shef/data.html");
		        	URL url = new URL(textfield.getText());
		            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		            BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
		            String line;
		            while ((line = reader.readLine()) != null) {
			            writer.write(line);
			            writer.newLine();
		            }
		            reader.close();
		            writer.close();
	            } 
	            catch(Exception e) {};
	        
	        }  
	                
	      });
	    
	    
	    f.add(label1);
	    f.add(textfield);
	    f.add(label);
	    f.add(b);  
	    f.add(b1);
	    f.add(browsetext);
	    f.add(b2);
	    //f.pack();   
	    f.setLayout(null);    
	    f.setVisible(true);    
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
	    
	                        //action listener
	    b1.addActionListener(new ActionListener() {
	        
	        @Override
	        public void actionPerformed(ActionEvent arg0) {
	                //label1.setText("Name has been submitted.");    
	                // create an object of JFileChooser class 
	            JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
	  
	            // invoke the showsOpenDialog function to show the save dialog 
	            int r = j.showOpenDialog(null); 
	  
	            // if the user selects a file 
	            if (r == JFileChooser.APPROVE_OPTION) 
	  
	            { 
	                // set the label to the path of the selected file 
	            	browsetext.setText(j.getSelectedFile().getAbsolutePath());
	            	setpath(browsetext.getText());
	
	            }
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
		        	HTMLEditorPane editor;
		            public void run() {
		               Demo d1 = new Demo(filepath);
		               editor = d1.geteditor();
		               f.add(editor);
		            }
		        });
				new ChunkUI(chunks);
	        }  
	                
	      });
//		try {
//            UIManager.setLookAndFeel(
//                UIManager.getSystemLookAndFeelClassName());
//        } catch(Exception ex){}
//
//
//        SwingUtilities.invokeLater(new Runnable() {
//
//            public void run() {
//               new Demo("/net/atlanticbb/tantlinger/shef/htmlsnip.txt");
//            }
//        });
//		// TODO Auto-generated method stub
//		new ChunkUI(chunks);
	}

}
