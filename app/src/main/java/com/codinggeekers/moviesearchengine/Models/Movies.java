package com.codinggeekers.moviesearchengine.Models;

public class Movies {
    String movieName, movieDescription, movieImage, movieRating, movieLaunchDate;

    public Movies(String movieName, String movieDescription, String movieImage, String movieRating, String movieLaunchDate) {
        this.movieName = movieName;
        this.movieDescription = movieDescription;
        this.movieImage = movieImage;
        this.movieRating = movieRating;
        this.movieLaunchDate = movieLaunchDate;
    }

    public Movies() {
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

    public String getMovieImage() {
        return movieImage;
    }

    public void setMovieImage(String movieImage) {
        this.movieImage = movieImage;
    }

    public String getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(String movieRating) {
        this.movieRating = movieRating;
    }

    public String getMovieLaunchDate() {
        return movieLaunchDate;
    }

    public void setMovieLaunchDate(String movieLaunchDate) {
        this.movieLaunchDate = movieLaunchDate;
    }
}
