package project;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "title")
public class Title{
	@XmlTransient protected String title;

	public String getvalue() {
		return this.title;
	}
	
	@XmlValue
	public void setvalue(String s) {
		this.title = s;
	}
}
