package com.ptrufanov.decathlon;

import com.ptrufanov.decathlon.model.Athlete;
import com.ptrufanov.decathlon.model.Score;
import com.ptrufanov.decathlon.processor.ScoreProcessor;
import com.ptrufanov.decathlon.reader.CsvResultsReader;
import com.ptrufanov.decathlon.reader.ResultsReader;
import com.ptrufanov.decathlon.writer.ResultsWriter;
import com.ptrufanov.decathlon.writer.XmlResultsWriter;

import java.util.List;

public class App {

    public static void main(String[ ] args) {
        ResultsReader reader = new CsvResultsReader();
        ResultsWriter writer = new XmlResultsWriter();
        ScoreProcessor processor = new ScoreProcessor();
        List<Athlete> athletes = reader.read("results.csv");
        List<Score> scores = processor.process(athletes);
        writer.write(scores);
    }
}
