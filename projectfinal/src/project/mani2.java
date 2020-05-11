package project;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileSystemView;

import net.atlanticbb.tantlinger.shef.Demo;
import net.atlanticbb.tantlinger.shef.HTMLEditorPane;

public class mani2 {
	static String filepath;
	private static void setpath(String s) {filepath=s;}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<ChunkType> chunks = new ArrayList<ChunkType>();
		JFrame jframe = new JFrame();
        jframe.setTitle("Title");
        jframe.setResizable(false);

        //This creates one row and two equally divided columns
        GridLayout gridLayout = new GridLayout(1,2);
        jframe.setLayout(gridLayout);
        gridLayout.layoutContainer(jframe);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(3, 1));
//        leftPanel.setPreferredSize(new Dimension(500, 500));
//        leftPanel.setLayout(new GridLayout(3, 3));
        JPanel subPanel1 = new JPanel();
	   	subPanel1.setLayout(new FlowLayout());
        JLabel label = new JLabel("Enter Website URL :");
        JButton b=new JButton("Download");
        JTextField textfield= new JTextField(20);
        subPanel1.add(label); 
        subPanel1.add(textfield);
        subPanel1.add(b);
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
        JButton b2=new JButton("Open");
        JButton b3=new JButton("Assembling");
        subPanel3.add(b2);
        subPanel3.add(b3);
//        leftPanel.add(label);
//        leftPanel.add(textfield);
//        leftPanel.add(b);
//        leftPanel.add(label1);
//        leftPanel.add(browsetext);
//        leftPanel.add(b1);
//        leftPanel.add(b2);
        leftPanel.add(subPanel1);
        leftPanel.add(subPanel2);
        leftPanel.add(subPanel3);
        jframe.add(leftPanel);

        JPanel rightPanel = new JPanel();
//        jframe.add(rightPanel);
//        rightPanel.add(new JLabel("Right side"));
        
        
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
		            	if(editor != null) {
		            		jframe.getContentPane().removeAll();
			            	d1 = new Demo(filepath);
			            	editor = d1.geteditor();
//			            	jframe.getContentPane().add(editor);
			            	jframe.add(editor);
			            	jframe.validate();
//			            	jframe.repaint();
		            	}
		            	else {
		            		d1 = new Demo(filepath);
			            	editor = d1.geteditor();
			            	jframe.add(editor);
//			            	jframe.getContentPane().add(editor);
		            	}
//		               rightPanel
		            }
		        });
				new ChunkUI(chunks);
	        }  
	                
	      });
	    b3.addActionListener(new ActionListener() {
	        
	        @Override
	        public void actionPerformed(ActionEvent arg0) {
	        	jframe.dispose();
	        	new SearchtoQuery();
	        }  
	                
	      });
//	    jframe.add(rightPanel);
	    jframe.setSize(1200, 600);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
	}

}
