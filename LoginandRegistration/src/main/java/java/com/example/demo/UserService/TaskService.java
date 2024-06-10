package java.com.example.demo.UserService;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import java.com.example.demo.UserDto.TasksDto;
import java.com.example.demo.UserDto.TasksOfAllUsers;


public interface TaskService {
	
	TasksDto save(long id,TasksDto TasksDto);
	List<TasksDto> GetAllTasksofUser(long id);
	TasksDto UpdateTask(long task_id, TasksDto taskDto,long user_id);
	String DeleteTask(long task_id);
	List<TasksOfAllUsers> getAllTasks();
	
	

}
