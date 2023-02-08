package org.training360.week01.day02;

import java.time.LocalDate;

public class Movie {

    private Long id;
    private String title;
    private LocalDate releaseDate;
    private int length;
    private Genre genre;

    public Movie(Long id, String title, LocalDate releaseDate, int length, Genre genre) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.length = length;
        this.genre = genre;
    }

    public Movie(String title, LocalDate releaseDate, int length, Genre genre) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.length = length;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public int getLength() {
        return length;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
