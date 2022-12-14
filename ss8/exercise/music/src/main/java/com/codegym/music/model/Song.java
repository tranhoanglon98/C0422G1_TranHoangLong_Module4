package com.codegym.music.model;

import javax.persistence.*;

@Entity
@Table(name = "song")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String artist;
    private String type;
    private String path;

    public Song() {
    }

    public Song(int id, String name, String artist, String type, String path) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.type = type;
        this.path = path;
    }

    public Song(String name, String artist, String type, String path) {
        this.name = name;
        this.artist = artist;
        this.type = type;
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
