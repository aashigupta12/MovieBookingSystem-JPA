package com.aashi.movieBookingSys.entities;

import jakarta.persistence.*;

@Entity
public class Engine {

    @Id
    @GeneratedValue
    private int engineId;
    private String engineName;

    @OneToOne(mappedBy = "engine")
    private Car car;

    public int getEngineId() {
        return engineId;
    }

    public void setEngineId(int engineId) {
        this.engineId = engineId;
    }

    public String getEngineName() {
        return engineName;
    }

    public void setEngineName(String engineName) {
        this.engineName = engineName;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "engineId=" + engineId +
                ", engineName='" + engineName + '\'' +
                ", car=" + car +
                '}';
    }
}
