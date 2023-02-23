package com.driver;

import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie){
        movieRepository.addMovie(movie);
    }

    public void addDirector(Director director){
        movieRepository.addDirector(director);
    }

    public void addMovieDirectorPair(String movie_name, String director_name){
        movieRepository.addMovieDirectorPair(movie_name, director_name);
    }

    public Movie getMovie(String movie_name){
        return movieRepository.getmovie(movie_name);
    }

    public Director getDirector(String director_name){
        return movieRepository.getdirector(director_name);
    }

    public List<String> getAllDirectorMovies(String director_name){
        return movieRepository.getListOfDirectorMovies(director_name);
    }

    public List<String> getAllMovies(){
        return movieRepository.getListOfAllMovies();
    }

    public void deleteDirectorAndHisMovies(String director_name){
        movieRepository.DeleteDirector(director_name);
    }

    public void deleteAllDirectorsAndTheirMovies(){
        movieRepository.DeleteAllDirectorsAndTheirMovies();
    }
}
