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
	String finalResult; 
	

	//parameterized constructor
	public Results(String FilePath) 
	{
		path = FilePath;
		finalResult = "";
	}

	@Override
	public String toString()
	{
			return "Class Results [Path is -> "+path+"]";
	}
	
	//store is void method,in which finalResult stores the final output in string format
	//which we can write into the file and stdout
	public void store(String str)
	{
				
		finalResult = finalResult+str;				
	
	}
	

	//this is generic void method, which write output to output.txt or matrics.txt depends on
	//the instace (WordRotator/MatricsCalculator) used to call this method.
	public void writeToFile() throws IOException
	{
		
		FileWriter owrite = new FileWriter(path);

		try
		{
			owrite.write(finalResult);
			owrite.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(0);
		}
		finally
		{
			owrite.close();
		}

	}
	
	//this is void method wich is used to write output to console.
	public void writeToStdout()
	{
		System.out.println(finalResult);	
	}
	

}
