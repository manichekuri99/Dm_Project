package project;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElement;

public class Published{
	@XmlElement
	DateAndTime published;
	public DateAndTime getvalue() {
		return this.published;
	}
	public void setvalue(DateAndTime dt) {
		this.published.setDate(dt.getDate());
		this.published.setTime(dt.getTime());
	}
}
