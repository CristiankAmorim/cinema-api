package cinema.api.dto;

import cinema.api.model.Movie;

public class MovieDto {

    private long id;
    private String title;
    private String gender;
    private int durationMinutes;

    public MovieDto() {
    }

    public MovieDto(long id, String title, String gender, int durationMinutes) {
        this.id = id;
        this.title = title;
        this.gender = gender;
        this.durationMinutes = durationMinutes;
    }

    public MovieDto(Movie movie) {
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.gender = movie.getGender();
        this.durationMinutes = movie.getDurationMinutes();
    }
}
