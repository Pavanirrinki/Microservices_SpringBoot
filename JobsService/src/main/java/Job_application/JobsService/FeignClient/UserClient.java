package Job_application.JobsService.FeignClient;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import Job_application.JobsService.external.UserDto;




@FeignClient(name ="USER-SERVICE",url = "http://localhost:9091/users")
public interface UserClient {
	@GetMapping("/test")
	public String testEndpoint();
	
	
	@PostMapping("/save")
	public UserDto saveUser(UserDto userDto);
	
	@GetMapping("/user_details/{userId}")
	public ResponseEntity<?> UserDetails(@PathVariable String userId);
}

