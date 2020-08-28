package com.ptrufanov.decathlon;

import com.ptrufanov.decathlon.model.Athlete;
import com.ptrufanov.decathlon.model.Result;
import com.ptrufanov.decathlon.model.ResultType;
import com.ptrufanov.decathlon.model.Score;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestData {

    public static List<Athlete> getAthletes() {
        List<Athlete> athletes = new ArrayList<>();

        Athlete athlete1 = new Athlete();
        athlete1.setName("athlete_1");
        List<Result> athlete1Results = new ArrayList<>();
        athlete1Results.add(new Result("10.395", ResultType.RUN_100_M));
        athlete1Results.add(new Result("7.76", ResultType.LONG_JUMP));
        athlete1Results.add(new Result("18.4", ResultType.SHOT_PUT));
        athlete1Results.add(new Result("2.20", ResultType.HIGH_JUMP));
        athlete1Results.add(new Result("46.17", ResultType.RUN_400_M));
        athlete1Results.add(new Result("13.8", ResultType.RUN_110_M_HURDLES));
        athlete1Results.add(new Result("56.17", ResultType.DISCUS_THROW));
        athlete1Results.add(new Result("5.28", ResultType.POLE_VAULT));
        athlete1Results.add(new Result("77.19", ResultType.JAVELIN_THROW));
        athlete1Results.add(new Result("3:53.79", ResultType.RUN_1500_M));
        athlete1.setResults(athlete1Results);
        athletes.add(athlete1);

        Athlete athlete2 = new Athlete();
        athlete2.setName("athlete_2");
        List<Result> athlete2Results = new ArrayList<>();
        athlete2Results.add(new Result("10.827", ResultType.RUN_100_M));
        athlete2Results.add(new Result("7.36", ResultType.LONG_JUMP));
        athlete2Results.add(new Result("16.79", ResultType.SHOT_PUT));
        athlete2Results.add(new Result("2.10", ResultType.HIGH_JUMP));
        athlete2Results.add(new Result("48.19", ResultType.RUN_400_M));
        athlete2Results.add(new Result("14.59", ResultType.RUN_110_M_HURDLES));
        athlete2Results.add(new Result("51.4", ResultType.DISCUS_THROW));
        athlete2Results.add(new Result("4.96", ResultType.POLE_VAULT));
        athlete2Results.add(new Result("70.67", ResultType.JAVELIN_THROW));
        athlete2Results.add(new Result("4:07.42", ResultType.RUN_1500_M));
        athlete2.setResults(athlete2Results);
        athletes.add(athlete2);

        Athlete athlete3 = new Athlete();
        athlete3.setName("athlete_3");
        List<Result> athlete3Results = new ArrayList<>();
        athlete3Results.add(new Result("10.827", ResultType.RUN_100_M));
        athlete3Results.add(new Result("7.36", ResultType.LONG_JUMP));
        athlete3Results.add(new Result("16.79", ResultType.SHOT_PUT));
        athlete3Results.add(new Result("2.10", ResultType.HIGH_JUMP));
        athlete3Results.add(new Result("48.19", ResultType.RUN_400_M));
        athlete3Results.add(new Result("14.59", ResultType.RUN_110_M_HURDLES));
        athlete3Results.add(new Result("51.4", ResultType.DISCUS_THROW));
        athlete3Results.add(new Result("4.96", ResultType.POLE_VAULT));
        athlete3Results.add(new Result("70.67", ResultType.JAVELIN_THROW));
        athlete3Results.add(new Result("4:07.42", ResultType.RUN_1500_M));
        athlete3.setResults(athlete3Results);
        athletes.add(athlete3);

        Athlete athlete4 = new Athlete();
        athlete4.setName("athlete_4");
        List<Result> athlete4Results = new ArrayList<>();
        athlete4Results.add(new Result("11.278", ResultType.RUN_100_M));
        athlete4Results.add(new Result("6.94", ResultType.LONG_JUMP));
        athlete4Results.add(new Result("15.16", ResultType.SHOT_PUT));
        athlete4Results.add(new Result("1.99", ResultType.HIGH_JUMP));
        athlete4Results.add(new Result("50.32", ResultType.RUN_400_M));
        athlete4Results.add(new Result("15.419", ResultType.RUN_110_M_HURDLES));
        athlete4Results.add(new Result("46.59", ResultType.DISCUS_THROW));
        athlete4Results.add(new Result("4.63", ResultType.POLE_VAULT));
        athlete4Results.add(new Result("64.09", ResultType.JAVELIN_THROW));
        athlete4Results.add(new Result("4:21.77", ResultType.RUN_1500_M));
        athlete4.setResults(athlete4Results);
        athletes.add(athlete4);

        Athlete athlete5 = new Athlete();
        athlete5.setName("athlete_5");
        List<Result> athlete5Results = new ArrayList<>();
        athlete5Results.add(new Result("11.756", ResultType.RUN_100_M));
        athlete5Results.add(new Result("6.51", ResultType.LONG_JUMP));
        athlete5Results.add(new Result("13.53", ResultType.SHOT_PUT));
        athlete5Results.add(new Result("1.88", ResultType.HIGH_JUMP));
        athlete5Results.add(new Result("52.58", ResultType.RUN_400_M));
        athlete5Results.add(new Result("16.29", ResultType.RUN_110_M_HURDLES));
        athlete5Results.add(new Result("41.72", ResultType.DISCUS_THROW));
        athlete5Results.add(new Result("4.29", ResultType.POLE_VAULT));
        athlete5Results.add(new Result("57.45", ResultType.JAVELIN_THROW));
        athlete5Results.add(new Result("4:36.96", ResultType.RUN_1500_M));
        athlete5.setResults(athlete5Results);
        athletes.add(athlete5);

        return athletes;
    }

    public static List<Score> getScores() {
        List<Score> scores = new ArrayList<>();

        Score score1 = new Score();
        score1.setName("athlete_1");
        score1.setResults(Arrays.asList("10.395", "7.76", "18.4", "2.20", "46.17", "13.8", "56.17", "5.28", "77.19", "3:53.79"));
        score1.setPosition("1");
        score1.setPoints(9990);
        scores.add(score1);

        Score score2 = new Score();
        score2.setName("athlete_2");
        score2.setResults(Arrays.asList("10.827", "7.36", "16.79", "2.10", "48.19", "14.59", "51.4", "4.96", "70.67", "4:07.42"));
        score2.setPosition("2-3");
        score2.setPoints(8994);
        scores.add(score2);

        Score score3 = new Score();
        score3.setName("athlete_3");
        score3.setResults(Arrays.asList("10.827", "7.36", "16.79", "2.10", "48.19", "14.59", "51.4", "4.96", "70.67", "4:07.42"));
        score3.setPosition("2-3");
        score3.setPoints(8994);
        scores.add(score3);

        Score score4 = new Score();
        score4.setName("athlete_4");
        score4.setResults(Arrays.asList("11.278", "6.94", "15.16", "1.99", "50.32", "15.419", "46.59", "4.63", "64.09", "4:21.77"));
        score4.setPosition("4");
        score4.setPoints(7992);
        scores.add(score4);

        Score score5 = new Score();
        score5.setName("athlete_5");
        score5.setResults(Arrays.asList("11.756", "6.51", "13.53", "1.88", "52.58", "16.29", "41.72", "4.29", "57.45", "4:36.96"));
        score5.setPosition("5");
        score5.setPoints(6995);
        scores.add(score5);

        return scores;
    }
}
