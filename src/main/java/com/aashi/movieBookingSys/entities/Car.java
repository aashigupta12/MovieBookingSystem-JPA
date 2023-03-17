package com.aashi.movieBookingSys.entities;

import jakarta.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue
    private int carId;
    private String carName;

    @OneToOne
    @JoinColumn(name = "engine_name")
    private Engine engine;

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", carName='" + carName + '\'' +
                ", engine=" + engine +
                '}';
    }
}
