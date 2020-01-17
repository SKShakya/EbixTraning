package app.utill;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import app.pojo.Student;

public class Util {
	
   //Mark: This method will return hibrenet section
	public static Session getSession(Object obj) {
		  Configuration conf = new Configuration().configure().addAnnotatedClass(obj.getClass());
		  SessionFactory sf = conf.buildSessionFactory(); 
		  return sf.openSession();
		
	}

	//Mark: This method will return True if date string is valid
	  public static boolean isValidDate(String dateStr) {
		    String dateFormat = "yyyy/MM/dd";
	        DateFormat sdf = new SimpleDateFormat(dateFormat);
	        try {
	            sdf.parse(dateStr);
	        } catch (ParseException e) {
	        	System.out.println(e);
	            return false;
	        }
	        return true;
	    }
	  //Mark: This method will return true if string is valid
	   public static boolean isValidString(String str) {
			return str.matches("[A-Za-z]+");
		}
	  //Mark: This method will return true if string is convertable in Number
	   public static boolean isValidInt(CharSequence id) {
			return Pattern.matches("[0-9]+",id);
		}
	   public static JSONObject readFile() throws org.json.simple.parser.ParseException {
		   
		   JSONObject jsonObj = null;
		   JSONParser jsonParser = new JSONParser();
		   try
	        {
	        	FileReader reader = new FileReader("city-list.json");
	            Object obj = jsonParser.parse(reader);
	 
	            jsonObj = (JSONObject) obj;


	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		return jsonObj;
		
	   }
	   public static double getTemperatureKtoF(double kalbinTemp) {
		   return Math.round((kalbinTemp - 273.15)*(9/5)+32);
		   
	   }
	   public static double getTemperatureKtoC(double kalbinTemp) {
		   return Math.round(kalbinTemp - 273.15);  
	   }
	   public static void timstampToDate(double timestamp) {
		   
		  // return    new java.util.Date(timestamp.getTime());
		   System.out.println(timestamp);
	   }
	 
	 

}
