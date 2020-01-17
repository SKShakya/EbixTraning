package app.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import app.entityClasses.CloudsEntity;
import app.entityClasses.CoordenateEntity;
import app.entityClasses.MainEntity;
import app.entityClasses.WeatherEntity;
import app.entityClasses.WeatherInfoEntity;
import app.entityClasses.WeatherSystemEntity;
import app.entityClasses.WindEntity;
import app.pojo.*;
import app.utill.*;
import app.services.*;

public class AppDao {
	static Configuration conf = new Configuration().configure().addAnnotatedClass(WeatherInfoEntity.class);
	static SessionFactory sf = conf.buildSessionFactory();

	// Mark: This method will save the object
	public static void saveWeatherInfo(WeatherInfo weatherInfo) {
		DaoService dao = new DaoService();
		WeatherInfoEntity weatherInfoEntity = dao.getWeatherInfoEntity(weatherInfo);
		saveWeatherInfoEntity(weatherInfoEntity);

	}

	public static void getObject(Student student){
		Session session = Util.getSession(student);
		System.out.println("************Select Data from DB***********");
		Student dbStudent = session.get(Student.class, 600);
		System.out.println(dbStudent);
		session.close();
		System.out.println("dbStudent==student: " + (dbStudent == student));

	}
	public static void saveWeatherInfoEntity(WeatherInfoEntity weatherInfo) {
		CloudsEntity  cloudsEntity = weatherInfo.getClouds();
		CoordenateEntity cooredaneEntity = weatherInfo.getCoord();
		MainEntity mainEntity = weatherInfo.getMain();
		
		System.out.println(mainEntity);
		
		Collection<WeatherEntity> weatherEntity = weatherInfo.getWeather();
		System.out.println(weatherEntity);
		
		WeatherSystemEntity weatherSystemEntity = weatherInfo.getSys();
		WindEntity windEntity = weatherInfo.getWind();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(cloudsEntity);
		session.save(cooredaneEntity);
		session.save(mainEntity);
		Iterator<WeatherEntity> iterator = weatherEntity.iterator();
	     while (iterator.hasNext()) {
	    	session.save(iterator.next());
	     }		
		session.save(weatherSystemEntity);
		session.save(weatherInfo);
		session.save(windEntity);
		transaction.commit();
	}
	public static void getWeatherInfoEntity(int id) {
		Session session = sf.openSession();
		WeatherInfoEntity obj = session.get(WeatherInfoEntity.class, id);
		System.out.println("Current temp in "+obj.getName()+ ">>> "+Util.getTemperatureKtoC(obj.getMain().getTemp())+"c");
		session.close();
		
	}
	
	public static void saveObject() throws ParseException {

		Student student = new Student();
		student.setRollNo(601);
		student.setFirstName("Aman");
		student.setLastName("Gupta");
		student.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2017-11-15"));
		Configuration conf = new Configuration().configure().addAnnotatedClass(Student.class);
		SessionFactory sf = conf.buildSessionFactory();

		Session session = sf.openSession();

		Transaction transaction = session.beginTransaction();
		session.save(student);
		transaction.commit();
		/*
		 * Transaction transaction1 = session.beginTransaction();
		 * student.setFirstName("Ali"); student.setLastName("Ahamad");
		 * 
		 * student.setFirstName("Shiv"); student.setLastName("Kumar");
		 * transaction1.commit();
		 */
		session.close();
		Session newSession = sf.openSession();
		System.out.println("************Select Data from DB***********");
		Student dbStudent = newSession.get(Student.class, student.getRollNo());
		System.out.println(dbStudent);
		newSession.close();
		System.out.println("dbStudent==student: " + (dbStudent == student));

	}

}
