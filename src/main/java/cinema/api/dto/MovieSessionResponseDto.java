package cinema.api.dto;

import cinema.api.model.Movie;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieSessionResponseDto {

    @JsonProperty(required = true)
    private String room;
    @JsonProperty(required = true)
    private LocalDateTime sessionTime;

    @ManyToOne
    @JsonProperty(required = true)
    private Movie movie;
}
