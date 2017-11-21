package skeleton;

import java.util.HashMap;

public class Adapter {
	public static final String[] BEVERAGES = new String[] {
			"Caffe Americano", "Caffe Mocha", "Caffe Latte", 
			"Cappuccino", "Caramel Macchiato", "Espresso" }; // You can change these

	/**
	* This function compute the edit distance between a string and every 
	* strings in your selected beverage set. The beverage with the minimum 
	* edit distance <= 3 is returned. The use of Wagner_Fischer algorithm
	* is shown in the main function in WagnerFischer.java
	**/
	public String getBeverage(String s){
		// TODO: find the word with minimum edit distance
		WagnerFischer wf;
		int distances[] = new int[BEVERAGES.length];
		int result = -1;
		
		// Save the edit distance between user inquiry and each word in the database
		for(int i = 0; i < BEVERAGES.length; i++) {
			wf = new WagnerFischer(BEVERAGES[i], s);
	        distances[i] = wf.getDistance();
		}
		
		// Find out the minimum edit distance among the values
		for(int i = 0; i < BEVERAGES.length; i++) {
			if(distances[i] <= 3) {
				if(result < 0) {
					result = i;
				}else if(distances[i] < distances[result]){
					result = i;
				}
			}
		}
		
		// Return the value
		if(result < 0) {
			return null;
		}else{
			return BEVERAGES[result];
		}
	}
}
