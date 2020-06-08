package wordPlay.util;
import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.InvalidPathException;


public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	
	String path;
	String finalResult=""; 

	public Results(String FilePath) {
		
		path = FilePath;

	}
	

	public void store(String str)
	{
				
		finalResult = finalResult+str;				
	
	}
	public void storeMetrics(double avgWord,double avgWordLength)
	{
		double res1 = avgWord;
		double res2 = avgWordLength; 
	}
	
	public void writeToFile() throws Exception
	{
		System.out.println("Path is in write "+path+" out "+finalResult);
		FileWriter owrite = new FileWriter(path);
		owrite.write(finalResult);
		owrite.close();		
	}
	
	
	public void writeToStdout()
	{
		System.out.println(finalResult);	
	}
	

}
