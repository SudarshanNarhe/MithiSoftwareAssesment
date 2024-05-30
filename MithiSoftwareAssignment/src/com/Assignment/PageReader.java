package com.Assignment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PageReader implements PageMethods{
	
	public PageReader(){
		
	}
	public String getStringFromText(String filePath) throws IOException {
		String content = Files.readString(Paths.get(filePath));
		return content;
	}
	
	public String[] getWords(String str) {
		String[] words = str.split("\\W");
		return words;
	}
	
	public String getStringWithoutExcluded(String[]words, String[] excludewords) {
		
		 Set<String> excludedSet = new HashSet<>(Arrays.asList(excludewords));
		    StringBuilder uniqueStringBuilder = new StringBuilder();

		    for (String word : words) {
		        if (!excludedSet.contains(word)&& !isNumeric(word) && word.length()>1) {
		            uniqueStringBuilder.append(word).append(" ");
		        }
		    }
		    
		    return uniqueStringBuilder.toString();
		
	}
	
	private static boolean isNumeric(String str) {
		
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

}
