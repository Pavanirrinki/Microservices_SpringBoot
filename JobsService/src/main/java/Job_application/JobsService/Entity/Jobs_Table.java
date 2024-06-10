package Job_application.JobsService.Entity;

import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "jobs_table")
public class Jobs_Table {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private UUID id;

    @Column(name = "job_description", nullable = false)
    private String jobDescription;

    @Column(name = "technologies_known", nullable = false)
    private String[] technologiesKnown;

    @Column(name = "min_exp", nullable = false)
    private Integer minExp;

    @Column(name = "max_exp", nullable = false)
    private Integer maxExp;

    @Column(name = "applied", nullable = false)
    private Integer applied;

    @Column(name = "company_id", nullable = false)
    private UUID companyId;
    
    @Column(name ="Location", nullable = false)
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

    // Getters and Setters
}
