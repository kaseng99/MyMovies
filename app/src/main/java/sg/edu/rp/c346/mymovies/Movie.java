package sg.edu.rp.c346.mymovies;

import java.util.Calendar;

public class Movie {
private String title;
private String year;
private String rated;
private String genre;
private Calendar watched_on;
private String in_theatre;
private String description;
private int rating;

    public Movie(String title, String year, String rated, String genre, Calendar watched_on, String in_theatre, String description ,int rating) {
        this.title = title;
        this.year = year;
        this.rated = rated;
        this.genre = genre;
        this.watched_on = watched_on;
        this.in_theatre = in_theatre;
        this.description = description;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getRated() {
        return rated;
    }

    public String getGenre() {
        return genre;
    }

    public Calendar getWatched_on() {
        return watched_on;
    }

    public String getIn_theatre() {
        return in_theatre;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setWatched_on(Calendar watched_on) {
        this.watched_on = watched_on;
    }

    public void setIn_theatre(String in_theatre) {
        this.in_theatre = in_theatre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
