package Job_application.JobsService.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import Job_application.JobsService.Entity.Jobs_Table;
import Job_application.JobsService.FeignClient.CompanyClient;
import Job_application.JobsService.JobsDto.JobsDto;
import Job_application.JobsService.JobsRepository.JobsRepository;
import Job_application.JobsService.external.CompanyDto;
import Job_application.JobsService.external.JobsAndCompanyDto;



@Service
public class JobsServiceImpl implements JobsService{
	
	@Autowired
	private JobsRepository jobsRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CompanyClient companyClient;

	@Override
	public JobsDto SaveJob(List<String> jobDescription, String minExp, String maxExp, String minSal, String maxSal, String companyId,
			String location, String workmode, String jobTitle, String industryType, String openings,List<String> qualifications,
			List<String> skills) {
		  JobsDto jobsDto = new JobsDto();
	        jobsDto.setJobDescription(jobDescription);
	        jobsDto.setMinExp(Integer.parseInt(minExp));
	        jobsDto.setMaxExp(Integer.parseInt(maxExp));
	        jobsDto.setMinSal(Integer.parseInt(minSal));
	        jobsDto.setMaxSal(Integer.parseInt(maxSal));
	        jobsDto.setCompanyId(companyId);
	        jobsDto.setLocation(location);
	        jobsDto.setWorkmode(workmode);
	        jobsDto.setJobTitle(jobTitle);
	        jobsDto.setIndustryType(industryType);
	        jobsDto.setOpenings(Integer.parseInt(openings));
	        jobsDto.setTechnologiesKnown(skills);
	        jobsDto.setPosted(new Date());
	        jobsDto.setQualifications(qualifications);
		Jobs_Table jobs = jobsRepository.save(modelMapper.map(jobsDto,Jobs_Table.class));
		JobsDto savedJobs = modelMapper.map(jobs,JobsDto.class);
		
		return savedJobs;
	}

	@Override
	public JobsDto updateJobDetails(String id, JobsDto jobsDto) {
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

	 public List<JobsAndCompanyDto> FetchAllJobs() {
	 
	        PageRequest pageRequest = PageRequest.of(0,6);
	        Page<Jobs_Table> jobsPage = jobsRepository.findAll(pageRequest);

	        List<Jobs_Table> allJobs = jobsPage.getContent();
	        List<JobsAndCompanyDto> jobsAndCompanyDtoList = new ArrayList<>();

	        for (Jobs_Table job : allJobs) {
	            String companyId = job.getCompanyId();
	            CompanyDto companyDetails = companyClient.GetParticularCompanyDetails(companyId); 
	            JobsAndCompanyDto jobs = new JobsAndCompanyDto();

	            jobs.setCompanyId(companyDetails);
	            jobs.setIndustryType(job.getIndustryType());
	            jobs.setJobDescription(job.getJobDescription());
	            jobs.setJobTitle(job.getJobTitle());
	            jobs.setLocation(job.getLocation());
	            jobs.setMaxExp(job.getMaxExp());
	            jobs.setMinExp(job.getMinExp());
	            jobs.setMaxSal(job.getMaxSal());
	            jobs.setMinSal(job.getMinSal());
	            jobs.setOpenings(job.getOpenings()); 
	            jobs.setPosted(job.getPosted());
	            jobs.setTechnologiesKnown(job.getTechnologiesKnown());
	            jobs.setWorkmode(job.getWorkmode());
	            jobs.setId(job.getId());
	            jobs.setQualifications(job.getQualifications());
	            jobs.setApplied(job.getApplied());

	            jobsAndCompanyDtoList.add(jobs);
	        }

	        return jobsAndCompanyDtoList;
	    }
	

	@Override
	public List<Jobs_Table> findAllJobsByCompanyId(String companyId) {
		List<Jobs_Table> alljobsByCompany = jobsRepository.findAllByCompanyId(companyId);
		return alljobsByCompany;
	}

	@Override
	public List<Jobs_Table> findByJobDescription(String jobDescription) {
		List<Jobs_Table> searchedJobs = jobsRepository.findByJobTitleContainingIgnoreCase(jobDescription);
		return searchedJobs;
	}

	@Override
	public String DeleteJob(String job_Id) {
		jobsRepository.deleteById(job_Id);
		return "Job Deleted Successfully";
	}

	@Override
	public JobsAndCompanyDto particularJobDetails(String user_id) {
		Jobs_Table particularJob = jobsRepository.findById(user_id).get();
		CompanyDto companyDetails = companyClient.GetParticularCompanyDetails(particularJob.getCompanyId());
		JobsAndCompanyDto particularjobandcompany = new JobsAndCompanyDto();
		particularjobandcompany.setId(user_id);
		particularjobandcompany.setCompanyId(companyDetails);
		particularjobandcompany.setIndustryType(particularJob.getIndustryType());
		particularjobandcompany.setJobDescription(particularJob.getJobDescription());
		particularjobandcompany.setJobTitle(particularJob.getJobTitle());
		particularjobandcompany.setLocation(particularJob.getLocation());
		particularjobandcompany.setMaxExp(particularJob.getMaxExp());
		particularjobandcompany.setMaxSal(particularJob.getMaxSal());
		particularjobandcompany.setMinExp(particularJob.getMinExp());
		particularjobandcompany.setMinSal(particularJob.getMinSal());
		particularjobandcompany.setOpenings(particularJob.getOpenings());
		particularjobandcompany.setPosted(particularJob.getPosted());
		particularjobandcompany.setTechnologiesKnown(particularJob.getTechnologiesKnown());
		particularjobandcompany.setWorkmode(particularJob.getWorkmode());
		particularjobandcompany.setQualifications(particularJob.getQualifications());
		particularjobandcompany.setApplied(particularJob.getApplied());
		return particularjobandcompany;
	}

	@Override
	public String UpdateAppliedJob(String jobIds, String userId) {
	
		Jobs_Table savedJob = jobsRepository.findById(jobIds).get();

		if (savedJob == null) {
			throw new RuntimeException("User resume not found for userId: " + jobIds);
		}

		List<String> existingAppliedJobs = savedJob.getApplied();

		if (existingAppliedJobs == null) {
			existingAppliedJobs = new ArrayList<String>();
		}

		existingAppliedJobs.add(userId);
		savedJob.setApplied(existingAppliedJobs);
		
		
		jobsRepository.save(savedJob);

		
		return "Successfully Applied";
	}



	
	
	

}
