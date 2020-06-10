package wordPlay.handler;
import wordPlay.util.*;
import java.util.*;
import java.io.*;
import java.lang.*;

public class WordRotator
{

		@Override
		public String toString()
		{
			return null;
		}

		/*rotate is a void function which rotates the array characters by index number of times 
		@param array character array of word which need to ratate
		@param index by how many times we need to rotate characters of words
		@param len length of word
		@return void
	        @see display nothing just rotate the input array	
		*/
		public void rotate(char array[], int index, int len)
		{

                	for (int i = 0; i < index; i++)
                	{
                        	char ctemp = array[len-1];
                        	for (int j = len-2; j >= 0; j--)
                        	{
                                	array[j+1] = array[j];
                        	}
                        	array[0] = ctemp;
               		 }
		}
}
