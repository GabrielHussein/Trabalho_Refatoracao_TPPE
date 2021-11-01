package main.java.project;

import main.java.project.Persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collections;
import java.util.List;

import main.java.project.exception.ArquivoNaoEncontradoException;

public class AnalysisReader extends Persistencia {

	public List<String> openFile(String fileName) throws ArquivoNaoEncontradoException {
		try{
		BufferedReader reader = allocateObjects(fileName);
		return super.readFileContent(reader, fileName);
		}catch (Exception e) {
			new ArquivoNaoEncontradoException(fileName);
		}
		return Collections.emptyList();
	}

	private BufferedReader allocateObjects(String fileName) throws ArquivoNaoEncontradoException {
		try {
			File file = new File("src/main/resources/" + fileName);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			return reader;
		} catch (Exception e) {
			throw new ArquivoNaoEncontradoException(fileName);
		}
	}

	public AnalysisReader(String fileName) throws ArquivoNaoEncontradoException {
		this.openFile(fileName);
	}

}
