package Job_application.JobsService.JobsRepository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Job_application.JobsService.Entity.Jobs_Table;

@Repository
public interface JobsRepository extends JpaRepository<Jobs_Table,UUID>{

	

	List<Jobs_Table> findAllByCompanyId(UUID companyId);

	List<Jobs_Table> findByJobDescriptionContainingIgnoreCase(String jobDescription);

	

	
	
	

}
