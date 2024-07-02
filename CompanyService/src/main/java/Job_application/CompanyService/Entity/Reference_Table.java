package Job_application.CompanyService.Entity;

import java.util.List;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Reference_Table {

	@Id
	@GeneratedValue
	@UuidGenerator
	@Column(name = "Id", updatable = false, nullable = false)
	private String id;
	private List<String> technologies;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<String> getTechnologies() {
		return technologies;
	}
	public void setTechnologies(List<String> technologies) {
		this.technologies = technologies;
	}
}
