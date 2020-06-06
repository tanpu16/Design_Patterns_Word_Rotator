package wordPlay.handler;
import wordPlay.util.*;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Rotater
{
        public void rotate(FileProcessor fp) throws Exception{
                try
                {
                        //FileProcessor fp = new FileProcessor(path);
                        int index = 0;
			String temp = fp.poll();
                        while(temp != null)
                        {
                                index++;
				if(temp != null && temp.matches("^[a-zA-Z0-9]*$"))
                                {
                                        System.out.println("String is : "+temp);
					int length = temp.length();
					char array[] = temp.toCharArray();
                                        leftRotate(array, index, length);
					String result = String.valueOf(array);
                                        System.out.println("Rotated String is : "+result);
                                }
                                if(temp != null && temp.matches(".*[.]$")) //end of the line
                                {
					String dummy = temp.replace(".","");
                                        System.out.println("after period removal String is : "+dummy);
					int length = dummy.length();
					char array[] = dummy.toCharArray();
                                        leftRotate(array, index, length);
					String result = String.valueOf(array);
					result = result+".";
                                        System.out.println("Rotated String is : "+result);
					break;
                                }
				temp=fp.poll();
                        }
	

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
