package project;

import javax.xml.bind.annotation.*;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "author")
public class Author{
	@XmlTransient protected String author;
	@XmlValue
	public String getauthor() {
		return this.author;
	}
	public void setauthor(String s) {
		this.author = s;
	}

}
