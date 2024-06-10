package java.com.example.demo.UserDto;

import java.com.example.demo.Entity.Users;

public class TasksDto {
	private Long Id;
	private String task_name;
	private String status;
	private Users user;
	

	public Long getUsers() {
		return user.getId();
	}
	public void setUsers(Users users) {
		this.user = users;
	}
	

	
	public Long getId() {
		return Id;
	}
	
	public void setId(Long id) {
		Id = id;
	}
	
	public String getTask_name() {
		return task_name;
	}
	
	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	

	
}
