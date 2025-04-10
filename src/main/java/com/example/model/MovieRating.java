// MovieRating.java
package com.example.model;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class MovieRating {
    @JsonProperty("customer-id")
    private String customerId;
    
    @JsonProperty("movie-id")
    private String movieId;
    
    private int rating;
    private String date;
}

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

    
