package cinema.api.service;

import cinema.api.model.Movie;
import org.aspectj.weaver.Utils;
import org.springframework.stereotype.Service;
import cinema.api.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> showAllMovies() {
        return movieRepository.findAll();
    }

    public Movie saveMovieAtList(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Long id, Movie movieToChange) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));

        movie.setTitle(movieToChange.getTitle());
        movie.setGender(movieToChange.getGender());
        movie.setDurationMinutes(movieToChange.getDurationMinutes());

        return movieRepository.save(movie);
    }

    public void deleteMovie(Long id) {
        if(!movieRepository.existsById(id)) {
            throw new RuntimeException("Filme não encontrado");
        }

        movieRepository.deleteById(id);
    }

}
