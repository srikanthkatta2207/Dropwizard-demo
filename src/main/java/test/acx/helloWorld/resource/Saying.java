package test.acx.helloWorld.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Saying {
    private long id;

    @Length(max = 3)
    private String content;

    public Saying() {
        // Jackson deserialization
    }

    public Saying(long id, String content) {
        this.id = id;
        this.content = content;
        }



    @JsonProperty
    @XmlElement
    public long getId() {
        return id;
    }

    @JsonProperty
    @XmlElement
    public String getContent() {
        return content;
    }
}

