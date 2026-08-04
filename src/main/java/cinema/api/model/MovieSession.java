package cinema.api.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "tb_session")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String room;
    private LocalDateTime sessionTime;

    @ManyToOne
    private Movie movie;

}
