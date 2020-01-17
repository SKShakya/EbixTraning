package app.pojo;

import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class WeatherInfo {

	private Coordenate coord;

	private Long dt;

	private String name;

	private String base;

	private Main main;
	private double visibility;

	private Wind wind;

	private Clouds clouds;

	private int id;

	private int cod;
	
	private WeatherSystem sys;

	private List<Weather> weather = new ArrayList<Weather>();

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public double getVisibility() {
		return visibility;
	}

	public void setVisibility(double visibility) {
		this.visibility = visibility;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public Clouds getClouds() {
		return clouds;
	}

	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public WeatherSystem getSys() {
		return sys;
	}

	public void setSys(WeatherSystem sys) {
		this.sys = sys;
	}

	public List<Weather> getWeather() {
		return weather;
	}

	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	public WeatherInfo() {

	}

	public Coordenate getCoord() {
		return coord;
	}

	public void setCoord(Coordenate coord) {
		this.coord = coord;
	}

	public Long getDt() {
		return dt;
	}

	public void setDt(Long dt) {
		this.dt = dt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "WeatherInfo [coord=" + coord + ", dt=" + dt + ", name=" + name + ", base=" + base + ", main=" + main
				+ ", visibility=" + visibility + ", wind=" + wind + ", clouds=" + clouds + ", id=" + id + ", cod=" + cod
				+ ", sys=" + sys + ", weather=" + weather + "]";
	}
		
	

}
