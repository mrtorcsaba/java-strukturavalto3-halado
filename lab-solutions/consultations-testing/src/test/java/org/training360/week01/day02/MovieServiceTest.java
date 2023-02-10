package org.training360.week01.day02;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MovieServiceTest {

    @Mock
    MovieRepository movieRepository;

    @InjectMocks
    MovieService movieService;

//    @BeforeEach
//    void init(){
//        movieService.addMovie(new Movie("Titanic", LocalDate.of(1997,12,12),120,Genre.DRAMA));
//        movieService.addMovie(new Movie("Jurassic Park", LocalDate.of(1993,12,12),119,Genre.ACTION));
//        movieService.addMovie(new Movie("Spiderman", LocalDate.of(2022,12,12),134,Genre.DRAMA));
//        movieService.addMovie(new Movie("Dumb and Dumber", LocalDate.of(1994,12,12),92,Genre.COMEDY));
//    }

    @Test
    void testAddMovie(){

        movieService.addMovie(new Movie("Forest Gump", LocalDate.of(1994,12,12),121,Genre.DRAMA));

        verify(movieRepository).saveMovie(argThat(m->m.getTitle().equals("Forest Gump")));
    }

    @Test

    void testAddMovieWrongDate(){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()->
                        movieService.addMovie(new Movie("Forest Gump", LocalDate.of(1910,12,31),121,Genre.DRAMA)))
                .withMessage("Date is not correct: 1910-12-31");

        verify(movieRepository,never()).saveMovie(any());
    }

    @Test
    void testFindByTitle(){
      when(movieRepository.findByTitle(anyString()))
              .thenReturn(new Movie("Jurassic Park", LocalDate.of(1993,12,12),119,Genre.ACTION));

      Movie movie = movieService.findByTitle("Jurassic Park");

      assertEquals(119, movie.getLength());
      assertEquals("Jurassic Park", movie.getTitle());

      verify(movieRepository).findByTitle(argThat(m->m.equals("Jurassic Park")));

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