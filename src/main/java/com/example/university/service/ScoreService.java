package com.example.university.service;

import com.example.university.model.Score;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ScoreService {

    private Map<Long, Score> scoreMap = new HashMap<>();
    private Long nextId = 1L;

    public List<Score> getAllScores() {
        return new ArrayList<>(scoreMap.values());
    }

    public Score getScoreById(Long id) {
        return scoreMap.get(id);
    }

    public Score createScore(Long studentId, Score score) {
        score.setId(nextId);
        scoreMap.put(nextId, score);
        nextId++;
        return score;
    }

    public Score updateScore(Long id, Score updatedScore) {
        if (scoreMap.containsKey(id)) {
            updatedScore.setId(id);
            scoreMap.put(id, updatedScore);
            return updatedScore;
        }
        return null;
    }
}
