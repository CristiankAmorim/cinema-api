package cinema.api.controller;

import cinema.api.model.MovieSession;
import org.springframework.web.bind.annotation.*;
import cinema.api.service.MovieSessionService;

import java.util.List;

@RestController
@RequestMapping("/sessions")
public class MovieSessionController {
    private final MovieSessionService sessionService;

    public MovieSessionController(MovieSessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping
    public List<MovieSession> getAllSessions() {
        return sessionService.showAllSessions();
    }

    @PostMapping("/{movieId}")
    public MovieSession addSession(@PathVariable Long movieId, @RequestBody MovieSession session) {
        return sessionService.saveNewSession(movieId, session);
    }
}
