package com.aashi.movieBookingSys.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
//to change the table name in database
//@Table(name="Movie_Table")
public class Movie {
    @Id
    //@Id indicates that movieId will be the primary field
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int movieId;
    @Column(length = 50, nullable = false, unique = true)
    private String movieName;
    @Column(name="movie_desc",length=500,nullable = false)
    private String movieDescription;
    private LocalDateTime releaseDate;
    private int duration;
    private String coverPhotoUrl;
    private String trailerUrl;



    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

//    @JoinTable(name= "movie_theatre",
//            joinColumns = @JoinColumn(name="movie_id"), //same entity
//            inverseJoinColumns = @JoinColumn(name= "theatre_id")) //diff entity
//    @ManyToMany
//    private List<Theatre> theatres;

    //parameterized constructor
//    public Movie(int movieId, String movieName, String movieDescription, LocalDateTime releaseDate, int duration, String coverPhotoUrl, String trailerUrl, Status status, List<Theatre> theatres) {
//        this.movieId = movieId;
//        this.movieName = movieName;
//        this.movieDescription = movieDescription;
//        this.releaseDate = releaseDate;
//        this.duration = duration;
//        this.coverPhotoUrl = coverPhotoUrl;
//        this.trailerUrl = trailerUrl;
//        this.status = status;
//        this.theatres = theatres;
//    }
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

//    public List<Theatre> getTheatres() {
//        return theatres;
//    }
//
//    public void setTheatres(List<Theatre> theatres) {
//        this.theatres = theatres;
//    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getCoverPhotoUrl() {
        return coverPhotoUrl;
    }

    public void setCoverPhotoUrl(String coverPhotoUrl) {
        this.coverPhotoUrl = coverPhotoUrl;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    //to get meaningful output
    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", movieDescription='" + movieDescription + '\'' +
                ", releaseDate=" + releaseDate +
                ", duration=" + duration +
                ", coverPhotoUrl='" + coverPhotoUrl + '\'' +
                ", trailerUrl='" + trailerUrl + '\'' +
                '}';
    }
}
