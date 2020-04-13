package project;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "text")
public class Text {
	@XmlTransient protected String text;
	@XmlAttribute
    protected int id;
	@XmlValue
	public String gettext() {
		return this.text;
	}
	public void settext(String s) {
		this.text = s;
	}
	public int getid() {
		return this.id;
	}
	public void setid(int x) {
		this.id=x;
	}
}
