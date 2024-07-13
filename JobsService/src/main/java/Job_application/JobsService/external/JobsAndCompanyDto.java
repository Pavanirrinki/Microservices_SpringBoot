package Job_application.JobsService.external;

import java.util.Date;
import java.util.List;

import Job_application.JobsService.Entity.Jobs_Table;

public class JobsAndCompanyDto {
	private String id;
	private List<String> jobDescription;
	private List<String> technologiesKnown;
	private List<String> qualifications;
	private int minExp;
	private int maxExp;
	private int minSal;
	private int maxSal;
	private List<String> applied;
	private CompanyDto companyId;
	private String Location;
	private String workmode;
	private String  jobTitle ;
    private String IndustryType;
    private int openings;
    private Date posted;
    private UserDto userId;
    
   
	public UserDto getUserId() {
		return userId;
	}
	public void setUserId(UserDto userId) {
		this.userId = userId;
	}
	public List<String> getQualifications() {
		return qualifications;
	}
	public void setQualifications(List<String> qualifications) {
		this.qualifications = qualifications;
	}
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
	public CompanyDto getCompanyId() {
		return companyId;
	}
	public void setCompanyId(CompanyDto companyId) {
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
