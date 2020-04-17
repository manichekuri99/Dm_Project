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
  	    	JFrame f=new JFrame("Id"); 
  	    	f.setPreferredSize(new Dimension(1000, 600));
  	        JTextField tx= new JTextField();
//  	        tx.setPreferredSize(new Dimension(60, 40));
  	        tx.setBounds(555, 70, 240, 30);
  	    	f.add(tx);
  	    	
  	    	JLabel label = new JLabel();        
  	    	label.setText("Enter Id  :");
  	    	label.setBounds(410, 10, 200, 150);
  	    	f.add(label);
  	    	JButton b=new JButton("Ok");
//  	    	b.setPreferredSize(new Dimension(20,10));
  	    	b.setBounds(650,120,110, 30);
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
		ch.setText(t);
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
