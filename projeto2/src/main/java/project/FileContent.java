package main.java.project;


public class FileContent {
	private int arraySize;
	private String[] arrayAux;
	private String singleLine = "";
	private int parseListLength;
	
	public String[] fileContent(int fileFormat, String[] parseList){
		parseListLength = parseList.length;
		String[] auxParseList = new String[parseListLength];

		int counter = 0;

		if (fileFormat == 0) {
			arrayAux = parseList[0].split(";");
			arraySize = arrayAux.length;
			for (int k = 0; k < parseListLength; k++) {
				singleLine += counter + ";";
				counter++;
			}
			auxParseList[0] = singleLine; 
			for (int i = 1; i < arraySize; i++) {
				singleLine = "";
				for (int j = 0; j < parseListLength; j++) {
					singleLine += parseList[j].split(";")[i] + ";";
				}
				auxParseList[i] = singleLine;
			}
		} else {
			for (String line : parseList) {
				singleLine = counter + line;
				auxParseList[counter] = singleLine;
				counter++;
			}
		}
		return auxParseList;
	}

	
	
}