package Job_application.CompanyService.CompanyDto;

import java.util.List;
import java.util.UUID;



public class CompanyDto {
	
    private UUID id;
    private String companyName;
    private String companyDescription;
    private List<String> workingTechnologies;
   
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
    
}
