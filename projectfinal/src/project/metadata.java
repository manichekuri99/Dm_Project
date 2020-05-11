package project;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
//import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlElementRef;
//import javax.xml.bind.annotation.XmlElementRefs;
//import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "metadata")
public class metadata {
//	@XmlElementRefs({
//        @XmlElementRef(name = "description", namespace = "http://www.example.com/contacts", type = Description.class, required = false),
//        @XmlElementRef(name = "author", namespace = "http://www.example.com/contacts", type = Author.class, required = false),
//        @XmlElementRef(name = "Contact_Email", namespace = "http://www.example.com/contacts", type = Email.class, required = false),
//        @XmlElementRef(name = "title", namespace = "http://www.example.com/contacts", type = Title.class, required = false)
//    })
//    private List<Object> contactInfo;
	@XmlElements({
		@XmlElement(name = "Title",  type = Title.class, required = false),
		@XmlElement(name = "Author",  type = Author.class, required = false),
		@XmlElement(name = "description",  type = Description.class, required = false),
		@XmlElement(name = "Contact_Email",  type = Email.class, required = false),
		@XmlElement(name = "published",  type = Published.class, required = false),
		@XmlElement(name = "lastmodified",  type = LastModified.class, required = false)
		})
	private List<Object> contactInfo;
//	public List<JAXBElement<?>> getcontactInfo(){
//		if (contactInfo == null) {
//			contactInfo = new ArrayList<JAXBElement<?>>();
//        }
//		return this.contactInfo;
//	}
	public List<Object> getcontactInfo(){
		if (contactInfo == null) {
			contactInfo = new ArrayList<Object>();
        }
		return this.contactInfo;
	}
	
	public void setcontactInfo(List<Object> X) {
		if (contactInfo == null) {
			contactInfo = new ArrayList<Object>();
        }
		else {
			this.contactInfo.clear();
		}
		int n = X.size();
		for(int i=0; i<n; i++) {
			this.contactInfo.add(X.get(i));
		}
	}
	
}
