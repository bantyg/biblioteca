package com.twu.biblioteca;

public class Movie implements Item {

    private final String title;
    private final String director;
    private final int releaseYear;
    private final int rating;

    public Movie(String title, String director, int releaseYear, int rating) {

        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (rating != movie.rating) return false;
        if (releaseYear != movie.releaseYear) return false;
        if (!director.equals(movie.director)) return false;
        if (!title.equals(movie.title)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + director.hashCode();
        result = 31 * result + releaseYear;
        result = 31 * result + rating;
        return result;
    }

    @Override
    public String getHeader() {
        return "Title - Director - year of Release - Rating\n";
    }

    @Override
    public String toString() {
        return
                 title + '-' +
                 director + '-' +
                 + releaseYear +'-'
                 + rating ;
    }

    @Override
    public boolean isTitleEquals(String title) {
        return this.title.equals(title);
    }
}
