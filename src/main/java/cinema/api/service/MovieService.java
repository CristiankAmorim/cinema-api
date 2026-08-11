package cinema.api.service;

import cinema.api.dto.MovieRequestDto;
import cinema.api.dto.MovieResponseDto;
import cinema.api.mapper.MovieMapper;
import cinema.api.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cinema.api.repository.MovieRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    @Autowired
    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    public List<MovieResponseDto> showAllMovies() {
        return movieMapper.toListResponseDto(movieRepository.findAll());
    }

    public MovieResponseDto saveMovieAtList(MovieRequestDto requestDto) {
        return movieMapper.toResponeDto(
                movieRepository.save(
                        movieMapper.toMovie(requestDto)
                ));

    }

    public Movie updateMovie(Long id, Movie movieToChange) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));

        movie.setTitle(movieToChange.getTitle());
        movie.setGender(movieToChange.getGender());
        movie.setDurationMinutes(movieToChange.getDurationMinutes());

        return movieRepository.save(movie);
    }

    public void deleteMovieById(Long id) {
        if(!movieRepository.existsById(id)) {
            throw new RuntimeException("Filme não encontrado");
        }
        movieRepository.deleteById(id);
    }

}
