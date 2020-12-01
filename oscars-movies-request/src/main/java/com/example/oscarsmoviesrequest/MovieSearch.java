package com.example.oscarsmoviesrequest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.simple.parser.JSONParser;

public class MovieSearch {

	public String[] convertToStringArray(String json, String searchWord) {
		String s = "[\"A\",\"B\",\"C\",\"D\",\"E\"]";
		ObjectMapper mapper = new ObjectMapper();
		// String[] arr = mapper.readValue(s, String[].class);
		// if JSONObject is parameter

		/*
		 * JSONObject convert = json.getJSONObject(searchWord); JSONArray array =
		 * convert.toJSONArray(convert.names()); String[] strings = new
		 * String[array.length()]; try { //array = new JSONArray(json);
		 * 
		 * for (int i = 0; i < array.length(); i++) { strings[i] = array.optString(i);
		 * //strings[i] = (String) array.optString("year_film");
		 * System.out.print(strings[i] + " "); } System.out.println(""); } catch
		 * (JSONException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * //JSONArray array = json.toJSONArray(json);
		 * //System.out.println(json.toString()); //Iterator<String> itr =
		 * json.keySet();
		 */

		// if String is parameter -> convert string into string array
		System.out.println(json);
		String[] strings = new String[json.length()];
		// ArrayList<String> strings = new ArrayList<String>();
		/*
		 * JSONArray array = new JSONArray(json); for (int i = 0; i < array.length();
		 * i++) {
		 * 
		 * strings[i] = array.getString(i); }
		 */

		/*
		 * 
		 * for (int i = 0; i < array.size(); i++) {
		 * 
		 * strings.add(); }
		 */

		return strings;
	}

	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		// private JsonElement json;

		/*
		 * public String getActor() {
		 * 
		 * }
		 */

		try {
			Object obj = parser.parse(new FileReader("datahubio_oscar_data_json.json"));
			JSONObject jsonObj = (JSONObject) obj;
			// String name = (String) jsonObj.get("ACTOR");
			// System.out.println("name is: " + name);

			JSONArray arr = (JSONArray) jsonObj.get("ACTOR");
			// how many items to loop thru
			// Iterator<String> i = arr.iterator();
			// iterate through JSONArray
			// while (i.hasNext())
			// {
			// System.out.println("Actor: " + i.next());
			// }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}