package lab12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RainFallCharBasedReader {
	
	public static void main (String [] args)
	{
		//1. declare output file
		String sourceFile = "RainfallCharBased.txt";
		
		//display the sentence for reading data
		System.out.println("Reading data from " + sourceFile + "\n");
		
		try {
			//2. construct the reader object
			BufferedReader brInput = new BufferedReader(new FileReader(sourceFile));
		
			//3. read values from the stream
			//variables to handle data read from the source file
		
			//receive daily rainfall reading
			String dailyRainfall = "";
		
			//variables to count number of daily reading in the source file
			int noOfRecords = 0;
			
			//variables to calculate the total daily rainfall
			double totalRainfall = 0.0;
			
			//read values from the stream
			
			//read the data
			dailyRainfall = brInput.readLine();
			while (dailyRainfall != null) {
				
				//display each daily rainfall reading
				System.out.println(dailyRainfall);
				
				//calculate total daily rainfall
				totalRainfall = totalRainfall + Double.parseDouble(dailyRainfall);
				
				//auto update current number of records read from the source file
				noOfRecords ++;
				
				//read next value for the daily rainfall reading
				dailyRainfall = brInput.readLine();
				
				
			}
			
			//display the total number of records for the daily rainfall readings from the source file
			System.out.println("\nTotal Records: " + noOfRecords);
			
			//display total daily rainfall
			System.out.println("Total Daily Rainfall: " + totalRainfall);
			
			//calculate average daily rainfall
			double averageRainfall = totalRainfall / Double.valueOf(noOfRecords);
			
			String formattedAverage = String.format("%.1f", averageRainfall);
			System.out.println("\nAverage rainfall for " + noOfRecords + " days from station Simpang Ampat in Alor Gajah district: " + formattedAverage);
			
			//4. close the reader
			brInput.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
