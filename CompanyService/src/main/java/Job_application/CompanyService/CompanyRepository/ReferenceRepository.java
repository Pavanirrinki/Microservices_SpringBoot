package Job_application.CompanyService.CompanyRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import Job_application.CompanyService.Entity.Reference_Table;

public interface ReferenceRepository extends JpaRepository<Reference_Table, String>{



}
