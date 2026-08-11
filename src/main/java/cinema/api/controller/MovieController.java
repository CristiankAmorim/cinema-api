package cinema.api.controller;

import cinema.api.dto.MovieRequestDto;
import cinema.api.dto.MovieResponseDto;
import cinema.api.model.Movie;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cinema.api.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieResponseDto>> getAllMovies() {
        return ResponseEntity.ok(movieService.showAllMovies());
    }

    @GetMapping("/{title}")
    public ResponseEntity<MovieResponseDto> getMovieByTitle(@RequestParam("title") String title) {
        return ResponseEntity.ok(movieService.searchMovieByName(title));
    }

    @PostMapping
    public ResponseEntity<MovieResponseDto> addMovie(@RequestBody MovieRequestDto requestDto) {
        return ResponseEntity.ok(movieService.saveMovieAtList(requestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponseDto> updateMovie(@PathVariable Long id, @RequestBody MovieRequestDto requestDto) {
        return ResponseEntity.ok(movieService.updateMovie(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovieById(id);
        return ResponseEntity.ok().build();
    }

}
