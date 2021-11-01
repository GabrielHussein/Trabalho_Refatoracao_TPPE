package main.java.project;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import main.java.project.exception.ArquivoNaoEncontradoException;

public class Persistencia {

	public Persistencia() {
	}

	public List<String> readFileContent(BufferedReader reader, String fileName) throws ArquivoNaoEncontradoException {
		List<String> fileLines = new ArrayList<String>();
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				fileLines.add(line);
			}
			reader.close();
		} catch (Exception e) {
			throw new ArquivoNaoEncontradoException(fileName);
		}
		return fileLines;
	}

}
