package wordPlay.driver;
import wordPlay.util.*;
import wordPlay.handler.*;
import java.util.*;
import java.io.*;
/**
 * @author John Doe
 *
 */
public class Driver {
	public static void main(String[] args) throws Exception{

		/*
		 * As the build.xml specifies the arguments as input,output or metrics, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		if ((args.length != 3) || (args[0].equals("${input}")) || (args[1].equals("${output}")) || (args[2].equals("${metrics}"))) {
			System.err.println("Error: Incorrect number of arguments. Program accepts 3 arguments.");
			System.exit(0);
		}
		System.out.println("Hello World! Lets get started with the assignment");

		HelperClass hp = new HelperClass();
		FileProcessor fp = new FileProcessor(args[0]);
		Results res = new Results();
		try
		{	
			hp.helper(fp);
			/*
			int ind =0;
			String temp = fp.poll();
			while(temp != null)
			{
				ind++;
				System.out.println(" "+ind+" "+temp);
				temp = fp.poll();
			}
			*/
			res.store();



		}
		catch(Exception e)
		{
			System.out.println("Exception!!!");
		}
		
	}
}
