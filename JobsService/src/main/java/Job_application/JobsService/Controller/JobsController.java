package Job_application.JobsService.Controller;

import java.util.ArrayList;

import java.util.List;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
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
import Job_application.JobsService.JobsDto.JobWithUserDetailsResponse;
import Job_application.JobsService.JobsDto.JobsDto;
import Job_application.JobsService.JobsRepository.JobsRepository;
import Job_application.JobsService.Service.JobsService;
import Job_application.JobsService.external.JobsAndCompanyDto;


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
	
	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/save")
	public JobsDto saveJob(@RequestParam("jobDescription") List<String> jobDescription,
            @RequestParam("minExp") String minExp,
            @RequestParam("maxExp") String maxExp,
            @RequestParam("minSal") String minSal,
            @RequestParam("maxSal") String maxSal,
            @RequestParam("companyId") String companyId,
            @RequestParam("location") String location,
            @RequestParam("workmode") String workmode,
            @RequestParam("jobTitle") String jobTitle,
            @RequestParam("industryType") String industryType,
            @RequestParam("openings") String openings,
            @RequestParam("skills") List<String> skills,
            @RequestParam("qualifications") List<String> qualifications) {
		JobsDto savedjobs = jobsService.SaveJob(jobDescription,minExp,maxExp,minSal,maxSal,companyId,location,workmode,jobTitle,industryType,openings,skills,qualifications);
		return savedjobs;

	}
	

	
	@PutMapping("/update_job_details")
	public JobsDto updateJobDetails(@RequestParam(name = "id") String id,@RequestBody JobsDto jobsDto) {
		JobsDto updatedJob = jobsService.updateJobDetails(id,jobsDto);
		return updatedJob;
		
	}
	

    @GetMapping("/fetch_all_jobs")
    public ResponseEntity<List<JobsAndCompanyDto>> fetchAllJobs() {
        List<JobsAndCompanyDto> allJobs = jobsService.FetchAllJobs();
        return ResponseEntity.ok(allJobs);
    }

    @GetMapping("/fetch_jobs_by_companyId/{CompanyId}")
    public List<Jobs_Table> getJobsByCompanyId(@PathVariable String CompanyId) {
    	List<Jobs_Table> AllJobsbyCompany = jobsService.findAllJobsByCompanyId(CompanyId);

    	return AllJobsbyCompany;
    }
	
	
	@GetMapping("/Search_jobs_by_name/{title}")
	  public List<Jobs_Table> searchByJobDescriptionIgnoreCase(@PathVariable("title") String title) {
		  List<Jobs_Table> searchByJobDescription = jobsService.findByJobDescription(title);
		  return searchByJobDescription;
	    }

	
	@DeleteMapping("/delete_job/{Job_Id}")
	public String DeleteJobByCompany(@PathVariable String Job_Id ) {
		String DeleteJob = jobsService.DeleteJob(Job_Id);
		return DeleteJob;
		
	}
	
	@GetMapping("/Job_details/{id}")
	public JobsAndCompanyDto GetParticularJob(@PathVariable(name ="id") String user_id) {

		JobsAndCompanyDto particularJobDetails = jobsService.particularJobDetails(user_id);
		return particularJobDetails;
		
	}
	
	@PostMapping("/update_applied_Job")
	public String UpdateAppliedJob(@RequestParam(name = "jobIds") String jobIds,
            @RequestParam(name = "userId") String userId) {
	    String saveUser = jobsService.UpdateAppliedJob(jobIds,userId);
	    return saveUser;
	}


	
    @GetMapping("/fetch_jobs_by_companyId")
    public List<Jobs_Table> getJobsByCompanyId() {
       return jobsRepository.findAll();
    }
	

    @GetMapping("/jobs_posted_by_company/{companyId}")
    public ResponseEntity<?> JobsPostedByCompany(@PathVariable(name ="companyId") String companyId){
        List<Jobs_Table> allJobsByCompany = jobsRepository.findAllByCompanyId(companyId);
        List<JobWithUserDetailsResponse> result = new ArrayList<>();

        for (Jobs_Table job : allJobsByCompany) {
            List<Object> userDetailsList = new ArrayList<>();
            if (job.getApplied() != null) {
                for (String applied : job.getApplied()) {
                    ResponseEntity<?> response = userClient.UserDetails(applied);
                    if (response.getBody() != null) {
                        userDetailsList.add(response.getBody());
                    }
                }
            }
            result.add(new JobWithUserDetailsResponse(job, userDetailsList));
        }

        return ResponseEntity.ok(result);
    }

  @GetMapping("/company_details")
  public String companyDetails() {
	  return companyClient.CompanyDetails();
  }
  
  
  @GetMapping("/fetch_jobs/{page}")
  public Page<Jobs_Table> fetchJOBS(@PathVariable("page") int page){
	  return jobsRepository.findAll(PageRequest.of(page, 4));
}

@GetMapping("/fetch_jobs_by_category_pagination/{page}/{jobTitle}")
public Page<Jobs_Table> FetchJobsByCategory(@PathVariable("page") int page,@PathVariable("jobTitle") String jobTitle){
  Page<Jobs_Table> searchedJobs = jobsRepository.findByJobTitleContainingIgnoreCase(jobTitle,PageRequest.of(page, 4));
	return searchedJobs;
	
}
  
  
  
}
;