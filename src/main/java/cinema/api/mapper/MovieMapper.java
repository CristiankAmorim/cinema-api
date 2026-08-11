package cinema.api.mapper;

import cinema.api.dto.MovieRequestDto;
import cinema.api.dto.MovieResponseDto;
import cinema.api.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    @Mapping(target = "id", ignore = true)
    Movie toMovie(MovieRequestDto dto);

    MovieResponseDto toResponeDto(Movie movie);

    List<MovieResponseDto> toListResponseDto(List<Movie> movies);

}
