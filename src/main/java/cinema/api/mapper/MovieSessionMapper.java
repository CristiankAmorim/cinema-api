package cinema.api.mapper;

import cinema.api.dto.MovieSessionRequestDto;
import cinema.api.dto.MovieSessionResponseDto;
import cinema.api.model.MovieSession;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieSessionMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "movie", ignore = true)
    MovieSession toMovieSession(MovieSessionRequestDto dto);

    MovieSessionResponseDto toResppnseDto(MovieSession movieSession);

    List<MovieSession> toListResponseDto(List<MovieSession> sessions);
}
