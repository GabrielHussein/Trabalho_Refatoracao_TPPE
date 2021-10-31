package main.java.project;

import java.util.List;

import main.java.project.exception.DelimitadorInvalidoException;

public class AnalysisParser {
    
	private String delimiter;

	public AnalysisParser(String userDelimiter, List<String> fileLines) throws DelimitadorInvalidoException{
		this.setDelimiter(userDelimiter);
		this.parseFile(fileLines, userDelimiter);
	}

	public String getDelimiter() {
		return delimiter;
	}

	public void setDelimiter(String delimiter) throws DelimitadorInvalidoException {
		char charAux = delimiter.charAt(0);
		if(delimiter.length()==1 || (delimiter.length()==2 && charAux == '\\')) {
			this.delimiter = delimiter;
		} else {
			throw new DelimitadorInvalidoException();
		}
	}

	public String[] parseFile(List<String> fileLines, String delimiter){
		String[] evolutionList = new String[fileLines.size()];
		int evolutionIndex = 0, arrayIndex = 0;
		for(String line : fileLines)
        {	
			if(line.substring(0, 3).equals("---")){
				if(evolutionIndex != 0) {
					arrayIndex++;
				}
				evolutionIndex++;
				evolutionList[arrayIndex] = delimiter;
			} else {
				evolutionList[arrayIndex] += line + delimiter;
			}
        }
		return evolutionList;
	}
}
