package com.ptrufanov.decathlon.reader;

import com.ptrufanov.decathlon.model.Athlete;
import com.ptrufanov.decathlon.model.Result;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.ptrufanov.decathlon.model.ResultType.*;

public class CsvResultsReader implements ResultsReader {
    public static final String SEPARATOR = ",";

    public List<Athlete> read(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.lines()
                    .map(line -> mapToResults(line.split(SEPARATOR)))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("An error parsing csv file", e);
        }
    }

    private Athlete mapToResults(String[] line) {
        Athlete athlete = new Athlete();
        athlete.setName(line[0]);
        List<Result> resultList = new ArrayList<>();
        resultList.add(new Result(line[1], RUN_100_M));
        resultList.add(new Result(line[2], LONG_JUMP));
        resultList.add(new Result(line[3], SHOT_PUT));
        resultList.add(new Result(line[4], HIGH_JUMP));
        resultList.add(new Result(line[5], RUN_400_M));
        resultList.add(new Result(line[6], RUN_110_M_HURDLES));
        resultList.add(new Result(line[7], DISCUS_THROW));
        resultList.add(new Result(line[8], POLE_VAULT));
        resultList.add(new Result(line[9], JAVELIN_THROW));
        resultList.add(new Result(line[10], RUN_1500_M));
        athlete.setResults(resultList);
        return athlete;
    }
}
