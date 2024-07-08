package Job_application.JobsService.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import Job_application.JobsService.external.CompanyDto;



@FeignClient(name ="COMPANY-SERVICE",url = "http://localhost:8092/company")
public interface CompanyClient {
	
	@GetMapping("/company_details")
	public String CompanyDetails();
    
	@GetMapping("/get_particular_company_details/{company_id}")
	public CompanyDto GetParticularCompanyDetails(@PathVariable String company_id);
}
