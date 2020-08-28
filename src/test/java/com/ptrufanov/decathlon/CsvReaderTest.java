package com.ptrufanov.decathlon;

import com.ptrufanov.decathlon.model.Athlete;
import com.ptrufanov.decathlon.reader.CsvResultsReader;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static com.ptrufanov.decathlon.TestData.getAthletes;

public class CsvReaderTest {

    @Test
    public void testReadingAthleteFromCsv() {
        CsvResultsReader reader = new CsvResultsReader();
        List<Athlete> athletes = reader.read(getResourcesPath());
        Assert.assertEquals(athletes, getAthletes());
    }

    private String getResourcesPath() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("test_data.csv").getFile());
        return file.getAbsolutePath();
    }
}
