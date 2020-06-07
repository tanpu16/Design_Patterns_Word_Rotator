package wordPlay.util;
import java.util.*;
//import java.handler.*;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {


	Queue<String> rwords = new LinkedList<>();


	public void store(String str)
	{
				
		rwords.add(str);				
	
	}
	public void storeMetrics(double avgWord,double avgWordLength)
	{
		double avgWord = avgWord;
		double avgWordLength = avgWordLength; 
	}

	public void printq()
	{
		System.out.println("Q elements : "+rwords);
	}

	void writeToFile()
	{
		
	}

	void writeToStdout()
	{
		
	}


}
