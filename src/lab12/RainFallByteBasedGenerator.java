package lab12;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class RainFallByteBasedGenerator {
	
	public static void main (String [] args)
	{
		//1. declare output file
		String outFile = "RainfallByteBased.txt";
		
		//data declaration
		//station id
		int id[] = {2421003, 2222002, 2324033, 2125002, 2223023,2222006};
		
		//station name
		String stations[] = {"Simpang Ampat", "Durian Tunggal", "Hospital Jasin", "Telok Rimba", "Sg. Duyong", "Cheng (Taman Merdeka"};
		
		//district name
		String district[] = {"Alor Gajah", "Alor Gajah", "Jasin", "Jasin", "Melaka Tengah", "Melaka Tengah"};
		
		//readings on 1 June 2023
		double readings1[] = {0.0, 2.0, 22.0, 13.0, 37.0, 20.0};
		
		//readings on 2 June 2023
		double readings2[] = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		
		//readings on 3 June 2023
		double readings3[] = {4.0, 0.0, 14.0, 0.0, 0.0, 0.0};
		
		//readings on 4 June 2023
		double readings4[] = {1.0, 0.0, 14.0, 1.0, 3.0, 3.5};
		
		//readings on 5 June 2023
		double readings5[] = {0.0, 0.0, 0.0, 1.0, 0.0, 0.0};
		
		//readings on 6 June 2023
		double readings6[] = {6.0, 37.0, 11.0, 69.0, 43.0, 42.5};
		
		try {
			//2. create output stream to read data
			DataOutputStream dosOut = new DataOutputStream(new FileOutputStream(outFile));
			
			//process data
			for (int index = 0; index < stations.length; index++) {
				
				//3. write data into data stream
				dosOut.writeInt(id[index]);
				dosOut.writeUTF(stations[index]);
				dosOut.writeUTF(district[index]);
				dosOut.writeDouble(readings1[index]);
				dosOut.writeDouble(readings2[index]);
				dosOut.writeDouble(readings3[index]);
				dosOut.writeDouble(readings4[index]);
				dosOut.writeDouble(readings5[index]);
				dosOut.writeDouble(readings6[index]);
				
				//4. Flush for each writing
				dosOut.flush();
				
			}
			
			//5. close stream
			dosOut.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			
		}
		
		//indicate end of program - could be successful
		System.out.println("End of program. Checkout " + outFile);
		
	}	

}
