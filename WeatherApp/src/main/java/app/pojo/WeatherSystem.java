package app.pojo;




import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)

public class WeatherSystem {

	  private String country;
	  private double sunrise;
	  private double sunset;
	  
     public WeatherSystem() {
		  
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
		return "WeatherSystem [country=" + country + ", sunrise=" + sunrise + ", sunset=" + sunset + "]";
	}

	

}
