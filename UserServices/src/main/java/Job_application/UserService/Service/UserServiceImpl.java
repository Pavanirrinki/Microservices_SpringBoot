package Job_application.UserService.Service;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import Job_application.UserService.UserDto.UserDto;
import Job_application.UserService.UserDto.UserResumeDto;
import Job_application.UserService.UserEntity.User_data;
import Job_application.UserService.UserEntity.User_resume;
import Job_application.UserService.UserRepository.UserRepository;
import Job_application.UserService.UserRepository.User_resumeRepository;

@Service
public class UserServiceImpl implements  UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper ModelMapper;
	
	@Autowired
	private User_resumeRepository user_resumeRepository;

	@Override
	public UserDto saveUser(UserDto userDto) {
		User_data users = userRepository.save(ModelMapper.map(userDto, User_data.class));
		UserDto savedUser = ModelMapper.map(users, UserDto.class);
		return savedUser;
	}

	@Override
	public String loginuser(String email, String password) {
		User_data user = userRepository.findByEmail(email);
		if(user.getPassword().equals(password)) {
			return "User Exists";
		}
		return "Password and Email not match";
	}

	@Override
	public User_resume UploadDocuments(UUID id,List<String> skills,MultipartFile pdf) throws IOException {
		User_data user = userRepository.findById(id).get();
		User_resume users = new User_resume();
		users.setUserId(user);
		users.setPdf(pdf.getBytes());
		users.setSkills(skills);
		user_resumeRepository.save(users);
		return users;
	}

	@Override
	public User_resume updateuserdetails(UUID id, String name, long mobilenumber, String email, List<String> skills,MultipartFile pdf) throws IOException {
		User_data user = userRepository.findById(id).get();
		user.setEmail(email);
		user.setMobilenumber(mobilenumber);
		user.setName(name);
		User_resume saveduser = user_resumeRepository.findByUserId_Id(id);
		saveduser.setPdf(pdf.getBytes());
		saveduser.setSkills(skills);
		return user_resumeRepository.save(saveduser);
	}

	@Override
	public List<UUID> ApplyForJob(List<UUID> jobIds, UUID userId) {
	 
	    User_resume saveduser = user_resumeRepository.findByUserId_Id(userId);
	   
	    List<UUID> existingAppliedJobs = saveduser.getApplied_jobs();
	    
	    if (existingAppliedJobs == null) {
	        existingAppliedJobs = new ArrayList<>();
	    }
	    
	
	    existingAppliedJobs.addAll(jobIds);
	    
	    saveduser.setApplied_jobs(existingAppliedJobs);
	
	    user_resumeRepository.save(saveduser);
	
	    return saveduser.getApplied_jobs();
	}

	@Override
	public List<User_data> fetchallusers() {
		List<User_data> allusers = userRepository.findAll();
		return allusers;
	}


}
