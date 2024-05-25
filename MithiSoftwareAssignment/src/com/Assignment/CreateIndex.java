package com.Assignment;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CreateIndex {
	
	public Map<String, String> createIndex(String str1,String str2,String str3) {
			
			Map<String, String> indexmap = new TreeMap<String, String>();
			
			String[] words1 = str1.split(" ");
		
			for(int i=0;i<words1.length;i++) {
				indexmap.put(words1[i], "1");
			}
			
			String[] words2 = str2.split(" ");
			
			for(int i=0;i<words2.length;i++) {
				indexmap.put(words2[i], indexmap.containsKey(words2[i]) ? indexmap.get(words2[i])+",2":"2");
			}
			
			String[] words3 = str3.split(" ");
			
			for(int i=0;i<words3.length;i++) {
				indexmap.put(words3[i], indexmap.containsKey(words3[i]) ? indexmap.get(words3[i])+",3":"3");

			}
			
			for (String word : indexmap.keySet()) {
		         
				String value = indexmap.get(word);
		        Set<String> valuesSet = new TreeSet<>(Arrays.asList(value.split(",")));
		        indexmap.put(word, String.join(",", valuesSet));
		    }
			
			return indexmap;
			
		}
	
	public void printMap(Map<String, String> map) {
		System.out.println("Word   :   Page Numbers\n-----------------------");
		for(Map.Entry<String, String> entry : map.entrySet()) {

			System.out.println(entry.getKey()+" : "+ entry.getValue());
			
		}
	}
	
	public static void main(String[] args) {
		
		PageReader reader = new PageReader();
		CreateIndex index = new CreateIndex();
		CreateFile file = new CreateFile();
		
		String file1 = "C:\\Users\\ajitb\\OneDrive\\Desktop\\MithiSoftware\\Page1.txt";
		
		String file2 = "C:\\Users\\ajitb\\OneDrive\\Desktop\\MithiSoftware\\Page2.txt";
		
		String file3 = "C:\\Users\\ajitb\\OneDrive\\Desktop\\MithiSoftware\\Page3.txt";
		
		String excludewordFile = "C:\\Users\\ajitb\\OneDrive\\Desktop\\MithiSoftware\\exclude-words.txt";
				
		try {
			//get data from file into string format
			String str1 = reader.getStringFromText(file1);
			String str2 = reader.getStringFromText(file2);
			String str3 = reader.getStringFromText(file3);
			String exclude = reader.getStringFromText(excludewordFile);
//			System.out.println(str1);
//			System.out.println(str2);
//			System.out.println(str3);
			
			//convert string to words for check and exclude words of excludewordfile
			String [] words1 = reader.getWords(str1.toLowerCase());
			String [] words2 = reader.getWords(str2.toLowerCase());
			String [] words3 = reader.getWords(str3.toLowerCase());
		//	System.out.println(Arrays.toString(words3));
			String[] excludewords = reader.getWords(exclude);
			
			//get a string by excluding a word of excludeword files
			String uniquewords1 = reader.getStringWithoutExcluded(words1, excludewords);
			String uniquewords2 = reader.getStringWithoutExcluded(words2, excludewords);
			String uniquewords3 = reader.getStringWithoutExcluded(words3, excludewords);
			
			//get a value in word and page number using map
			Map<String, String> indexmap = new TreeMap<String, String>();
			indexmap = index.createIndex(uniquewords1,uniquewords2,uniquewords3);
			index.printMap(indexmap);
			
		//code for create a file
			file.createFileFromMap(indexmap, "index.txt");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
}
