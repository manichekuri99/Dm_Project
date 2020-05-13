package net.atlanticbb.tantlinger.shef;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileSystemView;

import org.jsoup.Jsoup;
import org.jsoup.helper.W3CDom;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

import net.atlanticbb.tantlinger.io.IOUtils;


public class DemoAssembling {
	private HTMLEditorPane editor;
    public DemoAssembling(String filepath) {
//    	System.out.println(filepath);
    	Path src = Paths.get(filepath);
		Path des = Paths.get("./build/classes/net/atlanticbb/tantlinger/shef/final.html");
		try{	
			Files.copy(src, des, StandardCopyOption.REPLACE_EXISTING);
		}
		catch(IOException ex) {
		    System.err.format("I/O Error when copying file");
		}
		editor = new HTMLEditorPane();
        InputStream in = Demo.class.getResourceAsStream("/net/atlanticbb/tantlinger/shef/final.html");
        try{
            editor.setText(IOUtils.read(in));
        }catch(IOException ex) {
            ex.printStackTrace();
        } finally {
            IOUtils.close(in);
        }

        JFrame frame = new JFrame();
        JMenuBar menuBar = new JMenuBar();
        JButton b1 = new JButton("Convert to PDF");
	   	JButton b2 = new JButton("Convert to HTML");
        menuBar.add(b1);
        menuBar.add(b2);
//        editor.add(menuBar);
        frame.setJMenuBar(menuBar);
        
        frame.setTitle("HTML Editor Demo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.getContentPane().add(editor);
        frame.add(editor);
        frame.setVisible(true);
        b1.addActionListener(new ActionListener() {
	        
	        @Override
	        public void actionPerformed(ActionEvent arg0) {
	        	JFileChooser saveFile = new JFileChooser();
                int userSelection = saveFile.showSaveDialog(null);
                File fileToSave = null;
                // int userSelection = fileChooser.showSaveDialog(this);
		            if (userSelection == JFileChooser.APPROVE_OPTION) {
			               fileToSave = saveFile.getSelectedFile();
//			                  System.out.println("Save as file: " + fileToSave.getAbsolutePath());
//			                  write(fileToSave.getAbsolutePath());
		            }
	        	try{
	        		OutputStream os = new FileOutputStream(fileToSave.getAbsolutePath());
	                PdfRendererBuilder builder = new PdfRendererBuilder();
	                builder.useFastMode();
	                
	                File myFoo = new File("./build/classes/resources/convert2pdf.html");
	                write(myFoo);
//	                String fileurl = "file:///home/bala/Desktop/MYCLG/8_th/Data   Modeling/Project/projectfinal/build/classes/resources/convert2pdf.html";
	                String fileurl = "file://"+myFoo.getAbsolutePath();
	                builder.withW3cDocument(html5ParseDocument(fileurl, 10), fileurl);
	                builder.toStream(os);
	                builder.run();
	            }
	        	catch(Exception e){
	        		System.out.println("Error unable to open file");
	        	}
	         }  
	                
	      });
        b2.addActionListener(new ActionListener() {
	        
	        @Override
	        public void actionPerformed(ActionEvent arg0) {
	        	JFileChooser saveFile = new JFileChooser();
                int userSelection = saveFile.showSaveDialog(null);
                // int userSelection = fileChooser.showSaveDialog(this);
		            if (userSelection == JFileChooser.APPROVE_OPTION) {
			               File fileToSave = saveFile.getSelectedFile();
//			                  System.out.println("Save as file: " + fileToSave.getAbsolutePath());
//			                  write(fileToSave.getAbsolutePath());
			                  File myFoo = new File(fileToSave.getAbsolutePath());
				              write(myFoo);
		            }
	         }  
	                
	      });
        
        
    }
    public void write(File myFoo) {
  	  try {
//  		  String path = s + "Data.html";
  		  
  		  FileWriter myWriter = new FileWriter(myFoo, false);
  	      
  	      myWriter.write(editor.getText());
  	      myWriter.close();
//  	      System.out.println("Successfully wrote to the file.");
  	    } catch (IOException e) {
  	      System.out.println("An error occurred.");
  	      e.printStackTrace();
  	    }
    }
    public static org.w3c.dom.Document html5ParseDocument(String urlStr, int timeoutMs) throws IOException 
	{
		URL url = new URL(urlStr);
		org.jsoup.nodes.Document doc;
		
		if (url.getProtocol().equalsIgnoreCase("file")) {
			doc = Jsoup.parse(new File(url.getPath()), "UTF-8");
		}
		else {
			doc = Jsoup.parse(url, timeoutMs);	
		}
		// Should reuse W3CDom instance if converting multiple documents.
		return new W3CDom().fromJsoup(doc);
	}
//    public HTMLEditorPane geteditor() {
//    	return editor;
//    }

//    public static void main(String args[]) {
//
//        try {
//            UIManager.setLookAndFeel(
//                UIManager.getSystemLookAndFeelClassName());
//        } catch(Exception ex){}
//
//
//        SwingUtilities.invokeLater(new Runnable() {
//
//            public void run() {
//               new Demo();
//            }
//        });
//    }

}
