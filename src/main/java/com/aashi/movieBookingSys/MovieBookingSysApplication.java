package com.aashi.movieBookingSys;

import com.aashi.movieBookingSys.services.InitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class MovieBookingSysApplication {

	/**
	 * we need the logger object
	 * */
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieBookingSysApplication.class);

	public static void main(String[] args)  {
		ApplicationContext ctx = SpringApplication.run(MovieBookingSysApplication.class, args);

		LOGGER.debug("Writing for debug");
		LOGGER.info("Writing for info");
		LOGGER.warn("Writing for warn");
		LOGGER.error("Writing for error");
		//init service impl testing
		/**
		 * SERVICE LAYER
		 */
//		MovieService movieService = ctx.getBean(MovieService.class);
//		StatusDao statusDao = ctx.getBean(StatusDao.class);
//
//		Status status = new Status();
//		status.setStatusName("RELEASED!!");
//
//		//SAVE THE STTAUS
//		statusDao.save(status);
//
//		Movie movie = new Movie();
//		movie.setMovieName("Conjuring");
//		movie.setMovieDescription("Horror Movie");
//		movie.setTrailerUrl("trailer_url");
//		movie.setDuration(120);
//		movie.setReleaseDate(LocalDateTime.of(2023,3,16,6,6,6));
//		movie.setCoverPhotoUrl("cover-photo");
//		movie.setStatus(status);
//
//		Movie store = movieService.acceptMovieDetails(movie);
//		try{
//			Movie st = movieService.getMovieDetails(store.getMovieId());
//			System.out.println("st -->>>>>>>>>" + st);
//		} catch (MovieDetailsNotFoundException e){
//			System.out.println("not found");
//			e.printStackTrace();
//		}
//
//		UserService userService = ctx.getBean(UserService.class);
//		User user = new User();
//		user.setFirstName("Aashi");
//		user.setLastName("Gupta");
//		user.setDateOfBirth(LocalDateTime.of(2000,9,12,2,2,2));
//		user.setUsername("aashi12");
//		user.setPassword("#aashi12");
//
//		User user1 = new User();
//		user1.setFirstName("Tapan");
//		user1.setLastName("Kumar");
//		user1.setDateOfBirth(LocalDateTime.of(2000,3,12,2,2,2));
//		user1.setUsername("tapan");
//		user1.setPassword("#sigmarek");
//
//        try {
//			System.out.println("hi pehle");
//			User store2 = userService.acceptUserDetails(user);
//			userService.acceptUserDetails(user1);
//			System.out.println(userService.getUserDetails(store2.getUserId()));
//
//			System.out.println("hi2");
//		} catch(Exception e) {
//			System.out.println("Exception is " + e);
//		}
//
//		try{
//			User store3 = userService.getUserDetailsByUsername("aashi12");
//			System.out.println(store3);
//		} catch(UserDetailsNotFoundException u){
//			System.out.println("hi bye");
//		}
//
//		try{
//			user1.setUsername("sigmarek");
//			User store4 = userService.updateUserDetails(2,user1);
//		} catch (UserNameAlreadyExistException e) {
//			e.printStackTrace();
//		} catch (UserTypeDetailsNotFoundException e) {
//			e.printStackTrace();
//		} catch (UserDetailsNotFoundException e) {
//			e.printStackTrace();
//		}


		/**
		 * Data Access Layer
		 */
		//ex1
		//many to one & one to many
//		MovieDao movieDao = ctx.getBean(MovieDao.class);
//		MovieDao movieDao = (MovieDao) ctx.getBean("movieDao");

//		System.out.println("MovieDao: "+ movieDao);
//
//		CityDao cityDao = (CityDao) ctx.getBean(CityDao.class);
//		System.out.println("CityDao: " + cityDao);
//
//		/*
//		* I should be able to save the entity
//		* */
//		System.out.println("====Creating movie object ====");
//		Movie movie = new Movie();
//		movie.setMovieName("Pathaan");
//		movie.setMovieDescription("nice movie");
//		movie.setReleaseDate(LocalDateTime.of(2023, Month.MARCH,13,6,30,40,50000));
//		movie.setDuration(150);
//		movie.setCoverPhotoUrl("cover-photo-url");
//		movie.setTrailerUrl("trailer-url");
//
//		Movie movie1 = new Movie();
//		movie1.setMovieName("Mission Mangal");
//		movie1.setMovieDescription("great movie");
//		movie1.setReleaseDate(LocalDateTime.of(2023, Month.MARCH,13,8,30,40,50000));
//		movie1.setDuration(250);
//		movie1.setCoverPhotoUrl("cover-photo-url");
//		movie1.setTrailerUrl("trailer-url");
//		movieDao.save(movie1);
//
//		//		System.out.println("#### going to save now in db ####");
//		Movie savedObj = movieDao.save(movie);
//		System.out.println("saved object: " + savedObj);
//
//		List<Movie> ans = movieDao.findByDurationGreaterThanEqual(200);
//		List<Movie> ans2 = movieDao.findByDurationLessThan(200);
//
//		System.out.println("ans: ->.... " + ans);
//		System.out.println("ans2: ->.... " + ans2);

//		Movie savedObj1 = movieDao.save(movie1);
//		System.out.println(savedObj1);
//
//		//I should be able to find the movie, I am interested in;
//		Movie searchedMovie = movieDao.findById(2).get();
//		System.out.println("Searched movie: "+ searchedMovie);
//
//		//update
//		movie.setMovieDescription("Updated desc");
//		movieDao.save(movie);
//
//		//delete the movie:
//		movieDao.delete(searchedMovie);
//
//
//		Movie movie2 = new Movie();
//		//whether you provide id or not , it doesn't matter , since we set auto generated!
//		movie2.setMovieId(4);
//		movie2.setMovieName("Twilight");
//		movie2.setMovieDescription("amazing vampire movie");
//		movie2.setReleaseDate(LocalDateTime.of(2023, Month.MARCH,13,8,30,40,50000));
//		movie2.setDuration(250);
//		movie2.setCoverPhotoUrl("cover-photo-url");
//		movie2.setTrailerUrl("trailer-url");
//
//		movieDao.save(movie2);
//
//		List<Movie> searchedMovieByName = movieDao.findByMovieName("Pathaan");
//		System.out.println("SearchedMovieByName: "+ searchedMovieByName);
//
//		City city = new City();
//		city.setCityName("delhi");
//		System.out.println(city.getCityName());
//
//		City city1 = new City();
//		city1.setCityName("Ahmedabad");
//
//		cityDao.save(city);
//		cityDao.save(city1);
//		System.out.println(cityDao.findByCityName("Ahmedabad")); //case sensitve
//		System.out.println(cityDao.findById(2));
//



		//ex2 one to one
//		CarDao carDao = (CarDao) ctx.getBean(CarDao.class);
//		EngineDao engineDao = (EngineDao) ctx.getBean(EngineDao.class);
//
//		Engine engine = new Engine();
//		engine.setEngineName("Super Engine");
//
//		Engine savedEng = engineDao.save(engine);
//		System.out.println(savedEng);
//
//		Car car = new Car();
//		car.setCarName("Audi");
//		car.setEngine(engine);
//
//		Car savedCar = carDao.save(car);
//		System.out.println(savedCar);

		System.out.println("hello spring boot!");
	}

	//this is a way to execute something in the very beginning
	//when application is starting up
	@Bean
	CommandLineRunner init(InitService initService){
		return args -> {
			System.out.println("this will be executed as soon as the application is started");
			initService.init();
		};
	}
}
