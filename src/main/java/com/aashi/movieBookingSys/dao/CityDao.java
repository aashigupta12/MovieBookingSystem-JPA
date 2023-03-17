package com.aashi.movieBookingSys.dao;


import com.aashi.movieBookingSys.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City, Integer> {
    public City findByCityName(String cityName);
}