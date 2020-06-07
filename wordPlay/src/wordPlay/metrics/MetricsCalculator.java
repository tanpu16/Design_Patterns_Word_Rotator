package wordPlay.metrics;
import java.text.DecimalFormat;

public class MetricsCalculator 
{
	public String avgWord(int totalWords, int lines)
	{
		double AVG_NUM_WORDS_PER_SENTENCE = (double)totalWords/(double)lines;
		DecimalFormat df = new DecimalFormat("0.00");
		String sresult1 = df.format(AVG_NUM_WORDS_PER_SENTENCE);
		//String sresult1 = new Double(result1).toString();
		return sresult1;
	}
	public String avgWordLength(int totalWordsLength,int totalWords)
	{
		double AVG_WORD_LENGTH = (double)totalWordsLength/(double)totalWords;
		DecimalFormat df = new DecimalFormat("0.00");
		String sresult2 = df.format(AVG_WORD_LENGTH);
		//String sresult2 = new Double(result2).toString();
		return sresult2;
	}	
}
