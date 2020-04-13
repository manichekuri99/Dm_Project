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
@XmlType(name = "", propOrder = {
    "chunk"
})
@XmlRootElement(name = "Database")
public class Database {
	protected List<ChunkType> chunk;
	
	protected Database() {
		this.chunk = new ArrayList<ChunkType>(); 
	}
	public List<ChunkType> getChunk() {
        if (chunk == null) {
            chunk = new ArrayList<ChunkType>();
        }
        return this.chunk;
	}
	public void setChunk(List<ChunkType> value) {
		this.chunk.clear();
		int n = value.size();
		for(int i=0; i<n ; i++) {
			this.chunk.add(value.get(i));
		}
	}
}
