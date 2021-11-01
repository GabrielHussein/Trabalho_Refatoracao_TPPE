package main.java.project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import main.java.project.exception.EscritaNaoPermitidaException;

public class AnalysisWriter {
	private boolean writeSuccess;

	public AnalysisWriter(String[] parseList, int inputFileFormat, String inputFilePath, String fileName)
			throws EscritaNaoPermitidaException, IOException {
		this.writeFile(parseList, inputFileFormat, inputFilePath, fileName);
	}

	public void writeFile(String[] parseList, int fileFormat, String filePath, String fileName)
			throws EscritaNaoPermitidaException, IOException {
		fileName = fileName.replace(".out", "");
		fileName = fileName + "Tab.out";
		if (canWriteOnFile(filePath)) {
			String[] organizedContent = new FileContent().fileContent(fileFormat, parseList);
			setWriteSuccess(writeOnFile(filePath, fileName, fileFormat, organizedContent));
		} else {
			setWriteSuccess(false);
			throw new EscritaNaoPermitidaException();
		}
	}

	private boolean canWriteOnFile(String filePath) {
		File outFile = new File(filePath);
		if(outFile.canWrite()){
			return true;
		}
		return false;
	}

	private boolean writeOnFile(String filePath, String fileName, int fileFormat, String[] parseList)
			throws IOException {
		File completeFile = new File(filePath, fileName);
		BufferedWriter writer = new BufferedWriter(new FileWriter(completeFile));
		for (String line : parseList) {
			writer.write(line);
			writer.newLine();
		}
		writer.close();
		return true;
	}

	public boolean isWriteSuccess() {
		return writeSuccess;
	}

	public void setWriteSuccess(boolean writeSuccess) {
		this.writeSuccess = writeSuccess;
	}

}
