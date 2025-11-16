package cinema.api.dto;

import cinema.api.model.Movie;
import cinema.api.model.MovieSession;

import java.time.LocalDateTime;

public class MovieSessionDto {

    private long id;
    private String room;
    private LocalDateTime sessionTime;
    private Movie movie;

    public MovieSessionDto() {
    }

    public MovieSessionDto(long id, String room, LocalDateTime sessionTime, Movie movie) {
        this.id = id;
        this.room = room;
        this.sessionTime = sessionTime;
        this.movie = movie;
    }

    public MovieSessionDto(MovieSession movieSession) {
        this.id = movieSession.getId();
        this.room = movieSession.getRoom();
        this.sessionTime = movieSession.getSessionTime();
        this.movie = movieSession.getMovie();
    }
}
