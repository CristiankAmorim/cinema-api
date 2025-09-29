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

    public MovieSession updateSession(Long id, MovieSession sessionToChange) {
        MovieSession session = sessionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sessão não encontrada"));

        session.setMovie(sessionToChange.getMovie());
        session.setRoom(sessionToChange.getRoom());
        session.setSessionTime(sessionToChange.getSessionTime());

        return sessionRepository.save(session);
    }

    public void deleSession(Long id) {
        if(!sessionRepository.existsById(id)) {
            throw new RuntimeException("Sessão não encontrada");
        }

        sessionRepository.deleteById(id);
    }

}
