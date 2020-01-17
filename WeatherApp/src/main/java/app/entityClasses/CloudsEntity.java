package app.entityClasses;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity

public class CloudsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "clouds_all")
	private int all;
	
	public int getAll() {
		return all;
	}
	public void setAll(int all) {
		this.all = all;
	}
	
	@Override
	public String toString() {
		return "CloudsEntity [id=" + id + ", all=" + all + "]";
	}

}
