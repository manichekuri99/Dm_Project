package project;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
//@XmlRootElement(name = "text")
@XmlType(name = "chunk_type" ,propOrder= {"text","metadata"})
public class ChunkType {
	private List<Text> text;
//	private int id;
	metadata metadata;
	
	protected ChunkType() {
		this.text = new ArrayList<Text>();
		metadata = new metadata();
	}
	public List<Text> getText(){
		return this.text;
	}
	public void setText(List<Text> t) {
		this.text.clear();
		int n = t.size();
		for(int i=0; i<n; i++) {
			this.text.add(t.get(i));
		}
//		this.text = t;
	}
//	public int getid() {
//		return this.id;
//	}
//	public void setid(int x) {
//		this.id = x;
//	}
	public metadata getmetadata() {
		return this.metadata;
	}
	public void setmetadata(metadata value) {
		this.metadata.setcontactInfo(value.getcontactInfo());
	}
}
