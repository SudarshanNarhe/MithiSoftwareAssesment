Interface :

1.interface PageMethods 

methods : A)String getStringWithoutExcluded(String[]words, String[] excludewords);
	
	 B)String[] getWords(String str);

Classes :

1.class PageReader
	
	This class is responsible for read the data from text file which also implements PageMethods interface 

methods : A) String getStringFromText(String filePath) 
		This method accept the file path and return a string by converting file content into string
	
          B) String getStringWithoutExcluded(String[]words, String[] excludewords)
		This is implantation of interface method it accept the file words and check the words from excluded file
		and return a string which does not contain a words which are present in exclude file.

	 C) String[] getWords(String str)
		This is also a implementation of interface method it simply return a words from string using split method.

	D) boolean isNumeric(String str)
		return a boolean value the string is number or not.

2.class CreateFile
	This class is responsible for create a file which contain only one method.
	
method :  void createFileFromMap(Map<String,String> map,String filename)
		This method accept a map and file path where we have to store that file and using BufferWriter inbuild class
		it will create a file.

3.class CreateIndex 
	This is the class which contain method method and responsible for create a index file and followed all operations.
	
methods : A) Map<String, String> createIndex(String str1,String str2,String str3)
		This method accept the all content of files after all operations and return a Map which contain word as key and 
		page number as value.
	
	  B) void printMap
		Simply print a Map to show output on console.
		
	  C) main
		This is the starting point of our code from where code start its execution.

WorkFlow : 
	
	1.Start the execution from main method which is present in create index
	2.We will create a object of all classes.
	3.provide a path of file in string format.
	4.using try and catch block to handle the exception we will call first getStringFromText which return a string of all files
	5.from that string we convert it into words in form of string[] using getWord method
	6.to exclude the given words we will use getStringWithoutExcluded method which return a string so we will get a uniquestring
	7.using the create index method we will create one TreeMap which contain word as key and page number as value and also
	  sort the data naturally.
	8.finally we will use a createFileFromMap method which is present in CreateFile class which create a file.
 
