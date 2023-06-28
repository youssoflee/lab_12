package lab12;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class RainFallDataReader {
	public static void main(String [] args) {
		
		//1. Declare output file
		String sourceFile = "RainFall.txt";
		
		//display the sentence for reading data
		System.out.println("Reading data from " + sourceFile + "\n");
		
		try {
			//. create stream to read data
			DataInputStream disInput = new DataInputStream(new FileInputStream(sourceFile));
			
			//3. Read values from the stream
			//variables to handle data read from the source file
			
			//receive daily rainfall reading
			double dailyRainfall = 0;
			
			//variables to count number of daily reading in the source file
			int noOfRecords = 0;
			
			//variable to calculate total daily rainfall
			double totalRainfall = 0.0;
			
			//read values from the stream
			dailyRainfall = disInput.read();
			
			System.out.println("The 6 days reading of daily rainfall from station Simpang Ampat in Alor Gajah district: ");
			
			//-1: read until end of file/stream
			while (dailyRainfall != -1) {
				
				//display each daily rainfall reading
				System.out.println(dailyRainfall);
				
				//calculate total daily rainfall
				totalRainfall = totalRainfall + dailyRainfall;
				
				//auto update current number of records
				noOfRecords ++;
				
				//read next value for the daily rainfall
				dailyRainfall = disInput.read();
			}
			
			//display total number of records for the daily rainfall readings from the source file
			System.out.println("\nTotal Records: " + noOfRecords);
			
			//display total number of records for the daily rainfall readings from the source file
			System.out.println("\nTotal Daily Rainfall: " + totalRainfall);
			
			//calculate average daily rainfall
			double averageRainfall = totalRainfall / Double.valueOf(noOfRecords);
			
			String formattedAverage = String.format("%.1f", averageRainfall);
			System.out.println("\nAverage rainfall for " + noOfRecords + " days from station Simpang Ampat in Alor Gajah district: " + formattedAverage);
			
			//4. Close stream
			disInput.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		//Indicate end of program - could be successful
		System.out.println("\nEnd of program");
		
		
		
	}

}
