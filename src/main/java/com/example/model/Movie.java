// Movie.java
package com.example.model;

import lombok.Data;
import java.util.List;

@Data
public class Movie {
    private String movieId;
    private String title;
    private int yearOfRelease;
    private List<MovieRating> watchedBy;
}

