package Job_application.UserService.Service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import Job_application.UserService.UserDto.UserDto;
import Job_application.UserService.UserDto.UserResumeDto;
import Job_application.UserService.UserEntity.User_data;
import Job_application.UserService.UserEntity.User_resume;

public interface UserService {
	
	UserDto saveUser(UserDto userDto);
	String loginuser(String email,String password);
	User_resume UploadDocuments(UUID id, List<String> skills, MultipartFile pdf) throws IOException;
	User_resume updateuserdetails(UUID id, String name, long mobilenumber, String email, List<String> skills,MultipartFile pdf) throws IOException;
	List<UUID> ApplyForJob(List<UUID> JobId, UUID userId);
	List<User_data> fetchallusers();
    
	
    
}
