package app.entityClasses;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class WeatherSystemEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	  private String country;
	  
	  private double sunrise;
	  
	  private double sunset;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public double getSunrise() {
		return sunrise;
	}

	public void setSunrise(double sunrise) {
		this.sunrise = sunrise;
	}

	public double getSunset() {
		return sunset;
	}

	public void setSunset(double sunset) {
		this.sunset = sunset;
	}
	@Override
	public String toString() {
		return "WeatherSystemEntity [id=" + id + ", country=" + country + ", sunrise=" + sunrise + ", sunset=" + sunset
				+ "]";
	}

}
