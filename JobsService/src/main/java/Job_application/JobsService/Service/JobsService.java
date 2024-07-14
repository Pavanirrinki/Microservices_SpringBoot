package Job_application.JobsService.Service;

import java.util.List;
import java.util.UUID;

import Job_application.JobsService.Entity.Jobs_Table;
import Job_application.JobsService.JobsDto.JobsDto;
import Job_application.JobsService.external.JobsAndCompanyDto;

public interface JobsService {
	JobsDto updateJobDetails(String id, JobsDto jobsDto);
	List<JobsAndCompanyDto> FetchAllJobs();
    List<Jobs_Table> findAllJobsByCompanyId(String companyId);
    List<Jobs_Table> findByJobDescription(String title);
    String DeleteJob(String job_Id);
    JobsDto SaveJob(List<String> jobDescription, String minExp, String maxExp, String minSal, String maxSal, String companyId,
			String location, String workmode, String jobTitle, String industryType, String openings,
			List<String> skills,List<String> qualifications);
    JobsAndCompanyDto particularJobDetails(String user_id);
	String UpdateAppliedJob(String jobsIds, String userId);
  


}
