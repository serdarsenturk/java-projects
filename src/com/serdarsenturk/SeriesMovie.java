package com.serdarsenturk;

import java.security.KeyException;
import java.util.HashMap;

public class SeriesMovie extends Movie {
    private int seasons;
    private int episodes;
    private String title;

    public  SeriesMovie(int id, String name, Genre genre, int seasons, int episodes, String title, String author){
        super(id, name, genre, title, author);
        this.episodes = episodes;
        this.seasons = seasons;
    }

    public int getSeasons(){
        return this.seasons;
    }

    public int getEpisodes(){return this.episodes;}

    public String getTitle(){
        return "Series Film" + this.title;
    }

    @Override
    public void addActor(Actor actor) throws KeyException {
        if(isActorExists(actor)){
            System.out.println("Actor with name: " + actor.getActorName() + " is added to SeriesMovie");
        }

        super.addActor(actor);
    }
}
