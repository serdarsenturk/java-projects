package com.serdarsenturk;

import java.security.KeyException;
import java.util.*;

public class Movie{
    private int id;
    private String name;
    private int price;
    private HashMap<Integer, Comment> comments;
    private HashMap<Integer, Actor> actors;
    private Genre genre;

    public Movie(int id, String name, Genre genre){
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.comments = new HashMap<>();
        this.actors = new HashMap<>();
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public int getPrice(){
        return price;
    }

    public int getCommentSize(){
        return this.comments.size();
    }

    public Iterable<Comment> getComments(){
        var commentsDictValues = this.comments.values();
        return new ArrayList<>(commentsDictValues);
    }

    public void addComment(Comment comment) throws KeyException {
        if(this.comments.containsKey(comment.getId())){
            throw new KeyException("Key zaten var");
        }

        this.comments.put(comment.getId(), comment);
    }

    public void updateComment(Comment comment) throws KeyException {
        if(!this.comments.containsKey(comment.getId())){
            throw new KeyException("Key yok");
        }

        this.comments.put(comment.getId(), comment);
    }
    public Iterable<Actor> getActors(){
        var actorsDictValues = this.actors.values();
        return new ArrayList<>(actorsDictValues);
    }

    public void addActor(Actor actor) throws KeyException {
        if(this.actors.containsKey(actor.getId())){
            return;
        }
        this.actors.put(actor.getId(), actor);
        actor.addMovies(this);
    }

    public void setPrice(int price){
        this.price = price;
    }

    public int getNextMinimumPrice(){
        return this.price + this.price * 10 / 100;
    }
}
