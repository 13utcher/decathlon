package com.ptrufanov.decathlon;

import com.ptrufanov.decathlon.model.Score;
import com.ptrufanov.decathlon.processor.ScoreProcessor;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static com.ptrufanov.decathlon.TestData.getAthletes;
import static com.ptrufanov.decathlon.TestData.getScores;

public class ScoreProcessorTest {

    @Test
    public void testResultsProcessor() {
        ScoreProcessor processor = new ScoreProcessor();
        List<Score> scores = processor.process(getAthletes());
        Assert.assertEquals(scores, getScores());
    }

}
