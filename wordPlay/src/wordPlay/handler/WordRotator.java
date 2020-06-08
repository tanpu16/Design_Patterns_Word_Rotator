package wordPlay.handler;
import wordPlay.util.*;
import java.util.*;
import java.io.*;
import java.lang.*;

public class WordRotator
{
		void leftRotate(char array[], int index, int len)
		{
                	for (int i = 0; i < index; i++)
                	{
                        	int j;
                        	char ctemp = array[len-1];
                        	for (j = len-2; j >= 0; j--)
                        	{
                                	array[j+1] = array[j];
                        	}
                        	array[0] = ctemp;
               		 }
		}
}
