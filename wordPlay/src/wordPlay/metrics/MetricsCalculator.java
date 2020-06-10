package wordPlay.metrics;
import java.text.DecimalFormat;

public class MetricsCalculator 
{
	double AVG_NUM_WORDS_PER_SENTENCE,AVG_WORD_LENGTH; 

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

	public String avgWord(int totalWords, int lines)
	{
		AVG_NUM_WORDS_PER_SENTENCE = (double)totalWords/(double)lines;
		DecimalFormat df = new DecimalFormat("0.00");

		String sresult1 = df.format(AVG_NUM_WORDS_PER_SENTENCE);
		
		return sresult1;
	}
	public String avgWordLength(int totalWordsLength,int totalWords)
	{
		AVG_WORD_LENGTH = (double)totalWordsLength/(double)totalWords;
		DecimalFormat df = new DecimalFormat("0.00");
		
		String sresult2 = df.format(AVG_WORD_LENGTH);
		
		return sresult2;
	}	
}
