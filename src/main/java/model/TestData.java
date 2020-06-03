package model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"sectionId", "section"})
@Table(name = "TestData")
public class TestData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sectionId;

    @Column(name="section")
    private String section;

    @Column(name="data")
    private String data;

    @XmlElement
    public Long getSectionId() {
        return this.sectionId;
    }

    @XmlElement
    public String getSection() {
        return this.section;
    }

    @XmlElement
    public String getData() {
        return this.data;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String toString() {
        return "TestData(sectionId=" + this.getSectionId() + ", section=" + this.getSection() + ", data=" + this.getData() + ")";
    }
}
