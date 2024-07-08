package Job_application.JobsService.JobsRepository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import Job_application.JobsService.Entity.Jobs_Table;

@Repository
public interface JobsRepository extends JpaRepository<Jobs_Table,String>{
	
	List<Jobs_Table> findAllByCompanyId(String companyId);
	List<Jobs_Table> findByJobTitleContainingIgnoreCase(String jobDescription);

	

	
	
	

}
