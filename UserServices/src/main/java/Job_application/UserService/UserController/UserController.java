package Job_application.UserService.UserController;

import java.util.Map;
import java.util.UUID;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonValue;

import Job_application.UserService.Service.UserService;
import Job_application.UserService.UserDto.UserDto;
import Job_application.UserService.UserDto.UserResumeDto;
import Job_application.UserService.UserEntity.User_data;
import Job_application.UserService.UserEntity.User_resume;
import Job_application.UserService.UserRepository.UserRepository;
import Job_application.UserService.UserRepository.User_resumeRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserService userService;
	@Autowired
	private User_resumeRepository userResumeRepository;

	@GetMapping("/test")
	public String testEndpoint() {
		System.out.println("ppppppppppppppppp");
		return "Test endpoint reached!";
	}


	@PostMapping("/register")
	public ResponseEntity<UserDto> Register(@RequestBody UserDto userDto) {
		try {
		UserDto data = userService.saveUser(userDto);
		return new ResponseEntity<>(data, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);   
		}
		 
	}

	@PostMapping("/login")
	public ResponseEntity<String> Login(@RequestBody Map<String, String> loginData) {
		String data = userService.loginuser(loginData.get("email"), loginData.get("password"));
		return new ResponseEntity<>(data, HttpStatus.OK);

	}

	@PostMapping("/upload_user_data")
	public User_resume uploadUserDetails(@RequestParam(name = "id") UUID id,
			@RequestParam(name = "skills") List<String> skills, @RequestParam(name = "pdf") MultipartFile pdf)
			throws Exception {
		User_resume userData = userService.UploadDocuments(id, skills, pdf);
		return userData;
	}

	@PutMapping("/update_user_data")
	public User_resume Getuserdata(@RequestParam(name = "Id") UUID id, @RequestParam(name = "name") String name,
			@RequestParam(name = "mobilenumber") long mobilenumber, @RequestParam(name = "email") String email,
			@RequestParam(name = "skills") List<String> skills, @RequestParam(name = "pdf") MultipartFile pdf)
			throws IOException {
		User_resume updatedResume = userService.updateuserdetails(id, name, mobilenumber, email, skills, pdf);

		return updatedResume;

	}
	
	@PostMapping("/apply_for_job")
	public List<UUID> ApplyForJob(@RequestParam(name ="JobId") List<UUID> JobId,@RequestParam(name ="userId") UUID userId ) {
	List<UUID> SAVED= userService.ApplyForJob(JobId,userId);
		return SAVED;
		
	}
   @GetMapping("/fetch_all_users")
   public List<User_data> FetchAllJobs(){
	 List<User_data> fetchedusers= userService.fetchallusers();
	return fetchedusers;
	   
   }
}
