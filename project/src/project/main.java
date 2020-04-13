package project;


import java.util.ArrayList;
import java.util.List;

import java.io.File;
import java.io.StringWriter;
 
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class main {

	public static void main(String[] args) throws DatatypeConfigurationException{
		// TODO Auto-generated method stub
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
	    XMLGregorianCalendar dateXMLGreg = DatatypeFactory.newInstance()
	            .newXMLGregorianCalendar(isoDateTime);
//	    XMLGregorianCalendar time = DatatypeFactory.newInstance()
//	    		  .newXMLGregorianCalendarTime(xgc.getHour(), xgc.getMinute(), xgc.getSecond(), 
//	    		      xgc.getFractionalSecond(), xgc.getTimezone());
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
