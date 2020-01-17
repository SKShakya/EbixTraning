package app.entityClasses;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class WeatherInfoEntity {
	@Id
	private int id;
	private Long dt;
	private String name;
	private String base;
	private double visibility;
	private int cod;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Main_ID", referencedColumnName = "id")
	private MainEntity main;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Wind_ID", referencedColumnName = "id")
	private WindEntity wind;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CloudsEntity_ID", referencedColumnName = "id")
	private CloudsEntity clouds;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "WeatherSystem_ID", referencedColumnName = "id")
	private WeatherSystemEntity sys;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "Weather_ID", referencedColumnName = "id")
	private List<WeatherEntity> weather;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Coordanete_ID", referencedColumnName = "id")
	private CoordenateEntity coord;

	public CoordenateEntity getCoord() {
		return coord;
	}

	public void setCoord(CoordenateEntity coord) {
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

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public MainEntity getMain() {
		return main;
	}

	public void setMain(MainEntity main) {
		this.main = main;
	}

	public double getVisibility() {
		return visibility;
	}

	public void setVisibility(double visibility) {
		this.visibility = visibility;
	}

	public WindEntity getWind() {
		return wind;
	}

	public void setWind(WindEntity wind) {
		this.wind = wind;
	}

	public CloudsEntity getClouds() {
		return clouds;
	}

	public void setClouds(CloudsEntity cloudsEntity) {
		this.clouds = cloudsEntity;
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

	public WeatherSystemEntity getSys() {
		return sys;
	}

	public void setSys(WeatherSystemEntity sys) {
		this.sys = sys;
	}
	
	public List<WeatherEntity> getWeather() {
		return weather;
	}

	public void setWeather(List<WeatherEntity> weather) {
		this.weather = weather;
	}


//	@Override
//	public String toString() {
//		return "WeatherInfoEntity [dt=" + dt + ", name=" + name + ", base=" + base + ", main=" + main + ", visibility="
//				+ visibility + ", wind=" + wind + ", clouds=" + clouds + ", id=" + id + ", cod=" + cod + ", sys=" + sys
//				+ ", weather=" + weather + ", coord=" + coord + "]";
//	}

}
