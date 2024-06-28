package Job_application.JobsService.Service;

import java.util.List;
import java.util.UUID;

import Job_application.JobsService.Entity.Jobs_Table;
import Job_application.JobsService.JobsDto.JobsDto;

public interface JobsService {
   
	JobsDto SaveJob(JobsDto jobsDto);

	JobsDto updateJobDetails(UUID id, JobsDto jobsDto);

	List<Jobs_Table> FetchAllJobs();

	List<Jobs_Table> findAllJobsByCompanyId(UUID companyId);

	List<Jobs_Table> findByJobDescription(String jobDescription);

	String DeleteJob(UUID job_Id);

	
}
