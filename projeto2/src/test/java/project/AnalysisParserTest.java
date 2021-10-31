package test.java.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.java.project.AnalysisParser;
import main.java.project.exception.DelimitadorInvalidoException;

public class AnalysisParserTest {

	@Test
    public void testDelimiterSuccess() throws DelimitadorInvalidoException{
		String delimiterTest = ";";
		List<String> fileLinesMock = new ArrayList<String>();
    	fileLinesMock.add("---------- Evolution 0 ----------");
    	fileLinesMock.add("1110");
    	fileLinesMock.add("---------- Evolution 1 ----------");
    	fileLinesMock.add("577");
    	AnalysisParser parserMock = new AnalysisParser(delimiterTest, fileLinesMock);
    	assertEquals(parserMock.getDelimiter(), delimiterTest);
    	parserMock = null;
    	delimiterTest = null;
    	assertNull(parserMock);
    	assertNull(delimiterTest);
    	delimiterTest = "\n";
    	parserMock = new AnalysisParser(delimiterTest, fileLinesMock);
    	assertEquals(parserMock.getDelimiter(), delimiterTest);
    }
	
    @Test
    public void testDelimiterFail() throws DelimitadorInvalidoException{
    	assertThrows(DelimitadorInvalidoException.class, () -> {new AnalysisParser("failTest", null);});
    }
    
    @Test
    public void testParser() throws DelimitadorInvalidoException{
    	List<String> fileLinesMock = new ArrayList<String>();
    	fileLinesMock.add("---------- Evolution 0 ----------");
    	fileLinesMock.add("1110");
    	fileLinesMock.add("---------- Evolution 1 ----------");
    	fileLinesMock.add("577");
    	AnalysisParser parserMock = new AnalysisParser(";", fileLinesMock);
    	String[] parserReturn = parserMock.parseFile(fileLinesMock, ";");
    	assertEquals(parserReturn[0], ";1110;");
    }
    
}