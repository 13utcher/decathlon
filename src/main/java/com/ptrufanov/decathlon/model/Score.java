package com.ptrufanov.decathlon.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "score")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Score {

    private String name;
    private List<String> results;
    private int points;
    private String position;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getResults() {
        return results;
    }

    @XmlElementWrapper(name = "results")
    @XmlElement(name = "result")
    public void setResults(List<String> results) {
        this.results = results;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Score score = (Score) o;

        if (points != score.points) return false;
        if (!Objects.equals(name, score.name)) return false;
        if (!Objects.equals(results, score.results)) return false;
        return Objects.equals(position, score.position);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (results != null ? results.hashCode() : 0);
        result = 31 * result + points;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }
}
