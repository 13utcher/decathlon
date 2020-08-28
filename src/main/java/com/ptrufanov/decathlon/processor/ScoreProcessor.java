package com.ptrufanov.decathlon.processor;

import com.ptrufanov.decathlon.model.Athlete;
import com.ptrufanov.decathlon.model.EventType;
import com.ptrufanov.decathlon.model.Result;
import com.ptrufanov.decathlon.model.ResultType;
import com.ptrufanov.decathlon.model.Score;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ScoreProcessor calculates each athlete's total score,
 * set final position and
 * sorts athletes by position depending on total score in asc order
 */
public class ScoreProcessor {

    /**
     *
     * @param athletes list of athletes data
     * @return processed list of athlete's with
     * calculated score and position
     */
    public List<Score> process(List<Athlete> athletes) {
        List<Score> result = new ArrayList<>();
        athletes.forEach(athlete -> {
            Score score = new Score();
            List<Result> results = athlete.getResults();
            int points = results.stream()
                    .mapToInt(this::calculateScore)
                    .sum();
            score.setPoints(points);
            score.setName(athlete.getName());
            score.setResults(results.stream().map(Result::getValue).collect(Collectors.toList()));
            result.add(score);
        });
        List<Score> sortedScores = sortScores(result);
        setPosition(sortedScores);
        return sortedScores;
    }

    private int calculateScore(Result result) {
        ResultType type = result.getType();
        double value = type.getConverter().apply(result.getValue());
        int score;
        if (EventType.TRACK.equals(type.getEventType())) {
            score = (int)(type.getParameterA() * Math.pow((type.getParameterB() - value), type.getParameterC()));
        } else {
            score = (int)(type.getParameterA() * Math.pow((value - type.getParameterB()), type.getParameterC()));
        }
        return score;
    }

    private List<Score> sortScores(List<Score> scores) {
        return scores.stream()
                .sorted(Comparator.comparingInt(Score::getPoints).reversed())
                .collect(Collectors.toList());
    }

    private void setPosition(List<Score> scores) {
        int startPosition = 0;
        int endPosition = 0;
        for (int i = 0; i < scores.size(); i++) {
            String position;
            Score currentScore = scores.get(i);
            if (i >= endPosition) {
                startPosition = ++endPosition;
                for (int j = i + 1; j < scores.size(); j++) {
                    Score nextScore = scores.get(j);
                    if (currentScore.getPoints() == nextScore.getPoints()) {
                        endPosition++;
                    } else {
                        break;
                    }
                }
            }
            if (startPosition == endPosition) {
                position = String.valueOf(startPosition);
            } else {
                position = startPosition + "-" + endPosition;
            }
            currentScore.setPosition(position);
        }
    }
}
