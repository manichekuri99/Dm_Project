package project;

import java.util.InputMismatchException;
import java.util.regex.*;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;

public class Details extends Element{
	String title;
	String description;
	String author;
	DateAndTime published;
	DateAndTime lastmodified;
	
	public String getTitle() {
		return this.title;
	}
	@XmlElement
	public void setTitle(String value) {
		this.title = value;
	}
	
	public String getdescription() {
		return this.description;
	}
	@XmlElement
	public void setdescription(String value) {
		this.description = value;
	}
	
	public String getauthor() {
		return this.author;
	}
	@XmlElement
	public void setauthor(String value) {
		this.author = value;
	}
	
	public DateAndTime getpubdate() {
		return this.published;
	}
	
	@XmlElement
	public void setdate(DateAndTime dt) {
		this.published.setDate(dt.getDate());
		this.published.setTime(dt.getTime());
	}
	
	public DateAndTime getlastmodifieddate() {
		return this.lastmodified;
	}
	
	@XmlElement
	public void lastmodifieddate(DateAndTime dt) {
		this.lastmodified.setDate(dt.getDate());
		this.lastmodified.setTime(dt.getTime());
	}

}
