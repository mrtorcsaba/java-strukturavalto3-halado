package org.training360.week01.day02;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class MovieRepository {


    private JdbcTemplate jdbcTemplate;

    public MovieRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public void saveMovie(Movie movie){
        jdbcTemplate.update("insert into movies (title, release_date,length,genre) values(?,?,?,?)",
                movie.getTitle(),
                movie.getReleaseDate(),
                movie.getLength(),
                movie.getGenre());
    }

    public Movie findByTitle(String title){
        return jdbcTemplate.queryForObject("select * from movies where title=?",
                (rs,rw)->new Movie(rs.getLong("id"),rs.getString("title"),rs.getDate("release_date").toLocalDate(),rs.getInt("length"), Genre.valueOf(rs.getString("genre"))));
    }

}
