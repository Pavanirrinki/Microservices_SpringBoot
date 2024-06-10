package java.com.example.demo.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.com.example.demo.Entity.Tasks;
import java.com.example.demo.Entity.Users;
import java.com.example.demo.UserDto.TasksDto;
import java.com.example.demo.UserDto.TasksOfAllUsers;
import java.com.example.demo.UserDto.UserDto;
import java.com.example.demo.UserRepository.TasksRepository;
import java.com.example.demo.UserRepository.UserRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TasksRepository taskRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapper ModelMapper;

	@Override
	public TasksDto save(long id, TasksDto TasksDto) {
		Users users = userRepository.findById(id).get();
		Tasks task = ModelMapper.map(TasksDto, Tasks.class);
		task.setUsers(users);

		Tasks savedTasks = taskRepository.save(task);
		return ModelMapper.map(savedTasks, TasksDto.class);

	}

	@Override
	public List<TasksDto> GetAllTasksofUser(long userId) {
		List<Tasks> tasks = taskRepository.findAllByUsersId(userId);
		return tasks.stream().map(task -> ModelMapper.map(task, TasksDto.class)).collect(Collectors.toList());
	}

	public TasksDto UpdateTask(long id, TasksDto taskDto,long user_id) {
	 
	    Optional<Tasks> optionalExistingTask = taskRepository.findById(id);
	    Users optionalExistinguser = userRepository.findById(user_id).get();
	    if (optionalExistingTask.isPresent()) {
	    
	        Tasks existingTask = optionalExistingTask.get();
	       
	        existingTask.setTask_name(taskDto.getTask_name()); 
	        existingTask.setStatus(taskDto.getStatus());
	        existingTask.setUsers(optionalExistinguser);
	        Tasks updatedTask = taskRepository.save(existingTask);

	        return ModelMapper.map(updatedTask, TasksDto.class);
	    } else {
	       
	        return null;
	    }
	}

	@Override
	public String DeleteTask(long task_id) {
		Tasks optionalTask = taskRepository.findById(task_id).get();
		if(optionalTask != null) {
			taskRepository.deleteById(task_id);
			return "Successfully deleted";
		}
		return null;
	}

	@Override
	public List<TasksOfAllUsers> getAllTasks() {
		
		return taskRepository.getAllTasks();
	}

	
}
