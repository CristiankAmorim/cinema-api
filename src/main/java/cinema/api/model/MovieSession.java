package cinema.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity(name = "tb_session")
@Data
public class MovieSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String room;
    private LocalDateTime sessionTime;

    @ManyToOne
    private Movie movie;

}
