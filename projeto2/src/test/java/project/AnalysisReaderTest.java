package test.java.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import main.java.project.AnalysisReader;
import main.java.project.exception.ArquivoNaoEncontradoException;

public class AnalysisReaderTest {
    @Test
    public void testOpenFileSuccess() throws ArquivoNaoEncontradoException{
        AnalysisReader reader = new AnalysisReader("analysisMemory.out");
        List<String> readerReturn = reader.openFile("analysisMemory.out");
        assertEquals(252, readerReturn.size());
        reader = null;
        readerReturn = null;
        assertNull(reader);
        assertNull(readerReturn);
        reader = new AnalysisReader("analysisTime.out");
        readerReturn = reader.openFile("analysisTime.out");
        assertEquals(252, readerReturn.size());
    }

    @Test
    public void testOpenFileFail() throws ArquivoNaoEncontradoException{
        AnalysisReader reader = new AnalysisReader("failtest");
        List<String> readerReturn = reader.openFile("failtest");
        assertTrue(readerReturn.isEmpty());
    }
}
