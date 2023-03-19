package com.aashi.movieBookingSys.services.implementation;

import com.aashi.movieBookingSys.Exceptions.MovieTheatreDetailsNotFoundException;
import com.aashi.movieBookingSys.Exceptions.UserDetailsNotFoundException;
import com.aashi.movieBookingSys.Exceptions.UserNameAlreadyExistException;
import com.aashi.movieBookingSys.Exceptions.UserTypeDetailsNotFoundException;
import com.aashi.movieBookingSys.dao.*;
import com.aashi.movieBookingSys.entities.*;
import com.aashi.movieBookingSys.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class InitServiceImpl implements InitService {
    @Autowired //city dao ko inject karne ke liye
//    private CityDao cityDao;
    private CityService cityService;
    @Autowired
    private UserTypeDao userTypeDao;
    @Autowired
    private StatusService statusService;
    @Autowired
    private UserService customerService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private TheatreService theatreService;
    @Autowired
    private MovieTheatreService movieTheatreService;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private LanguageDao languageDao;

    /**
     * COOKING DATA
     *
     * Define and initialize together
     *
     * int i ;  define
     * i = 5; assigning
     *
     * int i = 5; define & assign both at same time
     **/
    List<Status> statuses = Arrays.asList(new Status("Upcoming"),new Status("Released"),new Status("Blocked"));
    List<UserType> userTypes = Arrays.asList(new UserType("Customer"),new UserType("Admin"));
    List<Language> languages = Arrays.asList(new Language("English"), new Language("Hindi"), new Language("Bengali"));
    List<City> cities = Arrays.asList(new City("Delhi"),new City("Bangalore"),new City("Kolkata"),new City("Mumbai"));


    @Override
    public void init() throws UserNameAlreadyExistException, UserTypeDetailsNotFoundException, MovieTheatreDetailsNotFoundException, UserDetailsNotFoundException {
        /**
         * write the logic to store data inside the database in diff tables
         * */

        /**
        * add cities
        * */
        createCities();

        /**
         * add user Types
         * */
        createUserTypes();

        /**
         * add statuses
         * */

        createStatuses();

        /**
         * add movies
         * */
        createMovies();
        /**
         * add USERS
         * */
        createCustomer();

        /**
         * add language
         * */
//        createLanguages();

        /**
         * add theatres
         * */
//        createTheatre();


        /**
         * add movie theatre
         * */
//        MovieTheatre movieTheatre1 = new MovieTheatre();
//        movieTheatre1.setMovie();
//        movieTheatre1.setTheatre(t);

        /**
         * add bookings
         * */
//        Booking booking = new Booking();
//        booking.setBookingDate(LocalDateTime.of(2019, 1, 8, 0, 10));
////        booking.setUser(customer);
//        booking.setNoOfSeats(150);
//        booking.setMovieTheatre(movieTheatre1);
//        bookingService.acceptBookingDetails(booking);
    }

    private void createCustomer() throws UserNameAlreadyExistException, UserTypeDetailsNotFoundException {
        User customer = new User();
        customer.setFirstName("Aashi");
        customer.setLastName("Gupta");
        customer.setUsername("aashi@123");
        customer.setPassword("aashi@1234");
        customer.setDateOfBirth(LocalDateTime.of(2000,9,12,10,8,8));
        customer.setUserType(userTypes.get(0));
//        Language language = new Language("Wakandan");
//        customer.setLanguage(language);
        customerService.acceptUserDetails(customer);
    }


//    private void createTheatre() {
//        Theatre theatre1 = new Theatre();
//        theatre1.setTheatreName("Dlf Cineplex");
//        theatre1.setTicketPrice(650);
//        theatre1.setCity(cities.get(0));
//        theatreService.acceptTheatreDetails(theatre1);
//
//        Theatre theatre2 = new Theatre();
//        theatre2.setTheatreName("Cinepolis Multiplex");
//        theatre2.setTicketPrice(600);
//        theatre2.setCity(cities.get(1));
//        theatreService.acceptTheatreDetails(theatre2);
//    }



    private void createLanguages() {
        languages.forEach(language -> languageDao.save(language));
    }

    private void createMovies() {
        //because I want tom create 2 movies
        Movie movie1 = new Movie();
        movie1.setMovieName("John Wick");
        movie1.setTrailerUrl("Url1");
        movie1.setStatus(statuses.get(1));
        movie1.setMovieDescription("Desc1");
        movie1.setDuration(120);
        movie1.setReleaseDate(LocalDateTime.of(2023,3,18,6,7,8));
        movie1.setCoverPhotoUrl("cover url 1");

        movie1 = movieService.acceptMovieDetails(movie1);

        Movie movie2 = new Movie();
        movie2.setMovieName("John Wick 2");
        movie2.setTrailerUrl("Url2");
        movie2.setStatus(statuses.get(0));
        movie2.setMovieDescription("Desc2");
        movie2.setDuration(150);
        movie2.setReleaseDate(LocalDateTime.of(2024,3,18,6,7,8));
        movie2.setCoverPhotoUrl("cover url 2");

        movieService.acceptMovieDetails(movie2);
    }

    //for saving the statuses
    private void createStatuses() {
        statuses.forEach(status -> statusService.acceptStatusDetails(status));
    }

    private void createUserTypes() {
        userTypes.forEach(userType ->
                userTypeDao.save(userType));
    }

    private void createCities() {
        //forEach: iterate through each city one after the another
        //the using city dao to save it into database

        //can use both ways to save
        //but which is a better way?
//        cities.forEach(city -> cityDao.save(city));
        cities.forEach(city -> cityService.acceptCityDetails(city));
    }
}
