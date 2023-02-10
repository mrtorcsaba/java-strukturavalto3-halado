package org.training360.week01.day02;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MovieService {

    private AtomicLong idGenerator = new AtomicLong();
    private static LocalDate MIN_DATE = LocalDate.of(1911,1,1);

    private List<Movie> movies = new ArrayList<>();

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void addMovie(Movie movie){
        if(!checkDate(movie)){
            throw new IllegalArgumentException("Date is not correct: "+movie.getReleaseDate());
        }
        movieRepository.saveMovie(movie);
    }


    private boolean checkDate(Movie movie){
        return movie.getReleaseDate().isAfter(MIN_DATE);
    }


    public Movie findByTitle(String title){
        return movieRepository.findByTitle(title);
    }

    public List<Movie> findMoviesAfterDate(LocalDate date){
        return movies.stream()
                .filter(m->m.getReleaseDate().isAfter(date))
                .collect(Collectors.toList());
    }

    public Map<Genre,List<Movie>> groupMoviesByGenreStream(){
        return movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre));
    }

    public Map<Genre,List<Movie>> groupMoviesByGenre(){
        Map<Genre, List<Movie>> result = new HashMap<>();
        for (Movie actual: movies) {
            if(!result.containsKey(actual.getGenre())){
                result.put(actual.getGenre(),new ArrayList<>());
            }
            result.get(actual.getGenre()).add(actual);
        }
        return result;
    }

    public List<Movie> getMovies() {
        return new ArrayList<>(movies);
    }
}
