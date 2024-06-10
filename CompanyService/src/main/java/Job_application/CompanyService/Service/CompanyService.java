package Job_application.CompanyService.Service;

import java.util.List;
import java.util.UUID;

import Job_application.CompanyService.CompanyDto.CompanyDto;
import Job_application.CompanyService.Entity.Company_Table;

public interface CompanyService {
	
	CompanyDto saveComapny(CompanyDto companyDto);

	List<Company_Table> fetchAllCompanies();

	CompanyDto updateCompanyDetails(UUID company_id, CompanyDto companyDto);
}
