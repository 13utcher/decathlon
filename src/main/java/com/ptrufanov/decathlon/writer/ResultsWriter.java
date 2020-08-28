package com.ptrufanov.decathlon.writer;

import com.ptrufanov.decathlon.model.Score;

import java.util.List;

/**
 * ResultsWriter writes athletes data and score
 * into specified data format on a disk
 */
public interface ResultsWriter {

    /**
     *
     * @param results athletes results list that should be serialized
     */
    void write(List<Score> results);

}
