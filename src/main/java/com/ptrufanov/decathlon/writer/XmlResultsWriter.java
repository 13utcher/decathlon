package com.ptrufanov.decathlon.writer;

import com.ptrufanov.decathlon.model.Score;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;

public class XmlResultsWriter implements ResultsWriter {

    private File output = new File("output.xml");

    public void write(List<Score> results) {
        JAXBContext jaxbContext;
        try {
            XmlRoot decorator = new XmlRoot();
            decorator.setScore(results);
            jaxbContext = JAXBContext.newInstance(XmlRoot.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            jaxbMarshaller.marshal(decorator, output);
        } catch (JAXBException e) {
            throw new RuntimeException("An error while serializing object to xml", e);
        }
    }

    public File getOutput() {
        return output;
    }

    public void setOutput(File output) {
        this.output = output;
    }

    @XmlRootElement(name = "scores")
    @XmlAccessorType(XmlAccessType.FIELD)
    private static class XmlRoot {
        private List<Score> score;

        public List<Score> getScore() {
            return score;
        }

        public void setScore(List<Score> score) {
            this.score = score;
        }
    }
}
