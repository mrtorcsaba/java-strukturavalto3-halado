package org.training360.week01.day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {

    MovieService movieService = new MovieService();

    @BeforeEach
    void init(){
        movieService.addMovie(new Movie("Titanic", LocalDate.of(1997,12,12),120,Genre.DRAMA));
        movieService.addMovie(new Movie("Jurassic Park", LocalDate.of(1993,12,12),119,Genre.ACTION));
        movieService.addMovie(new Movie("Spiderman", LocalDate.of(2022,12,12),134,Genre.DRAMA));
        movieService.addMovie(new Movie("Dumb and Dumber", LocalDate.of(1994,12,12),92,Genre.COMEDY));
    }

    @Test
    void testAddMovie(){
        MovieService movieService = new MovieService();

        movieService.addMovie(new Movie("Forest Gump", LocalDate.of(1994,12,12),121,Genre.DRAMA));

        assertThat(movieService.getMovies())
                .hasSize(1)
                .extracting(Movie::getTitle)
                .contains("Forest Gump");
    }

    @Test
    void testAddMovieWrongDate(){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()->
                        movieService.addMovie(new Movie("Forest Gump", LocalDate.of(1910,12,31),121,Genre.DRAMA)))
                .withMessage("Date is not correct: 1910-12-31");
    }

    @Test
    void testFindByTitle(){
        Movie movie = movieService.findByTitle("Spiderman");

        assertThat(movie.getTitle()).isEqualTo("Spiderman");
        assertThat(movie.getLength()).isEqualTo(134);

     
    }

    @Test
    void testFindMoviesAfterDate(){
        List<Movie> result = movieService.findMoviesAfterDate(LocalDate.of(1994,12,13));

        assertThat(result)
                .hasSize(2)
                .extracting(Movie::getTitle)
                .containsExactly("Titanic","Spiderman");
    }


}