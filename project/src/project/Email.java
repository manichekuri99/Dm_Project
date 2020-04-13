package project;

import java.util.InputMismatchException;
import java.util.regex.*;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "email")

public class Email{
	@XmlTransient protected String email;
	
	@XmlValue
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String x) {
		String REGEX = "[a-z]*[0-9]*[a-z]*[@][a-z]*[.][a-z]*";
		Pattern pattern = Pattern.compile(REGEX);
		Matcher matcher = pattern.matcher(x);
		if(matcher.matches()) {
			this.email = x;
		}
		else {
			System.out.println("wrong email");
			throw new InputMismatchException("wrong input");
		}
	}
}
