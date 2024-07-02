package Job_application.CompanyService.CompanyRepository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Job_application.CompanyService.Entity.Company_Table;

@Repository
public interface CompanyRepository extends JpaRepository<Company_Table, String>{

	Company_Table findByEmail(String string);

	

}
