package cinema.api.service;

import cinema.api.model.Movie;
import org.springframework.stereotype.Service;
import cinema.api.repository.MovieRepository;

import java.util.List;

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

}
