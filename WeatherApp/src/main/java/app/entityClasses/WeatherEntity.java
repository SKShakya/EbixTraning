package app.entityClasses;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WeatherEntity {
	@Id
	private int id;
	private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "WeatherEntity [id=" + id + ", description=" + description + "]";
	}

}
