package project;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import java.util.*;

public class XMLDatabaseDriver {

  private Document doc;
  private XPath xPath;

  XMLDatabaseDriver(String xmlFile){
    try{
      File inputFile = new File(xmlFile);
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder;

      dBuilder = dbFactory.newDocumentBuilder();

      doc = dBuilder.parse(inputFile);
      doc.getDocumentElement().normalize();

      xPath =  XPathFactory.newInstance().newXPath();

    }
    catch (ParserConfigurationException e) {
       e.printStackTrace();
    } catch (SAXException e) {
       e.printStackTrace();
    } catch (IOException e) {
       e.printStackTrace();
    }
  }

   public ArrayList<String> retrieveChunk(String query){

     ArrayList<String> chunksText = new ArrayList<String>();

      try {
         // File inputFile = new File("Database.xml");
         // DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         // DocumentBuilder dBuilder;
         //
         // dBuilder = dbFactory.newDocumentBuilder();
         //
         // Document doc = dBuilder.parse(inputFile);
         // doc.getDocumentElement().normalize();
         //
         // XPath xPath =  XPathFactory.newInstance().newXPath();

         // String expression = "/Database/chunk[contains(metadata/Author, 'bala')]";
         // contains(text, 'medcraveonline')
         String expression = "/Database/chunk" + query;
         NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(
            doc, XPathConstants.NODESET);

         for (int i = 0; i < nodeList.getLength(); i++) {
            Node nNode = nodeList.item(i);
//            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               // System.out.println("id : "
               //    + eElement.getAttribute("text.id"));
               // System.out.println("text : "
               chunksText.add(eElement.getElementsByTagName("text").item(0).getTextContent());
               // System.out.println("Last Name : "
               //    + eElement
               //    .getElementsByTagName("lastname")
               //    .item(0)
               //    .getTextContent());
               // System.out.println("Nick Name : "
               //    + eElement
               //    .getElementsByTagName("nickname")
               //    .item(0)
               //    .getTextContent());
               // System.out.println("Marks : "
               //    + eElement
               //    .getElementsByTagName("marks")
               //    .item(0)
               //    .getTextContent());
            }
         }
      } catch (XPathExpressionException e) {
         e.printStackTrace();
      }
      return chunksText;
   }
}
