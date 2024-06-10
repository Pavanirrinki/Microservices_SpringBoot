package Job_application.JobsService.Service;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Job_application.JobsService.Entity.Jobs_Table;
import Job_application.JobsService.JobsDto.JobsDto;
import Job_application.JobsService.JobsRepository.JobsRepository;

@Service
public class JobsServiceImpl implements JobsService{
	
	@Autowired
	private JobsRepository jobsRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public JobsDto SaveJob(JobsDto jobsDto) {
		Jobs_Table jobs = jobsRepository.save(modelMapper.map(jobsDto,Jobs_Table.class));
		JobsDto savedJobs = modelMapper.map(jobs,JobsDto.class);
		return savedJobs;
	}

	@Override
	public JobsDto updateJobDetails(UUID id, JobsDto jobsDto) {
		Jobs_Table jobs = jobsRepository.findById(id).get();
		
        jobs.setJobDescription(jobsDto.getJobDescription());
        jobs.setTechnologiesKnown(jobsDto.getTechnologiesKnown());
        jobs.setMinExp(jobsDto.getMinExp());
        jobs.setMaxExp(jobsDto.getMaxExp());
        jobs.setApplied(jobsDto.getApplied());
        jobs.setCompanyId(jobsDto.getCompanyId());
        jobs.setLocation(jobsDto.getLocation());
	        jobsRepository.save(jobs);
		JobsDto savedJobs = (modelMapper.map(jobs,JobsDto.class));
		return savedJobs;
	}

	@Override
	public List<Jobs_Table> FetchAllJobs() {
		List<Jobs_Table> allJobs = jobsRepository.findAll();
		return allJobs;
	}

	@Override
	public List<Jobs_Table> findAllJobsByCompanyId(UUID companyId) {
		List<Jobs_Table> alljobsByCompany = jobsRepository.findAllByCompanyId(companyId);
		return alljobsByCompany;
	}

	
	
	

}
