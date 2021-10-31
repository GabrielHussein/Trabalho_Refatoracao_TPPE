package main.java.project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import main.java.project.exception.ArquivoNaoEncontradoException;

public class AnalysisReader {
    
	public List<String> openFile(String fileName) throws ArquivoNaoEncontradoException{
		List<String> fileLines = new ArrayList<String>();
		try{

			File file = new File("src/main/resources/" + fileName);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
        	while ((line = reader.readLine()) != null) {
            	fileLines.add(line);
        	}
			reader.close();
		} catch (Exception e) {
			new ArquivoNaoEncontradoException(fileName);
		}
		return fileLines;
	}

	public AnalysisReader(String fileName) throws ArquivoNaoEncontradoException{
		this.openFile(fileName);
	}



}
