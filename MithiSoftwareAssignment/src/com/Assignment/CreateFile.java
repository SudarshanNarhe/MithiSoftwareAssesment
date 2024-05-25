package com.Assignment;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CreateFile {

	public void createFileFromMap(Map<String,String> map,String filename) throws IOException {

		BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
		writer.write("Word   :   Page Numbers");
		writer.newLine();
		writer.write("---------------------------");
		writer.newLine();
		for(Map.Entry<String, String> entry : map.entrySet()) {
			writer.write(entry.getKey()+" : "+ entry.getValue());
			writer.newLine();
		}
		writer.close();
	}
}
