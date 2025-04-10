// MovieRatingService.java
package com.example.service;

import com.example.model.Movie;
import com.example.model.MovieRating;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

@Service
@Slf4j
public class MovieRatingService {

    @Autowired
    private JedisCluster jedisCluster;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void addRating(MovieRating rating) {
        try {
            // Get existing movie data
            String movieJson = jedisCluster.get(rating.getMovieId());
            Movie movie;

            if (movieJson != null) {
                movie = objectMapper.readValue(movieJson, Movie.class);
                movie.getWatchedBy().add(rating);
            } else {
                movie = new Movie();
                movie.setMovieId(rating.getMovieId());
                movie.getWatchedBy().add(rating);
            }

            // Save updated movie data
            String updatedJson = objectMapper.writeValueAsString(movie);
            jedisCluster.set(rating.getMovieId(), updatedJson);

            log.info("Successfully added rating for movie: {}", rating.getMovieId());
        } catch (Exception e) {
            log.error("Error adding rating: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to add rating", e);
        }
    }
}

