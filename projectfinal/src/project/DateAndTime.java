package project;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "date",
    "time"
})
public class DateAndTime {
//	@XmlElement(name = "Date", required = true)
//    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar date;
//	@XmlElement(name = "Time", required = true)
//    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar time;
    
    /**Date element**/
    public XMLGregorianCalendar getDate() {
        return date;
    }
//    @XmlElement
    public void setDate(XMLGregorianCalendar value) {
    	this.date = value;
    }
    
    
    /** Time element**/
    public XMLGregorianCalendar getTime() {
        return time;
    }
//    @XmlElement
    public void setTime(XMLGregorianCalendar value) {
    	this.time = value;
    }
}
