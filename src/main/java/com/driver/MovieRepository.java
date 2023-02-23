package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {

    HashMap<String , Movie> Moviemap;
    HashMap<String , Director> Directormap;
    HashMap<String , List<String>> MovieDirectorPair;
    MovieRepository(){
        Moviemap = new HashMap<String , Movie>();
        Directormap = new HashMap<String , Director>();
        MovieDirectorPair = new HashMap<String, List<String>>();
    }

    public void addMovie(Movie movie){
        Moviemap.put(movie.getName(), movie);
    }

    public void addDirector(Director director){
        Directormap.put(director.getName(), director);
    }

    public void addMovieDirectorPair(String  movie_name, String  director_name){
        if(Moviemap.containsKey(movie_name) && Directormap.containsKey(director_name)){
            Moviemap.put(movie_name, Moviemap.get(movie_name));
            Directormap.put(director_name, Directormap.get(director_name));
            List<String> currmovies =  new ArrayList<>();
            if(MovieDirectorPair.containsKey(director_name)){
                currmovies = MovieDirectorPair.get(director_name);
            }
            currmovies.add(movie_name);
            MovieDirectorPair.put(director_name, currmovies);
        }
    }

    public Movie getmovie(String movie_name){
        return Moviemap.get((movie_name));
    }

    public Director getdirector(String director_name){
        return Directormap.get((director_name));
    }

    public List<String> getListOfDirectorMovies(String director_name){
        return MovieDirectorPair.get(director_name);
    }

    public List<String> getListOfAllMovies(){
        return new ArrayList<>(Moviemap.keySet());
    }

    public void DeleteDirector(String director_name){
        List<String> movies = new ArrayList<>();
        if(MovieDirectorPair.containsKey(director_name)){
            Directormap.remove(director_name);
            movies = MovieDirectorPair.get(director_name);
            for(String movie : movies){
                Moviemap.remove(movie);
            }
        }
        MovieDirectorPair.remove(director_name);
    }

    public void DeleteAllDirectorsAndTheirMovies(){
        for(Map.Entry<String, Director> name : Directormap.entrySet()){
            DeleteDirector(name.getKey());
        }
        Directormap.clear();
        MovieDirectorPair.clear();
    }
}
