package cinema.api.service;

import cinema.api.model.Movie;
import cinema.api.model.MovieSession;
import org.springframework.stereotype.Service;
import cinema.api.repository.MovieRepository;
import cinema.api.repository.MovieSessionRepository;

import java.util.List;

@Service
public class MovieSessionService {
    private final MovieSessionRepository sessionRepository;
    private final MovieRepository movieRepository;

    public MovieSessionService(MovieSessionRepository sessionRepository, MovieRepository movieRepository) {
        this.sessionRepository = sessionRepository;
        this.movieRepository = movieRepository;
    }

    public List<MovieSession> showAllSessions() {
        return sessionRepository.findAll();
    }

    public MovieSession saveNewSession(Long movieId, MovieSession session) {
        Movie movie = movieRepository.findById(movieId).orElseThrow();
        session.setMovie(movie);
        return sessionRepository.save(session);
    }

}
