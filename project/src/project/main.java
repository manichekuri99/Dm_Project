package project;


import java.util.ArrayList;
import java.util.List;
import java.awt.Insets;
import java.io.File;
import java.io.StringWriter;

import java.awt.*;
//
import java.io.*; 
import javax.swing.*; 
import java.awt.event.*; 
import javax.swing.filechooser.*;
 
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBElement;
//import javax.xml.bind.JAXBException;
import javax.xml.bind.*;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.border.EmptyBorder;

public class main {

	public static void main(String[] args) throws DatatypeConfigurationException{
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Hello Swing");
		frame.setPreferredSize(new Dimension(1000, 600));
		JPanel panel = new JPanel();
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxlayout);
        panel.setBorder(new EmptyBorder(new Insets(45, 70, 45, 70)));
        
        
        JTextField textfield = new JTextField();
        textfield.setPreferredSize(new Dimension(600, 400));
        panel.add(textfield);     package project;


import java.util.ArrayList;
import java.util.List;
import java.awt.Insets;
import java.io.File;
import java.io.StringWriter;

import java.awt.*;
//
import java.io.*; 
import javax.swing.*; 
import java.awt.event.*; 
import javax.swing.filechooser.*;
 
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBElement;
//import javax.xml.bind.JAXBException;
import javax.xml.bind.*;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.border.EmptyBorder;

public class main {

	public static void main(String[] args) throws DatatypeConfigurationException{
		// TODO Auto-generated method stub
		List<ChunkType> chunks = new ArrayList<ChunkType>();
		JFrame frame = new JFrame("Hello Swing");
		frame.setPreferredSize(new Dimension(1000, 600));
		JPanel panel = new JPanel();
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxlayout);
        panel.setBorder(new EmptyBorder(new Insets(45, 70, 45, 70)));
        
        
        JTextField textfield = new JTextField();
        textfield.setPreferredSize(new Dimension(600, 400));
        panel.add(textfield);     
        JButton jb1 = new JButton("Chunk it");
//        JButton jb2 = new JButton("Button 2");
        panel.add(jb1); 
//        panel.add(jb2);
        frame.setLayout(new GridLayout(2, 1));
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        jb1.addActionListener(new ActionListener() {
  	      
  	      @Override
  	      public void actionPerformed(ActionEvent arg0) {
  	    	String ChunkContent = textfield.getText();
  	    	List<Object> md = new ArrayList<Object>();
  	    	ChunkType ch = new ChunkType(); 
  	    	Text t1 = new Text();
  	    	
  	    	JFrame f=new JFrame("Id"); 
  	    	f.setPreferredSize(new Dimension(1000, 600));
  	        JTextField tid= new JTextField();
  	        tid.setBounds(200,50,150,25);
  	    	f.add(tid);
  	    	JLabel idLabel = new JLabel("Id:");
  	    	idLabel.setBounds(25,50,75,25);
  	    	f.add(idLabel);
  	    	
  	    	
  	    	JTextField tauthor= new JTextField();
  	    	tauthor.setBounds(200,100,200,25);
  	    	f.add(tauthor);
  	    	JLabel authorLabel = new JLabel("Author name:");
  	    	authorLabel.setBounds(25,100,150,25);
  	    	f.add(authorLabel);
  	    	
  	    	
  	    	JTextField Textitle= new JTextField();
  	    	Textitle.setBounds(200,150,300,25);
  	    	f.add(Textitle);
  	    	JLabel TitleLabel = new JLabel("Title:");
  	    	TitleLabel.setBounds(25,150,75,25);
  	    	f.add(TitleLabel);
  	    	
  	    	JTextField TexDescrption= new JTextField();
  	    	TexDescrption.setBounds(200,200,300,100);
  	    	f.add(TexDescrption);
  	    	JLabel DescrptionLabel = new JLabel("Descrption:");
  	    	DescrptionLabel.setBounds(25,200,150,25);
  	    	f.add(DescrptionLabel);
  	    	
  	    	JTextField TexEmail= new JTextField();
  	    	TexEmail.setBounds(200,325,300,25);
  	    	f.add(TexEmail);
  	    	JLabel EmailLabel = new JLabel("Email:");
  	    	EmailLabel.setBounds(25,325,75,25);
  	    	f.add(EmailLabel);

  	    	JButton b=new JButton("Ok");
  	    	b.setBounds(100,500,110, 30);
  	    	f.add(b);
  	    	
  	    	
  	    	
  			
  	    	f.setLayout(null);
  	    	f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  	    	f.pack();
  	        f.setVisible(true);
  	        b.addActionListener(new ActionListener() {
  		      
  		      @Override
  		      public void actionPerformed(ActionEvent e) {
  		    	t1.settext(ChunkContent);
  		    	t1.setid(0);
  		    	Author auth = new Author();
  		    	auth.setauthor(tauthor.getText());
  		    	Title titl = new Title();
  		    	titl.setvalue(Textitle.getText());
  		    	Email eml = new Email();
  		    	eml.setEmail(TexEmail.getText());
  		    	Description d = new Description();
  		    	d.setdescription(TexDescrption.getText());
  		    	md.add(titl);
  		    	md.add(d);
  		    	md.add(auth);
  		    	md.add(eml);
  		    	
  		    	metadata meta = new metadata();
  	  			meta.setcontactInfo(md);
  	  			ch.setText(t1);
  	  			ch.setmetadata(meta);
  	  			chunks.add(ch);
  		    	Database db = new Database();
  	  			db.setChunk(chunks);
  	  			jaxbObjectToXML(db);
  		    	f.dispose();
  		      }
  		              
  		    });
  	      }
  	              
  	    });
        
//        Html To Xml
//        general intoduction and project request
//        Balamanikanta
//        manichekuri99@gmail.com
	}
	
