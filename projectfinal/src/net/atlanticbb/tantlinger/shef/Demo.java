
package net.atlanticbb.tantlinger.shef;

import java.awt.BorderLayout;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import net.atlanticbb.tantlinger.io.IOUtils;

/**
 *
 * @author Bob Tantlinger
 */
public class Demo {
	private HTMLEditorPane editor;
    public Demo(String filepath) {
//    	System.out.println(filepath);
    	Path src = Paths.get(filepath);
		Path des = Paths.get("/home/bala/Desktop/MYCLG/8_th/Data   Modeling/Project/projectfinal/build/classes/net/atlanticbb/tantlinger/shef/data.html");
		try{	
			Files.copy(src, des, StandardCopyOption.REPLACE_EXISTING);
		}
		catch(IOException ex) {
		    System.err.format("I/O Error when copying file");
		}
		editor = new HTMLEditorPane();
        InputStream in = Demo.class.getResourceAsStream("/net/atlanticbb/tantlinger/shef/data.html");
        try{
            editor.setText(IOUtils.read(in));
        }catch(IOException ex) {
            ex.printStackTrace();
        } finally {
            IOUtils.close(in);
        }

//        JFrame frame = new JFrame();
//        panel.setLayout(new BorderLayout());
//        System.out.println("Came to Demo");
//        JMenuBar menuBar = new JMenuBar();
//        menuBar.add(editor.getEditMenu());
//        menuBar.add(editor.getFormatMenu());
//        menuBar.add(editor.getInsertMenu());
//        editor.add(menuBar);
//        panel.add(menuBar);
//        panel.add(editor);
//        frame.setJMenuBar(menuBar);
//        
//        frame.setTitle("HTML Editor Demo");
//        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        frame.setSize(800, 600);
//        frame.getContentPane().add(editor);
////        frame.add(editor);
//        frame.setVisible(true);
        System.out.println(" Came to Sheff");
        
    }
    public HTMLEditorPane geteditor() {
    	return editor;
    }

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
