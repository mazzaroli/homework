package com.solvd.parser.models;


import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class RamSlots {
    @XmlElement(name = "ram")
    private List<RAM> rams;

    public List<RAM> getRams() {
        return rams;
    }
    public void setRams(List<RAM> rams) {
        this.rams = rams;
    }

    @Override
    public String toString() {
        return "RamSlots{" +
                "rams=" + rams +
                '}';
    }
}