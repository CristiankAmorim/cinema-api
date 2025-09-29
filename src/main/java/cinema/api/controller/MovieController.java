package cinema.api.controller;

import cinema.api.model.Movie;
import org.springframework.web.bind.annotation.*;
import cinema.api.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.showAllMovies();
    }

    @PostMapping()
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.saveMovieAtList(movie);
    }

}
