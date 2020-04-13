package project;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "lastmodified")
public class LastModified{
	@XmlTransient protected DateAndTime lastmodified = new DateAndTime();
	@XmlElement
	public DateAndTime getDateAndTime() {
		return this.lastmodified;
	}
	public void setDateAndTime(DateAndTime dt) {
		this.lastmodified.setDate(dt.getDate());
		this.lastmodified.setTime(dt.getTime());
	}
}
