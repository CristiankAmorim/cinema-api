package cinema.api.service;

import cinema.api.dto.MovieRequestDto;
import cinema.api.dto.MovieResponseDto;
import cinema.api.mapper.MovieMapper;
import cinema.api.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import cinema.api.repository.MovieRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

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

    public MovieResponseDto updateMovie(Long id, MovieRequestDto requestDto) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));

        if(requestDto.getTitle() != null) {
            movie.setTitle(requestDto.getTitle());
        }

        if(requestDto.getGender() != null) {
            movie.setGender(requestDto.getGender());
        }

        if(requestDto.getDurationMinutes() != null) {
            movie.setDurationMinutes(requestDto.getDurationMinutes());
        }

        Movie updateMovie = movieRepository.save(movie);

        return movieMapper.toResponeDto(updateMovie);
    }

    public void deleteMovieById(Long id) {
        if(!movieRepository.existsById(id)) {
            throw new RuntimeException("Filme não encontrado");
        }
        movieRepository.deleteById(id);
    }

}
