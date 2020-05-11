package project;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

//import org.apache.commons.codec.binary.Hex;
import java.awt.*;
//
import java.io.*; 
import javax.swing.*; 
import java.awt.event.*; 
import javax.swing.filechooser.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class simple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f=new JFrame("Content Repurposing system"); 
        f.setPreferredSize(new Dimension(1000, 600));
              //submit button
	  JButton b=new JButton("Submit");    
	  b.setBounds(650,120,110, 30);    
	              //enter name label
	  JLabel label = new JLabel();        
	  label.setText("Enter Website URL :");
	  label.setBounds(410, 10, 200, 150);
	              //empty label which will show event after button clicked
	  JLabel label1 = new JLabel();
	  label1.setBounds(10, 110, 200, 100);
	              //textfield to enter name
	  JTextField textfield= new JTextField();
	  textfield.setBounds(555, 70, 240, 30);
	
	  JButton b1=new JButton("Browse");
	  b1.setBounds(800,70,110, 30);
	
	
	
	
	
	
	              //add to frame
	  f.add(label1);
	  f.add(textfield);
	  f.add(label);
	  f.add(b);  
	  f.add(b1);  
//	  f.setSize(300,300);    
	  f.setLayout(null);
	  f.pack();
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
		      textfield.setText(j.getSelectedFile().getAbsolutePath()); 
		
		  } 
		  // if the user cancelled the operation 
		  
		          //
		                  
		      }  
	              
	    });
	  }      


}
