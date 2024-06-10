package Job_application.JobsService.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Job_application.JobsService.Entity.Jobs_Table;
import Job_application.JobsService.FeignClient.CompanyClient;
import Job_application.JobsService.FeignClient.UserClient;
import Job_application.JobsService.JobsDto.JobsDto;
import Job_application.JobsService.JobsRepository.JobsRepository;
import Job_application.JobsService.Service.JobsService;
import Job_application.JobsService.external.UserDto;

@RestController
@RequestMapping("/Jobs")
public class JobsController {

	@Autowired
	private JobsService jobsService;
	
	@Autowired
	private UserClient userClient;
	
	@Autowired
	private CompanyClient companyClient;
	
	@Autowired
	private JobsRepository jobsRepository;

	@PostMapping("/save")
	public JobsDto saveJob(@RequestBody JobsDto jobsDto) {
		JobsDto savedjobs = jobsService.SaveJob(jobsDto);
		return savedjobs;

	}
	
	@GetMapping("/job_details")
	public Jobs_Table GetJobDetails(@RequestParam UUID id) {
		Jobs_Table jobs = jobsRepository.findById(id).get();
		return jobs;
		
	}
	
	@PutMapping("/update_job_details")
	public JobsDto updateJobDetails(@RequestParam(name = "id") UUID id,@RequestBody JobsDto jobsDto) {
		JobsDto updatedJob = jobsService.updateJobDetails(id,jobsDto);
		return updatedJob;
		
	}
	
	@GetMapping("/fetch_all_jobs")
	public List<Jobs_Table> FetchAllJobs(){
		List<Jobs_Table> alljobs = jobsService.FetchAllJobs();
		return alljobs;
		
	}

    @GetMapping("/fetch_jobs_by_companyId/{CompanyId}")
    public List<Jobs_Table> getJobsByCompanyId(@PathVariable UUID CompanyId) {
    	List<Jobs_Table> AllJobsbyCompany = jobsService.findAllJobsByCompanyId(CompanyId);

    	return AllJobsbyCompany;
    }
	
	
	@GetMapping("/Search_jobs_by_name")
	  public List<Jobs_Table> searchByJobDescriptionIgnoreCase(@RequestParam String jobDescription) {
	        return jobsRepository.findByJobDescriptionContainingIgnoreCase(jobDescription);
	    }

	
	@DeleteMapping("/delete_job/{Job_Id}")
	public String DeleteJobByCompany(@PathVariable UUID Job_Id ) {
		jobsRepository.deleteById(Job_Id);
		return "Deleted";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
  @GetMapping("/company_details")
  public String companyDetails() {
	  return companyClient.CompanyDetails();
  }
}
