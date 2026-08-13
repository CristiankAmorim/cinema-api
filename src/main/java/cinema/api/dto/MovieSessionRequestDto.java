package cinema.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieSessionRequestDto {

    @JsonProperty(required = true)
    private String room;
    @JsonProperty(required = true)
    private LocalDateTime sessionTime;
    private Long movieId;

}
