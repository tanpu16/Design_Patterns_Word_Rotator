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
                        char ctemp = array[0];
                        for (j = 0; j < len - 1; j++)
                        {
                                array[j] = array[j + 1];
                        }
                        array[j] = ctemp;
                }
			}
}
