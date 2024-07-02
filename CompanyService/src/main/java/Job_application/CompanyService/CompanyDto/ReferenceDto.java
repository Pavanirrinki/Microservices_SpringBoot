package Job_application.CompanyService.CompanyDto;

import java.util.List;

public class ReferenceDto {
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
