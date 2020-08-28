package com.ptrufanov.decathlon.reader;

import com.ptrufanov.decathlon.model.Athlete;

import java.util.List;

/**
 * ResultsReader interface provides a contract
 * which should be used we we read decathlon results
 * data from different sources and formats
 */
public interface ResultsReader {

    /**
     * Returns the list of athletes data read from data source
     * @param filepath specify the file path with the data
     *
     * @return list of athletes data read from file
     */
    List<Athlete> read(String filepath);

}
