package com.heatpump.simulator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHelper {

	public static void createTemperatureFile(String fileName, String tempraturValues) throws IOException {
		File source = new File(fileName);
		FileWriter fileWriter = new FileWriter(source);
		fileWriter.append(tempraturValues);
		fileWriter.close();
	}

	public static boolean deleteFile(String fileName) {
		return new File(fileName).delete();
	}

}
