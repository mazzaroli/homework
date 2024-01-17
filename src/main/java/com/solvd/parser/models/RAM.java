package com.solvd.parser.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class RAM {
    @JsonProperty("@id")
    @XmlAttribute(name = "id")
    private long id;
    private String capacity;

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RAM{" +
                "id=" + id +
                ", capacity='" + capacity + '\'' +
                '}';
    }
}