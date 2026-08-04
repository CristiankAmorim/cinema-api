package cinema.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieResponseDto {

    @JsonProperty(required = true)
    private String title;
    @JsonProperty(required = true)
    private String gender;
    @JsonProperty(required = true)
    private Integer durationMinutes;
}
