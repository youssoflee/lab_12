package lab12;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;

public class RainFallByteBasedReader {
	
	public static void main(String[] args) {
		
		//1. declare source file
		String sourceFile = "RainfallByteBased.txt";
		System.out.println("Reading data from: " + sourceFile + "\n");
		
		try {
			
			//2. create input stream to read data
			DataInputStream disIn = new DataInputStream(new FileInputStream(sourceFile));
			
			//variables for processing byte-based data
			//station Id
			int id = 0;
			
			//station name and district
			String station = " ", district = " ";
			
			//daily rainfall readings from 1 June 2023 to 6 June 2023
			double readings1 = 0.0, readings2 = 0.0, readings3 = 0.0;
			double readings4 = 0.0, readings5 = 0.0, readings6 = 0.0;
			
			//variable declaration for calculation
			//total number of records read from the source file
			int noOfRecords = 0;
			
			//total daily rainfall readings for each station
			double sum = 0.0;
			
			//declaration of ArrayList to store the each total daily rainfall readings
			ArrayList<Double> totalRainfall = new ArrayList<Double>();
			
			//ArrayList to store stations for calculation propose
			ArrayList<String> stations = new ArrayList<String>();
			
			//Hashset to store distinct district for calculation purpose
			HashSet<String> districtCount = new HashSet<String>();
			
			//3. process data until end-of-file
			while(disIn.available() > 0) {
				//read data
				
				//station
				id = disIn.readInt();
				
				//station name
				station = disIn.readUTF();
				
				//district
				district = disIn.readUTF();
				
				//daily rainfall readings for 1 June 2023
				readings1 = disIn.readDouble();
				
				//daily rainfall readings for 2 June 2023
				readings2 = disIn.readDouble();
				
				//daily rainfall readings for 3 June 2023
				readings3 = disIn.readDouble();
				
				//daily rainfall readings for 4 June 2023
				readings4 = disIn.readDouble();
				
				//daily rainfall readings for 5 June 2023
				readings5 = disIn.readDouble();
				
				//daily rainfall readings for 6 June 2023
				readings6 = disIn.readDouble();
				
				System.out.println(id + "\t" + station + "\t" + district
						+ "\t" + readings1 + "\t" + readings2 + "\t" + readings3
						+ "\t" + readings4 + "\t" + readings5 + "\t" + readings6);
				
				//calculate total daily rainfall readings for each station
				sum = readings1 + readings2 + readings3 + readings4 + readings5 + readings6;
				
				//save the sum into arraylist, totalrainfall
				totalRainfall.add(sum);
				
				//save the station names into the arraylist, stations
				stations.add(station);
				
				//save the distinct district into hashset, districtcount
				districtCount.add(district);
				
				//auto update for current number of records
				noOfRecords ++;
				
				
			}
			
			System.out.println("\n");
			
			//calculation for average daily rainfall readings in each station
			for(int index = 0; index < stations.size(); index++)
			{
				//calculation for average daily rainfall readings in each station
				double average = totalRainfall.get(index) / noOfRecords;
				
				//format the average in one decimal places
				String formattedAverage = String.format("%.1f", average);
				
				//display the total daily rainfall readings in each station and its correspond average
				System.out.println("The total daily rainfall readings in " + stations.get(index) + " : " + totalRainfall.get(index));
				System.out.println("The average daily rainfall readings in " + stations.get(index) + " : " + formattedAverage + "\n");
				
			}
			System.out.println("Ther are " + stations.size() + "stations and " + districtCount.size() + " districts in Melaka");
			
			//4. close stream
			disIn.close();	
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		//indicate end of program - could be successful
		System.out.println("\nEnd of program.");
	}

}
