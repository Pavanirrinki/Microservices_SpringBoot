package Job_application.JobsService.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name ="COMPANY-SERVICE",url = "http://localhost:8092/company")
public interface CompanyClient {
	
	@GetMapping("/company_details")
	public String CompanyDetails();

}
