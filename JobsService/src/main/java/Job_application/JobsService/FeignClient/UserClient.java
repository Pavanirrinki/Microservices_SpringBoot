package Job_application.JobsService.FeignClient;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import Job_application.JobsService.external.UserDto;



@FeignClient(name ="USER-SERVICE",url = "http://localhost:8096/users")
public interface UserClient {
	@GetMapping("/test")
	public String testEndpoint();
	
	
	@PostMapping("/save")
	public UserDto saveUser(UserDto userDto);
}
