package wordPlay.util;
import java.util.*;
//import java.handler.*;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {

	public void store()
	{
		Queue<String> rwords = new LinkedList<>();
		
		rwords.add("abc");
		rwords.add("pqr");

		System.out.println("Q elements : "+rwords);

	
	}

}
