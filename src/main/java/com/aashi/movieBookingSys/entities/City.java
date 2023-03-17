package com.aashi.movieBookingSys.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class City{

    @Id
    @GeneratedValue
    private int cityId;

    @Column(length = 20, nullable = false)
    private String cityName;


    //in @OneToMany & @ManyToMany : default fetch strategy will be LAZY
    //but to convert it into Eager you can do it using Fetch

    //One city can have multiple theatres : one to many
//    @OneToMany //result in creation of new additional mapping table
    @OneToMany(mappedBy = "city", fetch = FetchType.EAGER)
    //we are telling that city and theatre are already mapped by city table(city_id)
    private Set<Theatre> theatres;

    public City() {}

    public City(int cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public City(String cityName) {
        this.cityName = cityName;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "City{" + "cityId=" + cityId + ", cityName='" + cityName + '\'' + '}';
    }
}