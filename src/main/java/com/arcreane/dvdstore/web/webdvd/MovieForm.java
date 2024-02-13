package com.arcreane.dvdstore.web.webdvd;

import com.arcreane.dvdstore.core.entity.Category;
import com.arcreane.dvdstore.core.entity.Movie;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MovieForm {
    @NotBlank
    protected String id;
    @NotBlank
    protected String name;
    protected Category category;
    protected Integer nbStocks;

    public Movie convertToMovie() {
        return new Movie(id, name, category, nbStocks);
    }
}
