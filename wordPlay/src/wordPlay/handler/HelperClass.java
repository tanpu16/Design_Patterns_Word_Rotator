package wordPlay.handler;
import wordPlay.util.*;
import wordPlay.metrics.*;
import java.util.*;
import java.io.*;
import java.lang.*;

public class HelperClass
{
        public void helper(FileProcessor fp, Results res, MetricsCalculator cal) throws Exception{
                try
                {
                        WordRotator robj = new WordRotator();
                       
				int index = 0;
				int wordCount=0;
				int lines=0;
				int totalWordLength=0;
                        	String temp = fp.poll();

                        	while(temp != null)
                        	{
                                	index++;
					System.out.println("Index1 "+index);
                                	if(temp.matches("^[a-zA-Z0-9]*$"))
                                	{
                                        //System.out.println("String is : "+temp);
                                        int length = temp.length();
					totalWordLength += length; 
                                        char array[] = temp.toCharArray();
                                        robj.leftRotate(array, index, length);
                                        String result = String.valueOf(array);
                                        //System.out.println("Rotated String is : "+result);
                                        res.store(result);
					System.out.println("Index2 "+index);
                                	}
                                	if(temp.matches(".*[.]$")) //end of the line
                                	{
                                        String dummy = temp.replace(".","");
                                        //System.out.println("after period removal String is : "+dummy);
                                        int length = dummy.length();
					totalWordLength += length;
                                        char array[] = dummy.toCharArray();
                                        robj.leftRotate(array, index, length);
                                        String result = String.valueOf(array);
                                        result = result+".";
                                        //System.out.println("Rotated String is : "+result);
					res.store(result);
					res.printq();
					wordCount +=index;
					lines++;
                                        System.out.println("Index3 "+index);
					index=0;
                                	}
                                	temp=fp.poll();
					
                        	}
				double avgWord = cal.avgWord(wordCount,lines);
				double avgWordLength = cal.avgWordLength(totalWordLength,wordCount);		
				rs.storeMetrics(avgWord,avgWordLength);

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
