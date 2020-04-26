package com.serdarsenturk;

import java.security.KeyException;
import java.util.ArrayList;
import java.util.HashMap;

public class Actor {
    private int id;
    private String name;
    private int age;
    private HashMap<Integer, Movie> movies;

    public Actor(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
        this.movies = new HashMap<>();
    }

    public String getActorName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public int getId(){
        return this.id;
    }

    public Iterable<Movie> getMovies(){
        var actorsDicValues = this.movies.values();
        return new ArrayList<>(actorsDicValues);
    }

    public void addMovies(Movie movie) throws KeyException {
        if(movies.containsKey(movie.getId())){
            return;
        }
        this.movies.put(movie.getId(), movie);
        movie.addActor(this);
    }
}
