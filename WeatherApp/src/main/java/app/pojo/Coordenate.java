package app.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Coordenate {

  
	private Double lon;
	
	private Double lat;
	
    public Coordenate(){
		
	}
    
	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	@Override
	public String toString() {
		return "Coordenate [lon=" + lon + ", lat=" + lat + "]";
	}



}
