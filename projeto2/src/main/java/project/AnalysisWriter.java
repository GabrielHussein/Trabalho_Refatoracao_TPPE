package main.java.project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import main.java.project.exception.EscritaNaoPermitidaException;

public class AnalysisWriter {
	private boolean writeSuccess;
	private String singleLine = "";
	private int parseListLength;
	private String[] arrayAux;
	private int arraySize;
	private int lineCounter = 0;

	public AnalysisWriter(String[] parseList, int inputFileFormat, String inputFilePath, String fileName)
			throws EscritaNaoPermitidaException, IOException {
		this.writeFile(parseList, inputFileFormat, inputFilePath, fileName);
	}

	public void writeFile(String[] parseList, int fileFormat, String filePath, String fileName)
			throws EscritaNaoPermitidaException, IOException {
		fileName = fileName.replace(".out", "");
		fileName = fileName + "Tab.out";
		if (canWriteOnFile(filePath)) {
			parseListLength = parseList.length;

			arrayAux = parseList[0].split(";");
			arraySize = arrayAux.length;

			int counter = 0;

			for (int k = 0; k < parseListLength; k++) {
				singleLine += counter + ";";
				counter++;
			}
			setWriteSuccess(writeOnFile(filePath, fileName, fileFormat, parseList));
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
		if (fileFormat == 0) {
			writer.write(singleLine);
			writer.newLine();
			for (int i = 1; i < arraySize; i++) {
				singleLine = "";
				for (int j = 0; j < parseListLength; j++) {
					singleLine += parseList[j].split(";")[i] + ";";
				}
				writer.write(singleLine);
				writer.newLine();
			}
			writer.close();
		} else {
			for (String line : parseList) {
				singleLine = lineCounter + line;
				writer.write(singleLine);
				writer.newLine();
				lineCounter++;
			}
			writer.close();
		}
		return true;
	}

	public boolean isWriteSuccess() {
		return writeSuccess;
	}

	public void setWriteSuccess(boolean writeSuccess) {
		this.writeSuccess = writeSuccess;
	}

}
