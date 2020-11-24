package com.example.oscarsmoviesrequest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import org.json.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

public class MovieSearch
{
	
	public String[] convertToStringArray(JSONObject json, int size) {
		JSONArray array = new JSONArray();
		System.out.println(json.toString());
		//Iterator<String> itr = json.keySet();
		//ArrayList
		/*
		JSONArray array = (JSONArray) json.get("ACTOR");
		String[] strings = new String[size];
		//ArrayList<String> strings = new ArrayList<String>();
		for (int i = 0; i < array.size(); i++) {
			strings[i] = (String) (array.get(i));
			System.out.println(strings[i]);
		}
		*/
		
		
		/*
		
		for (int i = 0; i < array.size(); i++) {
			strings[i] = array.getString("year_film");
			strings.add();
		}*/
		
		return strings;
	}
	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		//private JsonElement json;
		
		/*public String getActor()
		{
			
		}*/
		
		try
		{
			Object obj = parser.parse(new FileReader("datahubio_oscar_data_json.json"));
			JSONObject jsonObj = (JSONObject) obj;
			//String name = (String) jsonObj.get("ACTOR");
			//System.out.println("name is: " + name);
			
			JSONArray arr = (JSONArray) jsonObj.get("ACTOR");
			//how many items to loop thru
			Iterator<String> i = arr.iterator();
			//iterate through JSONArray
			while (i.hasNext())
			{
				System.out.println("Actor: " + i.next());
			}		
		}
		catch(FileNotFoundException e) {e.printStackTrace();}
		catch(IOException e) {e.printStackTrace();}
		catch(ParseException e) {e.printStackTrace();}
		catch(Exception e) {e.printStackTrace();}
	}
	
}