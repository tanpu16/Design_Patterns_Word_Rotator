package wordPlay.driver;
import wordPlay.util.Results;
import wordPlay.util.FileProcessor;
import wordPlay.handler.HelperClass;
import java.io.IOException;
import java.lang.NullPointerException;
/**
 * @author John Doe
 *
 */
public class Driver {
	public static void main(String[] args) throws IOException,NullPointerException{

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
		System.out.print("\n");

		try{
			HelperClass hp = new HelperClass();
			FileProcessor fp = new FileProcessor(args[0]);
			Results ores = new Results(args[1]);
			Results mres = new Results(args[2]);
				
			hp.helper(fp,ores,mres);

			ores.writeToFile();
			System.out.println("output.txt file Content :");
			ores.writeToStdout();
			
			mres.writeToFile();
			System.out.println("matrics.txt file content :");
			mres.writeToStdout();

		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
			System.exit(0);
		}
		catch(NullPointerException ne)
		{
			ne.printStackTrace();
			System.exit(0);
		}
		
	}
}
