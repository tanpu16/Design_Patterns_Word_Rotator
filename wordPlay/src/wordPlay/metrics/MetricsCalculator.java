package wordPlay.metrics;
import java.text.DecimalFormat;

public class MetricsCalculator 
{
	double AVG_NUM_WORDS_PER_SENTENCE,AVG_WORD_LENGTH; 

	//constructor
	public MetricsCalculator()
	{
		AVG_NUM_WORDS_PER_SENTENCE = 0.0;
		AVG_WORD_LENGTH = 0.0;
	}
	
	@Override
	public String toString()
	{
		return "MetricsCalculator [AVG_NUM_WORDS_PER_SENTENCE : "+AVG_NUM_WORDS_PER_SENTENCE+" AVG_WORD_LENGTH : "+AVG_WORD_LENGTH+"]";
	}
	
	/*
	This method used to calculate average number of words per sentence
	@param totalwords total number of words in input file
	@param line number of lines in input file
	@return sresult1 result in String format for storing
	@see display nothing but calculate the average number of words per line
	*/
	public String avgWord(int totalWords, int lines)
	{
		AVG_NUM_WORDS_PER_SENTENCE = (double)totalWords/(double)lines;
		DecimalFormat df = new DecimalFormat("0.00");

		String sresult1 = df.format(AVG_NUM_WORDS_PER_SENTENCE);
		
		return sresult1;
	}

	/*
	This method used to calculate average words length
	@param totalWordsLength total length of words in input file
	@param totalWords total number of words in input file
	@return sresult2 result in String format for storing
	@see display nothing but calculate the average word length in input file
	*/
	public String avgWordLength(int totalWordsLength,int totalWords)
	{
		AVG_WORD_LENGTH = (double)totalWordsLength/(double)totalWords;
		DecimalFormat df = new DecimalFormat("0.00");
		
		String sresult2 = df.format(AVG_WORD_LENGTH);
		
		return sresult2;
	}	
}
