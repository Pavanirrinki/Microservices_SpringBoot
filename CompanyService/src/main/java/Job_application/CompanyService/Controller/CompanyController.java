package Job_application.CompanyService.Controller;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import Job_application.CompanyService.CompanyDto.CompanyDto;
import Job_application.CompanyService.CompanyRepository.CompanyRepository;
import Job_application.CompanyService.CompanyRepository.ReferenceRepository;
import Job_application.CompanyService.Entity.Company_Table;
import Job_application.CompanyService.Entity.Reference_Table;
import Job_application.CompanyService.FeignClient.UserClient;
import Job_application.CompanyService.Service.CompanyService;



@RestController
@RequestMapping("/company")
@CrossOrigin(origins = "http://localhost:3000")
public class CompanyController {
	
	@Autowired
	private CompanyService companyServicve;
	
	@Autowired
	private UserClient userClient;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private ReferenceRepository referenceRepository;
	


	
	@PostMapping("/save")
	public CompanyDto SaveCompany(
	        @RequestParam(name = "name") String name,
	        @RequestParam(name = "companyDescription") List<String> companyDescription,
	        @RequestParam(name = "email") String email,
	        @RequestParam(name = "mobilenumber") long mobilenumber,
	        @RequestParam(name = "password") String password,
	        @RequestParam(name = "workingTechnologies") List<String> workingTechnologies) {
		CompanyDto company = companyServicve.saveCompanyDetails(name,companyDescription,email,mobilenumber,password,workingTechnologies);
         return company;
	}

	@PostMapping("/login")
	public ResponseEntity<String> CompanyLogin(@RequestBody Map<String,String> loginuser) throws Exception {
		String loginSucess = companyServicve.loginuser(loginuser);
		return ResponseEntity.ok(loginSucess);
		 		
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
public CompanyDto UpdateCompanyDetails(@PathVariable String company_id,@RequestBody CompanyDto companyDto) {

	CompanyDto updatecompany = companyServicve.updateCompanyDetails(company_id,companyDto);
	return updatecompany;
	
}









@PostMapping("/Reference")
public String Reference(@RequestBody  List<String> technologies) {
	Reference_Table ref = new Reference_Table();
	ref.setTechnologies(technologies);
	referenceRepository.save(ref);
	return null;
	
}
}
