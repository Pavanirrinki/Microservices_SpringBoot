package Job_application.CompanyService.Entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "company_table")
public class Company_Table {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id", updatable = false, nullable = false)
	private UUID id;

	private String companyName;

	private String companyDescription;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyDescription() {
		return companyDescription;
	}

	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}

	public List<String> getWorkingTechnologies() {
		return workingTechnologies;
	}

	public void setWorkingTechnologies(List<String> workingTechnologies) {
		this.workingTechnologies = workingTechnologies;
	}

	private List<String> workingTechnologies;

}
