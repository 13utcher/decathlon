package com.ptrufanov.decathlon;

import com.ptrufanov.decathlon.writer.XmlResultsWriter;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.ptrufanov.decathlon.TestData.getScores;

public class XmlWriterTest {
    @Rule
    public TemporaryFolder folder= new TemporaryFolder();

    @Test
    public void name() throws IOException {
        XmlResultsWriter writer = new XmlResultsWriter();
        File result = folder.newFile("temp.xml");
        writer.setOutput(result);
        writer.write(getScores());
        File sample = getSampleFile();
        Assert.assertEquals(getFileContent(result), getFileContent(sample));
    }

    private String getFileContent(File file) throws IOException {
        byte[] file1Bytes = Files.readAllBytes(Paths.get(file.getPath()));
        return new String(file1Bytes, StandardCharsets.UTF_8);
    }

    private File getSampleFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource("sample.xml").getFile());
    }
}
