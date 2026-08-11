package cinema.api.controller;

import cinema.api.dto.MovieRequestDto;
import cinema.api.dto.MovieResponseDto;
import cinema.api.model.Movie;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<MovieResponseDto>> getAllMovies() {
        return ResponseEntity.ok(movieService.showAllMovies());
    }

    @PostMapping
    public ResponseEntity<MovieResponseDto> addMovie(@RequestBody MovieRequestDto requestDto) {
        return ResponseEntity.ok(movieService.saveMovieAtList(requestDto));
    }

    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        return movieService.updateMovie(id, movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }

}
