package Job_application.JobsService.Entity;
import java.util.List;
import org.hibernate.annotations.UuidGenerator;

import Job_application.JobsService.external.CompanyDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
@Entity
@Table(name = "jobs_table")
public class Jobs_Table {

	@Id
	@GeneratedValue
	@UuidGenerator
	@Column(name = "Id", updatable = false, nullable = false)
	private String id;
    
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private List<String> jobDescription;

    @Column(name = "technologies_known", nullable = false,columnDefinition = "MEDIUMBLOB")
    private List<String> technologiesKnown;

    @Column(name = "qualifications",columnDefinition = "MEDIUMBLOB")
    private List<String> qualifications;
    
    @Column(name = "min_exp", nullable = false)
    private int minExp;

    @Column(name = "max_exp", nullable = false)
    private int maxExp;
    
    @Column(name = "min_sal", nullable = false)
    private int minSal;

    @Column(name = "max_sal", nullable = false)
    private int maxSal;

    @Column(name = "applied",nullable=true)
    private List<String> applied;

    @Column(name = "company_id", nullable = false)
    private String companyId;
    
    @Column(name ="Location", nullable = false)
    private String Location;
    
    @Column(name ="workmode", nullable = false)
    private String workmode;
  
    @Column(name = "Job_title", nullable = false)
    private String  jobTitle ;
    
	@Column(name="Industry_Type",nullable=false)
    private String IndustryType;
    
    @Column(name="openings",nullable=false)
    private int openings;
    
    @Column(name = "posted",nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date posted;
    
    
    public Date getPosted() {
		return posted;
	}

	public void setPosted(Date posted) {
		this.posted = posted;
	}

	public String getIndustryType() {
		return IndustryType;
	}

	public void setIndustryType(String industryType) {
		IndustryType = industryType;
	}

	public int getOpenings() {
		return openings;
	}

	public void setOpenings(int openings) {
		this.openings = openings;
	}


    public List<String> getQualifications() {
		return qualifications;
	}

	public void setQualifications(List<String> qualifications) {
		this.qualifications = qualifications;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(List<String> jobDescription) {
		this.jobDescription = jobDescription;
	}

	public List<String> getTechnologiesKnown() {
		return technologiesKnown;
	}

	public void setTechnologiesKnown(List<String> technologiesKnown) {
		this.technologiesKnown = technologiesKnown;
	}

	public int getMinExp() {
		return minExp;
	}

	public void setMinExp(int minExp) {
		this.minExp = minExp;
	}

	public int getMaxExp() {
		return maxExp;
	}

	public void setMaxExp(int maxExp) {
		this.maxExp = maxExp;
	}

	public int getMinSal() {
		return minSal;
	}

	public void setMinSal(int minSal) {
		this.minSal = minSal;
	}

	public int getMaxSal() {
		return maxSal;
	}

	public void setMaxSal(int maxSal) {
		this.maxSal = maxSal;
	}

	public List<String> getApplied() {
		return applied;
	}

	public void setApplied(List<String> applied) {
		this.applied = applied;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getWorkmode() {
		return workmode;
	}

	public void setWorkmode(String workmode) {
		this.workmode = workmode;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	
}
