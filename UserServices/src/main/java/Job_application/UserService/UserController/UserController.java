package Job_application.UserService.UserController;

import java.util.Map;
import java.util.UUID;
import java.io.IOException;

import java.util.Base64;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import Job_application.UserService.UserController.OTP;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import Job_application.UserService.Service.UserNotFoundException;
import Job_application.UserService.Service.UserService;
import Job_application.UserService.UserDto.SendMailDto;
import Job_application.UserService.UserDto.UserDto;
import Job_application.UserService.UserDto.UserGraduationDto;

import Job_application.UserService.UserEntity.User_data;
import Job_application.UserService.UserEntity.User_graduation;
import Job_application.UserService.UserEntity.User_resume;
import Job_application.UserService.UserRepository.UserRepository;
import Job_application.UserService.UserRepository.User_Graduation_repository;
import Job_application.UserService.UserRepository.User_resumeRepository;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000", methods = { RequestMethod.GET, RequestMethod.POST,
		RequestMethod.OPTIONS })
public class UserController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserService userService;
	@Autowired
	private User_resumeRepository userResumeRepository;
	@Autowired
	private User_Graduation_repository userGraduationRepository;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private ModelMapper modelmapper;

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
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/login")
	public ResponseEntity<?> Login(@RequestBody Map<String, String> loginData) {
		try {
			User_data data = userService.loginuser(loginData.get("email"), loginData.get("password"));
			return new ResponseEntity<>(data, HttpStatus.OK);
		} catch (UserNotFoundException ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
		}
	}

	@PostMapping("/upload_user_data")
	public User_resume uploadUserDetails(@RequestParam(name = "Id") String Id,
			@RequestParam(name = "skills") List<String> skills, @RequestParam(name = "pdf") MultipartFile pdf,
			@RequestParam("resumename") String resumename, @RequestParam("uploaddate") String uploadDate)
			throws Exception {
		UUID id = UUID.fromString(Id);

		User_resume userData = userService.UploadDocuments(id, skills, pdf, resumename, uploadDate);
		System.out.println("post upload user data detected");
		return userData;
	}

	@GetMapping("/get_user_details/{user_id}")
	public User_resume getUserData(@PathVariable UUID user_id) {
		System.out.println("User ID: " + user_id);
		User_resume userResumes = userResumeRepository.findByUserId_Id(user_id);
		System.out.println("User Resumes: " + userResumes);
		return userResumes;
	}

	@GetMapping("/get_user_educational/{user_id}")
	public User_graduation GetUserGraduation(@PathVariable UUID user_id) {
		User_graduation educationalDetails = userGraduationRepository.findByUserId_Id(user_id);

		return educationalDetails;

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
	public List<UUID> ApplyForJob(@RequestParam(name = "JobId") List<UUID> JobId,
			@RequestParam(name = "userId") UUID userId) {
		List<UUID> SAVED = userService.ApplyForJob(JobId, userId);
		return SAVED;

	}

	@PutMapping("/Save_user_educational_details/{userId}")
	public UserGraduationDto SaveEducationalDetails(@PathVariable String userId,
			@RequestBody UserGraduationDto userGraduationDto) {
		UUID UserId = UUID.fromString(userId);
		UserGraduationDto savedUserEducation = userService.saveEducationalDetails(UserId, userGraduationDto);
		System.out.println("oooooooo");
		return savedUserEducation;

	}

	@GetMapping("/fetch_all_users")
	public List<User_data> FetchAllJobs() {

		List<User_data> fetchedusers = userService.fetchallusers();
		return fetchedusers;

	}

	@PutMapping("/Update_profile/{userId}")
	public String UpdateProfile(@PathVariable String userId, @RequestParam(name = "profile") MultipartFile profile)
			throws IOException {
		UUID UserId = UUID.fromString(userId);
		User_data user = userRepository.findById(UserId).get();
		user.setProfile_pic(Base64.getEncoder().encodeToString(profile.getBytes()));
		userRepository.save(user);
		return "updated";

	}

	@PatchMapping("/update_user_personal_details/{userId}")
	public UserDto UpdateUserPersonalDetails(@PathVariable String userId, @RequestBody UserDto userDto) {
		UUID UserId = UUID.fromString(userId);
		UserDto updateduser = userService.updateUserPersonalDetails(userDto, UserId);
		return updateduser;
	}

	private OTP[] items = new OTP[0];

	@PostMapping("/otp-send")
	public OTP[] triggerMail(@RequestBody SendMailDto mailDto) {
		System.out.println("Mail sent");

		// Send email
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(mailDto.getTo());
		message.setSubject(mailDto.getSubject());
		message.setText(mailDto.getBody());
		mailSender.send(message);

		OTP otpEmail = new OTP(mailDto.getTo(), generateOtp());

		items = addToArray(items, otpEmail);

		return items;
	}

	private OTP[] addToArray(OTP[] array, OTP element) {
		OTP[] newArray = new OTP[array.length + 1];
		System.arraycopy(array, 0, newArray, 0, array.length);
		newArray[array.length] = element;
		return newArray;
	}

	private String generateOtp() {

		int otp = (int) (Math.random() * 900000) + 100000;
		return String.valueOf(otp);
	}

	@PostMapping("/verify_otp")
    public String verifyOTP(@RequestParam String email, @RequestParam String otp) {
        for (int i = 0; i < items.length; i++) {
            OTP storedOtp = items[i];
            if (storedOtp != null && storedOtp.getEmail().equals(email) && storedOtp.getOtp().equals(otp)) {
                return "OTP verified successfully!";
            }
        }
        return "OTP verification failed.";
    }

}
