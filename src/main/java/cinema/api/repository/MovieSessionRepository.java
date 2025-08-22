package cinema.api.repository;

import cinema.api.model.MovieSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieSessionRepository extends JpaRepository<MovieSession, Long> {
}
