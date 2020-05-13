package project;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.File;
import java.io.StringWriter;

//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBElement;
//import javax.xml.bind.JAXBException;
import java.awt.*;
//
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.filechooser.*;

import org.apache.commons.lang3.StringEscapeUtils;

import net.atlanticbb.tantlinger.shef.DemoAssembling;

import javax.swing.border.EmptyBorder;


public class SearchtoQuery{
	private static int Chunkscount;
	private static ArrayList<String> chunksText;
	public SearchtoQuery() {
		XMLDatabaseDriver driver = new XMLDatabaseDriver("Database.xml");
	    Set<String> FinalChunks = new HashSet<String>();
	    JFrame searchframe=new JFrame("Search");
	    searchframe.setPreferredSize(new Dimension(600, 400));

	    JLabel ntfLabel = new JLabel("Fill atleast one field. Based on entered fields, chunks will be retrieved");
	    ntfLabel.setBounds(0,0,500,50);
	    searchframe.add(ntfLabel);


	    JTextField sid = new JTextField();
	    sid.setBounds(200,50,150,25);
	    searchframe.add(sid);
	    // JCheckBox idCheckbox = new JCheckBox("Id") ;
	    // idCheckbox.setBounds(25,50,75,25);
	    // searchframe.add(idCheckbox);
	    JLabel sidLabel = new JLabel("Id(Integer only)");
	    sidLabel.setBounds(25,50,150,25);
	    searchframe.add(sidLabel);


	    JTextField sauthor = new JTextField();
	    sauthor.setBounds(200,100,150,25);
	    searchframe.add(sauthor);
	    // JCheckBox authorCheckbox = new JCheckBox("Author name") ;
	    // authorCheckbox.setBounds(25,100,150,25);
	    // searchframe.add(authorCheckbox);
	    JLabel sauthorLabel = new JLabel("Author name");
	    sauthorLabel.setBounds(25,100,150,25);
	    searchframe.add(sauthorLabel);


	    JTextField stitle = new JTextField();
	    stitle.setBounds(200,150,150,25);
	    searchframe.add(stitle);
	    // JCheckBox titleCheckbox = new JCheckBox("Title") ;
	    // titleCheckbox.setBounds(25,150,75,25);
	    // searchframe.add(titleCheckbox);
	    JLabel sTitleLabel = new JLabel("Title");
	    sTitleLabel.setBounds(25,150,75,25);
	    searchframe.add(sTitleLabel);

	    JTextField sTexDescrption= new JTextField();
	    sTexDescrption.setBounds(200,200,150,25);
	    searchframe.add(sTexDescrption);
	    // JCheckBox desCheckbox = new JCheckBox("Descrption") ;
	    // desCheckbox.setBounds(25,200,150,25);
	    // searchframe.add(desCheckbox);
	    JLabel sDescrptionLabel = new JLabel("Descrption");
	    sDescrptionLabel.setBounds(25,200,150,25);
	    searchframe.add(sDescrptionLabel);

	    JTextField sChunkContent= new JTextField();
	    sChunkContent.setBounds(200,250,150,25);
	    searchframe.add(sChunkContent);
	    // JCheckBox desCheckbox = new JCheckBox("Descrption") ;
	    // desCheckbox.setBounds(25,200,150,25);
	    // searchframe.add(desCheckbox);
	    JLabel sChunklabel = new JLabel("Chunk Content");
	    sChunklabel.setBounds(25,250,150,25);
	    searchframe.add(sChunklabel);


	    JButton retrieveChunkButton = new JButton("Retrieve chunk");
	    retrieveChunkButton.setBounds(25,300,150, 30);
	    searchframe.add(retrieveChunkButton);

	    JButton endSearchButton = new JButton("End Search");
	    endSearchButton.setBounds(200,300,150, 30);
	    searchframe.add(endSearchButton);


	    searchframe.setLayout(null);
	    searchframe.pack();
	    searchframe.setVisible(true);
	    searchframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	    endSearchButton.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e)
	      {
	         searchframe.dispose();
	         new DemoAssembling("Data.html");
	      }
	    });

	    // Integer id = null;
	    // String authorFromQuery = null, titleFromQuery = null, desFromQuery = null, xmlQuery = null;

	    retrieveChunkButton.addActionListener(new ActionListener() {

	      @Override
	      public void actionPerformed(ActionEvent e) {
	        boolean isEmpty = true;
	        ntfLabel.setText("Fill atleast one field. Based on entered fields, chunks will be retrieved");
	        ntfLabel.setForeground (Color.black);

	      

	        String query = "[";

	        if(!sid.getText().equals("")){
	          try{
	            int id = Integer.parseInt(sid.getText());
	            isEmpty = false;
	            query += "text/@id = ";
	            query += sid.getText();
	            sid.setText("");
	          }
	          catch (NumberFormatException ex){
	            ntfLabel.setText("Id should be interger");
	            ntfLabel.setForeground (Color.red);
	            sid.setText("");
	            return;
	          }
	        }

	        if(!sauthor.getText().equals("")){
	          if(!isEmpty){
	            query += " or ";
	          }
	          else{
	            isEmpty = false;
	          }
	          query += "contains(metadata/Author, '";
	          query += sauthor.getText();
	          query += "')";
	          sauthor.setText("");
	        }

	        if(!stitle.getText().equals("")){
	          if(!isEmpty){
	            query += " or ";
	          }
	          else{
	            isEmpty = false;
	          }
	          query += "contains(metadata/Title, '";
	          query += stitle.getText();
	          query += "')";
	          stitle.setText("");
	        }

	        if(!sTexDescrption.getText().equals("")){
	          if(!isEmpty){
	            query += " or ";
	          }
	          else{
	            isEmpty = false;
	          }
	          query += "contains(metadata/description, '";
	          query += sTexDescrption.getText();
	          query += "')";
	          sTexDescrption.setText("");
	        }

	        if(!sChunkContent.getText().equals("")){
	          if(!isEmpty){
	            query += " or ";
	          }
	          else{
	            isEmpty = false;
	          }
	          query += "contains(text, '";
	          query += sChunkContent.getText();
	          query += "')";
	          sChunkContent.setText("");
	        }

	        if(isEmpty){
	          ntfLabel.setText("*No field was filled");
	          ntfLabel.setForeground (Color.red);
	          return;
	        }

	        query += "]";
//	        System.out.println(query);

	        chunksText = driver.retrieveChunk(query);
	        
	        JFrame  Qframe = new JFrame("Query");
	        JPanel mainPanel = new JPanel(); // main panel
	        mainPanel.setLayout(new GridLayout(2, 1));
	        JPanel subPanel1 = new JPanel();
	        subPanel1.setLayout(new GridLayout(1, 1));
		   	JEditorPane myPane = new JEditorPane();
		   	myPane.setContentType("text/html"); 
		   	subPanel1.add(myPane);
		   	JPanel subPanel2 = new JPanel();
		   	subPanel2.setLayout(new FlowLayout());
		   	JButton b1 = new JButton("Select");
		   	JButton b2 = new JButton("NotSelect");
		   	subPanel2.add(b1);
		   	subPanel2.add(b2);
		   	mainPanel.add(subPanel1);
		    mainPanel.add(subPanel2);
		    Qframe.add(mainPanel);
		    
		    myPane.setText(StringEscapeUtils.unescapeXml(chunksText.get(0)));
		    
		    b1.addActionListener(new ActionListener() {
			      
			      @Override
			      public void actionPerformed(ActionEvent e) {
			    	  if(Chunkscount+1 == chunksText.size()) {
			    		  FinalChunks.add(StringEscapeUtils.unescapeXml(chunksText.get(Chunkscount)));
			    		  write(FinalChunks);
			    		  Chunkscount = 0;
			    		  Qframe.dispose();
			    	  }
			    	  else {
			    		  FinalChunks.add(StringEscapeUtils.unescapeXml(chunksText.get(Chunkscount)));
			    		  myPane.setText(StringEscapeUtils.unescapeXml(chunksText.get(Chunkscount+1)));
			    		  Chunkscount = Chunkscount+1;
			    	  }
			      }
			              
			    });
		    b2.addActionListener(new ActionListener() {
			      
			      @Override
			      public void actionPerformed(ActionEvent e) {
			    	  if(Chunkscount+1 == chunksText.size()) {
			    		  write(FinalChunks);
			    		  Chunkscount = 0;
			    		  Qframe.dispose();
			    	  }
			    	  else {
//			    		  FinalChunks.add(chunksText.get(Chunkscount));
			    		  myPane.setText(StringEscapeUtils.unescapeXml(chunksText.get(Chunkscount+1)));
			    		  Chunkscount = Chunkscount+1;
			    	  }
			      }
			              
			    });
		    
		    
		    
		    
		   	Qframe.setSize(400, 600); 
		   	Qframe.setVisible(true);   
		   	Qframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		   	
//	        for(int i = 0; i < chunksText.size(); i++){
//	          System.out.println(chunksText.get(i));
//	        }

	      }
	    });
	}
  public static void write(Set<String> s) {
	  try {
		  File myFoo = new File("Data.html");
		  FileWriter myWriter = new FileWriter(myFoo, false);
	      String start = "<html><body>";
	      String end = "</body></html>";
	      StringBuilder sb1 = new 
                  StringBuilder(start);
	      Object[] arr = s.toArray(); 
	      for(int i = 0; i < arr.length; i++){
	    	  sb1.append(arr[i]);
	        }
	      String complete = sb1+end;
	      myWriter.write(complete);
	      myWriter.close();
//	      System.out.println("Successfully wrote to the file.");
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
  }
  public static void print(Set<String> s) {
        System.out.println(s.size());
  }
}
