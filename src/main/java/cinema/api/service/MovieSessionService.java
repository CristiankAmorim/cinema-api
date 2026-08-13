package cinema.api.service;

import cinema.api.dto.MovieSessionRequestDto;
import cinema.api.dto.MovieSessionResponseDto;
import cinema.api.mapper.MovieSessionMapper;
import cinema.api.model.Movie;
import cinema.api.model.MovieSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import cinema.api.repository.MovieRepository;
import cinema.api.repository.MovieSessionRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieSessionService {

    private final MovieSessionRepository sessionRepository;
    private final MovieRepository movieRepository;
    private final MovieSessionRepository movieSessionRepository;
    private final MovieSessionMapper movieSessionMapper;

    @Transactional(readOnly = true)
    public List<MovieSessionResponseDto> showAllSessions() {
        return movieSessionMapper.toListResponseDto(sessionRepository.findAll());
    }

    @Transactional
    public MovieSessionResponseDto saveNewSession(MovieSessionRequestDto requestDto) {
        Movie movie = movieRepository.findById(requestDto.getMovieId())
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));
        MovieSession movieSession = movieSessionMapper.toMovieSession(requestDto);
        movieSession.setMovie(movie);

        MovieSession savedSession = movieSessionRepository.save(movieSession);
        return movieSessionMapper.toResponseDto(savedSession);
    }

    @Transactional
    public MovieSessionResponseDto updateSession(Long id, MovieSessionRequestDto requestDto) {
        MovieSession session = sessionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sessão não encontrada"));

        if (requestDto.getSessionTime() != null) {
            session.setSessionTime(requestDto.getSessionTime());
        }
        if(requestDto.getRoom() != null) {
            session.setRoom(requestDto.getRoom());
        }

        if(requestDto.getMovieId() != null) {
            Movie movie = movieRepository.findById(requestDto.getMovieId())
                    .orElseThrow(() -> new RuntimeException("Filme não encontrado"));
            session.setMovie(movie);
        }

        MovieSession updateSession = movieSessionRepository.save(session);

        return movieSessionMapper.toResponseDto(updateSession);
    }

    @Transactional
    public void deleSessionById(Long id) {
        if(!sessionRepository.existsById(id)) {
            throw new RuntimeException("Sessão não encontrada");
        }

        sessionRepository.deleteById(id);
    }

}
