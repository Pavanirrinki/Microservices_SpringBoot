package Job_application.CompanyService.CompanyDto;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;



public class CompanyDto {
	
    private UUID id;
    private String name;
    private List<String> companyDescription;
    private List<String> workingTechnologies;
    private String email;
    private long mobilenumber;
	private String profile_pic;
	
    public String getProfile_pic() {
		return profile_pic;
	}
	public void setProfile_pic(String profile_pic) {
		this.profile_pic = profile_pic;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String password;
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}

	public List<String> getCompanyDescription() {
		return companyDescription;
	}
	public void setCompanyDescription(List<String> companyDescription) {
		this.companyDescription = companyDescription;
	}
	public List<String> getWorkingTechnologies() {
		return workingTechnologies;
	}
	public void setWorkingTechnologies(List<String> workingTechnologies) {
		this.workingTechnologies = workingTechnologies;
	}
    
}
