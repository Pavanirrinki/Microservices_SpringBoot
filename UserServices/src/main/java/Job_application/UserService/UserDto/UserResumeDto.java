package Job_application.UserService.UserDto;

import java.util.List;
import java.util.UUID;

import Job_application.UserService.UserEntity.User_data;

public class UserResumeDto {
	private UUID id;
	private User_data userId;
	 private UUID[] Applied_jobs;
	
	public UUID[] getApplied_jobs() {
		return Applied_jobs;
	}
	public void setApplied_jobs(UUID[] applied_jobs) {
		Applied_jobs = applied_jobs;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public User_data getUserId() {
		return userId;
	}
	public void setUserId(User_data userId) {
		this.userId = userId;
	}

}
