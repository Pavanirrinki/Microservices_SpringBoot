package Job_application.CompanyService.Controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Job_application.CompanyService.CompanyDto.CompanyDto;
import Job_application.CompanyService.CompanyRepository.CompanyRepository;
import Job_application.CompanyService.Entity.Company_Table;
import Job_application.CompanyService.FeignClient.UserClient;
import Job_application.CompanyService.Service.CompanyService;


@RestController
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyServicve;
	
	@Autowired
	private UserClient userClient;
	
	@Autowired
	private CompanyRepository companyRepository;

	
	@PostMapping("/save")
	public CompanyDto SaveCompany(@RequestBody CompanyDto companyDto) {
		CompanyDto  companies= companyServicve.saveComapny(companyDto);
	        return companies;
	}		
@GetMapping("/test_in_user")
public String GetData() {
	return userClient.testEndpoint();
}

@GetMapping("/company_details")
public String CompanyDetails() {
	return "Company Details Route";
}

@GetMapping("/fetch-all_companies")
public List<Company_Table> FetchAllCompanies(){
	List<Company_Table> allCompanies = companyServicve.fetchAllCompanies();
	return allCompanies;
	
}

@PutMapping("/update_company_details/{company_id}")
public CompanyDto UpdateCompanyDetails(@PathVariable UUID company_id,@RequestBody CompanyDto companyDto) {

	CompanyDto updatecompany = companyServicve.updateCompanyDetails(company_id,companyDto);
	return updatecompany;
	
}
}
