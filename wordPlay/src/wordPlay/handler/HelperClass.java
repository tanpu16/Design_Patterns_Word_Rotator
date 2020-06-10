package wordPlay.handler;
import wordPlay.util.Results;
import wordPlay.util.FileProcessor;
import wordPlay.metrics.MetricsCalculator;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class HelperClass{

	int index;
	int wordCount;
	int lines;
	int totalWordLength;
	int length;
	String temp;
	boolean InvalidWord,nullWord,isEmpty;

	WordRotator robj = new WordRotator();
        MetricsCalculator cal = new MetricsCalculator();


	//constructor
	public HelperClass()
	{
		index = 0;
		wordCount = 0;
		lines = 0;
		totalWordLength = 0;
		length = 0;		
		temp = null;
		InvalidWord = false;
		nullWord = false;
		isEmpty = false;
	}
	
	
	@Override
	public String toString()
	{
		return "HelperClass [index : "+index+" wordCount : "+wordCount+" lines : "+lines+"length : "+length+" totalWordLength : "+totalWordLength+" Word : "+temp+
			" Is Invalid Word : "+InvalidWord+" Is null word : "+nullWord+"is Empty line : "+isEmpty+"]"; 	
	}
	

	//this is a helper method which takes instances of 3 classes used to perform operations on input.txt file.
	//operations like fetching words by using poll() method of FileProcessor class, Store final result in
	//store method of Result class.
        public void helper(FileProcessor fp, Results ores, Results mres) throws IOException{
                try{
                	                        	
				String temp = fp.poll();
				boolean check = false;
				//Pattern special = Pattern.compile("[!@#$%^&*()_+=|<>,/?:;'{}\\[\\]~`-]");
				//Matcher m = special.matcher(temp);

				if(null == temp)
				{
					nullWord = true;
				}

                        	while(null != temp)
                        	{
                                	index++;
						                                	
					if(check == true && temp.length() == 0)
					{
						isEmpty = true;
						check = false;
					}
					else if(temp.matches("^[a-zA-Z0-9]+$")) //Regular Expression to check if word contains only aphanumeric characters
                                	{       
						length = temp.length();
						totalWordLength += length; 
                                        	char array[] = temp.toCharArray();
                                        	
						robj.rotate(array, index, length);
                                        	
						String result = String.valueOf(array);
                                        	ores.store(result);
						ores.store(" ");
                                	}
					else if(temp.matches("^[a-zA-Z0-9]+[.]$")) //Regular Expression to check end of the line, by period "."
                                	{
					
                                        	String dummy = temp.replace(".","");
                                        	length = dummy.length();
						totalWordLength += length;
                                        	char array[] = dummy.toCharArray();
                                        	
						robj.rotate(array, index, length);
                                        	
						String result = String.valueOf(array);
                                        	result = result+".";
						ores.store(result);
						ores.store("\n");
						wordCount +=index;
						lines++;
						index=0;
						check=true;
                                	}
					else if(!temp.matches("^[a-zA-Z0-9]+$") || !temp.matches("^[a-zA-Z0-9]+[.]$"))
					//check if word contains other than alphanumeric char and period "."
					{
						InvalidWord = true;
					}
				                                	
					temp = fp.poll();
					
				}

				metricsStoreMethodCall(mres);
			
		}
                catch(IOException e)
                {
			e.printStackTrace();
                        System.exit(0);
                }
		
		try
		{
			if(InvalidWord)
			{
				throw new Exception("File contains Word other than [a-zA-Z0-9] found! Exiting!!!");
			}
			else if(nullWord)
			{
				throw new Exception("File is Empty! Exiting!!!");
			}
			else if(isEmpty)
			{
				throw new Exception("File contains Empty line! Exiting!!!");
			}
		}
		catch(Exception ie)
		{
			ie.printStackTrace();
			System.exit(0);
		}

		
        }


	//this is a void method used to send the final result of Average number of words per line and Average word length to 
	//to store method of Result class.
	public void metricsStoreMethodCall(Results mres)
	{
		String result1 = cal.avgWord(wordCount,lines);
		String result2 = cal.avgWordLength(totalWordLength,wordCount);
				
		mres.store("AVG_NUM_WORDS_PER_SENTENCE - ");
		mres.store(result1);
		mres.store("\n");
		mres.store("AVG_WORD_LENGTH - ");
		mres.store(result2);
		mres.store("\n");
	}


}
