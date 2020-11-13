package com.example.oscarsmoviesrequest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ConvertCSVtoArrayList {
	public static void main(String[] args) {
		BufferedReader convertBuffer = null;
		
		try {
			String convertLine;
			convertBuffer = new BufferedReader(new FileReader("C:\\Users\\donny\\git\\CSC131_ScrumdogMillionaires\\datahubio_oscar_data_csv.csv"));
		
			while ((convertLine = convertBuffer.readLine()) != null) {
				System.out.println("Raw CSV data: " + convertLine);
				System.out.println("Converted ArrayList data: " + convertCSVtoArrayList(convertLine));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (convertBuffer != null) {
					convertBuffer.close();
				}
			}
			catch (IOException convertException) {
				convertException.printStackTrace();
			}
		}		
	}
	
	public static ArrayList<String> convertCSVtoArrayList(String convertCSV) {
		ArrayList<String> convertResult = new ArrayList<String>();
		
		if (convertCSV != null) {
			String[] splitData = convertCSV.split("\\s*,\\s*");		//matches any whitespace in string and splits string token
			for (int i = 0; i < splitData.length; i++) {
				if (!(splitData[i] == null) || !(splitData[i].length() == 0)) {
					convertResult.add(splitData[i].trim());
				}
			}
		}	
		return convertResult;
	}
}