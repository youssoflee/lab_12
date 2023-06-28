package lab12;

import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class RainFallCharBasedGenerator {
	
	public static void main (String [] args)
	{
		
		//1. identify the destination and declare output file
		String outFile = "RainfallCharBased.txt.";
		
		try
		{
			
			//2. construct BufferedWriter object together with FileWriter
			FileWriter files = new FileWriter(outFile);
			BufferedWriter bwOutput = new BufferedWriter(files);
			int[] array = {5,0,0,4,1,0};
			
			
			//3. write the data
			for (int index = 0; index < array.length; index++) {
				bwOutput.write(String.valueOf(array[index]));
				bwOutput.newLine();
			}
			
			//4. clear the stream
			bwOutput.flush();
			
			//5. close the stream
			bwOutput.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		//indicate end of program - could be successful
		System.out.println("End of program. Checkout " + outFile);
		
	}

}
