package main.java.project;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import main.java.project.exception.EscritaNaoPermitidaException;

public class AnalysisWriter {
    private boolean writeSuccess;

    public AnalysisWriter(String[] parseList, int inputFileFormat, String inputFilePath, String fileName) throws EscritaNaoPermitidaException, IOException{
        this.writeFile(parseList, inputFileFormat, inputFilePath, fileName);
    }

    public void writeFile(String[] parseList, int fileFormat, String filePath, String fileName) throws EscritaNaoPermitidaException, IOException{
        File outFile = new File(filePath);
        fileName = fileName.replace(".out", "");
        fileName = fileName + "Tab.out";
        if(outFile.canWrite()){
            /*
            ajuste de formato
            parseList
            filePath invalido
            */
            int lineCounter = 0;
            String singleLine = "";
            File completeFile = new File(filePath, fileName);
            BufferedWriter writer = new BufferedWriter(new FileWriter(completeFile));
            
            if (fileFormat == 0) {
            	int parseListLength = parseList.length;
            	
            	String[] arrayAux = parseList[0].split(";");
            	int arraySize = arrayAux.length;
            	
            	int counter = 0;
            	
            	for (int k = 0; k < parseListLength; k++) {
            		singleLine += counter + ";";
            		counter ++;
            	}
            	
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
            	
            	setWriteSuccess(true);
            	writer.close();
            	
            } else {
            	for(String line : parseList){
            		singleLine = lineCounter + line;
            		writer.write(singleLine);
            		writer.newLine();
            		lineCounter++;	
            	}
            	setWriteSuccess(true);
            	writer.close();
            }
            
        } else {
            setWriteSuccess(false);
            throw new EscritaNaoPermitidaException();
        }
    }

	public boolean isWriteSuccess() {
		return writeSuccess;
	}

	public void setWriteSuccess(boolean writeSuccess) {
		this.writeSuccess = writeSuccess;
	}

}
