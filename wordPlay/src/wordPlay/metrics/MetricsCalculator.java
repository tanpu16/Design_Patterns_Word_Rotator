package wordPlay.metrics;
import java.text.DecimalFormat;

public class MetricsCalculator 
{
	public double avgWord(int totalWords, int lines)
	{
		double AVG_NUM_WORDS_PER_SENTENCE = (double)totalWords/(double)lines;
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.print("Average num of words per sentence : ");
		System.out.print(df.format(AVG_NUM_WORDS_PER_SENTENCE));
		return AVG_NUM_WORDS_PER_SENTENCE;
	}
	public double avgWordLength(int totalWordsLength,int totalWords)
	{
		System.out.println("in metrics : "+totalWordsLength+" "+totalWords);
		double AVG_WORD_LENGTH = (double)totalWordsLength/(double)totalWords;
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		System.out.print("Average word length : ");
		System.out.print(df.format(AVG_WORD_LENGTH));
		return AVG_WORD_LENGTH;
	}	
}
