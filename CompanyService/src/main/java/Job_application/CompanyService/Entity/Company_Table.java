package Job_application.CompanyService.Entity;
import java.util.List;
import org.hibernate.annotations.UuidGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Lob;


@Entity
@Table(name = "company_table")
public class Company_Table {

	@Id
	@GeneratedValue
	@UuidGenerator
	@Column(name = "Id", updatable = false, nullable = false)
	private String id;
    private String name;

	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private List<String> companyDescription;
    private String email;
	private long mobilenumber;
	private String password;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String Comapany_profile_pic;
	
	public long getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getComapany_profile_pic() {
		return Comapany_profile_pic;
	}

	public void setComapany_profile_pic(String comapany_profile_pic) {
		Comapany_profile_pic = comapany_profile_pic;
	}

	private List<String> workingTechnologies;
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobilenumber;
	}

	public void setMobile(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
