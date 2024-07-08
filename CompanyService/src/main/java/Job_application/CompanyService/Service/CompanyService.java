package Job_application.CompanyService.Service;

import java.util.List;
import java.util.Map;

import Job_application.CompanyService.CompanyDto.CompanyDto;
import Job_application.CompanyService.Entity.Company_Table;

public interface CompanyService {

	List<Company_Table> fetchAllCompanies();

    CompanyDto saveCompanyDetails(String name, List<String> companyDescription, String email, long mobilenumber,String password, List<String> workingTechnologies,String profile_pic);
	CompanyDto loginuser(Map<String, String> loginuser) throws Exception;

	CompanyDto updateCompanyDetails(String company_id, String name, String email, String mobilenumber,
			List<String> companyDescription, List<String> workingTechnologies);
}
