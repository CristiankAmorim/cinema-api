package cinema.api.controller;

import cinema.api.dto.MovieSessionRequestDto;
import cinema.api.dto.MovieSessionResponseDto;
import cinema.api.model.MovieSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cinema.api.service.MovieSessionService;

import java.util.List;

@RestController
@RequestMapping("/sessions")
@RequiredArgsConstructor
public class MovieSessionController {
    private final MovieSessionService sessionService;

    @GetMapping
    public ResponseEntity<List<MovieSessionResponseDto>> getAllSessions() {
        return ResponseEntity.ok(sessionService.showAllSessions());
    }

    @PostMapping
    public ResponseEntity<MovieSessionResponseDto> addSession(@RequestBody MovieSessionRequestDto requestDto) {
        return ResponseEntity.ok(sessionService.saveNewSession(requestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieSessionResponseDto> updateSession(@PathVariable Long id, @RequestBody MovieSessionRequestDto requestDto) {
        return ResponseEntity.ok(sessionService.updateSession(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSession(@PathVariable Long id) {
        sessionService.deleSessionById(id);
        return ResponseEntity.ok().build();
    }
}
