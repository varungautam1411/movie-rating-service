// MovieRatingController.java
package com.example.controller;

import com.example.model.MovieRating;
import com.example.service.MovieRatingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ratings")
@Slf4j
public class MovieRatingController {

    @Autowired
    private MovieRatingService movieRatingService;

    @PostMapping
    public ResponseEntity<String> addRating(@RequestBody MovieRating rating) {
        try {
            log.info("Received rating request for movie: {}", rating.getMovieId());
            movieRatingService.addRating(rating);
            return ResponseEntity.ok("Rating added successfully");
        } catch (Exception e) {
            log.error("Error processing rating: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError().body("Error processing rating");
        }
    }
}

