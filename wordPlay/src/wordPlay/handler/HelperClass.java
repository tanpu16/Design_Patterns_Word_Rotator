package wordPlay.handler;
import wordPlay.util.*;
import wordPlay.metrics.*;
import java.util.*;
import java.io.*;
import java.lang.*;

public class HelperClass
{
        public void helper(FileProcessor fp, Results ores, Results mres, MetricsCalculator cal) throws Exception{
                try
                {
                        	WordRotator robj = new WordRotator();
                       
				int index = 0;
				int wordCount=0;
				int lines=0;
				int totalWordLength=0;
                        	
				String temp = fp.poll();

				if(null == temp)
				{
					System.out.println("File is Empty!!! Exiting!!!");
					System.exit(0);
				}

                        	while(null != temp)
                        	{
                                	index++;
                                	//String checkString="";
					
					if(temp.matches("^[a-zA-Z0-9]*$"))
                                	{       
						int length = temp.length();
						totalWordLength += length; 
                                        	char array[] = temp.toCharArray();
                                        	
						robj.leftRotate(array, index, length);
                                        	
						String result = String.valueOf(array);
                                        	ores.store(result);
						ores.store(" ");
                                	}
					else if(temp.matches(".*[.]$")) //end of the line
                                	{
						//checkString = temp;
                                        	String dummy = temp.replace(".","");
                                        	int length = dummy.length();
						totalWordLength += length;
                                        	char array[] = dummy.toCharArray();
                                        	
						robj.leftRotate(array, index, length);
                                        	
						String result = String.valueOf(array);
                                        	result = result+".";
						ores.store(result);
						ores.store("\n");
						wordCount +=index;
						lines++;
						index=0;
                                	}
					else if(!temp.matches("^[a-zA-Z0-9]*$") && !temp.matches(".*[.]$"))
					{
						System.out.println("Words contains characters other than [a-zA-Z0-9]... Exiting!!!"+temp);
						System.exit(0);
					}	
                                	temp=fp.poll();
					/*
					if(null == temp && checkString.matches(".*[.]$"))
					{
						System.out.println("Empty line in input file! Exiting!!!");	
						System.exit(0);
					}
					*/
                        	}
				
				String result1 = cal.avgWord(wordCount,lines);
				String result2 = cal.avgWordLength(totalWordLength,wordCount);
				
				mres.store("AVG_NUM_WORDS_PER_SENTENCE - ");
				mres.store(result1);
				mres.store("\n");
				mres.store("AVG_WORD_LENGTH - ");
				mres.store(result2);
				mres.store("\n");

                }
                catch(FileNotFoundException ex)
                {
                        System.out.println("File does not exist!");
                        System.exit(0);
                }
                catch(IOException e)
                {
                        System.out.println("IO exception occurs!");
                        System.exit(0);
                }

        }
}
