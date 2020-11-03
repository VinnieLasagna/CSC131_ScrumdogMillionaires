package sample;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

public class MovieSearch
{
	JSONParser parser = new JSONParser();
	private JsonElement json;
	
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
		
		while (i.hasNext())
		{
			System.out.println("Actor: " + i.next());
		}
		
		
		
		
	}
	catch(FileNotFoundException e) (e.printStackTrace();}
	catch(IOException e) (e.printStackTrace();}
	catch(ParseException e) (e.printStackTrace();}
	catch(Exception e) (e.printStackTrace();}
	
	
}