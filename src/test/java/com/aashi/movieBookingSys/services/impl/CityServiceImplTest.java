package com.aashi.movieBookingSys.services.impl;

import com.aashi.movieBookingSys.Exceptions.CityDetailsNotFoundException;
import com.aashi.movieBookingSys.dao.CityDao;
import com.aashi.movieBookingSys.entities.City;
import com.aashi.movieBookingSys.services.implementation.CityServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.concurrent.Delayed;

@SpringBootTest
public class CityServiceImplTest {

    /**
     *
     * CityServiceImpl -> CityDao
     *
     * Unit test:
     * 1. create mock of CityDao
     * 2. Create CityServiceImpl using Mocked CityDao
     * 3. Provide the functionality of CityDao
     * */
    @Mock
    private CityDao cityDao;

    @InjectMocks
    private CityServiceImpl cityService;


    City city;
    @BeforeEach
    public void addFunctionalityToMockedCityDao(){
        Mockito.when(cityDao.save(new City("Delhi")))
                .thenReturn(new City(1, "Delhi"));

        //Mock the functionality for get
        Mockito.when(cityDao.findById(2))
                .thenReturn(Optional.of(new City(2, "Mumbai")));
        //mock func of save also
        Mockito.when(cityDao.save(new City(2, "Mumbai_New")))
                .thenReturn(new City(2, "Mumbai_New"));
    }

    /**
     * acceptCityDetails
     * */
    @Test
    public void testAcceptCityDetails(){
        /**
         * test if cityServiceImpl is able to save city details
         * */

        //implemented equals method in City entity to make obj equal for same city name
        City city = new City("Delhi");
        City savedCity = cityService.acceptCityDetails(city);
        System.out.println(savedCity);

        Assertions.assertEquals(1, savedCity.getCityId());
        Assertions.assertNotNull(savedCity);

    }

    /**
     * acceptMultipleCityDetails
     */

    /**
     *  updateCityDetails
     */
    @Test
    public void updateCityDetails() throws CityDetailsNotFoundException {
        City city = new City("Mumbai_New");
        City updatedCity = cityService.updateCityDetails(2, city);

        System.out.println(updatedCity);

        Assertions.assertNotNull(updatedCity);
        Assertions.assertEquals(2, updatedCity.getCityId());
    }


    /**
     *  getCityDetails
     */

    /**
     *  getCityDetailsByCityName
     */

    /**
     * deleteCity
     */


    /**
     * getAllCityDetails
     */


}
