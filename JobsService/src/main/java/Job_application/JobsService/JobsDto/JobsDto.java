package Job_application.JobsService.JobsDto;

import java.util.UUID;

public class JobsDto {
    private UUID id;
    private String jobDescription;
    private String[] technologiesKnown;
    private Integer minExp;
    private Integer maxExp;
    private Integer applied;
    private UUID companyId;
    private String Location;
    
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String[] getTechnologiesKnown() {
		return technologiesKnown;
	}
	public void setTechnologiesKnown(String[] technologiesKnown) {
		this.technologiesKnown = technologiesKnown;
	}
	public Integer getMinExp() {
		return minExp;
	}
	public void setMinExp(Integer minExp) {
		this.minExp = minExp;
	}
	public Integer getMaxExp() {
		return maxExp;
	}
	public void setMaxExp(Integer maxExp) {
		this.maxExp = maxExp;
	}
	public Integer getApplied() {
		return applied;
	}
	public void setApplied(Integer applied) {
		this.applied = applied;
	}
	public UUID getCompanyId() {
		return companyId;
	}
	public void setCompanyId(UUID companyId) {
		this.companyId = companyId;
	}

    
}
