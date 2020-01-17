package app.services;

import java.util.ArrayList;
import java.util.List;

import app.entityClasses.CloudsEntity;
import app.entityClasses.CoordenateEntity;
import app.entityClasses.MainEntity;
import app.entityClasses.WeatherEntity;
import app.entityClasses.WeatherInfoEntity;
import app.entityClasses.WeatherSystemEntity;
import app.entityClasses.WindEntity;
import app.pojo.WeatherInfo;
public class DaoService {
	static  WeatherInfo daoInfo;
	
	public CloudsEntity getCloudEntity() {
		CloudsEntity cloudentity = new CloudsEntity();
		cloudentity.setAll(daoInfo.getClouds().getAll());
		return cloudentity;
		
	}
	public CoordenateEntity setCoordenateEntity() {
		CoordenateEntity cooe = new CoordenateEntity();
		cooe.setLat(daoInfo.getCoord().getLat());
		cooe.setLon(daoInfo.getCoord().getLon());
		return cooe;
		
	}
	public MainEntity getMainEntity() {
		MainEntity mEntity = new MainEntity();
		mEntity.setHumidity(daoInfo.getMain().getHumidity());
		mEntity.setPressure(daoInfo.getMain().getPressure());
		mEntity.setTemp(daoInfo.getMain().getTemp());
		mEntity.setTemp_max(daoInfo.getMain().getTemp_max());
		mEntity.setTemp_min(daoInfo.getMain().getTemp_min());
		return mEntity;
	
	}
	public WeatherEntity getWeatherEntity() {
		 WeatherEntity weatherEntity = new WeatherEntity();
		 
		 weatherEntity.setDescription(daoInfo.getWeather().get(0).getDescription());
		 weatherEntity.setId(daoInfo.getWeather().get(0).getId());
		
		 return weatherEntity;
	}
	public WeatherSystemEntity getWeatherSystemEntity() {
		WeatherSystemEntity wsEntity = new WeatherSystemEntity();
		wsEntity.setCountry(daoInfo.getSys().getCountry());
		wsEntity.setSunrise(daoInfo.getSys().getSunrise());
		wsEntity.setSunset(daoInfo.getSys().getSunset());
		return wsEntity;
		
	}
	
	public WindEntity getWindEntity() {
		WindEntity windEntity = new WindEntity();
		windEntity.setDeg(daoInfo.getWind().getDeg());
		windEntity.setSpeed(daoInfo.getWind().getSpeed());
		return windEntity;
		
	}
	public WeatherInfoEntity getWeatherInfoEntity(WeatherInfo weatherInfo) {
		
		daoInfo = weatherInfo;
		WeatherInfoEntity weatherInfoEntity = new WeatherInfoEntity();
		weatherInfoEntity.setName(daoInfo.getName());
		weatherInfoEntity.setVisibility(daoInfo.getVisibility());
		weatherInfoEntity.setBase(daoInfo.getBase());
		weatherInfoEntity.setCod(daoInfo.getCod());
		weatherInfoEntity.setDt(daoInfo.getDt());
		weatherInfoEntity.setId(daoInfo.getId());
		weatherInfoEntity.setClouds(getCloudEntity());
		weatherInfoEntity.setCoord(setCoordenateEntity());
		weatherInfoEntity.setMain(getMainEntity());
		List<WeatherEntity> weatherlist = new ArrayList<WeatherEntity>();
		weatherlist.add(getWeatherEntity());
		weatherInfoEntity.setWeather(weatherlist);
		weatherInfoEntity.setSys(getWeatherSystemEntity());
		weatherInfoEntity.setWind(getWindEntity());
		return weatherInfoEntity;
		
	 }


}
