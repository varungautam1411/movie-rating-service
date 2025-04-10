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


    
