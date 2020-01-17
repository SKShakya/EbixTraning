package app.main;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

import org.hibernate.AnnotationException;
import org.hibernate.HibernateException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import app.dao.AppDao;
import app.pojo.WeatherInfo;
import app.services.APIService;
import app.utill.Util;
import app.web.AppInfo;

public class AppMainClass {

	@Autowired
	RestTemplate restTemplate;
	public void callRestAPI(String url) {
		WeatherInfo weather = restTemplate.getForObject(url, WeatherInfo.class);
		System.out.println(weather);
	}
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		try {
			String mykey = AppInfo.apiKey;
			System.out.println("Enter the City Name");
			String city = sc.nextLine();
			System.out.println("Enter The Contery Code");
			String conterycode = sc.nextLine();
			String myurl = null;
			myurl = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "," + conterycode + "&appid=" + mykey;
			APIService.parseUrlByJsonObject(myurl);
			APIService service = new APIService();
			WeatherInfo pojoObj = service.parseByObjectMaper(myurl);
			System.out.println("Current Temp : "+Util.getTemperatureKtoC(pojoObj.getMain().getTemp())+"C >> Max Temp "+pojoObj.getMain().getTemp_max()+"F >>Min Temp "+pojoObj.getMain().getTemp_min()+"F");
			System.out.println("Weather Pressure: "+pojoObj.getMain().getPressure());
			JSONObject result = Util.readFile();
			System.out.println("contery Code on given City :- " + result.get(city));
			
			/*****************TestSavingObjects*****************/
		    AppDao.saveWeatherInfo(pojoObj);
	
			/**************Retriving Objects****************/
		
		    AppDao.getWeatherInfoEntity(pojoObj.getId());
		    

		}
		catch (AnnotationException e) {
			System.out.println("AnnotationException Catch block ");
			e.printStackTrace();
		} 
		catch (HibernateException e) {
			System.out.println("HibernateException Catch block ");
			e.printStackTrace();
		}
		catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException Catch block ");
			e.printStackTrace();
		}
	
		catch (Exception e) {
			System.out.println("Exception Catch block ");
			e.printStackTrace();
		}
		sc.close();


	}

}
