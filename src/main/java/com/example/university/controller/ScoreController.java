package com.example.university.controller;

import com.example.university.model.Score;
import com.example.university.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scores")
public class ScoreController {

    private final ScoreService scoreService;

    @Autowired
    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @GetMapping
    public ResponseEntity<List<Score>> getAllScores() {
        List<Score> scores = scoreService.getAllScores();
        return ResponseEntity.ok(scores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Score> getScoreById(@PathVariable Long id) {
        Score score = scoreService.getScoreById(id);
        if (score != null) {
            return ResponseEntity.ok(score);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{studentId}")
    public ResponseEntity<Score> createScore(@PathVariable Long studentId, @RequestBody Score score) {
        Score createdScore = scoreService.createScore(studentId, score);
        return ResponseEntity.ok(createdScore);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Score> updateScore(@PathVariable Long id, @RequestBody Score updatedScore) {
        Score score = scoreService.updateScore(id, updatedScore);
        if (score != null) {
            return ResponseEntity.ok(score);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