	private static void jaxbObjectToXML(Database data) 
    {
        try
        {
            //Create JAXB Context
            JAXBContext jaxbContext = JAXBContext.newInstance(Database.class);
             
            //Create Marshaller
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
 
            //Required formatting??
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
 
            File file = new File("Database.xml");
            
          //Writes XML file to file-system
           jaxbMarshaller.marshal(data, file);
//            //Print XML String to Console
//            StringWriter sw = new StringWriter();
//             
//            //Write XML to StringWriter
//            jaxbMarshaller.marshal(data, sw);
//             
//            //Verify XML Content
//            String xmlContent = sw.toString();
//            System.out.println( xmlContent );
 
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}

        JButton jb1 = new JButton("Chunk it");
//        JButton jb2 = new JButton("Button 2");
        panel.add(jb1); 
//        panel.add(jb2);
        frame.setLayout(new GridLayout(2, 1));
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        jb1.addActionListener(new ActionListener() {
  	      
  	      @Override
  	      public void actionPerformed(ActionEvent arg0) {
  	    	JFrame f=new JFrame("Id"); 
  	    	f.setPreferredSize(new Dimension(1000, 600));
  	        JTextField tid= new JTextField();
  	        tid.setBounds(200,50,150,25);
  	    	f.add(tid);
  	    	JLabel idLabel = new JLabel("Id:");
  	    	idLabel.setBounds(25,50,75,25);
  	    	f.add(idLabel);
  	    	
  	    	
  	    	JTextField tauthor= new JTextField();
  	    	tauthor.setBounds(200,100,200,25);
  	    	f.add(tauthor);
  	    	JLabel authorLabel = new JLabel("Author name:");
  	    	authorLabel.setBounds(25,100,150,25);
  	    	f.add(authorLabel);
  	    	
  	    	
  	    	JTextField Textitle= new JTextField();
  	    	Textitle.setBounds(200,150,300,25);
  	    	f.add(Textitle);
  	    	JLabel TitleLabel = new JLabel("Title:");
  	    	TitleLabel.setBounds(25,150,75,25);
  	    	f.add(TitleLabel);
  	    	
  	    	JTextField TexDescrption= new JTextField();
  	    	TexDescrption.setBounds(200,200,300,100);
  	    	f.add(TexDescrption);
  	    	JLabel DescrptionLabel = new JLabel("Descrption:");
  	    	DescrptionLabel.setBounds(25,200,150,25);
  	    	f.add(DescrptionLabel);
  	    	
  	    	JTextField TexEmail= new JTextField();
  	    	TexEmail.setBounds(200,325,300,25);
  	    	f.add(TexEmail);
  	    	JLabel EmailLabel = new JLabel("Email:");
  	    	EmailLabel.setBounds(25,325,75,25);
  	    	f.add(EmailLabel);
//  	    	JLabel label = new JLabel();        
//  	    	label.setText("Enter Id  :");
//  	    	label.setBounds(410, 10, 200, 150);
//  	    	f.add(label);
  	    	JButton b=new JButton("Ok");
//  	    	b.setPreferredSize(new Dimension(20,10));
  	    	b.setBounds(100,500,110, 30);
  	    	f.add(b);
  	    	f.setLayout(null);
  	    	f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  	    	f.pack();
  	        f.setVisible(true);
  	        b.addActionListener(new ActionListener() {
  		      
  		      @Override
  		      public void actionPerformed(ActionEvent e) {
  		    	  f.dispose();
  		      }
  		              
  		    });
  	      }
  	              
  	    });
        
		List<Text> t = new ArrayList<Text>();
		Text t1 = new Text();
		t1.settext("hii there");
		t1.setid(1);
		Text t2 = new Text();
		t2.settext("headig is fine");
		t2.setid(2);
		Text t3 = new Text();
		t3.settext("balamanikanta chekuri");
		t3.setid(3);
		t.add(t1);
		t.add(t2);
		t.add(t3);
		Author auth = new Author();
		auth.setauthor("balamanikanta");
		Title titl = new Title();
		titl.setvalue("Html to XML");
		Email e = new Email();
		e.setEmail("manichekur99@gmail.com");
		Description d = new Description();
		d.setdescription("Project description");
		LastModified ld = new LastModified();
		String isoDateTime = "2020-04-13T17:39:00Z";
	    XMLGregorianCalendar dateXMLGreg = DatatypeFactory.newInstance().newXMLGregorianCalendar(isoDateTime);
	    DateAndTime dt = new DateAndTime();
	    dt.setDate(dateXMLGreg);
	    dt.setTime(dateXMLGreg);
	    ld.setDateAndTime(dt);
		List<Object> md = new ArrayList<Object>();
		md.add(auth);
		md.add(titl);
		md.add(e);
		md.add(d);
		md.add(ld);
		metadata meta = new metadata();
		meta.setcontactInfo(md);
		ChunkType ch = new ChunkType(); 
		ch.setText(t3);
		ch.setmetadata(meta);
		List<ChunkType> chunks = new ArrayList<ChunkType>();
		chunks.add(ch);
		Database db = new Database();
		db.setChunk(chunks);
		jaxbObjectToXML(db);
	}
	
	private static void jaxbObjectToXML(Database data) 
    {
        try
        {
            //Create JAXB Context
            JAXBContext jaxbContext = JAXBContext.newInstance(Database.class);
             
            //Create Marshaller
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
 
            //Required formatting??
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
 
            //Print XML String to Console
            StringWriter sw = new StringWriter();
             
            //Write XML to StringWriter
            jaxbMarshaller.marshal(data, sw);
             
            //Verify XML Content
            String xmlContent = sw.toString();
            System.out.println( xmlContent );
 
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
