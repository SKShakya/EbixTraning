package app.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import app.pojo.WeatherInfo;
@Component
public class APIService {
	 public APIService() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	RestTemplate restTemplate;
	public static JSONObject getJSONObject(String urlString) throws IOException, ParseException {
	   URL url = null;
	   try {
		  url = new URL(urlString);
	   } catch (MalformedURLException e) {
		  e.printStackTrace();
	   }
	     
      URLConnection connection = url.openConnection();
      BufferedReader in = new BufferedReader(new InputStreamReader(
     		 connection.getInputStream()));
      StringBuffer sb = new StringBuffer();
      sb.append(in.readLine());
    
      JSONParser parser = new JSONParser();
      JSONObject json = (JSONObject) parser.parse(sb.toString());
      in.close();
      return json;
	}
	public static void parseUrlByJsonObject(String myurl) throws IOException, ParseException {
		 System.out.println("*************Parsing By JSONObject *******************");
         JSONObject json = getJSONObject(myurl); 
         System.out.println(json);
         System.out.println(json.get("main"));
         System.out.println(json.get("name"));
         System.out.println(json.get("weather"));
         JSONArray jsonarr_1 = (JSONArray)json.get("weather");
			for(int i=0;i<jsonarr_1.size();i++)
			{
			 JSONObject jsonobj_1 = (JSONObject)jsonarr_1.get(i);
			   System.out.println("Elements in jsonArray");
			   System.out.println(jsonobj_1.get("icon"));
			   System.out.println(jsonobj_1.get("description"));
			   System.out.println(jsonobj_1.get("main"));
			}
			JSONObject jsonobj_2 = (JSONObject)json.get("coord");
			System.out.println("Longi tonitute and latitute ");
			System.out.println(jsonobj_2.get("lon"));
			System.out.println(jsonobj_2.get("lat"));
	}
	public WeatherInfo parseByObjectMaper(String url) throws IOException, ParseException {
		System.out.println("*********ParsingByObjectMaper************");
		JSONObject obj = getJSONObject(url);
		String jsonString = obj.toJSONString();
		ObjectMapper mapper = new ObjectMapper();
		WeatherInfo pojoObject = mapper.readValue(jsonString, WeatherInfo.class);
		System.out.println(pojoObject);
		return pojoObject;

	}
	public  void parseUrlByRestTemplate(String url) {
		System.out.println(restTemplate.hashCode());
		WeatherInfo pojoObject = restTemplate.getForObject(url, WeatherInfo.class);
		System.out.println(pojoObject);
		
	}

}
