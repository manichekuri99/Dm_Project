package project;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.commons.lang3.StringEscapeUtils;

public class ChunkUI {
	public ChunkUI(List<ChunkType> chunks) {
		JFrame frame = new JFrame("Hello Swing");
		frame.setLayout(new GridLayout(2, 1));
		frame.setPreferredSize(new Dimension(1000, 600));
//		JPanel panel = new JPanel();
//		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
//        panel.setLayout(boxlayout);
//        panel.setBorder(new EmptyBorder(new Insets(45, 70, 45, 70)));
		JPanel mainPanel = new JPanel(); // main panel
        mainPanel.setLayout(new GridLayout(2, 1));
        JPanel subPanel1 = new JPanel();
        subPanel1.setLayout(new GridLayout(1, 1));
        JEditorPane textfield = new JEditorPane();
        textfield.setContentType("text");
//        JTextField textfield = new JTextField();
//        textfield.setPreferredSize(new Dimension(600, 400));
        subPanel1.add(textfield); 
        JPanel subPanel2 = new JPanel();
	   	subPanel2.setLayout(new FlowLayout());
        JButton jb1 = new JButton("Chunk it");
//        JButton jb2 = new JButton("Button 2");
        subPanel2.add(jb1); 
//        panel.add(jb2);
        mainPanel.add(subPanel1);
        mainPanel.add(subPanel2);
        frame.add(mainPanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        
        jb1.addActionListener(new ActionListener() {
  	      
  	      @Override
  	      public void actionPerformed(ActionEvent arg0) {
  	    	String ChunkContent = StringEscapeUtils.escapeXml(textfield.getText());
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
  		    	t1.setid(Integer.parseInt(tid.getText()));
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
