package project;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import javax.swing.JButton;
    import javax.swing.JFrame;
    import javax.swing.JLabel;
    import javax.swing.JTextField;
    import java.awt.*;
    //
    import java.io.BufferedReader;
    import java.io.BufferedWriter;
    import java.io.FileWriter;
    import java.io.InputStreamReader;
    import java.net.URL;
//
    import java.io.*; 
import javax.swing.*; 
import java.awt.event.*; 
import javax.swing.filechooser.*; 
    //import org.apache.commons.codec.binary.Hex;
    import java.awt.BorderLayout;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.awt.event.WindowAdapter;
    import java.awt.event.WindowEvent;

    public class simpl2 {
        simpl2(){} 
             
	    public static void main(String[] args) throws Exception {
	    	simpl2 simp = new simpl2(); 
	        JFrame f=new JFrame("Content Repurposing system"); 
	        f.setSize(1500,1500);
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
	
	
	
	
		    b.addActionListener(new ActionListener() {
		        
		        @Override
		        public void actionPerformed(ActionEvent arg0) {
		                //label1.setText("Name has been submitted.");    
		                // create an object of JFileChooser class 
		           try{
			        	URL url = new URL(textfield.getText());
			            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			            BufferedWriter writer = new BufferedWriter(new FileWriter("data4.html"));
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
	
	
	
	
	
	                //add to frame
		    f.add(label1);
		    f.add(textfield);
		    f.add(label);
		    f.add(b);  
		    f.add(b1);  
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
		        System.out.println(j.getSelectedFile().getAbsolutePath()); 
		
		    } 
		    // if the user cancelled the operation 
		    
		            //
		                    
		        }  
		                
		      });
	    }      
}    
     