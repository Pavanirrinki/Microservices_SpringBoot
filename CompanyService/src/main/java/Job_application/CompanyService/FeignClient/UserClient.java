package Job_application.CompanyService.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name ="USER-SERVICE",url = "http://localhost:9091/users")
public interface UserClient {
	@GetMapping("/test")
	public String testEndpoint();
}
